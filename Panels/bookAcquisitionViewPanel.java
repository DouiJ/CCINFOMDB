import javax.swing.*;
import java.awt.*;

public class bookAcquisitionViewPanel extends JPanel {

    public JLabel idLabel;
    public JLabel idValueLabel;
    public JLabel dateLabel;
    public JLabel dateValueLabel;
    public JLabel priceLabel;
    public JTextField priceTextField;
    public JLabel nameLabel;
    public JTextField nameTextField;
    public JLabel copiesAcquiredLabel;
    public JTextField copiesAcquiredTextField;
    public JLabel archivistLabel;
    public JTextField archivistTextField;
    public JLabel isbnLabel;
    public JTextField isbnTextField;
    public JLabel branchDeliveredLabel;
    public JTextField branchDeliveredTextField;
    public JButton saveButton;

    public bookAcquisitionViewPanel() {
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
        idValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(idValueLabel, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 1;
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        dateValueLabel = new JLabel("TEXT");
        dateValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(dateValueLabel, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(priceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        priceTextField = new JTextField(15);
        priceTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(priceTextField, gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        nameTextField = new JTextField(15);
        nameTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(nameTextField, gbc);

        // Copies Acquired
        gbc.gridx = 0;
        gbc.gridy = 4;
        copiesAcquiredLabel = new JLabel("Copies Acquired:");
        copiesAcquiredLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(copiesAcquiredLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        copiesAcquiredTextField = new JTextField(15);
        copiesAcquiredTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(copiesAcquiredTextField, gbc);

        // Archivist
        gbc.gridx = 0;
        gbc.gridy = 5;
        archivistLabel = new JLabel("Archivist:");
        archivistLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(archivistLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        archivistTextField = new JTextField(15);
        archivistTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(archivistTextField, gbc);

        // ISBN
        gbc.gridx = 0;
        gbc.gridy = 6;
        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        isbnTextField = new JTextField(15);
        isbnTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(isbnTextField, gbc);

        // Branch Delivered
        gbc.gridx = 0;
        gbc.gridy = 7;
        branchDeliveredLabel = new JLabel("Branch Delivered:");
        branchDeliveredLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(branchDeliveredLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        branchDeliveredTextField = new JTextField(15);
        branchDeliveredTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(branchDeliveredTextField, gbc);

        // Save Button
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(saveButton, gbc);
    }
}