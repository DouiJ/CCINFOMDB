package panels;

import javax.swing.*;
import java.awt.*;

public class branch_inputPanel extends JPanel {

    public JLabel fullAddressLabel;
    public JTextField fullAddressTextField;
    public JLabel phoneNoLabel;
    public JTextField phoneNoTextField;
    public JButton okButton;

    public branch_inputPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);

        // Move the content panel a bit to the top
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 2, 10, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Full Address
        fullAddressLabel = new JLabel("Full Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        fullAddressTextField = new JTextField(15);
        fullAddressTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(fullAddressTextField, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 1;
        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        phoneNoTextField = new JTextField(15);
        phoneNoTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(phoneNoTextField, gbc);

        // Accept Button
        gbc.gridx = 1;
        gbc.gridy = 3;
        okButton = new JButton("OK");
        okButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        okButton.setPreferredSize(new Dimension(60, 20));
        okButton.setFocusable(false);
        okButton.setBackground(Color.WHITE);
        contentPanel.add(okButton, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}