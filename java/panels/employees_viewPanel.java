package panels;

import javax.swing.*;
import java.awt.*;

public class employees_viewPanel extends JPanel {

    public JLabel employeeIdValueLabel;
    public JLabel lastNameValueLabel;
    public JLabel firstNameValueLabel;
    public JLabel ageValueLabel;
    public JLabel phoneNoValueLabel;
    public JLabel emailValueLabel;
    public JLabel jobIdValueLabel;
    public JLabel hireDateValueLabel;
    public JLabel fullAddressValueLabel;
    public JLabel branchIdValueLabel;

    public employees_viewPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);

        // Move the content panel a bit to the top
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        // Set JLabel for attributes and their values
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(2, 11, 5, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Employee ID
        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(employeeIdLabel, gbc);

        gbc.gridx = 1;
        employeeIdValueLabel = new JLabel("TEXT");
        employeeIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(employeeIdValueLabel, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameValueLabel = new JLabel("TEXT");
        firstNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(firstNameValueLabel, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        lastNameValueLabel = new JLabel("TEXT");
        lastNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(lastNameValueLabel, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(ageLabel, gbc);

        gbc.gridx = 1;
        ageValueLabel = new JLabel("TEXT");
        ageValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(ageValueLabel, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        phoneNoValueLabel = new JLabel("TEXT");
        phoneNoValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(phoneNoValueLabel, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailValueLabel = new JLabel("TEXT");
        emailValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(emailValueLabel, gbc);

        // Job ID
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel jobIdLabel = new JLabel("Job Name:");
        jobIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(jobIdLabel, gbc);

        gbc.gridx = 1;
        jobIdValueLabel = new JLabel("TEXT");
        jobIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(jobIdValueLabel, gbc);

        // Hire Date
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel hireDateLabel = new JLabel("Hire Date:");
        hireDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(hireDateLabel, gbc);

        gbc.gridx = 1;
        hireDateValueLabel = new JLabel("TEXT");
        hireDateValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(hireDateValueLabel, gbc);

        // Full Address
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel fullAddressLabel = new JLabel("Full Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        fullAddressValueLabel = new JLabel("TEXT");
        fullAddressValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 8));
        contentPanel.add(fullAddressValueLabel, gbc);

        // Branch ID
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel branchIdLabel = new JLabel("Branch ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        branchIdValueLabel = new JLabel("TEXT");
        branchIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(branchIdValueLabel, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}