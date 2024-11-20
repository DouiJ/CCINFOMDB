package libraryDB;

import java.sql.*;

public class book_detail_management {

    private String isbn;
    private String title;
    private String price;
    private String author_last_name;
    private String author_first_name;


    public book_detail_management() {
        isbn = "";
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }

    public String add_Book_details() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO book_details (isbn, title, price, author_last_name, author_first_name) VALUES (?, ?, ?, ?, ?)");

            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setDouble(3, Double.parseDouble(price));
            pstmt.setString(4, author_last_name);
            pstmt.setString(5, author_first_name);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            connection.close();
            return isbn;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    public int update_Book_details() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Book_Details SET title=?, price=?, author_last_name=?, author_first_name=? WHERE isbn=?");

            pstmt.setString(1, title);
            pstmt.setDouble(2, Double.parseDouble(price));
            pstmt.setString(3, author_last_name);
            pstmt.setString(4, author_first_name);
            pstmt.setString(5, isbn);

            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            connection.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int delete_Book_details() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM book_details WHERE isbn=?");
            pstmt.setString(1, isbn);

            pstmt.executeUpdate();
            System.out.println("Record was deleted");

            pstmt.close();
            connection.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int get_Book_details() {
        int recordcount = 0;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM book_details WHERE isbn=?");
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {  // Since ISBN should be unique, just check once
                title = rs.getString("title");
                price = rs.getString("price");
                author_last_name = rs.getString("author_last_name");
                author_first_name = rs.getString("author_first_name");
                recordcount++; // Only one record expected for a unique ISBN
            }

            rs.close();
            return recordcount;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }

    }

}

