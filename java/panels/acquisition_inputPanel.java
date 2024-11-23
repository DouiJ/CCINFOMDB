package panels;

import javax.swing.*;
import java.awt.*;

public class acquisition_inputPanel extends JPanel {

    public JTextField isbnTextField;
    public JTextField acquisitionDateTextField;
    public JTextField supplierTextField;
    public JTextField priceTextField;
    public JTextField copiesAcquiredTextField;
    public JTextField branchDeliveredTextField;
    public JTextField archivistTextField;
    public JButton okButton;

    public acquisition_inputPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel gridPanel = new JPanel(new GridBagLayout());
        gridPanel.setBackground(Color.WHITE);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 11, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("Bookman Old Style", Font.BOLD, 11);
        Font textFont = new Font("Bookman Old Style", Font.PLAIN, 11);

        // ISBN
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(labelFont);
        gridPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        isbnTextField = new JTextField(15);
        isbnTextField.setFont(textFont);
        gridPanel.add(isbnTextField, gbc);

        // Acquisition Date
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel acquisitionDateLabel = new JLabel("Acquisition Date (YYYY/DD/MM):");
        acquisitionDateLabel.setFont(labelFont);
        gridPanel.add(acquisitionDateLabel, gbc);

        gbc.gridx = 1;
        acquisitionDateTextField = new JTextField(15);
        acquisitionDateTextField.setFont(textFont);
        gridPanel.add(acquisitionDateTextField, gbc);

        // Supplier
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel supplierLabel = new JLabel("Supplier:");
        supplierLabel.setFont(labelFont);
        gridPanel.add(supplierLabel, gbc);

        gbc.gridx = 1;
        supplierTextField = new JTextField(15);
        supplierTextField.setFont(textFont);
        gridPanel.add(supplierTextField, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(labelFont);
        gridPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
        priceTextField = new JTextField(15);
        priceTextField.setFont(textFont);
        gridPanel.add(priceTextField, gbc);

        // Copies Acquired
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel copiesAcquiredLabel = new JLabel("Copies Acquired:");
        copiesAcquiredLabel.setFont(labelFont);
        gridPanel.add(copiesAcquiredLabel, gbc);

        gbc.gridx = 1;
        copiesAcquiredTextField = new JTextField(15);
        copiesAcquiredTextField.setFont(textFont);
        gridPanel.add(copiesAcquiredTextField, gbc);

        // Branch Delivered
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel branchDeliveredLabel = new JLabel("Branch Delivered:");
        branchDeliveredLabel.setFont(labelFont);
        gridPanel.add(branchDeliveredLabel, gbc);

        gbc.gridx = 1;
        branchDeliveredTextField = new JTextField(15);
        branchDeliveredTextField.setFont(textFont);
        gridPanel.add(branchDeliveredTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel archivistLabel = new JLabel("Archivist ID:");
        archivistLabel.setFont(labelFont);
        gridPanel.add(archivistLabel, gbc);

        gbc.gridx = 1;
        archivistTextField = new JTextField(15);
        archivistTextField.setFont(textFont);
        gridPanel.add(archivistTextField, gbc);


        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 7;
        okButton = new JButton("OK");
        okButton.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        okButton.setPreferredSize(new Dimension(60, 20));
        okButton.setFocusable(false);
        okButton.setBackground(Color.WHITE);
        gridPanel.add(okButton, gbc);

        this.add(gridPanel, BorderLayout.NORTH);
    }
}