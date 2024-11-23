package panels;

import javax.swing.*;
import java.awt.*;

public class inventory_inputPanel extends JPanel {

    public JTextField isbnTextField;
    public JTextField BranchidTextField;
    public JButton okButton;

    public inventory_inputPanel() {
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
        JLabel acquisition = new JLabel("Branch ID:");
        acquisition.setFont(labelFont);
        gridPanel.add(acquisition, gbc);

        gbc.gridx = 1;
        BranchidTextField = new JTextField(15);
        BranchidTextField.setFont(textFont);
        gridPanel.add(BranchidTextField, gbc);

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