import javax.swing.*;
import java.awt.*;

public class bookinventoryViewPanel extends JPanel {

    public JLabel inventoryIdLabel;
    public JLabel inventoryIdValueLabel;
    public JLabel isbnLabel;
    public JLabel isbnValueLabel;
    public JLabel branchIdLabel;
    public JLabel branchIdValueLabel;
    public JLabel acquisitionIdLabel;
    public JLabel acquisitionIdValueLabel;

    public bookinventoryViewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 30, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Inventory ID
        inventoryIdLabel = new JLabel("Inventory_ID:");
        inventoryIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(inventoryIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inventoryIdValueLabel = new JLabel("TEXT");
        inventoryIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(inventoryIdValueLabel, gbc);

        // ISBN
        gbc.gridx = 0;
        gbc.gridy = 1;
        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        isbnValueLabel = new JLabel("TEXT");
        isbnValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(isbnValueLabel, gbc);

        // Branch ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        branchIdLabel = new JLabel("Branch_ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        branchIdValueLabel = new JLabel("TEXT");
        branchIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(branchIdValueLabel, gbc);

        // Acquisition ID
        gbc.gridx = 0;
        gbc.gridy = 3;
        acquisitionIdLabel = new JLabel("Acquisition_ID:");
        acquisitionIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(acquisitionIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        acquisitionIdValueLabel = new JLabel("TEXT");
        acquisitionIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(acquisitionIdValueLabel, gbc);
    }
}