import javax.swing.*;
import java.awt.*;

public class payFinesPanel extends JPanel {

    public JLabel patronidLabel;
    public JLabel patronidValueLabel;
    public JLabel patronnameLabel;
    public JLabel patronnameValueLabel;
    public JLabel fineLabel;
    public JLabel fineValueLabel;
    public JLabel booknameLabel;
    public JLabel booknameValueLabel;
    public JLabel dateLabel;
    public JLabel dateValueLabel;
    public JButton payButton;

    public payFinesPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(8, 10, 15, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Patron ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        patronidLabel = new JLabel("Patron ID:");
        patronidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(patronidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        patronidValueLabel = new JLabel("TEXT");
        patronidValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(patronidValueLabel, gbc);

        // Patron Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        patronnameLabel = new JLabel("Patron Name:");
        patronnameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(patronnameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        patronnameValueLabel = new JLabel("TEXT");
        patronnameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(patronnameValueLabel, gbc);

        // Book Name
        gbc.gridx = 0;
        gbc.gridy = 4;
        booknameLabel = new JLabel("Book Name:");
        booknameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(booknameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        booknameValueLabel = new JLabel("TEXT");
        booknameValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(booknameValueLabel, gbc);

        // Book ID
        gbc.gridx = 0;
        gbc.gridy = 5;
        fineLabel = new JLabel("Fine:");
        fineLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(fineLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        fineValueLabel = new JLabel("TEXT");
        fineValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(fineValueLabel, gbc);

        // Book ID
        gbc.gridx = 0;
        gbc.gridy = 6;
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        dateValueLabel = new JLabel("TEXT");
        dateValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(dateValueLabel, gbc);

        // Borrow Button
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        payButton = new JButton("Pay");
        payButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(payButton, gbc);
    }
}