import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeesCreatePanel extends JPanel {

    public JLabel lastNameLabel;
    public JTextField lastNameTextField;
    public JLabel firstNameLabel;
    public JTextField firstNameTextField;
    public JLabel ageLabel;
    public JTextField ageTextField;
    public JLabel phoneNoLabel;
    public JTextField phoneNoTextField;
    public JLabel emailLabel;
    public JTextField emailTextField;
    public JLabel jobIdLabel;
    public JTextField jobIdTextField;
    public JLabel hireDateLabel;
    public JTextField hireDateTextField;
    public JLabel fullAddressLabel;
    public JTextField fullAddressTextField;
    public JLabel branchIdLabel;
    public JTextField branchIdTextField;
    public JButton createButton;

    public employeesCreatePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 5, 8, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Last Name
        lastNameLabel = new JLabel("Last_Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        lastNameTextField = new JTextField(15);
        lastNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(lastNameTextField, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        firstNameLabel = new JLabel("First_Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        firstNameTextField = new JTextField(15);
        firstNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(firstNameTextField, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 2;
        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ageTextField = new JTextField(15);
        ageTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(ageTextField, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 3;
        phoneNoLabel = new JLabel("Phone_No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        phoneNoTextField = new JTextField(15);
        phoneNoTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(phoneNoTextField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 4;
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        emailTextField = new JTextField(15);
        emailTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(emailTextField, gbc);

        // Job ID
        gbc.gridx = 0;
        gbc.gridy = 5;
        jobIdLabel = new JLabel("Job_ID:");
        jobIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(jobIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        jobIdTextField = new JTextField(15);
        jobIdTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(jobIdTextField, gbc);

        // Hire Date
        gbc.gridx = 0;
        gbc.gridy = 6;
        hireDateLabel = new JLabel("Hire_Date:");
        hireDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(hireDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        hireDateTextField = new JTextField(15);
        hireDateTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(hireDateTextField, gbc);

        // Full Address
        gbc.gridx = 0;
        gbc.gridy = 7;
        fullAddressLabel = new JLabel("Full_Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        fullAddressTextField = new JTextField(15);
        fullAddressTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(fullAddressTextField, gbc);

        // Branch ID
        gbc.gridx = 0;
        gbc.gridy = 8;
        branchIdLabel = new JLabel("Branch_ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        branchIdTextField = new JTextField(15);
        branchIdTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(branchIdTextField, gbc);

        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 9;
        createButton = new JButton("Create");
        createButton.setFont(new Font("Bookman Old Style", Font.BOLD, 11));

        this.add(createButton, gbc);
    }
}