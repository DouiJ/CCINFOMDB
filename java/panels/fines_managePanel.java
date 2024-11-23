package panels;

import javax.swing.*;
import java.awt.*;

public class fines_managePanel extends JPanel {

    public JLabel clerkidLabel;
    public JLabel fineid;
    public JLabel clerknameLabel;
    public JLabel fineamount;
    public JLabel patronidLabel;
    public JLabel paymentdate;
    public JLabel patronnameLabel;
    public JLabel borrowid;
    public JLabel bookidLabel;
    public JLabel clerkid;
    public JLabel booknameLabel;
    public JLabel status;
    public JButton paidButton;
    public JButton cancelButton;

    public fines_managePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(8, 10, 11, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Clerk ID
        clerkidLabel = new JLabel("Fine ID:");
        clerkidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(clerkidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        fineid = new JLabel("TEXT");
        fineid.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(fineid, gbc);

        // Clerk Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        clerknameLabel = new JLabel("Fine Amount:");
        clerknameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(clerknameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fineamount = new JLabel("TEXT");
        fineamount.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(fineamount, gbc);

        // Patron ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        patronidLabel = new JLabel("Payment Date:");
        patronidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(patronidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        paymentdate = new JLabel("TEXT");
        paymentdate.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(paymentdate, gbc);

        // Patron Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        patronnameLabel = new JLabel("Borrow ID:");
        patronnameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(patronnameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        borrowid = new JLabel("TEXT");
        borrowid.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(borrowid, gbc);

        // Book ID
        gbc.gridx = 0;
        gbc.gridy = 4;
        bookidLabel = new JLabel("Clerk ID:");
        bookidLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(bookidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        clerkid = new JLabel("TEXT");
        clerkid.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(clerkid, gbc);

        // Book Name
        gbc.gridx = 0;
        gbc.gridy = 5;
        booknameLabel = new JLabel("Status:");
        booknameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(booknameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        status = new JLabel("TEXT");
        status.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(status, gbc);

        // Borrow Button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        paidButton = new JButton("Mark as Paid");
        paidButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(paidButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        cancelButton = new JButton("Mark as Cancel");
        cancelButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(cancelButton, gbc);
    }
}