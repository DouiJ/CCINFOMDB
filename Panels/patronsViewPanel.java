import javax.swing.*;
import java.awt.*;

public class patronsViewPanel extends JPanel {

    public JLabel patronIdLabel;
    public JLabel patronIdValueLabel;
    public JLabel lastNameLabel;
    public JLabel lastNameValueLabel;
    public JLabel firstNameLabel;
    public JLabel firstNameValueLabel;
    public JLabel ageLabel;
    public JLabel ageValueLabel;
    public JLabel genderLabel;
    public JLabel genderValueLabel;
    public JLabel phoneNoLabel;
    public JLabel phoneNoValueLabel;
    public JLabel emailLabel;
    public JLabel emailValueLabel;

    public patronsViewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        // Set JLabel for attributes and their values
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(8, 4, 12, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Patron ID
        patronIdLabel = new JLabel("Patron_ID:");
        patronIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(patronIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        patronIdValueLabel = new JLabel("TEXT");
        patronIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(patronIdValueLabel, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        lastNameLabel = new JLabel("Last_Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        lastNameValueLabel = new JLabel("TEXT");
        lastNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(lastNameValueLabel, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        firstNameLabel = new JLabel("First_Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        firstNameValueLabel = new JLabel("TEXT");
        firstNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(firstNameValueLabel, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 3;
        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        ageValueLabel = new JLabel("TEXT");
        ageValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(ageValueLabel, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 4;
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        genderValueLabel = new JLabel("TEXT");
        genderValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(genderValueLabel, gbc);

        // Phone_No
        gbc.gridx = 0;
        gbc.gridy = 5;
        phoneNoLabel = new JLabel("Phone_No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        phoneNoValueLabel = new JLabel("TEXT");
        phoneNoValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(phoneNoValueLabel, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 6;
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        emailValueLabel = new JLabel("TEXT");
        emailValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(emailValueLabel, gbc);
    }
}