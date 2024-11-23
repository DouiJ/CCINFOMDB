package panels;

import javax.swing.*;
import java.awt.*;

public class review_inputPanel extends JPanel {

    public JLabel idLabel;
    public JTextField idTextField;
    public JLabel scoreLabel;
    public JTextField scoreTextField;
    public JLabel dateLabel;
    public JTextField dateTextField;
    public JLabel commentLabel;
    public JTextField commentTextField;
    public JButton createButton;

    public review_inputPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 15, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ID
        idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        idTextField = new JTextField(15);
        idTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(idTextField, gbc);

        // Score
        gbc.gridx = 0;
        gbc.gridy = 1;
        scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(scoreLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        scoreTextField = new JTextField(15);
        scoreTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(scoreTextField, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        dateTextField = new JTextField(15);
        dateTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(dateTextField, gbc);

        // Comment
        gbc.gridx = 0;
        gbc.gridy = 3;
        commentLabel = new JLabel("Comment:");
        commentLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(commentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        commentTextField = new JTextField(15);
        commentTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(commentTextField, gbc);

        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 4;
        createButton = new JButton("Create");
        createButton.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        this.add(createButton, gbc);
    }
}