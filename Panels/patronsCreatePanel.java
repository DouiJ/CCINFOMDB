import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patronsCreatePanel extends JPanel {

    public JLabel lastNameLabel;
    public JTextField lastNameTextField;
    public JLabel firstNameLabel;
    public JTextField firstNameTextField;
    public JLabel ageLabel;
    public JTextField ageTextField;
    public JLabel genderLabel;
    public JTextField genderTextField;
    public JLabel phoneNoLabel;
    public JTextField phoneNoTextField;
    public JLabel emailLabel;
    public JTextField emailTextField;
    public JButton createButton;

    public patronsCreatePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 20, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Last Name
        lastNameLabel = new JLabel("Last_Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        lastNameTextField = new JTextField(15);
        lastNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(lastNameTextField, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        firstNameLabel = new JLabel("First_Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        firstNameTextField = new JTextField(15);
        firstNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(firstNameTextField, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 2;
        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ageTextField = new JTextField(15);
        ageTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(ageTextField, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 3;
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        genderTextField = new JTextField(15);
        genderTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(genderTextField, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 4;
        phoneNoLabel = new JLabel("Phone_No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        phoneNoTextField = new JTextField(15);
        phoneNoTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(phoneNoTextField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 5;
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        emailTextField = new JTextField(15);
        emailTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(emailTextField, gbc);

        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 6;
        createButton = new JButton("Create");
        createButton.setFont(new Font("Bookman Old Style", Font.BOLD, 14));

        this.add(createButton, gbc);
    }
}