package tables;

import java.sql.*;

public class book_detail_management {

    private final Connection connection;

    public book_detail_management(Connection connection) {
        this.connection = connection;
    }

    public int add_BookDetails(String isbn, String title, String price, String authorLastName, String authorFirstName) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO book_details (isbn, title, price, author_last_name, author_first_name) VALUES (?, ?, ?, ?, ?)");

            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setDouble(3, Double.parseDouble(price));
            pstmt.setString(4, authorLastName);
            pstmt.setString(5, authorFirstName);

            int rowsAdded = pstmt.executeUpdate();
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

    public int update_BookDetails(String isbn, String title, String price, String authorLastName, String authorFirstName) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE book_details SET title=?, price=?, author_last_name=?, author_first_name=? WHERE isbn=?");

            pstmt.setString(1, title);
            pstmt.setDouble(2, Double.parseDouble(price));
            pstmt.setString(3, authorLastName);
            pstmt.setString(4, authorFirstName);
            pstmt.setString(5, isbn);

            int rowsUpdated = pstmt.executeUpdate();
            pstmt.close();

            if (rowsUpdated > 0) {
                System.out.println("Record successfully updated.");
                return 1;
            } else {
                System.out.println("Record unsuccessfully updated.");
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

    public int delete_BookDetails(String isbn) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "DELETE FROM book_details WHERE isbn=?");
            pstmt.setString(1, isbn);

            int rowsDeleted = pstmt.executeUpdate();
            pstmt.close();

            if (rowsDeleted > 0) {
                System.out.println("Record successfully deleted.");
                return 1;
            } else {
                System.out.println("Record unsuccessfully deleted.");
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
}