package panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class combinedReportPanel extends JPanel {

    // Panels for each report
    private reportPanel topBorrowedBooksPanel;
    private reportPanel newlyAcquiredBooksPanel;
    private reportPanel patronActivityPanel;
    private reportPanel bookRatingPanel;

    /**
     * Constructs the combined report panel containing all four reports.
     * Makes the panel scrollable if content overflows.
     */
    public combinedReportPanel() {
        this.setLayout(new BorderLayout());

        // Create a container panel to hold all the report panels
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // Initialize the individual report panels
        topBorrowedBooksPanel = new reportPanel("Top 10 Most Borrowed Books");
        newlyAcquiredBooksPanel = new reportPanel("Newly Acquired Books");
        patronActivityPanel = new reportPanel("Patron Activity");
        bookRatingPanel = new reportPanel("Book Ratings");

        // Add panels to the container
        container.add(topBorrowedBooksPanel);
        container.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        container.add(newlyAcquiredBooksPanel);
        container.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        container.add(patronActivityPanel);
        container.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        container.add(bookRatingPanel);

        // Make the container scrollable
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
            }
        });

        this.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Returns the panel for the "Top 10 Most Borrowed Books" report.
     */
    public reportPanel getTopBorrowedBooksPanel() {
        return topBorrowedBooksPanel;
    }

    /**
     * Returns the panel for the "Newly Acquired Books" report.
     */
    public reportPanel getNewlyAcquiredBooksPanel() {
        return newlyAcquiredBooksPanel;
    }

    /**
     * Returns the panel for the "Patron Activity" report.
     */
    public reportPanel getPatronActivityPanel() {
        return patronActivityPanel;
    }

    /**
     * Returns the panel for the "Book Ratings" report.
     */
    public reportPanel getBookRatingPanel() {
        return bookRatingPanel;
    }
}
