package panels;

import javax.swing.*;
import java.awt.*;

public class book_viewPanel extends JPanel {

    public JLabel isbnValueLabel;
    public JLabel titleValueLabel;
    public JLabel priceValueLabel;
    public JLabel authorFirstNameValueLabel;
    public JLabel authorLastNameValueLabel;

    public book_viewPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(2, 4, 10, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ISBN
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        isbnValueLabel = new JLabel("TEXT");
        isbnValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(isbnValueLabel, gbc);

        // Title
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(titleLabel, gbc);

        gbc.gridx = 1;
        titleValueLabel = new JLabel("TEXT");
        titleValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(titleValueLabel, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
        priceValueLabel = new JLabel("TEXT");
        priceValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(priceValueLabel, gbc);

        // Author First Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel authorFirstNameLabel = new JLabel("Author First Name:");
        authorFirstNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(authorFirstNameLabel, gbc);

        gbc.gridx = 1;
        authorFirstNameValueLabel = new JLabel("TEXT");
        authorFirstNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(authorFirstNameValueLabel, gbc);

        // Author Last Name
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel authorLastNameLabel = new JLabel("Author Last Name:");
        authorLastNameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(authorLastNameLabel, gbc);

        gbc.gridx = 1;
        authorLastNameValueLabel = new JLabel("TEXT");
        authorLastNameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(authorLastNameValueLabel, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}