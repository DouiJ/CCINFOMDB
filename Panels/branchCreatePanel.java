import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class branchCreatePanel extends JPanel {

    public JLabel fullAddressLabel;
    public JTextField fullAddressTextField;
    public JLabel phoneNoLabel;
    public JTextField phoneNoTextField;
    public JButton acceptButton;

    public branchCreatePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 30, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Full Address
        fullAddressLabel = new JLabel("Full_Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        fullAddressTextField = new JTextField(15);
        fullAddressTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(fullAddressTextField, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 1;
        phoneNoLabel = new JLabel("Phone_No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        phoneNoTextField = new JTextField(15);
        phoneNoTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(phoneNoTextField, gbc);

        // Accept Button
        gbc.gridx = 1;
        gbc.gridy = 2;
        acceptButton = new JButton("Accept");
        acceptButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));

        this.add(acceptButton, gbc);
    }
}