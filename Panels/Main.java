import javax.swing.*;

public class Main extends JFrame {

    public Main() {

        this.setTitle("Library Management System");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        bookReviewUpdatePanel file = new bookReviewUpdatePanel();
        file.setBounds(0, 0, 400, 400);

        this.add(file);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main view = new Main();
    }
}
