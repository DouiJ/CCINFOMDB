import javax.swing.*;
import java.awt.*;

public class bookDetailsCreatePanel extends JPanel {

    public JLabel isbnLabel;
    public JTextField isbnTextField;
    public JLabel titleLabel;
    public JTextField titleTextField;
    public JLabel priceLabel;
    public JTextField priceTextField;
    public JLabel lastNameLabel;
    public JTextField lastNameTextField;
    public JLabel firstNameLabel;
    public JTextField firstNameTextField;
    public JButton createButton;

    public bookDetailsCreatePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 15, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ISBN
        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        isbnTextField = new JTextField(15);
        isbnTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(isbnTextField, gbc);

        // Title
        gbc.gridx = 0;
        gbc.gridy = 1;
        titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(titleLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        titleTextField = new JTextField(15);
        titleTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(titleTextField, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(priceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        priceTextField = new JTextField(15);
        priceTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(priceTextField, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        lastNameLabel = new JLabel("Last_Name:");
        lastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        lastNameTextField = new JTextField(15);
        lastNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(lastNameTextField, gbc);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 4;
        firstNameLabel = new JLabel("First_Name:");
        firstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        firstNameTextField = new JTextField(15);
        firstNameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(firstNameTextField, gbc);

        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 5;
        createButton = new JButton("Create");
        createButton.setFont(new Font("Bookman Old Style", Font.BOLD, 15));

        this.add(createButton, gbc);
    }
}