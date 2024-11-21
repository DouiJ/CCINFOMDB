import javax.swing.*;
import java.awt.*;

public class branchViewPanel extends JPanel {

    public JLabel branchIdLabel;
    public JLabel branchIdValueLabel;
    public JLabel fullAddressLabel;
    public JLabel fullAddressValueLabel;
    public JLabel phoneNoLabel;
    public JLabel phoneNoValueLabel;

    public branchViewPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(4, 4, 30, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Branch ID
        branchIdLabel = new JLabel("Branch_ID:");
        branchIdLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(branchIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        branchIdValueLabel = new JLabel("TEXT");
        branchIdValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(branchIdValueLabel, gbc);

        // Full Address
        gbc.gridx = 0;
        gbc.gridy = 1;
        fullAddressLabel = new JLabel("Full_Address:");
        fullAddressLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(fullAddressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fullAddressValueLabel = new JLabel("TEXT");
        fullAddressValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        this.add(fullAddressValueLabel, gbc);

        // Phone No
        gbc.gridx = 0;
        gbc.gridy = 2;
        phoneNoLabel = new JLabel("Phone_No:");
        phoneNoLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        this.add(phoneNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        phoneNoValueLabel = new JLabel("TEXT");
        phoneNoValueLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        this.add(phoneNoValueLabel, gbc);
    }
}