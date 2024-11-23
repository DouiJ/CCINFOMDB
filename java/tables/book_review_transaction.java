package tables;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

// Transaction Data Tables
//   - Managed with Transaction Processing
//   - Create a Transaction
//   - Submit and Finalize a Transaction
//   - Transaction-Specific Actions
//   - Cancel a Transaction
//   - Delete a Transaction

public class book_review_transaction {
    private String rating_id;      // VARCHAR(10)
    private String rating_score;   // DECIMAL(2,1)
    private Date rating_date;      // DATE
    private String rating_comment; // VARCHAR(200)
    private String borrow_id;      // VARCHAR(10)
    private String status;         // ENUM
    private Connection conn;       // Connection instance passed in constructor

    // Constructor that accepts the connection
    public book_review_transaction(Connection conn) {
        this.rating_id = "";
        this.rating_score = null;
        this.rating_date = null;
        this.rating_comment = "";
        this.borrow_id = "";
        this.status = "";
        this.conn = conn;  // Initialize the connection passed through constructor
    }

    // Getter and Setter methods
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

    public int create_Review() {
        try {

            String date = java.time.LocalDate.now().toString();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = df.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(rating_id) FROM book_rating");

            String maxBranchID = "R0000";
            if (resultSet.next()) {
                maxBranchID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxBranchID = "R0000";
            }

            int branchIDNumber = Integer.parseInt(maxBranchID.substring(1)) + 1; // Extract the number part only and add 1
            rating_id = "R" + String.format("%04d", branchIDNumber);




            // Check if review has already been made
            PreparedStatement reviewAlreadyExists = conn.prepareStatement("SELECT 1 FROM Book_Rating WHERE borrow_id = ?");
            reviewAlreadyExists.setString(1, borrow_id);
            ResultSet rs = reviewAlreadyExists.executeQuery();


            if (rs.next()) {
                System.out.println("Review already exists for this borrowing number.");
                reviewAlreadyExists.close();
                return 0;
            }
            reviewAlreadyExists.close();

            // Insert new review
            PreparedStatement revStmt = conn.prepareStatement(
                    "INSERT INTO Book_Rating (rating_id, rating_score, rating_date, rating_comment, borrow_id, status) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            revStmt.setString(1, rating_id);
            revStmt.setFloat(2, Float.parseFloat(rating_score));
            revStmt.setDate(3, sqlDate);
            revStmt.setString(4, rating_comment);
            revStmt.setString(5, borrow_id);
            revStmt.setString(6, "A");

            int rowsInserted = revStmt.executeUpdate();
            revStmt.close();

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

    public int update_Review() {
        try {
            // Check if review record exists
            PreparedStatement reviewExistsStmt = conn.prepareStatement(
                    "SELECT 1 FROM Book_Rating WHERE borrow_id = ?");
            reviewExistsStmt.setString(1, borrow_id);
            ResultSet rs = reviewExistsStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Review does not exist for this borrowing number.");
                reviewExistsStmt.close();
                return 0;
            }
            reviewExistsStmt.close();

            // Update review record
            PreparedStatement updateStmt = conn.prepareStatement(
                    "UPDATE Book_Rating SET rating_score = ?, rating_date = ?, rating_comment = ? WHERE borrow_id = ?");
            updateStmt.setFloat(1, Float.parseFloat(rating_score));
            updateStmt.setDate(2, rating_date);
            updateStmt.setString(3, rating_comment);
            updateStmt.setString(4, borrow_id);

            int rowsUpdated = updateStmt.executeUpdate();
            updateStmt.close();

            if (rowsUpdated > 0) {
                System.out.println("Review updated successfully.");
                return 1;
            } else {
                System.out.println("Failed to update review.");
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

    public int cancel_Review() {
        try {
            // Check if review record exists
            PreparedStatement reviewExistsStmt = conn.prepareStatement(
                    "SELECT 1 FROM Book_Rating WHERE borrow_id = ?");
            reviewExistsStmt.setString(1, borrow_id);
            ResultSet rs = reviewExistsStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Review does not exist for this borrowing number.");
                reviewExistsStmt.close();
                return 0;
            }
            reviewExistsStmt.close();

            // Delete review record
            PreparedStatement cancelStmt = conn.prepareStatement(
                    "UPDATE Book_Rating SET status = ? WHERE borrow_id = ?");
            cancelStmt.setString(1, "C");
            cancelStmt.setString(2, borrow_id);

            cancelStmt.executeUpdate();
            cancelStmt.close();

            System.out.println("Review deleted successfully.");
            return 1;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int get_Review() {
        try {
            // Check if review record exists
            PreparedStatement reviewExistsStmt = conn.prepareStatement(
                    "SELECT rating_id, rating_score, rating_date, rating_comment, status FROM Book_Rating WHERE borrow_id = ?");
            reviewExistsStmt.setString(1, borrow_id);
            ResultSet rs = reviewExistsStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Review does not exist for this borrowing number.");
                reviewExistsStmt.close();
                return 0;
            }

            // Retrieve review details
            rating_id = rs.getString("rating_id");
            rating_score = String.valueOf(rs.getFloat("rating_score"));
            rating_date = rs.getDate("rating_date");
            rating_comment = rs.getString("rating_comment");
            status = rs.getString("status");

            reviewExistsStmt.close();

            System.out.println("Review retrieved successfully.");
            return 1;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }
}
