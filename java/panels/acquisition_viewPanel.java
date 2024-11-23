package panels;

import javax.swing.*;
import java.awt.*;

public class acquisition_viewPanel extends JPanel {

    public JLabel idValueLabel;
    public JLabel dateValueLabel;
    public JLabel priceValueLabel;
    public JLabel copiesValueAcquiredValueLabel;
    public JLabel archivistValueLabel;
    public JLabel isbnValueLabel;
    public JLabel branchDeliveredValueLabel;

    public acquisition_viewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 11, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // ID
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        idValueLabel = new JLabel("\"\"");
        idValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(idValueLabel, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        dateValueLabel = new JLabel("TEXT");
        dateValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(dateValueLabel, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(priceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        priceValueLabel = new JLabel("");
        priceValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(priceValueLabel, gbc);

        // Copies Acquired
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel copiesAcquiredLabel = new JLabel("Copies Acquired:");
        copiesAcquiredLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(copiesAcquiredLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        copiesValueAcquiredValueLabel = new JLabel("");
        copiesValueAcquiredValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(copiesValueAcquiredValueLabel, gbc);

        // Archivist
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel archivistLabel = new JLabel("Archivist:");
        archivistLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(archivistLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        archivistValueLabel = new JLabel("");
        archivistValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(archivistValueLabel, gbc);

        // ISBN
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        isbnValueLabel = new JLabel("");
        isbnValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        this.add(isbnValueLabel, gbc);

        // Branch Delivered
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel branchDeliveredLabel = new JLabel("Branch Delivered:");
        branchDeliveredLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        this.add(branchDeliveredLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        branchDeliveredValueLabel = new JLabel("");
        branchDeliveredValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(branchDeliveredValueLabel, gbc);


    }
}