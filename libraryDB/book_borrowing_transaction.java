package libraryDB;
import java.sql.*;
import java.time.LocalDate;


public class book_borrowing_transaction {


    //Transaction Data Tables
    //   - Managed with Transaction Processing
    //   - Create a Transaction
    //   - Submit and Finalize a Transaction
    //   - Transaction-Specific Actions
    //   - Cancel a Transaction
    //   - Delete a Transaction

    public String borrow_no;        // VARCHAR(10)
    public Date date_borrowed;      // DATE
    public Date date_due;           // DATE
    public Date date_returned;      // DATE
    public String borrow_status;    // ENUM('B','O','R','L')
    public String book_id;          // VARCHAR(10)
    public String patron_id;        // VARCHAR(10)
    public String fines_id;         // VARCHAR(10)
    public String clerk_id;         // VARCHAR(10)

    public book_borrowing_transaction() {
        borrow_no = "";
        date_borrowed = null;
        date_due = null;
        date_returned = null;
        borrow_status = "";
        book_id = "";
        patron_id = "";
        fines_id = null;
        clerk_id = "";
    }

    // Check if patron can borrow books
    public boolean canPatronBorrow() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT"
            );

            // Check current borrows count and overdue status
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT COUNT(*) as borrow_count FROM Borrowing_History " +
                            "WHERE patron_id = ? AND borrow_status IN ('B', 'O')"
            );
            pstmt.setString(1, patron_id);   // Require specific patron_id from user
            ResultSet rs = pstmt.executeQuery();

            int currentBorrows = 0;
            if (rs.next())
                currentBorrows = rs.getInt("borrow_count");

            // Check for overdue or lost books
            pstmt = conn.prepareStatement(
                    "SELECT COUNT(*) as overdue_count FROM Borrowing_History " +
                            "WHERE patron_id = ? AND borrow_status IN ('O', 'L')"
            );
            pstmt.setString(1, patron_id);
            rs = pstmt.executeQuery();

            int overdueCount = 0;
            if (rs.next())
                overdueCount = rs.getInt("overdue_count");

            pstmt.close();
            conn.close();

            return currentBorrows < 3 && overdueCount == 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int create_Borrowing() {

        try {
            if (!canPatronBorrow()) {
                System.out.println("Patron cannot borrow more books or has overdue items");
                return 0;
            }

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT"
            );

            // Check if book is available  -- User Input the BOOK_ID or Inventory_id
            PreparedStatement checkBook = conn.prepareStatement(
                        "SELECT 1 FROM Books_Inventory bi " +
                            "WHERE bi.inventory_id = ? " +
                            "AND NOT EXISTS (SELECT 1 FROM Borrowing_History bh " +
                            "              WHERE bh.book_id = bi.inventory_id " +
                            "              AND bh.borrow_status IN ('B', 'O'))"
            );
            checkBook.setString(1, book_id);
            ResultSet rs = checkBook.executeQuery();

            // If result from query is empty.
            if (!rs.next()) {
                System.out.println("Book is not available for borrowing");
                return 0;
            }

            // Generate new borrow number
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT MAX(borrow_no) FROM Borrowing_History");

            String maxBorrowNo = "BRW0000";
            if (rs.next())
                maxBorrowNo = rs.getString(1);

            int borrowNoNumber = Integer.parseInt(maxBorrowNo.substring(3)) + 1;
            borrow_no = "BRW" + String.format("%04d", borrowNoNumber);

            // Insert borrowing record
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Borrowing_History (borrow_no, date_borrowed, date_due, " +
                            "borrow_status, book_id, patron_id, clerk_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            // Set current date and due date (14 days from now)
            LocalDate currentDate = LocalDate.now();
            LocalDate dueDate = currentDate.plusDays(14);

            pstmt.setString(1, borrow_no);
            pstmt.setDate(2, Date.valueOf(currentDate));
            pstmt.setDate(3, Date.valueOf(dueDate));
            pstmt.setString(4, "B");
            pstmt.setString(5, book_id);
            pstmt.setString(6, patron_id);
            pstmt.setString(7, clerk_id);

            pstmt.executeUpdate();
            System.out.println("Borrowing transaction created successfully");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


    // Create and Submit -- option to cancel



    // Update -- extend the book deadline?



    // Delete -- cancel the borrowing/return the book








}
