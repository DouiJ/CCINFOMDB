package panels;

import javax.swing.*;
import java.awt.*;

public class borrowing_viewPanel extends JPanel {

    public JLabel clerkidLabel;
    public JLabel clerkidValueLabel;
    public JLabel clerknameLabel;
    public JLabel clerknameValueLabel;
    public JLabel patronidLabel;
    public JLabel patronidValueLabel;
    public JLabel patronnameLabel;
    public JLabel patronnameValueLabel;
    public JLabel bookidLabel;
    public JLabel bookidValueLabel;
    public JLabel booknameLabel;
    public JLabel booknameValueLabel;
    public JButton returnButton;
    public JButton lostButton;

    public borrowing_viewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(8, 10, 11, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Clerk ID
        clerkidLabel = new JLabel("Clerk ID:");
        clerkidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(clerkidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        clerkidValueLabel = new JLabel("TEXT");
        clerkidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(clerkidValueLabel, gbc);

        // Clerk Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        clerknameLabel = new JLabel("Clerk Name:");
        clerknameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(clerknameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        clerknameValueLabel = new JLabel("TEXT");
        clerknameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(clerknameValueLabel, gbc);

        // Patron ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        patronidLabel = new JLabel("Patron ID:");
        patronidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(patronidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        patronidValueLabel = new JLabel("TEXT");
        patronidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(patronidValueLabel, gbc);

        // Patron Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        patronnameLabel = new JLabel("Patron Name:");
        patronnameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(patronnameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        patronnameValueLabel = new JLabel("TEXT");
        patronnameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(patronnameValueLabel, gbc);

        // Book ID
        gbc.gridx = 0;
        gbc.gridy = 4;
        bookidLabel = new JLabel("Book ID:");
        bookidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(bookidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        bookidValueLabel = new JLabel("TEXT");
        bookidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(bookidValueLabel, gbc);

        // Book Name
        gbc.gridx = 0;
        gbc.gridy = 5;
        booknameLabel = new JLabel("Book Name:");
        booknameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(booknameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        booknameValueLabel = new JLabel("TEXT");
        booknameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(booknameValueLabel, gbc);

        // Borrow Button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        returnButton = new JButton("Mark as Returned");
        returnButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(returnButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        lostButton = new JButton("Mark as Lost");
        lostButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(lostButton, gbc);
    }
}