import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class branch_crudPanel extends JPanel {

    public ArrayList<JTextPane> textBoxList;
    public JPanel list;
    public JButton deleteButton;
    public JButton addButton;
    public JButton editButton;
    public JCheckBox checkBox; // Add the JCheckBox

    public branch_crudPanel() {

        this.textBoxList = new ArrayList<>();
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JLabel label = new JLabel("LIST OF BRANCHES");
        label.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        label.setBounds(11, 15, 300, 20);
        this.add(label);

        // Initialize other components (list, buttons, etc.)
        list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.WHITE);

        // Create and configure the scroll pane for the room list
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 50, 360, 253);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.lightGray;
            }
        });
        this.add(scrollPane);

        addButton = new JButton("+");
        addButton.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
        addButton.setBounds(10, 310, 50, 50);
        addButton.setForeground(new Color(50, 205, 50));
        addButton.setFocusable(false);
        addButton.setBackground(Color.WHITE);
        this.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        deleteButton.setBounds(70, 310, 145, 50);
        this.add(deleteButton);

        editButton = new JButton("Edit");
        editButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        editButton.setBounds(224, 310, 145, 50);
        this.add(editButton);

        // Create and add the JCheckBox
        JCheckBox checkBox = new JCheckBox("Enable / Disable (?)");
        checkBox.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
        checkBox.setBackground(Color.WHITE);
        list.add(checkBox); // Add the checkbox to the 'list' panel

        // Add an ItemListener to handle state changes
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Checkbox is selected");
                } else {
                    System.out.println("Checkbox is deselected");
                }
            }
        });
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

        // Add the JCheckBox to the JTextPane
        textBox.insertComponent(checkBox);

        return textBox;
    }
}