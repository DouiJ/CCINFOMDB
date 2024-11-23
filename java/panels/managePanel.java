package panels;

import javax.swing.*;
import java.awt.*;

public class managePanel extends JPanel {

    public JButton branchesButton;
    public JButton employeesButton;
    public JButton patronsButton;
    public JButton booksButton;
    public JButton inventoryButton;

    public managePanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 18));
        panel.setBounds(90, 30, 200, 300);
        panel.setBackground(Color.WHITE);

        branchesButton = new JButton("BRANCHES");
        branchesButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        branchesButton.setPreferredSize(new Dimension(190, 40));
        branchesButton.setFocusable(false);
        branchesButton.setBackground(Color.WHITE);
        panel.add(branchesButton);

        employeesButton = new JButton("EMPLOYEES");
        employeesButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        employeesButton.setPreferredSize(new Dimension(190, 40));
        employeesButton.setFocusable(false);
        employeesButton.setBackground(Color.WHITE);
        panel.add(employeesButton);

        patronsButton = new JButton("PATRONS");
        patronsButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        patronsButton.setPreferredSize(new Dimension(190, 40));
        patronsButton.setFocusable(false);
        patronsButton.setBackground(Color.WHITE);
        panel.add(patronsButton);

        booksButton = new JButton("BOOKS");
        booksButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        booksButton.setPreferredSize(new Dimension(190, 40));
        booksButton.setFocusable(false);
        booksButton.setBackground(Color.WHITE);
        panel.add(booksButton);

        inventoryButton = new JButton("INVENTORY");
        inventoryButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        inventoryButton.setPreferredSize(new Dimension(190, 40));
        inventoryButton.setFocusable(false);
        inventoryButton.setBackground(Color.WHITE);
        panel.add(inventoryButton);

        this.add(panel);
    }
}
