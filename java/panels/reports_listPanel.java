package panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.ArrayList;

/**
 * The `mainPanel` class represents the main user interface panel for managing hotels.
 * This panel displays a list of hotels and provides buttons for creating, booking, and deleting hotels.
 */
public class reports_listPanel extends JPanel {

    // List to hold dynamically created JTextPane components
    public ArrayList<JTextPane> textBoxList;

    // Panel containing the list of hotels
    public JPanel list;;

    /**
     * Constructs a `mainPanel` instance and initializes its components.
     * The panel is designed to display:
     * <ul>
     *   <li>A list of hotels</li>
     *   <li>Buttons to create, delete, and book hotels</li>
     * </ul>
     * The layout and component settings are configured in this constructor.
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

        // Create and configure the panel for displaying the list of hotels
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
     * Creates a new JTextPane with the specified title and adds it to the hotel list.
     * Also ensures that there is spacing between the added text boxes.
     *
     * @param title The title to set in the newly created JTextPane
     */
    public void createTextBox(String title) {
        JTextArea textArea = new JTextArea(2, 1);
        JTextPane textBox = getjTextPane(title, textArea);
        textBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        textBoxList.add(textBox);

        list.add(textBoxList.getLast());
        list.add(Box.createRigidArea(new Dimension(0, 2))); // Add space between text boxes
    }

    /**
     * Creates a JTextPane with the specified title and preferred size.
     * Configures the text pane to be non-editable and sets its appearance.
     *
     * @param title The title to set in the JTextPane
     * @param textArea A JTextArea to determine the preferred size
     * @return The configured JTextPane
     */
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
