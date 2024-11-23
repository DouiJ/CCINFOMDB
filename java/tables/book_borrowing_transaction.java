package tables;

import java.sql.*;
import java.time.LocalDate;

public class book_borrowing_transaction {

    private String borrow_id;           // VARCHAR(6)
    private Date date_borrowed;         // DATE
    private Date date_due;              // DATE
    private Date date_returned;         // DATE
    private String borrow_status;       // ENUM('B','O','R','L')
    private String book_id;             // VARCHAR(10)
    private String patron_id;           // VARCHAR(10)
    private String clerk_id;            // VARCHAR(10)
    private String transaction_status;  // ENUM('A','C')
    private Connection connection;      // The existing database connection passed through the constructor

    // Constructor that accepts a Connection
    public book_borrowing_transaction(Connection connection) {
        this.connection = connection;  // Assign the passed connection
        borrow_id = "";
        date_borrowed = null;
        date_due = null;
        date_returned = null;
        borrow_status = "";
        book_id = "";
        patron_id = "";
        clerk_id = "";
        transaction_status = "";
    }

    // Getters and Setters for the fields
    public String getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(String borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Date getDate_borrowed() {
        return date_borrowed;
    }

    public void setDate_borrowed(Date date_borrowed) {
        this.date_borrowed = date_borrowed;
    }

    public Date getDate_due() {
        return date_due;
    }

    public void setDate_due(Date date_due) {
        this.date_due = date_due;
    }

    public Date getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(Date date_returned) {
        this.date_returned = date_returned;
    }

    public String getBorrow_status() {
        return borrow_status;
    }

    public void setBorrow_status(String borrow_status) {
        this.borrow_status = borrow_status;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(String patron_id) {
        this.patron_id = patron_id;
    }

    public String getClerk_id() {
        return clerk_id;
    }

    public void setClerk_id(String clerk_id) {
        this.clerk_id = clerk_id;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    // Check if patron can borrow books
    private boolean canPatronBorrow() {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "SELECT COUNT(*) as borrow_count FROM Borrowing_History " +
                        "WHERE patron_id = ? AND borrow_status IN ('B', 'O')");
             PreparedStatement overduePstmt = connection.prepareStatement(
                     "SELECT COUNT(*) as overdue_count FROM Borrowing_History " +
                             "WHERE patron_id = ? AND borrow_status IN ('O', 'L')")) {

            pstmt.setString(1, patron_id);
            ResultSet rs = pstmt.executeQuery();
            int currentBorrows = 0;
            if (rs.next()) currentBorrows = rs.getInt("borrow_count");

            overduePstmt.setString(1, patron_id);
            ResultSet overdueRs = overduePstmt.executeQuery();
            int overdueCount = 0;
            if (overdueRs.next()) overdueCount = overdueRs.getInt("overdue_count");

            rs.close();
            overdueRs.close();

            return currentBorrows < 3 && overdueCount == 0;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public int create_Borrowing() {
        try {
            if (!canPatronBorrow()) {
                System.out.println("Patron cannot borrow more books or has overdue items");
                return 0;
            }

            // Check if book is available
            PreparedStatement checkBook = connection.prepareStatement(
                    "SELECT 1 FROM Books_Inventory bi " +
                            "WHERE bi.inventory_id = ? " +
                            "AND NOT EXISTS (SELECT 1 FROM Borrowing_History bh " +
                            "              WHERE bh.book_id = bi.inventory_id " +
                            "              AND bh.borrow_status IN ('B', 'O'))");
            checkBook.setString(1, book_id);
            ResultSet rs = checkBook.executeQuery();

            if (!rs.next()) {
                System.out.println("Book is not available for borrowing");
                return 0;
            }

            // Generate new borrow id
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT MAX(borrow_id) FROM Borrowing_History");

            String maxBorrowNo = "H0000";
            if (rs.next()) maxBorrowNo = rs.getString(1);

            int borrowNoNumber = Integer.parseInt(maxBorrowNo.substring(1)) + 1;
            borrow_id = "B" + String.format("%04d", borrowNoNumber);

            // Insert borrowing record
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO Borrowing_History (borrow_id, date_borrowed, date_due, " +
                            "borrow_status, book_id, patron_id, clerk_id, status) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            // Set current date and due date (14 days from now)
            LocalDate currentDate = LocalDate.now();
            LocalDate dueDate = currentDate.plusDays(14);

            pstmt.setString(1, borrow_id);
            pstmt.setDate(2, Date.valueOf(currentDate));
            pstmt.setDate(3, Date.valueOf(dueDate));
            pstmt.setString(4, "B");
            pstmt.setString(5, book_id);
            pstmt.setString(6, patron_id);
            pstmt.setString(7, clerk_id);
            pstmt.setString(8, "A");  // Available status

            int rowsAdded = pstmt.executeUpdate();
            rs.close();
            pstmt.close();

            if (rowsAdded > 0) {
                System.out.println("Record successfully created.");
                return 1;
            } else {
                System.out.println("Record unsuccessfully created.");
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    // Other methods (process_Return, update_Borrowing, cancel_Borrowing, etc.) should also use the `connection` passed via the constructor

}
