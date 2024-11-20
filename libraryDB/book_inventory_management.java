package libraryDB;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static libraryDB.branch_menu.getCurrentBranchID;

public class book_inventory_management {

    public String inventory_id;
    public String isbn;
    public String branch_id;

    public String title;
    public String genre;
    public Double price;
    public String author_last_name;
    public String author_first_name;




    public book_inventory_management() {
        inventory_id = "";
        isbn = "";
        branch_id = "";
    }

    public int add_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(inventory_id) FROM books_inventory");
            
            String maxID = "0";
            while(rs.next())
                maxID = rs.getString(1);

            if (maxID == null)
            {
                maxID = "0";
            }
            
            long idnumber = Integer.parseInt(maxID) + 1;
            inventory_id = String.format("%010d", idnumber);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO books_inventory (inventory_id, isbn, branch_id) VALUES (?, ?, ?)");

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

    public int add_ISBN() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO book_details (isbn, title, genre, price, author_last_name, author_first_name) VALUES (?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setString(3, genre);
            pstmt.setDouble(4, price);
            pstmt.setString(5, author_last_name);
            pstmt.setString(6, author_first_name);

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

    public int update_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Books_Inventory SET isbn=?, branch_id=? WHERE inventory_id=?");

            pstmt.setString(1, isbn);
            pstmt.setString(2, branch_id);
            pstmt.setString(3, inventory_id);;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Book_Details SET title=?, genre=?, price=?, author_last_name=?, author_first_name=? WHERE isbn=?");

            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setDouble(3, price);
            pstmt.setString(4, author_last_name);
            pstmt.setString(5, author_first_name);
            pstmt.setString(6, isbn);

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

    public int delete_ISBN() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM book_details WHERE isbn=?");
            pstmt.setString(1, isbn);

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

    // Delete an Existing Record
    public int delete_Book() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM books_inventory WHERE inventory_id=?");
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

    public int get_ISBN() {
        int recordcount = 0;

        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM book_details WHERE isbn=?");
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                title = rs.getString("title");
                genre = rs.getString("genre");
                price = rs.getDouble("price");
                author_last_name = rs.getString("author_last_name");
                author_first_name = rs.getString("author_first_name");
                recordcount++;
            }

            return recordcount;
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

}
