package libraryDB.reports;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class reportPatronActivityPanel extends JPanel {

    private DefaultTableModel tableModel;

    public reportPatronActivityPanel(List<Object[]> data) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // Define column names
        String[] columnNames = {
                "Patron ID", "First Name", "Last Name", "Status",
                "Total Books Borrowed", "Overdue Transactions", "Total Fines", "Avg Return Days"
        };

        // Create the table model with the column names
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create the table with the table model
        JTable table = new JTable(tableModel);

        // Set a smaller font for the table
        table.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
        table.setRowHeight(20);

        // Set a smaller font for the table headers
        table.getTableHeader().setFont(new Font("Bookman Old Style", Font.PLAIN, 10));

        // Wrap the table in a JScrollPane to provide scrollbars
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the JScrollPane to the panel
        this.add(scrollPane, BorderLayout.CENTER);

        // Add rows to the table
        for (Object[] row : data) {
            addRow(row);
        }
    }

    // Method to add a row to the table
    public void addRow(Object[] rowData) {
        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        // Example usage
        reports report = new reports();
        report.year = 2023; // Set the desired year
        report.month = 5; // Set the desired month
        List<Object[]> data = report.patronActivity();

        // Create and display the panel with the data
        JFrame frame = new JFrame("Patron Activity Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        reportPatronActivityPanel panel = new reportPatronActivityPanel(data);
        frame.add(panel);
        frame.setVisible(true);
    }
}