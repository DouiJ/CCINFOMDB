package panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.ArrayList;

public class inventory_crudPanel extends JPanel {

    public ArrayList<JTextPane> textBoxList;
    public JPanel list;
    public JButton deleteButton;
    public JButton addButton;
    public JButton editButton;

    public inventory_crudPanel() {

        this.textBoxList = new ArrayList<>();
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JLabel label = new JLabel("LIST OF BOOKS INVENTORY");
        label.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        label.setBounds(11, 15, 300, 20);
        this.add(label);

        list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.WHITE);

        // Create and configure the scroll pane for the room list
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 40, 360, 250);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.lightGray;
            }
        });
        this.add(scrollPane);

        addButton = new JButton("+");
        addButton.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
        addButton.setBounds(10, 300, 50, 50);
        addButton.setForeground(new Color(50, 205, 50));
        addButton.setFocusable(false);
        addButton.setBackground(Color.WHITE);
        this.add(addButton);

        ImageIcon icon = new ImageIcon("edit.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        icon = new ImageIcon(newimg);

        editButton = new JButton("");
        editButton.setBounds(70, 300, 50, 50);
        editButton.setFocusable(false);
        editButton.setBackground(Color.WHITE);
        editButton.setIcon(icon);
        editButton.setEnabled(false);
        this.add(editButton);

        ImageIcon icon2 = new ImageIcon("delete.png");
        Image image2 = icon2.getImage();
        Image newimg2 = image2.getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        icon2 = new ImageIcon(newimg2);

        deleteButton = new JButton("");
        deleteButton.setBounds(130, 300, 50, 50);
        deleteButton.setFocusable(false);
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setIcon(icon2);
        deleteButton.setEnabled(false);
        this.add(deleteButton);
    }

    public void createTextBox(String title) {
        JTextArea textArea = new JTextArea(2, 1);
        JTextPane textBox = getjTextPane(title, textArea);
        textBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        textBoxList.add(textBox);

        list.add(textBoxList.getLast());
        list.add(Box.createRigidArea(new Dimension(0, 2))); // Add space between text boxes
    }

    private static JTextPane getjTextPane(String title, JTextArea textArea) {
        JTextPane textBox = new JTextPane();
        textBox.setText(title);

        Caret blank = new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
            }

            @Override
            public boolean isVisible() {
                return false;
            }

            @Override
            public boolean isSelectionVisible() {
                return false;
            }
        };
        textBox.setCaret(blank);
        textBox.setHighlighter(null);
        textBox.setPreferredSize(textArea.getPreferredSize());
        textBox.setMaximumSize(new Dimension(400, 30));
        textBox.setEditable(false);
        textBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        textBox.setBackground(Color.WHITE);
        return textBox;
    }
}
