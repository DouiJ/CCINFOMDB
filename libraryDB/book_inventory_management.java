package libraryDB;

import java.sql.*;

public class book_inventory_management {

    public String inventory_id;  // VARCHAR(10)
    public String isbn;             // INT
    public String branch_id;     // VARCHAR(13)

    public book_inventory_management() {
        inventory_id = "";
        isbn = "";
        branch_id = "";
    }

    //        1. Core Data Tables
//                - Managed with Records Management
//                - Create a new Record
//                - Update an Existing Record
//                - Delete an Existing Record
//                - Deactivate an Existing Record
//                - View one Record
//        - List Records using a Filter

    // Create a new Record
    public int add_Book() {
        try {

            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(inventory_id) FROM Books_Inventory");

            String maxInv = "";
            while(rs.next())
                maxInv = rs.getString(1);

            int invNumber = Integer.parseInt(maxInv.substring(1)) + 1;
            String inventory_id = String.format("%010d", invNumber);

            // Inserting new record
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Books_Inventory (inventory_id, isbn, branch_id) VALUES (?, ?, ?)");

            pstmt.setString(1, inventory_id);        // Automated, starts at "E0001" parse to add 1 per record
            pstmt.setString(2, isbn);
            pstmt.setString(3, branch_id);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Update an Existing Record
    public int update_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Books_Inventory SET isbn=?, branch_id=? WHERE inventory_id=?");

            pstmt.setString(1, isbn);
            pstmt.setString(2, branch_id);;

            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int update_ISBN() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Book_Details SET title=?, genre=?, price=?, author_last_name=?, author_first_name=? WHERE isbn=?");

            pstmt.setString(1, isbn);
            pstmt.setString(2, branch_id);;

            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Delete an Existing Record
    public int delete_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Books_Inventory WHERE inventory_id=?");
            pstmt.setString(1, inventory_id);

            pstmt.executeUpdate();
            System.out.println("Record was deleted");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // View one Record
    public int get_Book() {
        int recordcount = 0;

        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
