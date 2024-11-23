package tables;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class book_inventory_management {

    private final Connection connection;

    public book_inventory_management(Connection connection) {
        this.connection = connection;
    }

    public int add_Book(String isbn, String branch_id) {
        String inventory_id;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(inventory_id) FROM books_inventory")) {

            System.out.println("Connection to DB Successful.");

            String maxID = "I0000";
            if (rs.next()) {
                maxID = rs.getString(1);
            }

            if (maxID == null) {
                maxID = "I0000";
            }

            long idNumber = Integer.parseInt(maxID.substring(1)) + 1;
            inventory_id = "I" + String.format("%04d", idNumber);

            try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO books_inventory (inventory_id, isbn, branch_id) VALUES (?, ?, ?)")) {
                pstmt.setString(1, inventory_id);
                pstmt.setString(2, isbn);
                pstmt.setString(3, branch_id);

                int rowsAdded = pstmt.executeUpdate();

                if (rowsAdded > 0) {
                    System.out.println("Record successfully created.");
                    return 1;
                } else {
                    System.out.println("Record unsuccessfully created.");
                    return 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int update_Book(String inventory_id, String isbn, String branch_id) {
        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE books_inventory SET isbn=?, branch_id=? WHERE inventory_id=?")) {

            System.out.println("Connection to DB Successful.");

            pstmt.setString(1, isbn);
            pstmt.setString(2, branch_id);
            pstmt.setString(3, inventory_id);

            int rowsUpdated = pstmt.executeUpdate();

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

    public int delete_Book(String inventory_id) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM books_inventory WHERE inventory_id=?")) {

            System.out.println("Connection to DB Successful.");

            pstmt.setString(1, inventory_id);

            int rowsDeleted = pstmt.executeUpdate();

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