package panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;

public class reports_listPanel extends JPanel {

    // List to hold dynamically created JTextPane components
    public ArrayList<JTextPane> textBoxList;

    // Panel containing the list of reports
    public JPanel list;

    /**
     * Constructs a `reports_listPanel` instance and initializes its components.
     */
    public reports_listPanel() {
        // Initialize the list of text boxes
        this.textBoxList = new ArrayList<>();

        // Set layout manager and background color
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        // Create and configure the label for displaying the list title
        JLabel label = new JLabel("REPORTS");
        label.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        label.setBounds(11, 15, 150, 20);
        this.add(label);

        // Create and configure the panel for displaying the list of reports
        list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 40, 360, 250);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.lightGray;
            }
        });
        this.add(scrollPane);
    }

    /**
     * Creates a new JTextPane with the specified title and adds it to the report list.
     * Ensures proper text wrapping and allows for scrolling if needed.
     *
     * @param title The title to set in the newly created JTextPane
     */
    public void createTextBox(String title) {
        JTextPane textBox = getjTextPane(title);
        textBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        textBoxList.add(textBox);

        list.add(textBox);
        list.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between text boxes
        list.revalidate();
        list.repaint();
    }

    /**
     * Creates a JTextPane with proper settings for displaying long text.
     *
     * @param title The text content to display
     * @return The configured JTextPane
     */
    private static JTextPane getjTextPane(String title) {
        JTextPane textBox = new JTextPane();
        textBox.setText(title);
        textBox.setEditable(false);

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

        // Enable word wrapping
        StyledDocument doc = textBox.getStyledDocument();
        SimpleAttributeSet wrap = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(wrap, 0.5f);
        doc.setParagraphAttributes(0, doc.getLength(), wrap, false);

        // Set appearance
        textBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        textBox.setBackground(Color.WHITE);
        textBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Set preferred and maximum size for dynamic layout
        textBox.setPreferredSize(new Dimension(340, 100));
        textBox.setMaximumSize(new Dimension(360, Integer.MAX_VALUE));

        return textBox;
    }
}
