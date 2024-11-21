import javax.swing.*;
import java.awt.*;

public class employeesViewPanel extends JPanel {

    public JLabel employeeIdLabel;
    public JLabel employeeIdValueLabel;
    public JLabel lastNameLabel;
    public JLabel lastNameValueLabel;
    public JLabel firstNameLabel;
    public JLabel firstNameValueLabel;
    public JLabel ageLabel;
    public JLabel ageValueLabel;
    public JLabel phoneNoLabel;
    public JLabel phoneNoValueLabel;
    public JLabel emailLabel;
    public JLabel emailValueLabel;
    public JLabel jobIdLabel;
    public JLabel jobIdValueLabel;
    public JLabel hireDateLabel;
    public JLabel hireDateValueLabel;
    public JLabel fullAddressLabel;
    public JLabel fullAddressValueLabel;
    public JLabel branchIdLabel;
    public JLabel branchIdValueLabel;

    public employeesViewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        // Set JLabel for attributes and their values
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 11, 12, 30);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Employee ID
        employeeIdLabel = new JLabel("Employee_ID:");
        employeeIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(employeeIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        employeeIdValueLabel = new JLabel("TEXT");
        employeeIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(employeeIdValueLabel, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        lastNameLabel = new JLabel("Last_Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        lastNameValueLabel = new JLabel("TEXT");
        lastNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(lastNameValueLabel, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        firstNameLabel = new JLabel("First_Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        firstNameValueLabel = new JLabel("TEXT");
        firstNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(firstNameValueLabel, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 3;
        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        ageValueLabel = new JLabel("TEXT");
        ageValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(ageValueLabel, gbc);

        // Phone_No
        gbc.gridx = 0;
        gbc.gridy = 4;
        phoneNoLabel = new JLabel("Phone_No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        phoneNoValueLabel = new JLabel("TEXT");
        phoneNoValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(phoneNoValueLabel, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 5;
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        emailValueLabel = new JLabel("TEXT");
        emailValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(emailValueLabel, gbc);

        // Job_ID
        gbc.gridx = 0;
        gbc.gridy = 6;
        jobIdLabel = new JLabel("Job_ID:");
        jobIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(jobIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        jobIdValueLabel = new JLabel("TEXT");
        jobIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(jobIdValueLabel, gbc);

        // Hire_Date
        gbc.gridx = 0;
        gbc.gridy = 7;
        hireDateLabel = new JLabel("Hire_Date:");
        hireDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(hireDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        hireDateValueLabel = new JLabel("TEXT");
        hireDateValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(hireDateValueLabel, gbc);

        // Full_Address
        gbc.gridx = 0;
        gbc.gridy = 8;
        fullAddressLabel = new JLabel("Full_Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        fullAddressValueLabel = new JLabel("TEXT");
        fullAddressValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(fullAddressValueLabel, gbc);

        // Branch_ID
        gbc.gridx = 0;
        gbc.gridy = 9;
        branchIdLabel = new JLabel("Branch_ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(branchIdLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;
        branchIdValueLabel = new JLabel("TEXT");
        branchIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(branchIdValueLabel, gbc);

    }
}