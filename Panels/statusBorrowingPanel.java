import javax.swing.*;
import java.awt.*;

public class statusBorrowingPanel extends JPanel{

    public JLabel borrowidLabel;
    public JLabel borrowidValueLabel;
    public JLabel patronidLabel;
    public JLabel patronidValueLabel;
    public JLabel patronnameLabel;
    public JLabel patronnameValueLabel;
    public JLabel clerkidLabel;
    public JLabel clerkidValueLabel;
    public JLabel clerknameLabel;
    public JLabel clerknameValueLabel;
    public JLabel dateborrowedLabel;
    public JLabel dateborrowedValueLabel;
    public JLabel datedueLabel;
    public JLabel datedueValueLabel;
    public JLabel statusLabel;
    public JLabel statusValueLabel;
    public JButton markReturn;
    public JButton markAsLostButton;
    public JButton cancelButton;
    public JButton editButton;

    public statusBorrowingPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 10, 8, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Borrow ID
        borrowidLabel = new JLabel("Borrow ID:");
        borrowidLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(borrowidLabel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        borrowidValueLabel = new JLabel("TEXT");
        borrowidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(borrowidValueLabel, gbc);

        // Patron ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        patronidLabel = new JLabel("Patron ID:");
        patronidLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(patronidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        patronidValueLabel = new JLabel("TEXT");
        patronidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(patronidValueLabel, gbc);

        // Patron Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        patronnameLabel = new JLabel("Patron Name:");
        patronnameLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(patronnameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        patronnameValueLabel = new JLabel("TEXT");
        patronnameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(patronnameValueLabel, gbc);

        // Clerk ID
        gbc.gridx = 0;
        gbc.gridy = 4;
        clerkidLabel = new JLabel("Clerk ID:");
        clerkidLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(clerkidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        clerkidValueLabel = new JLabel("TEXT");
        clerkidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(clerkidValueLabel, gbc);

        // Clerk Name
        gbc.gridx = 0;
        gbc.gridy = 5;
        clerknameLabel = new JLabel("Clerk Name:");
        clerknameLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(clerknameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        clerknameValueLabel = new JLabel("TEXT");
        clerknameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(clerknameValueLabel, gbc);

        // Date Borrowed
        gbc.gridx = 0;
        gbc.gridy = 6;
        dateborrowedLabel = new JLabel("Date Borrowed:");
        dateborrowedLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(dateborrowedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        dateborrowedValueLabel = new JLabel("TEXT");
        dateborrowedValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(dateborrowedValueLabel, gbc);

        // Date Due
        gbc.gridx = 0;
        gbc.gridy = 7;
        datedueLabel = new JLabel("Date Due:");
        datedueLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(datedueLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        datedueValueLabel = new JLabel("TEXT");
        datedueValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(datedueValueLabel, gbc);

        // Status
        gbc.gridx = 0;
        gbc.gridy = 8;
        statusLabel = new JLabel("Borrow Status:");
        statusLabel.setFont(new Font("Bookman Old Style", Font.BOLD,11));
        this.add(statusLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        statusValueLabel = new JLabel("TEXT");
        statusValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN,11));
        this.add(statusValueLabel, gbc);

        // Mark Return
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 11;
        markReturn = new JButton("Mark Return");
        this.add(markReturn, gbc);

        // Mark As Lost
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 11;
        markAsLostButton = new JButton("Mark As Lost");
        this.add(markAsLostButton, gbc);

        // Cancel
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 12;
        cancelButton = new JButton("Deactivate");
        this.add(cancelButton, gbc);

        // Edit
        gbc.gridx = 1;
        gbc.gridy = 12;
        editButton = new JButton("Edit");
        this.add(editButton, gbc);
    }

}
