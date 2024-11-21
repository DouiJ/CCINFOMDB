import javax.swing.*;
import java.awt.*;

public class bookdetailsViewPanel extends JPanel {

    public JLabel isbnLabel;
    public JLabel isbnValueLabel;
    public JLabel titleLabel;
    public JLabel titleValueLabel;
    public JLabel priceLabel;
    public JLabel priceValueLabel;
    public JLabel authorLastNameLabel;
    public JLabel authorLastNameValueLabel;
    public JLabel authorFirstNameLabel;
    public JLabel authorFirstNameValueLabel;

    public bookdetailsViewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(8, 4, 16, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ISBN
        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        isbnValueLabel = new JLabel("TEXT");
        isbnValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(isbnValueLabel, gbc);

        // Title
        gbc.gridx = 0;
        gbc.gridy = 1;
        titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(titleLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        titleValueLabel = new JLabel("TEXT");
        titleValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(titleValueLabel, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(priceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        priceValueLabel = new JLabel("TEXT");
        priceValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(priceValueLabel, gbc);

        // Author Last Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        authorLastNameLabel = new JLabel("Last_Name:");
        authorLastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(authorLastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        authorLastNameValueLabel = new JLabel("TEXT");
        authorLastNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(authorLastNameValueLabel, gbc);

        // Author First Name
        gbc.gridx = 0;
        gbc.gridy = 4;
        authorFirstNameLabel = new JLabel("First_Name:");
        authorFirstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(authorFirstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        authorFirstNameValueLabel = new JLabel("TEXT");
        authorFirstNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(authorFirstNameValueLabel, gbc);
    }
}