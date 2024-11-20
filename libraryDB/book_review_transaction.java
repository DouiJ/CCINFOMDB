package libraryDB;

import java.sql.*;

public class book_review_transaction {
    private String rating_id;      // VARCHAR(10)
    private String rating_score;   // DECIMAL(2,1)
    private Date rating_date;      // DATE
    private String rating_comment; // VARCHAR(200)
    private String borrow_id;      // VARCHAR(10)
    private String status;         // ENUM

    // constructor
    public book_review_transaction() {
        rating_id = "";
        rating_score = null;
        rating_date = null;
        rating_comment = "";
        borrow_id = "";
        status = "";
    }

    public String getRating_id() {
        return rating_id;
    }

    public void setRating_id(String rating_id) {
        this.rating_id = rating_id;
    }

    public String getRating_score() {
        return rating_score;
    }

    public void setRating_score(String rating_score) {
        this.rating_score = rating_score;
    }

    public Date getRating_date() {
        return rating_date;
    }

    public void setRating_date(Date rating_date) {
        this.rating_date = rating_date;
    }

    public String getRating_comment() {
        return rating_comment;
    }

    public void setRating_comment(String rating_comment) {
        this.rating_comment = rating_comment;
    }

    public String getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(String borrow_id) {
        this.borrow_id = borrow_id;
    }

    public boolean canPatronReview() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Fetch patron_id from Borrowing_History table based on borrow_id
            PreparedStatement fetchPatronIdStmt = conn.prepareStatement(
                    "SELECT patron_id FROM Borrowing_History WHERE borrow_id = ?");
            fetchPatronIdStmt.setString(1, borrow_id);
            ResultSet rs = fetchPatronIdStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Borrowing record not found");
                fetchPatronIdStmt.close();
                conn.close();
                return false;
            }

            String patron_id = rs.getString("patron_id");
            fetchPatronIdStmt.close();

            // Check if Patron has an active borrowing with the current book
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT 1 FROM Borrowing_History WHERE patron_id = ? AND borrow_id = ? AND borrow_status = 'B'");
            pstmt.setString(1, patron_id);
            pstmt.setString(2, borrow_id);

            rs = pstmt.executeQuery();

            boolean canReview = rs.next(); // returns true if

            pstmt.close();
            conn.close();
            return canReview;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int create_Review() {
        try {
            if (!canPatronReview()) {
                System.out.println("Book has not been borrowed or is not in active inventory.");
                return 0;
            } else {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

                // Check if review has already been made
                PreparedStatement reviewAlreadyExists = conn.prepareStatement("SELECT 1 FROM Book_Reviews WHERE borrow_id = ?");
                reviewAlreadyExists.setString(1, borrow_id);
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
                        "INSERT INTO Book_Reviews (rating_id, rating_date, rating_score,  rating_comment, borrow_id, status) " +
                                "VALUES (?, ?, ?, ?, ?, ?)");
                revStmt.setString(1, rating_id);
                revStmt.setDate(2, rating_date);
                revStmt.setFloat(3, Float.parseFloat(rating_score));
                revStmt.setString(4, rating_comment);
                revStmt.setString(5, borrow_id);
                revStmt.setString(6, "A");

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
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                        "SELECT 1 FROM Book_Reviews WHERE borrow_id = ?");
                reviewExistsStmt.setString(1, borrow_id);
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
                        "UPDATE Book_Reviews SET rating_score = ?, rating_date = ?, rating_comment = ? WHERE borrow_id = ?");
                updateStmt.setFloat(1, rating_score);
                updateStmt.setDate(2, rating_date);
                updateStmt.setString(3, rating_comment);
                updateStmt.setString(4, borrow_id);

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
                    "SELECT 1 FROM Book_Reviews WHERE borrow_id = ?");
            reviewExistsStmt.setString(1, borrow_id);
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
                    "DELETE FROM Book_Reviews WHERE borrow_id = ?");
            deleteStmt.setString(1, borrow_id);

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
                    "SELECT rating_id, rating_score, rating_date, rating_comment FROM Book_Reviews WHERE borrow_id = ?");
            reviewExistsStmt.setString(1, borrow_id);
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
