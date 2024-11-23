package panels;

import javax.swing.*;
import java.awt.*;

public class simulatePanel extends JPanel {

    public JButton borrowButton;
    public JButton borrowListButton;
    public JButton finesButton;

    public simulatePanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 18));
        panel.setBounds(90, 70, 200, 300);
        panel.setBackground(Color.WHITE);

        borrowButton = new JButton("BORROW A BOOK");
        borrowButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        borrowButton.setPreferredSize(new Dimension(190, 40));
        borrowButton.setFocusable(false);
        borrowButton.setBackground(Color.WHITE);
        panel.add(borrowButton);

        borrowListButton = new JButton("BORROWING LIST");
        borrowListButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        borrowListButton.setPreferredSize(new Dimension(190, 40));
        borrowListButton.setFocusable(false);
        borrowListButton.setBackground(Color.WHITE);
        panel.add(borrowListButton);

        finesButton = new JButton("FINES LIST");
        finesButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        finesButton.setPreferredSize(new Dimension(190, 40));
        finesButton.setFocusable(false);
        finesButton.setBackground(Color.WHITE);
        panel.add(finesButton);

        this.add(panel);
    }
}
