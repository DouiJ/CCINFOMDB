import javax.swing.*;
import java.awt.*;
import panels.*;

public class View extends JFrame {

    public JButton returnButton;
    public JButton homeButton;

    public JLayeredPane layer;
    public JLayeredPane layer2;

    public mainPanel main;
    public branch_listPanel branch_list_borrow;
    public employees_listPanel employee_list_borrow;
    public simulatePanel simulate;
    public managePanel manage;
    public branch_crudPanel branch_crud;
    public employees_crudPanel employee_crud;
    public patrons_crudPanel patron_crud;
    public book_crudPanel book_crud;
    public inventory_crudPanel inventory_crud;
    public borrowing_listPanel borrowing_list;
    public fines_listPanel fines_list;
    public branch_inputPanel add_branch;
    public branch_viewPanel view_branch;
    public branch_inputPanel edit_branch;
    public employees_inputPanel add_employee;
    public employees_viewPanel view_employee;
    public employees_inputPanel edit_employee;
    public branch_listPanel branch_list_employee;
    public patrons_inputPanel add_patron;
    public patrons_viewPanel view_patron;
    public patrons_inputPanel edit_patron;
    public book_inputPanel add_book;
    public book_viewPanel view_book;
    public book_inputPanel edit_book;
    public acquisition_inputPanel add_inventory;
    public inventory_viewPanel view_inventory;
    public inventory_inputPanel edit_inventory;
    public branch_listPanel branch_list_acquisition;
    public employees_listPanel employee_list_acquisition;
    public acquisition_inputPanel edit_acquisition;
    public acquisition_viewPanel view_acquisition;
    public book_listPanel book_list_borrow;
    public patron_listPanel patron_list_borrow;
    public borrowing_viewPanel borrowing_view;
    public reports_listPanel reports;
    public review_inputPanel add_review;
    public borrowing_listPanel borrowing_list_review;
    public review_listPanel review_list;
    public fines_managePanel manage_fines;

    public View() {

        layer = new JLayeredPane();
        layer2 = new JLayeredPane();

        main = new mainPanel();
        branch_list_borrow = new branch_listPanel();
        employee_list_borrow = new employees_listPanel();
        simulate = new simulatePanel();
        manage = new managePanel();
        branch_crud = new branch_crudPanel();
        employee_crud = new employees_crudPanel();
        patron_crud = new patrons_crudPanel();
        book_crud = new book_crudPanel();
        inventory_crud = new inventory_crudPanel();
        borrowing_list = new borrowing_listPanel();
        fines_list = new fines_listPanel();
        add_branch = new branch_inputPanel();
        view_branch = new branch_viewPanel();
        edit_branch = new branch_inputPanel();
        add_employee = new employees_inputPanel();
        view_employee = new employees_viewPanel();
        edit_employee = new employees_inputPanel();
        branch_list_employee = new branch_listPanel();
        add_patron = new patrons_inputPanel();
        view_patron = new patrons_viewPanel();
        edit_patron = new patrons_inputPanel();
        add_book = new book_inputPanel();
        view_book = new book_viewPanel();
        edit_book = new book_inputPanel();
        add_inventory = new acquisition_inputPanel();
        branch_list_acquisition = new branch_listPanel();
        employee_list_acquisition = new employees_listPanel();
        view_inventory = new inventory_viewPanel();
        edit_inventory = new inventory_inputPanel();
        edit_acquisition = new acquisition_inputPanel();
        view_acquisition = new acquisition_viewPanel();
        book_list_borrow = new book_listPanel();
        patron_list_borrow = new patron_listPanel();
        borrowing_view = new borrowing_viewPanel();
        reports = new reports_listPanel();
        add_review = new review_inputPanel();
        borrowing_list_review = new borrowing_listPanel();
        review_list = new review_listPanel();
        manage_fines = new fines_managePanel();




        this.setTitle("Library Management System");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        layer.setBounds(0, 0, 400, 400);

        setLayerBound(main, 1);
        setLayerBound(branch_list_borrow, 0);
        setLayerBound(employee_list_borrow, 0);
        setLayerBound(simulate, 0);
        setLayerBound(manage, 0);
        setLayerBound(branch_crud, 0);
        setLayerBound(employee_crud, 0);
        setLayerBound(patron_crud, 0);
        setLayerBound(book_crud, 0);
        setLayerBound(inventory_crud, 0);
        setLayerBound(borrowing_list, 0);
        setLayerBound(fines_list, 0);
        setLayerBound(add_branch, 0);
        setLayerBound(view_branch, 0);
        setLayerBound(edit_branch, 0);
        setLayerBound(add_employee, 0);
        setLayerBound(view_employee, 0);
        setLayerBound(edit_employee, 0);
        setLayerBound(branch_list_employee, 0);
        setLayerBound(add_patron, 0);
        setLayerBound(view_patron, 0);
        setLayerBound(edit_patron, 0);
        setLayerBound(add_book, 0);
        setLayerBound(view_book, 0);
        setLayerBound(edit_book, 0);
        setLayerBound(add_inventory, 0);
        setLayerBound(view_inventory, 0);
        setLayerBound(edit_inventory, 0);
        setLayerBound(branch_list_acquisition, 0);
        setLayerBound(employee_list_acquisition, 0);
        setLayerBound(view_acquisition, 0);
        setLayerBound(edit_acquisition, 0);
        setLayerBound(book_list_borrow, 0);
        setLayerBound(patron_list_borrow, 0);
        setLayerBound(borrowing_view, 0);
        setLayerBound(reports, 0);
        setLayerBound(add_review, 0);
        setLayerBound(borrowing_list_review, 0);
        setLayerBound(review_list, 0);
        setLayerBound(manage_fines, 0);



        returnButton = new JButton("<");
        returnButton.setBounds(320, 330, 50, 20);
        returnButton.setForeground(Color.red);
        returnButton.setFocusable(false);
        returnButton.setBackground(Color.WHITE);
        returnButton.setVisible(false);

        homeButton = new JButton("<<");
        homeButton.setBounds(320, 300, 50, 20);
        homeButton.setForeground(Color.red);
        homeButton.setFocusable(false);
        homeButton.setBackground(Color.WHITE);
        homeButton.setVisible(false);

        layer2.setBounds(0, 0, 400, 400);
        layer2.add(layer, Integer.valueOf(0));
        layer2.add(returnButton, Integer.valueOf(1));
        layer2.add(homeButton, Integer.valueOf(1));

        this.add(layer2);
        this.setVisible(true);
    }

    void goBack() {
        for (Component comp : layer.getComponentsInLayer(layer.highestLayer())) {
            layer.setLayer(comp, 0);
        }

        for (Component c : layer.getComponents()) {
            c.setVisible(layer.getLayer(c) == layer.highestLayer());
        }

        if (layer.highestLayer() == 1)
        {
            returnButton.setVisible(false);
            homeButton.setVisible(false);
        }
    }

    void goHome(mainPanel main) {
        for (Component c : layer.getComponents()) {
            layer.setLayer(c, 0);
            c.setVisible(false);
        }

        moveToFront(main);
        returnButton.setVisible(false);
        homeButton.setVisible(false);
    }

    void moveToFront(Component comp) {
        for (Component c : layer.getComponents()) {
            c.setVisible(false);
        }

        comp.setVisible(true);
        layer.setLayer(comp, layer.highestLayer() + 1);
    }

    void setLayerBound(Component comp, int intLayer)
    {
        layer.add(comp, Integer.valueOf(intLayer));
        comp.setBounds(0, 0, 400, 400);
    }
}
