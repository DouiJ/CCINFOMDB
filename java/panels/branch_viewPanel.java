package panels;

import javax.swing.*;
import java.awt.*;

public class branch_viewPanel extends JPanel {

    public JLabel branchIdLabel;
    public JLabel branchIdValueLabel;
    public JLabel fullAddressLabel;
    public JLabel fullAddressValueLabel;
    public JLabel phoneNoLabel;
    public JLabel phoneNoValueLabel;

    public branch_viewPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);

        // Move the content panel a bit to the top
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(2, 4, 10, 4); // Adjusted insets to move layout upward
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Branch ID
        branchIdLabel = new JLabel("Branch ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        branchIdValueLabel = new JLabel("TEXT");
        branchIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(branchIdValueLabel, gbc);

        // Full Address
        gbc.gridx = 0;
        gbc.gridy = 1;
        fullAddressLabel = new JLabel("Full Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        fullAddressValueLabel = new JLabel("TEXT");
        fullAddressValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(fullAddressValueLabel, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 2;
        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
        contentPanel.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        phoneNoValueLabel = new JLabel("TEXT");
        phoneNoValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
        contentPanel.add(phoneNoValueLabel, gbc);

        this.add(contentPanel, BorderLayout.NORTH);
    }
}