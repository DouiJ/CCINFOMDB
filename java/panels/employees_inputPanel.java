package panels;

import javax.swing.*;
import java.awt.*;

public class employees_inputPanel extends JPanel {

    public JTextField firstNameTextField;
    public JTextField lastNameTextField;
    public JTextField ageTextField;
    public JTextField phoneNoTextField;
    public JTextField emailTextField;
    public JTextField jobIdTextField;
    public JTextField hireDateTextField;
    public JTextField fullAddressTextField;
    public JTextField branchIdTextField;
    public JButton okButton;

    public employees_inputPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);

        // Move the content panel a bit to the top
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(1, 2, 8, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameTextField = new JTextField(15);
        firstNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(firstNameTextField, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(lastNameLabel, gbc);

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

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        phoneNoTextField = new JTextField(15);
        phoneNoTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(phoneNoTextField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailTextField = new JTextField(15);
        emailTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(emailTextField, gbc);

        // Job ID
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel jobIdLabel = new JLabel("Job ID (M/A/C):");
        jobIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(jobIdLabel, gbc);

        gbc.gridx = 1;
        jobIdTextField = new JTextField(15);
        jobIdTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(jobIdTextField, gbc);

        // Hire Date
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel hireDateLabel = new JLabel("Hire Date (YYYY/MM/DD):");
        hireDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(hireDateLabel, gbc);

        gbc.gridx = 1;
        hireDateTextField = new JTextField(15);
        hireDateTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(hireDateTextField, gbc);

        // Full Address
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel fullAddressLabel = new JLabel("Full Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        fullAddressTextField = new JTextField(15);
        fullAddressTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(fullAddressTextField, gbc);

        // Branch ID
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel branchIdLabel = new JLabel("Branch ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        branchIdTextField = new JTextField(15);
        branchIdTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(branchIdTextField, gbc);

        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 9;
        okButton = new JButton("OK");
        okButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        okButton.setPreferredSize(new Dimension(60, 20));
        okButton.setFocusable(false);
        okButton.setBackground(Color.WHITE);

        contentPanel.add(okButton, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}