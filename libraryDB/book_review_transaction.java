package libraryDB;

import java.sql.*;
import java.time.LocalDate;

public class book_review_transaction {
    public String rating_id; // VARCHAR(10)
    public Float rating_score; // DECIMAL(2,1)
    public Date rating_date; // DATE
    public String rating_comment; // VARCHAR(200)
    public String borrow_no; // VARCHAR(10)

    // constructor
    public book_review_transaction() {
        rating_id = "";
        rating_score = null;
        rating_date = null;
        rating_comment = "";
        borrow_no = "";
    }

    public boolean canPatronReview() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Fetch patron_id from Borrowing_History table based on borrow_no
            PreparedStatement fetchPatronIdStmt = conn.prepareStatement(
                    "SELECT patron_id FROM Borrowing_History WHERE borrow_no = ?");

            fetchPatronIdStmt.setString(1, borrow_no);
            ResultSet rs = fetchPatronIdStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Borrowing record not found");
                fetchPatronIdStmt.close();
                conn.close();
                return false;
            }

            String patron_id = rs.getString("patron_id");
            fetchPatronIdStmt.close();

            // Check if Patron has an acitve borrowing with the current book
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT 1 FROM Borrowing_History WHERE patron_id = ? AND borrow_no = ? AND borrow_status = 'B'");
            pstmt.setString(1, patron_id);
            pstmt.setString(2, borrow_no);

            rs = pstmt.executeQuery();

            boolean canReview = rs.next();

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
            }

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int update_Review() {

    }

    public int delete_Review() {

    }

    public int get_Review() {

    }

}
