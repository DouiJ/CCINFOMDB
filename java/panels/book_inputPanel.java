package panels;

import javax.swing.*;
import java.awt.*;

public class book_inputPanel extends JPanel {

    public JTextField isbnTextField;
    public JTextField titleTextField;
    public JTextField priceTextField;
    public JTextField lastNameTextField;
    public JTextField firstNameTextField;
    public JButton okButton;

    public book_inputPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.WHITE);

        topPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 15, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("Bookman Old Style", Font.BOLD, 11);
        Font textFieldFont = new Font("Bookman Old Style", Font.PLAIN, 11);

        // ISBN
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(labelFont);
        topPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        isbnTextField = new JTextField(15);
        isbnTextField.setFont(textFieldFont);
        topPanel.add(isbnTextField, gbc);

        // Title
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(labelFont);
        topPanel.add(titleLabel, gbc);

        gbc.gridx = 1;
        titleTextField = new JTextField(15);
        titleTextField.setFont(textFieldFont);
        topPanel.add(titleTextField, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(labelFont);
        topPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
        priceTextField = new JTextField(15);
        priceTextField.setFont(textFieldFont);
        topPanel.add(priceTextField, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel firstNameLabel = new JLabel("Author First Name:");
        firstNameLabel.setFont(labelFont);
        topPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameTextField = new JTextField(15);
        firstNameTextField.setFont(textFieldFont);
        topPanel.add(firstNameTextField, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lastNameLabel = new JLabel("Author Last Name:");
        lastNameLabel.setFont(labelFont);
        topPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        lastNameTextField = new JTextField(15);
        lastNameTextField.setFont(textFieldFont);
        topPanel.add(lastNameTextField, gbc);

        // OK Button
        gbc.gridx = 1;
        gbc.gridy = 5;
        okButton = new JButton("OK");
        okButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        okButton.setPreferredSize(new Dimension(60, 20));
        okButton.setFocusable(false);
        okButton.setBackground(Color.WHITE);

        topPanel.add(okButton, gbc);

        this.add(topPanel, BorderLayout.NORTH);
    }
}