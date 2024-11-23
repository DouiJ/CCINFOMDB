package panels;

import javax.swing.*;
import java.awt.*;

public class patrons_viewPanel extends JPanel {

    public JLabel patronIdValueLabel;
    public JLabel lastNameValueLabel;
    public JLabel firstNameValueLabel;
    public JLabel ageValueLabel;
    public JLabel genderValueLabel;
    public JLabel phoneNoValueLabel;
    public JLabel emailValueLabel;

    public patrons_viewPanel() {
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

        // Patron ID
        JLabel patronIdLabel = new JLabel("Patron ID:");
        patronIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(patronIdLabel, gbc);

        gbc.gridx = 1;
        patronIdValueLabel = new JLabel("TEXT");
        patronIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(patronIdValueLabel, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameValueLabel = new JLabel("TEXT");
        firstNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(firstNameValueLabel, gbc);

        // First Name
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

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        genderValueLabel = new JLabel("TEXT");
        genderValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(genderValueLabel, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        phoneNoValueLabel = new JLabel("TEXT");
        phoneNoValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(phoneNoValueLabel, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailValueLabel = new JLabel("TEXT");
        emailValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(emailValueLabel, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}