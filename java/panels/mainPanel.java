package panels;

import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {

    public JButton manageButton;
    public JButton simulateButton;
    public JButton reportsButton;

    public mainPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 18));
        panel.setBounds(90, 70, 200, 300);
        panel.setBackground(Color.WHITE);

        manageButton = new JButton("MANAGE");
        manageButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        manageButton.setPreferredSize(new Dimension(190, 40));
        manageButton.setFocusable(false);
        manageButton.setBackground(Color.WHITE);
        panel.add(manageButton);

        simulateButton = new JButton("SIMULATE LIBRARY");
        simulateButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        simulateButton.setPreferredSize(new Dimension(190, 40));
        simulateButton.setFocusable(false);
        simulateButton.setBackground(Color.WHITE);
        panel.add(simulateButton);

        reportsButton = new JButton("REPORTS GENERATED");
        reportsButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        reportsButton.setPreferredSize(new Dimension(190, 40));
        reportsButton.setFocusable(false);
        reportsButton.setBackground(Color.WHITE);
        panel.add(reportsButton);

        this.add(panel);
    }
}
