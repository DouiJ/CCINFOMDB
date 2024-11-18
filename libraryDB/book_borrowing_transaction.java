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

    public String borrow_id;        // VARCHAR(10)
    public Date date_borrowed;      // DATE
    public Date date_due;           // DATE
    public Date date_returned;      // DATE
    public String borrow_status;    // ENUM('B','O','R','L')
    public String book_id;          // VARCHAR(10)
    public String patron_id;        // VARCHAR(10)
    public String fines_id;         // VARCHAR(10)
    public String clerk_id;         // VARCHAR(10)

    public book_borrowing_transaction() {
        borrow_id = "";
        date_borrowed = null;
        date_due = null;
        date_returned = null;
        borrow_status = "";
        book_id = "";
        patron_id = "";
        fines_id = null;
        clerk_id = "";
    }

    private boolean check_ClerkIDValidity() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT 1 FROM Employees WHERE employee_id = ?");
            pstmt.setString(1, clerk_id);
            ResultSet rs = pstmt.executeQuery();

            boolean isValid = rs.next(); // Returns true if clerk exists

            pstmt.close();
            conn.close();

            return isValid;
        } catch (Exception e) {
            System.out.println("Clerk ID validation error: " + e.getMessage());
            return false;
        }
    }

    private boolean check_PatronIDValidity() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT 1 FROM Patrons WHERE patron_id = ?"
            );
            pstmt.setString(1, patron_id);
            ResultSet rs = pstmt.executeQuery();

            boolean isValid = rs.next(); // Returns true if patron exists

            pstmt.close();
            conn.close();

            return isValid;
        } catch (Exception e) {
            System.out.println("Patron ID validation error: " + e.getMessage());
            return false;
        }
    }

    // Check if patron can borrow books
    private boolean canPatronBorrow() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Check current borrows count and overdue status
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT COUNT(*) as borrow_count FROM Borrowing_History " +
                            "WHERE patron_id = ? AND borrow_status IN ('B', 'O')");
            pstmt.setString(1, patron_id);   // Require specific patron_id from user
            ResultSet rs = pstmt.executeQuery();

            int currentBorrows = 0;
            if (rs.next())
                currentBorrows = rs.getInt("borrow_count");

            // Check for overdue or lost books
            pstmt = conn.prepareStatement(
                    "SELECT COUNT(*) as overdue_count FROM Borrowing_History " +
                            "WHERE patron_id = ? AND borrow_status IN ('O', 'L')");
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
            if (!check_PatronIDValidity() && !check_ClerkIDValidity()) {
                System.out.println("Invalid Patron ID or Clerk ID");
                return 0;
            } else {
                if (!canPatronBorrow()) {
                    System.out.println("Patron cannot borrow more books or has overdue items");
                    return 0;
                }
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

                // Check if book is available
                PreparedStatement checkBook = conn.prepareStatement(
                        "SELECT 1 FROM Books_Inventory bi " +
                                "WHERE bi.inventory_id = ? " +
                                "AND NOT EXISTS (SELECT 1 FROM Borrowing_History bh " +
                                "              WHERE bh.book_id = bi.inventory_id " +
                                "              AND bh.borrow_status IN ('B', 'O'))");
                checkBook.setString(1, book_id);
                ResultSet rs = checkBook.executeQuery();

                // If result from query is empty.
                if (!rs.next()) {
                    System.out.println("Book is not available for borrowing");
                    return 0;
                }

                // Generate new borrow id
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT MAX(borrow_id) FROM Borrowing_History");

                String maxBorrowNo = "BRW0000";
                if (rs.next())
                    maxBorrowNo = rs.getString(1);

                int borrowNoNumber = Integer.parseInt(maxBorrowNo.substring(3)) + 1;
                borrow_id = "BRW" + String.format("%04d", borrowNoNumber);

                // Insert borrowing record
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO Borrowing_History (borrow_id, date_borrowed, date_due, " +
                                "borrow_status, book_id, patron_id, clerk_id) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)");

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

                pstmt.executeUpdate();
                System.out.println("Borrowing transaction created successfully");

                pstmt.close();
                conn.close();
                return 1;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Process book return
    public int process_Return() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Get borrowing details -- Dropdown on what to return getList of borrow_id for that branch
            PreparedStatement getBorrowing = conn.prepareStatement(
                    "SELECT date_due FROM Borrowing_History WHERE borrow_id = ?");
            getBorrowing.setString(1, borrow_id);
            ResultSet rs = getBorrowing.executeQuery();

            if (!rs.next()) {
                System.out.println("Borrowing record not found");
                return 0;
            }

            // Calculate days overdue
            Date dueDate = rs.getDate("date_due");
            LocalDate currentDate = LocalDate.now();
            long daysOverdue = currentDate.toEpochDay() - dueDate.toLocalDate().toEpochDay();

            if (daysOverdue > 0) {
                // Create a Fines record, use fine function
                // MUST RETURN A FINES_ID -- Null if not overdue
            } else
                fines_id = null; // No fines if not overdue

            // Update borrowing record
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE Borrowing_History SET date_returned = ?, borrow_status = ?, " +
                            "fines_id = ? WHERE borrow_id = ?");

            pstmt.setDate(1, Date.valueOf(currentDate));
            pstmt.setString(2, "R");
            pstmt.setString(3, fines_id);
            pstmt.setString(4, borrow_id);
            pstmt.executeUpdate();

            System.out.println("Return processed successfully.");

            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Update an existing borrowing record
    public int update_Borrowing() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Check if borrowing record exists
            PreparedStatement checkBorrowing = conn.prepareStatement(
                    "SELECT 1 FROM Borrowing_History WHERE borrow_no = ?");
            checkBorrowing.setString(1, borrow_id);
            ResultSet rs = checkBorrowing.executeQuery();

            if (!rs.next()) {
                System.out.println("Borrowing record not found");
                return 0;
            }

            // Update borrowing record
            PreparedStatement updateBorrowing = conn.prepareStatement(
                    "UPDATE Borrowing_History SET date_borrowed = ?, date_due = ?, " +
                            "borrow_status = ?, clerk_id = ? WHERE borrow_no = ?"
            );

            updateBorrowing.setDate(1, date_borrowed);
            updateBorrowing.setDate(2, date_due);
            updateBorrowing.setString(3, borrow_status);
            updateBorrowing.setString(4, clerk_id);
            updateBorrowing.setString(5, borrow_id);

            int rowsAffected = updateBorrowing.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Borrowing record updated successfully");
                return 1;
            } else {
                System.out.println("Failed to update borrowing record");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


    // Delete a borrowing transaction
    public int delete_Borrowing() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE FROM Borrowing_History " +
                            "WHERE borrow_id = ?");
            pstmt.setString(1, borrow_id);
            int rowsAffected = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            if (rowsAffected > 0) {
                System.out.println("Borrowing transaction cancelled successfully");
                return 1;
            } else {
                System.out.println("Cannot cancel: Transaction not found or already processed");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Get borrowing details
    public int getBorrowing() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM Borrowing_History WHERE borrow_no = ?");
            pstmt.setString(1, borrow_id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                date_borrowed = rs.getDate("date_borrowed");
                date_due = rs.getDate("date_due");
                date_returned = rs.getDate("date_returned");
                borrow_status = rs.getString("borrow_status");
                book_id = rs.getString("book_id");
                patron_id = rs.getString("patron_id");
                fines_id = rs.getString("fines_id");
                clerk_id = rs.getString("clerk_id");

                pstmt.close();
                conn.close();
                return 1;
            }

            pstmt.close();
            conn.close();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


}
