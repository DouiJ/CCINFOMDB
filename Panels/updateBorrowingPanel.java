import javax.swing.*;
import java.awt.*;

public class updateBorrowingPanel extends JPanel {

    public JLabel dateborrowedLabel;
    public JTextField dateborrowedTextField;
    public JLabel dueDateLabel;
    public JTextField dueDateTextField;
    public JLabel datereturnedLabel;
    public JTextField datereturnedTextField;
    public JLabel borrowstatusLabel;
    public JComboBox<String> borrowstatusComboBox;
    public JLabel clerk_idLabel;
    public JTextField clerk_idTextField;
    public JButton cancelButton;
    public JButton updateButton;

    public updateBorrowingPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(8, 10, 15, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Date Borrowed
        dateborrowedLabel = new JLabel("Date_Borrowed:");
        dateborrowedLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(dateborrowedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        dateborrowedTextField = new JTextField(15);
        dateborrowedTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        this.add(dateborrowedTextField, gbc);

        // Due Date
        gbc.gridx = 0;
        gbc.gridy = 1;
        dueDateLabel = new JLabel("Due_Date:");
        dueDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(dueDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        dueDateTextField = new JTextField(15);
        dueDateTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        this.add(dueDateTextField, gbc);

        // Date Returned
        gbc.gridx = 0;
        gbc.gridy = 2;
        datereturnedLabel = new JLabel("Date_Returned:");
        datereturnedLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(datereturnedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        datereturnedTextField = new JTextField(15);
        datereturnedTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        this.add(datereturnedTextField, gbc);

        // Borrow Status
        gbc.gridx = 0;
        gbc.gridy = 3;
        borrowstatusLabel = new JLabel("Borrow_Status:");
        borrowstatusLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(borrowstatusLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        String[] borrowStatuses = {"B", "O", "R", "L"};
        borrowstatusComboBox = new JComboBox<>(borrowStatuses);
        borrowstatusComboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        this.add(borrowstatusComboBox, gbc);

        // Clerk ID
        gbc.gridx = 0;
        gbc.gridy = 4;
        clerk_idLabel = new JLabel("Clerk_ID:");
        clerk_idLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(clerk_idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        clerk_idTextField = new JTextField(15);
        clerk_idTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        this.add(clerk_idTextField, gbc);

        // Cancel Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(cancelButton, gbc);

        // Update Button
        gbc.gridx = 1;
        gbc.gridy = 5;
        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
        this.add(updateButton, gbc);
    }



}
