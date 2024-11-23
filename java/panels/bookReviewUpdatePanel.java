package panels;

import javax.swing.*;
import java.awt.*;

public class bookReviewUpdatePanel extends JPanel {

    public JLabel idLabel;
    public JLabel idValueLabel;
    public JLabel scoreLabel;
    public JTextField scoreTextField;
    public JLabel dateLabel;
    public JLabel dateValueLabel;
    public JLabel commentLabel;
    public JTextField commentTextField;
    public JButton saveButton;

    public bookReviewUpdatePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 30, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ID
        idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        idValueLabel = new JLabel("TEXT");
        idValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(idValueLabel, gbc);

        // Score
        gbc.gridx = 0;
        gbc.gridy = 1;
        scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(scoreLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        scoreTextField = new JTextField(20);
        scoreTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(scoreTextField, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        dateValueLabel = new JLabel("TEXT");
        dateValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(dateValueLabel, gbc);

        // Rating Comment
        gbc.gridx = 0;
        gbc.gridy = 3;
        commentLabel = new JLabel("Comment:");
        commentLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(commentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        commentTextField = new JTextField(20);
        commentTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(commentTextField, gbc);

        // Save Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(saveButton, gbc);
    }
}