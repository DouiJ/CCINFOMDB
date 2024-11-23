package panels;

import javax.swing.*;
import java.awt.*;

public class patrons_inputPanel extends JPanel {

    public JTextField lastNameTextField;
    public JTextField firstNameTextField;
    public JTextField ageTextField;
    public JTextField genderTextField;
    public JTextField phoneNoTextField;
    public JTextField emailTextField;
    public JButton okButton;

    public patrons_inputPanel() {
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

        // Last Name
        JLabel firstNamelabel = new JLabel("First Name:");
        firstNamelabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(firstNamelabel, gbc);

        gbc.gridx = 1;
        firstNameTextField = new JTextField(15);
        firstNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(firstNameTextField, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lastNamelabel = new JLabel("Last Name:");
        lastNamelabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(lastNamelabel, gbc);

        gbc.gridx = 1;
        lastNameTextField = new JTextField(15);
        lastNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(lastNameTextField, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(ageLabel, gbc);

        gbc.gridx = 1;
        ageTextField = new JTextField(15);
        ageTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(ageTextField, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        genderTextField = new JTextField(15);
        genderTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(genderTextField, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        phoneNoTextField = new JTextField(15);
        phoneNoTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(phoneNoTextField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailTextField = new JTextField(15);
        emailTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(emailTextField, gbc);

        // OK Button
        gbc.gridx = 1;
        gbc.gridy = 6;
        okButton = new JButton("OK");
        okButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        okButton.setPreferredSize(new Dimension(60, 20));
        okButton.setFocusable(false);
        okButton.setBackground(Color.WHITE);
        contentPanel.add(okButton, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}