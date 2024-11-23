package libraryDB.reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class reports {

    public int year;
    public int month;
    public int recordcount;

    public reports() {
    }

    // REPORT 1 : TOP 10 BOOKS
    public int top10Books() {
        recordcount = 0;
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT bh.Book_id, COUNT(bh.Book_id) AS borrow_count " +
                    "FROM Borrowing_History bh " +
                    "WHERE YEAR(bh.Borrow_date) = ? " +
                    "AND MONTH(bh.Borrow_date) = ? " +
                    "GROUP BY bh.Book_id " +
                    "ORDER BY borrow_count DESC " +
                    "LIMIT 10";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, year);
            pstmt.setInt(2, month);
            System.out.println("SQL Statement Prepared");

            ResultSet rs = pstmt.executeQuery();

            System.out.printf("%-10s %10s\n", "Book ID", "Borrow Count");
            while (rs.next()) {
                recordcount++;
                System.out.printf("%-10s %10d\n", rs.getString("Book_id"), rs.getInt("borrow_count"));
            }

            rs.close();
            pstmt.close();
            conn.close();
            return recordcount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // REPORT 2 : NEWLY ACQUIRED BOOKS
    public int newlyAcquiredBooks() {
        recordcount = 0;
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT p.patron_id, p.first_name, p.last_name, " +
                    "COUNT(DISTINCT bh.borrow_id) AS total_borrows, " +
                    "SUM(bf.fine_amount) AS total_fines, " +
                    "SUM(CASE WHEN bh.date_due < bh.date_returned THEN 1 ELSE 0 END) AS books_overdue, " +
                    "AVG(DATEDIFF(bh.date_returned, bh.date_due)) AS avg_days_to_return " +
                    "FROM Patrons p " +
                    "LEFT JOIN Borrowing_History bh ON p.patron_id = bh.patron_id " +
                    "LEFT JOIN Borrowing_Fines bf ON bh.borrow_id = bf.borrow_id " +
                    "WHERE (MONTH(bh.date_borrowed) = ? AND YEAR(bh.date_borrowed) = ?) " +
                    "OR (MONTH(bf.payment_date) = ? AND YEAR(bf.payment_date) = ?) " +
                    "GROUP BY p.patron_id, p.first_name, p.last_name " +
                    "ORDER BY p.last_name, p.first_name";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, month);
            pstmt.setInt(2, year);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year);
            System.out.println("SQL Statement Prepared");

            ResultSet rs = pstmt.executeQuery();

            System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-20s\n",
                    "Patron ID", "First Name", "Last Name",
                    "Total Borrows", "Total Fines", "Books Overdue", "Avg Days to Return");
            while (rs.next()) {
                recordcount++;
                System.out.printf("%-10s %-15s %-15s %-15d %-15.2f %-15d %-20.2f\n",
                        rs.getString("patron_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("total_borrows"),
                        rs.getDouble("total_fines"),
                        rs.getInt("books_overdue"),
                        rs.getDouble("avg_days_to_return"));
            }

            rs.close();
            pstmt.close();
            conn.close();
            return recordcount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
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
            pstmt.setInt(2, year);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year);
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

    // REPORT 4 : BOOK RATINGS
    public List<Object[]> report_BookRatings() {
        recordcount = 0;
        List<Object[]> data = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful");

            String sql = "SELECT br.isbn, bd.title, " +
                    "AVG(br.rating_score) AS avg_rating, " +
                    "COUNT(br.rating_id) AS total_ratings " +
                    "FROM Book_Rating br " +
                    "JOIN Borrowing_History bh ON br.borrow_id = bh.borrow_id " +
                    "JOIN Book_Details bd ON bh.book_id = bd.isbn " +
                    "WHERE bh.branch_id = ? " +
                    "AND ((YEAR(br.rating_date) = ? AND MONTH(br.rating_date) = ?) " +
                    "OR (YEAR(br.rating_date) = ? AND MONTH(br.rating_date) = ?)) " +
                    "GROUP BY br.isbn, bd.title " +
                    "ORDER BY avg_rating DESC";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, branch_id);
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
}
