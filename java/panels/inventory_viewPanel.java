package panels;

import javax.swing.*;
import java.awt.*;

public class inventory_viewPanel extends JPanel {

    public JLabel inventoryIdValueLabel;
    public JLabel isbnValueLabel;
    public JLabel branchIdValueLabel;
    public JLabel acquisitionIdValueLabel;
    public JButton okButton;

    public inventory_viewPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel gridPanel = new JPanel(new GridBagLayout());
        gridPanel.setBackground(Color.WHITE);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 30));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 10, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("Bookman Old Style", Font.BOLD, 11);
        Font valueFont = new Font("Bookman Old Style", Font.PLAIN, 11);

        // Inventory ID
        JLabel inventoryIdLabel = new JLabel("Inventory ID:");
        inventoryIdLabel.setFont(labelFont);
        gridPanel.add(inventoryIdLabel, gbc);

        gbc.gridx = 1;
        inventoryIdValueLabel = new JLabel("TEXT");
        inventoryIdValueLabel.setFont(valueFont);
        gridPanel.add(inventoryIdValueLabel, gbc);

        // ISBN
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(labelFont);
        gridPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        isbnValueLabel = new JLabel("TEXT");
        isbnValueLabel.setFont(valueFont);
        gridPanel.add(isbnValueLabel, gbc);

        // Branch ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel branchIdLabel = new JLabel("Branch ID:");
        branchIdLabel.setFont(labelFont);
        gridPanel.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        branchIdValueLabel = new JLabel("TEXT");
        branchIdValueLabel.setFont(valueFont);
        gridPanel.add(branchIdValueLabel, gbc);

        // Acquisition ID
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel acquisitionIdLabel = new JLabel("Acquisition ID:");
        acquisitionIdLabel.setFont(labelFont);
        gridPanel.add(acquisitionIdLabel, gbc);

        gbc.gridx = 1;
        acquisitionIdValueLabel = new JLabel("TEXT");
        acquisitionIdValueLabel.setFont(valueFont);
        gridPanel.add(acquisitionIdValueLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        okButton = new JButton("VIEW ACQUISITION");
        okButton.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        okButton.setPreferredSize(new Dimension(180, 20));
        okButton.setFocusable(false);
        okButton.setBackground(Color.WHITE);
        gridPanel.add(okButton, gbc);

        this.add(gridPanel, BorderLayout.NORTH);
    }
}