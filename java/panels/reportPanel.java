package panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.ArrayList;

public class reportPanel extends JPanel {

    // List to hold dynamically created JTextPane components
    private ArrayList<JTextPane> textBoxList;

    // Panel containing the list of report items
    private JPanel list;

    /**
     * Constructs a `reportPanel` instance and initializes its components.
     * This panel displays a list of report items with a scrollable view.
     */
    public reportPanel(String title) {
        // Initialize the list of text boxes
        this.textBoxList = new ArrayList<>();

        // Set layout manager and background color
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        // Create and configure the label for displaying the list title
        JLabel label = new JLabel(title);
        label.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
        label.setBounds(11, 15, 250, 20);
        this.add(label);

        // Create and configure the panel for displaying the list of report items
        list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 40, 360, 250);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
            }
        });
        this.add(scrollPane);
    }

    /**
     * Adds a new report entry to the panel.
     *
     * @param content The content to display in the report entry.
     */
    public void addReportEntry(String content) {
        JTextArea textArea = new JTextArea(2, 1);
        JTextPane textBox = createTextBox(content, textArea);
        textBoxList.add(textBox);

        list.add(textBox);
        list.add(Box.createRigidArea(new Dimension(0, 2))); // Add space between text boxes
        list.revalidate();
        list.repaint();
    }

    /**
     * Creates a styled JTextPane for a report entry.
     *
     * @param content  The content to display in the JTextPane.
     * @param textArea A JTextArea used to determine the preferred size.
     * @return The configured JTextPane.
     */
    private static JTextPane createTextBox(String content, JTextArea textArea) {
        JTextPane textBox = new JTextPane();
        textBox.setText(content);

        // Remove caret visibility
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

    /**
     * Clears all entries from the report panel.
     */
    public void clearAllEntries() {
        list.removeAll();
        textBoxList.clear();
        list.revalidate();
        list.repaint();
    }
}
