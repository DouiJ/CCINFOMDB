import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class bookAcquisitionCreatePanel extends JPanel {

    public JLabel isbnLabel;
    public JTextField isbnTextField;
    public JLabel acquisitionDateLabel;
    public JTextField acquisitionDateTextField;
    public JLabel supplierLabel;
    public JTextField supplierTextField;
    public JLabel priceLabel;
    public JTextField priceTextField;
    public JLabel copiesAcquiredLabel;
    public JTextField copiesAcquiredTextField;
    public JLabel branchDeliveredLabel;
    public JTextField branchDeliveredTextField;

    public JButton createButton;

    public bookAcquisitionCreatePanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 15, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ISBN
        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        isbnTextField = new JTextField(15);
        isbnTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(isbnTextField, gbc);

        // Acquisition Date
        gbc.gridx = 0;
        gbc.gridy = 1;
        acquisitionDateLabel = new JLabel("Acquisition Date:");
        acquisitionDateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(acquisitionDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        acquisitionDateTextField = new JTextField(15);
        acquisitionDateTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(acquisitionDateTextField, gbc);

        // Supplier
        gbc.gridx = 0;
        gbc.gridy = 2;
        supplierLabel = new JLabel("Supplier:");
        supplierLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(supplierLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        supplierTextField = new JTextField(15);
        supplierTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(supplierTextField, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 3;
        priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(priceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        priceTextField = new JTextField(15);
        priceTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(priceTextField, gbc);

        // Copies Acquired
        gbc.gridx = 0;
        gbc.gridy = 4;
        copiesAcquiredLabel = new JLabel("Copies Acquired:");
        copiesAcquiredLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(copiesAcquiredLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        copiesAcquiredTextField = new JTextField(15);
        copiesAcquiredTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(copiesAcquiredTextField, gbc);

        // Branch Delivered
        gbc.gridx = 0;
        gbc.gridy = 5;
        branchDeliveredLabel = new JLabel("Branch Delivered:");
        branchDeliveredLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        this.add(branchDeliveredLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        branchDeliveredTextField = new JTextField(15);
        branchDeliveredTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        this.add(branchDeliveredTextField, gbc);

        // Create Button
        gbc.gridx = 1;
        gbc.gridy = 6;
        createButton = new JButton("Create");
        createButton.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        this.add(createButton, gbc);
    }
}