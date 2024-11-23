package panels;

import javax.swing.*;
import java.awt.*;

public class review_inputPanel extends JPanel {

    // Public Text Fields;
    public JTextField scoreTextField;
    public JTextField commentTextField;
    public JButton createButton;

    public review_inputPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 11, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Initialize and add ID Label
        JLabel scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(scoreLabel, gbc);

        // Initialize and add Score TextField
        gbc.gridx = 1;
        scoreTextField = new JTextField(15);
        scoreTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(scoreTextField, gbc);

        // Initialize and add Comment Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel commentLabel = new JLabel("Comment:");
        commentLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(commentLabel, gbc);

        // Initialize and add Comment TextField
        gbc.gridx = 1;
        commentTextField = new JTextField(15);
        commentTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(commentTextField, gbc);

        // Initialize and add Create Button
        gbc.gridx = 1;
        gbc.gridy = 2;
        createButton = new JButton("CREATE");
        createButton.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(createButton, gbc);
    }
}
