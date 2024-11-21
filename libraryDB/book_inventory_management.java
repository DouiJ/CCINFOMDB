package libraryDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static libraryDB.branch_menu.getCurrentBranchID;

public class book_inventory_management {

    private String inventory_id;
    private String isbn;
    private String branch_id;

    public book_inventory_management() {
        inventory_id = "";
        isbn = "";
        branch_id = "";
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getInventory_id() {
        return inventory_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public int add_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(inventory_id) FROM books_inventory");
            
            String maxID = "I0000";
            while(rs.next())
                maxID = rs.getString(1);

            if (maxID == null)
                maxID = "I0000";

            long idNumber = Integer.parseInt(maxID.substring(1)) + 1;
            this.inventory_id = "I" + String.format("%04d", idNumber);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO books_inventory (inventory_id, isbn, branch_id) VALUES (?, ?, ?)");
            pstmt.setString(1, inventory_id);
            pstmt.setString(2, isbn);
            pstmt.setString(3, branch_id);

            int rowsAdded = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

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

    public int update_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Books_Inventory SET isbn=?, branch_id=? WHERE inventory_id=?");

            pstmt.setString(1, isbn);
            pstmt.setString(2, branch_id);
            pstmt.setString(3, inventory_id);;

            int rowsUpdated = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

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

    // Delete an Existing Record
    public int delete_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM books_inventory WHERE inventory_id=?");
            pstmt.setString(1, inventory_id);

            int rowsDeleted = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

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

    // View one Record
    public int get_Book() {
        int recordcount = 0;

        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Books_Inventory WHERE inventory_id=?");
            pstmt.setString(1, inventory_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                isbn = rs.getString("isbn");
                branch_id = rs.getString("branch_id");
                recordcount++;
            }

            return recordcount;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    // Return List of Books in Branch
    public List<String> get_Books_In_Branch() {
        List<String> bookList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("SELECT inventory_id FROM books_inventory WHERE branch_id=?");
            pstmt.setString(1, getCurrentBranchID()); // Use the current branch ID
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
                bookList.add(rs.getString("inventory_id"));

            pstmt.close();
            conn.close();
            return bookList;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

}
