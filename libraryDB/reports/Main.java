package libraryDB.reports;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Main {

    public Main() {
        // Load data from insert_data_script.sql
        loadDataFromScript("path/to/insert_data_script.sql");

        // Create reports instance
        reports report = new reports();
        report.year = 2023; // Set the desired year
        report.month = 5; // Set the desired month

        // Create and display patronActivityPanel in a separate window
        List<Object[]> patronData = report.patronActivity();
        JFrame patronFrame = new JFrame("Patron Activity Panel");
        patronFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patronFrame.setSize(400, 400);
        reportPatronActivityPanel patronPanel = new reportPatronActivityPanel(patronData);
        patronFrame.add(patronPanel);
        patronFrame.setVisible(true);

        // Create and display reportTop10BooksPanel in a separate window
        List<Object[]> top10BooksData = report.top10Books();
        JFrame top10BooksFrame = new JFrame("Top 10 Books Panel");
        top10BooksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        top10BooksFrame.setSize(400, 400);
        reportTop10BooksPanel top10BooksPanel = new reportTop10BooksPanel(top10BooksData);
        top10BooksFrame.add(top10BooksPanel);
        top10BooksFrame.setVisible(true);

        // Create and display reportNewlyAcquiredBooksPanel in a separate window
        List<Object[]> newlyAcquiredBooksData = report.newlyAcquiredBooks();
        JFrame newlyAcquiredBooksFrame = new JFrame("Newly Acquired Books Panel");
        newlyAcquiredBooksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newlyAcquiredBooksFrame.setSize(400, 400);
        reportNewlyAcquiredBooksPanel newlyAcquiredBooksPanel = new reportNewlyAcquiredBooksPanel(
                newlyAcquiredBooksData);
        newlyAcquiredBooksFrame.add(newlyAcquiredBooksPanel);
        newlyAcquiredBooksFrame.setVisible(true);

        // Create and display reportBookRatingPanel in a separate window
        List<Object[]> bookRatingsData = report.bookRatings();
        JFrame bookRatingsFrame = new JFrame("Book Ratings Panel");
        bookRatingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookRatingsFrame.setSize(400, 400);
        reportBookRatingPanel bookRatingsPanel = new reportBookRatingPanel(bookRatingsData);
        bookRatingsFrame.add(bookRatingsPanel);
        bookRatingsFrame.setVisible(true);
    }

    private void loadDataFromScript(String scriptPath) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
                Statement stmt = conn.createStatement();
                BufferedReader br = new BufferedReader(new FileReader(scriptPath))) {

            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sql.append(line);
                if (line.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0);
                }
            }
            System.out.println("Data loaded from script successfully.");
        } catch (Exception e) {
            System.out.println("Error loading data from script: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
