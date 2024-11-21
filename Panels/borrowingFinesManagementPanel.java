import javax.swing.*;
import java.awt.*;

public class borrowingFinesManagementPanel extends JPanel {

    public JButton borrowButton;
    public JButton borrowListButton;
    public JButton finesButton;
    public JTable table;
    private JLabel valueLabel;
    public JButton viewHistoryButton;
    public JButton markAsPaidButton;
    public JButton cancelButton;

    public borrowingFinesManagementPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create a panel for labels and values
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints panelGbc = new GridBagConstraints();
        panelGbc.insets = new Insets(5, 5, 5, 5);
        panelGbc.anchor = GridBagConstraints.WEST;

        // Add labels and values
        addLabelValue(panel, "Fine ID:", "0", panelGbc, 0);
        addLabelValue(panel, "Borrow ID:", "0", panelGbc, 1);
        addLabelValue(panel, "Fine Amount:", "0", panelGbc, 2);

        // Add the panel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(panel, gbc);

        // Add buttons
        gbc.gridy = 2; // Move down for buttons

        viewHistoryButton = new JButton("View history");
        markAsPaidButton = new JButton("Mark as paid");
        cancelButton = new JButton("Cancel");

        this.add(viewHistoryButton, gbc);
        gbc.gridy++;
        this.add(markAsPaidButton, gbc);
        gbc.gridy++;
        this.add(cancelButton, gbc);
    }

    private void addLabelValue(JPanel panel, String labelText, String valueText, GridBagConstraints gbc, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        JLabel valueLabel = new JLabel(valueText);
        valueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        gbc.gridx = 1;
        panel.add(valueLabel, gbc);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("File Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new borrowingFinesManagementPanel());
        frame.setVisible(true);
    }
}