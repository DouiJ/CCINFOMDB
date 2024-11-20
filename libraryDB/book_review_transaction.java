package libraryDB;

import java.sql.*;
import java.time.LocalDate;

//Transaction Data Tables
//   - Managed with Transaction Processing
//   - Create a Transaction
//   - Submit and Finalize a Transaction
//   - Transaction-Specific Actions
//   - Cancel a Transaction
//   - Delete a Transaction

public class book_review_transaction {
    public String rating_id; // VARCHAR(10)
    public String rating_score; // DECIMAL(2,1)
    public String rating_date; // DATE
    public String rating_comment; // VARCHAR(200)
    public String borrow_id; // VARCHAR(10)

    // constructor
    public book_review_transaction() {
        rating_id = "";
        rating_score = "";
        rating_date = "";
        rating_comment = "";
        borrow_id = "";
    }

//    public boolean canPatronReview() {
//        try  (Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://127.0.0.1:3306/library",
//                "root",
//                "3d6%vQmT"
//        ))  {
//            // Fetch patron_id from Borrowing_History table based on borrow_no
//            String sql = "SELECT patron_id FROM Borrowing_History WHERE borrow_no = ?";
//            PreparedStatement fetchPatronIdStmt = connection.prepareStatement(sql);
//
//            fetchPatronIdStmt.setString(1, borrow_no);
//            ResultSet rs = fetchPatronIdStmt.executeQuery();
//
//            if (!rs.next()) {
//                System.out.println("Borrowing record not found");
//                fetchPatronIdStmt.close();
//                connection.close();
//                return false;
//            }
//
//            String patron_id = rs.getString("patron_id");
//            fetchPatronIdStmt.close();
//
//            // Check if Patron has an acitve borrowing with the current book
//            PreparedStatement pstmt = connection.prepareStatement(
//                    "SELECT 1 FROM Borrowing_History WHERE patron_id = ? AND borrow_no = ? AND borrow_status = 'B'");
//            pstmt.setString(1, patron_id);
//            pstmt.setString(2, borrow_no);
//
//            rs = pstmt.executeQuery();
//
//            boolean canReview = rs.next(); // returns true if
//
//            pstmt.close();
//            connection.close();
//            rs.close();
//            return canReview;
//        } catch (SQLException e) {
//            System.out.println("Database error: " + e.getMessage());
//            return false;
//        } catch (Exception e) {
//            System.out.println("Unexpected error: " + e.getMessage());
//            return false;
//        }
//    }

    public String add_Borrowing_fines() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(fine_id) FROM Borrowing_Fines");

            //Get the highest id value
            String maxID = "F0000";
            if (resultSet.next()) {
                maxID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxID = "F0000";
            }

            int iDNumber = Integer.parseInt(maxID.substring(1)) + 1; //Extract the number part only and add 1
            this.fine_id = "B" + String.format("%04d", iDNumber);

            String sql = "INSERT INTO Borrowing_Fines (fine_id, fine_amount, payment_date, borrow_id, clerk_id, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, fine_id);
            pstmt.setDouble(2, Double.parseDouble(fine_amount));
            pstmt.setString(3, payment_date);
            pstmt.setString(4, borrow_id);
            pstmt.setString(5, clerk_id);
            pstmt.setString(6, status);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            connection.close();
            return fine_id;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    public int create_Review() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {

                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

                // Check if review has already been made
                PreparedStatement reviewAlreadyExists = conn.prepareStatement(
                        "SELECT 1 FROM Book_Reviews WHERE borrow_no = ?");
                reviewAlreadyExists.setString(1, borrow_no);
                ResultSet rs = reviewAlreadyExists.executeQuery();

                if (rs.next()) {
                    System.out.println("Review already exists for this borrowing number.");
                    reviewAlreadyExists.close();
                    conn.close();
                    return 0;
                }
                reviewAlreadyExists.close();

                // Insert new review
                PreparedStatement revStmt = conn.prepareStatement(
                        "INSERT INTO Book_Reviews (rating_id, rating_score, rating_date, rating_comment, borrow_no) " +
                                "VALUES (?, ?, ?, ?, ?)");
                revStmt.setString(1, rating_id);
                revStmt.setFloat(2, rating_score);
                revStmt.setDate(3, rating_date);
                revStmt.setString(4, rating_comment);
                revStmt.setString(5, borrow_no);

                int rowsInserted = revStmt.executeUpdate();
                revStmt.close();
                conn.close();

                if (rowsInserted > 0) {
                    System.out.println("Review created successfully.");
                    return 1;
                } else {
                    System.out.println("Failed to create review.");
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

    public int edit_Review() {
        try {
            // Check if a review is even possible (cannot review a nonexistent book)
            if (!canPatronReview()) {
                System.out.println("Book has not been borrowed or is not in active inventory.");
                return 0;
            } else {
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

                // Check if review record exists
                PreparedStatement reviewExistsStmt = conn.prepareStatement(
                        "SELECT 1 FROM Book_Reviews WHERE borrow_no = ?");
                reviewExistsStmt.setString(1, borrow_no);
                ResultSet rs = reviewExistsStmt.executeQuery();

                if (!rs.next()) {
                    System.out.println("Review does not exist for this borrowing number.");
                    reviewExistsStmt.close();
                    conn.close();
                    return 0;
                }
                reviewExistsStmt.close();

                // Update review record
                PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE Book_Reviews SET rating_score = ?, rating_date = ?, rating_comment = ? WHERE borrow_no = ?");
                updateStmt.setFloat(1, rating_score);
                updateStmt.setDate(2, rating_date);
                updateStmt.setString(3, rating_comment);
                updateStmt.setString(4, borrow_no);

                // Store success into rowsUpdated
                int rowsUpdated = updateStmt.executeUpdate();
                updateStmt.close();
                conn.close();

                // Inform user if operation was successful
                if (rowsUpdated > 0) {
                    System.out.println("Review updated successfully.");
                    return 1;
                } else {
                    System.out.println("Failed to update review.");
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int delete_Review() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Check if review record exists
            PreparedStatement reviewExistsStmt = conn.prepareStatement(
                    "SELECT 1 FROM Book_Reviews WHERE borrow_no = ?");
            reviewExistsStmt.setString(1, borrow_no);
            ResultSet rs = reviewExistsStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Review does not exist for this borrowing number.");
                reviewExistsStmt.close();
                conn.close();
                return 0;
            }
            reviewExistsStmt.close();

            // Delete review record
            PreparedStatement deleteStmt = conn.prepareStatement(
                    "DELETE FROM Book_Reviews WHERE borrow_no = ?");
            deleteStmt.setString(1, borrow_no);

            int rowsDeleted = deleteStmt.executeUpdate();
            deleteStmt.close();
            conn.close();

            if (rowsDeleted > 0) {
                System.out.println("Review deleted successfully.");
                return 1;
            } else {
                System.out.println("Failed to delete review.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int get_Review() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Check if review record exists
            PreparedStatement reviewExistsStmt = conn.prepareStatement(
                    "SELECT rating_id, rating_score, rating_date, rating_comment FROM Book_Reviews WHERE borrow_no = ?");
            reviewExistsStmt.setString(1, borrow_no);
            ResultSet rs = reviewExistsStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Review does not exist for this borrowing number.");
                reviewExistsStmt.close();
                conn.close();
                return 0;
            }

            // Retrieve review details
            rating_id = rs.getString("rating_id");
            rating_score = rs.getFloat("rating_score");
            rating_date = rs.getDate("rating_date");
            rating_comment = rs.getString("rating_comment");

            reviewExistsStmt.close();
            conn.close();

            System.out.println("Review retrieved successfully.");
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
