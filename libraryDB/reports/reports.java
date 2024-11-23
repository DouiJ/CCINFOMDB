package libraryDB.reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class reports {

    public int year;
    public int month;
    public int year1;
    public int year2;
    public int recordcount;

    public reports() {
    }

    // REPORT 1 : TOP 10 BOOKS
    public List<Object[]> top10Books() {
        recordcount = 0;
        List<Object[]> data = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT bh.Book_id, bd.title, " +
                    "CONCAT(bd.author_first_name, ' ', bd.author_last_name) AS author, " +
                    "COUNT(bh.Book_id) AS borrow_count " +
                    "FROM Borrowing_History bh " +
                    "JOIN Book_Details bd ON bh.Book_id = bd.isbn " +
                    "WHERE YEAR(bh.Borrow_date) = ? " +
                    "AND MONTH(bh.Borrow_date) = ? " +
                    "GROUP BY bh.Book_id, bd.title, author " +
                    "ORDER BY borrow_count DESC " +
                    "LIMIT 10";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, year);
            pstmt.setInt(2, month);
            System.out.println("SQL Statement Prepared");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                recordcount++;
                Object[] row = {
                        rs.getString("Book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("borrow_count")
                };
                data.add(row);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    // Method to transfer data to top10BooksPanel
    public void updateTop10BooksPanel(JPanel reportTop10BooksPanel, List<Object[]> data) {
        reportTop10BooksPanel.removeAll();
        String[] columnNames = { "Book ID", "Title", "Author", "Borrow Count" };
        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        reportTop10BooksPanel.add(scrollPane);
        reportTop10BooksPanel.revalidate();
        reportTop10BooksPanel.repaint();
    }

    // REPORT 2 : NEWLY ACQUIRED BOOKS
    public List<Object[]> newlyAcquiredBooks() {
        recordcount = 0;
        List<Object[]> data = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT ba.acquisition_id, bd.title, " +
                    "CONCAT(bd.author_first_name, ' ', bd.author_last_name) AS author, " +
                    "ba.acquisition_date " +
                    "FROM Book_Acquisitions ba " +
                    "JOIN Book_Details bd ON ba.isbn = bd.isbn " +
                    "WHERE ((YEAR(ba.acquisition_date) = ? AND MONTH(ba.acquisition_date) = ?) " +
                    "OR (YEAR(ba.acquisition_date) = ? AND MONTH(ba.acquisition_date) = ?)) " +
                    "ORDER BY ba.acquisition_date DESC";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(2, year1);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year2);
            pstmt.setInt(5, month);
            System.out.println("SQL Statement Prepared");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                recordcount++;
                Object[] row = {
                        rs.getString("acquisition_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDate("acquisition_date")
                };
                data.add(row);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    // Method to transfer data to newlyAcquiredBooksPanel
    public void updateNewlyAcquiredBooksPanel(JPanel reportNewlyAcquiredBooksPanel, List<Object[]> data) {
        reportNewlyAcquiredBooksPanel.removeAll();
        String[] columnNames = { "Acquisition ID", "Title", "Author", "Acquisition Date" };
        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        reportNewlyAcquiredBooksPanel.add(scrollPane);
        reportNewlyAcquiredBooksPanel.revalidate();
        reportNewlyAcquiredBooksPanel.repaint();
    }

    // REPORT 3 : PATRON ACTIVITY
    public List<Object[]> patronActivity() {
        recordcount = 0;
        List<Object[]> data = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT p.patron_id, p.first_name, p.last_name, p.status, " +
                    "COUNT(DISTINCT bh.borrow_id) AS total_borrows, " +
                    "COALESCE(SUM(bf.fine_amount), 0) AS total_fines, " +
                    "SUM(CASE WHEN bh.date_due < bh.date_returned THEN 1 ELSE 0 END) AS books_overdue, " +
                    "AVG(DATEDIFF(bh.date_returned, bh.date_due)) AS avg_days_to_return " +
                    "FROM Patrons p " +
                    "LEFT JOIN Borrowing_History bh ON p.patron_id = bh.patron_id " +
                    "LEFT JOIN Borrowing_Fines bf ON bh.borrow_id = bf.borrow_id " +
                    "WHERE (MONTH(bh.date_borrowed) = ? AND YEAR(bh.date_borrowed) = ?) " +
                    "OR (MONTH(bf.payment_date) = ? AND YEAR(bf.payment_date) = ?) " +
                    "GROUP BY p.patron_id, p.first_name, p.last_name, p.status " +
                    "ORDER BY p.last_name, p.first_name";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, month);
            pstmt.setInt(2, year1);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year2);
            System.out.println("SQL Statement Prepared");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                recordcount++;
                Object[] row = {
                        rs.getString("patron_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("status"),
                        rs.getInt("total_borrows"),
                        rs.getDouble("total_fines"),
                        rs.getInt("books_overdue"),
                        rs.getDouble("avg_days_to_return")
                };
                data.add(row);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    // Method to transfer data to patronActivityPanel
    public void updatePatronActivityPanel(JPanel reportPatronActivityPanel, List<Object[]> data) {
        reportPatronActivityPanel.removeAll();
        String[] columnNames = { "Patron ID", "First Name", "Last Name", "Status", "Total Borrows", "Total Fines",
                "Books Overdue", "Avg Days to Return" };
        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        reportPatronActivityPanel.add(scrollPane);
        reportPatronActivityPanel.revalidate();
        reportPatronActivityPanel.repaint();
    }

    // REPORT 4 : BOOK RATINGS
    public List<Object[]> bookRatings() {
        recordcount = 0;
        List<Object[]> data = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT br.isbn, bd.title, " +
                    "CONCAT(bd.author_first_name, ' ', bd.author_last_name) AS author, " +
                    "AVG(br.rating_score) AS avg_rating, " +
                    "COUNT(br.rating_id) AS total_ratings " +
                    "FROM Book_Rating br " +
                    "JOIN Borrowing_History bh ON br.borrow_id = bh.borrow_id " +
                    "JOIN Book_Details bd ON bh.book_id = bd.isbn " +
                    "WHERE ((YEAR(br.rating_date) = ? AND MONTH(br.rating_date) = ?) " +
                    "OR (YEAR(br.rating_date) = ? AND MONTH(br.rating_date) = ?)) " +
                    "GROUP BY br.isbn, bd.title, author " +
                    "ORDER BY avg_rating DESC";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(2, year1);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year2);
            pstmt.setInt(5, month);
            System.out.println("SQL Statement Prepared");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                recordcount++;
                Object[] row = {
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("avg_rating"),
                        rs.getInt("total_ratings")
                };
                data.add(row);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    // Method to transfer data to bookRatingsPanel
    public void updateBookRatingsPanel(JPanel reportBookRatingsPanel, List<Object[]> data) {
        reportBookRatingsPanel.removeAll();
        String[] columnNames = { "ISBN", "Title", "Author", "Average Rating", "Total Ratings" };
        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        reportBookRatingsPanel.add(scrollPane);
        reportBookRatingsPanel.revalidate();
        reportBookRatingsPanel.repaint();
    }
}
