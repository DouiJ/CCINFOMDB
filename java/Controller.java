import tablesInfo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controller {

    private JTextPane currentTextPane;
    private String currentBranchId;
    private String currentEmployeeId;
    private String currentPatronId;
    private String currentBookId;
    private String currentInventoryId;
    private String currentAcquisitionId;
    private String currentBorrowingId;
    private String currentFinesId;
    private String currentReviewId;

    public Controller(Model model, View view) {

        ArrayList<String> branchIds = new ArrayList<>();
        ArrayList<String> borrowingIds = new ArrayList<>();
        ArrayList<String> employeeIds = new ArrayList<>();
        ArrayList<String> patronIds = new ArrayList<>();
        ArrayList<String> bookIds = new ArrayList<>();
        ArrayList<String> inventoryIds = new ArrayList<>();
        ArrayList<String> finesIds = model.getFines();
        // action listeners

        view.returnButton.addActionListener(_ -> {
            view.goBack();
        });

        view.homeButton.addActionListener(_ -> view.goHome(view.main));

        //manage section

        view.main.manageButton.addActionListener(_ -> {
            view.moveToFront(view.manage);
            view.returnButton.setVisible(true);
            view.homeButton.setVisible(true);
        });

        view.manage.branchesButton.addActionListener(_ -> {
            view.branch_crud.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_crud.createTextBox(e);
            }

            view.moveToFront(view.branch_crud);

        });

        view.branch_crud.addButton.addActionListener(_ -> {
            view.add_branch.fullAddressTextField.setText("");
            view.add_branch.phoneNoTextField.setText("");
            view.moveToFront(view.add_branch);
        });



        view.add_branch.okButton.addActionListener(_ -> {
            model.branch.add_Branch(view.add_branch.fullAddressTextField.getText(), view.add_branch.phoneNoTextField.getText());

            view.branch_crud.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_crud.createTextBox(e);
            }

            view.goBack();
        });

        view.branch_crud.editButton.addActionListener(_-> {
            view.edit_branch.fullAddressTextField.setText("");
            view.edit_branch.phoneNoTextField.setText("");
            view.moveToFront(view.edit_branch);
        });

        view.edit_branch.okButton.addActionListener(_ -> {
            model.branch.update_Branch(currentBranchId, view.edit_branch.fullAddressTextField.getText(), view.edit_branch.phoneNoTextField.getText());
            view.goBack();
        });

        view.branch_crud.deleteButton.addActionListener(_ -> {
            model.branch.delete_Branch(currentBranchId);

            view.branch_crud.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_crud.createTextBox(e);
            }

            view.moveToFront(view.branch_crud);

            view.branch_crud.deleteButton.setEnabled(false);
            view.branch_crud.editButton.setEnabled(false);
        });

        view.manage.employeesButton.addActionListener(_ -> {
            view.moveToFront(view.employee_crud);

            view.employee_crud.list.removeAll();

            for (String e : model.getAllEmployeeIds())  {
                view.employee_crud.createTextBox(e);
            }

            view.moveToFront(view.employee_crud);
        });

        view.employee_crud.addButton.addActionListener(_ -> {
            view.branch_list_employee.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_list_employee.createTextBox(e);
            }

            view.moveToFront(view.branch_list_employee);
        });

        view.add_employee.okButton.addActionListener(_ -> {
            model.employee.add_Employee(
                    view.add_employee.lastNameTextField.getText(),
                    view.add_employee.firstNameTextField.getText(),
                    view.add_employee.jobIdTextField.getText(),
                    view.add_employee.ageTextField.getText(),
                    view.add_employee.phoneNoTextField.getText(),
                    view.add_employee.emailTextField.getText(),
                    view.add_employee.fullAddressTextField.getText(),
                    currentBranchId);

            view.employee_crud.list.removeAll();

            for (String e : model.getAllEmployeeIds())  {
                view.employee_crud.createTextBox(e);
            }

            view.goBack();
            view.goBack();
        });


        view.employee_crud.editButton.addActionListener(_-> {
            view.edit_employee.firstNameTextField.setText("");
            view.edit_employee.lastNameTextField.setText("");
            view.edit_employee.jobIdTextField.setText("");
            view.edit_employee.ageTextField.setText("");
            view.edit_employee.phoneNoTextField.setText("");
            view.edit_employee.emailTextField.setText("");
            view.edit_employee.hireDateTextField.setText("");
            view.edit_employee.fullAddressTextField.setText("");
            view.edit_employee.branchIdTextField.setText("");
            view.moveToFront(view.edit_employee);
        });

        view.edit_employee.okButton.addActionListener(_-> {
            model.employee.update_Employee(
                    currentEmployeeId,
                    view.edit_employee.lastNameTextField.getText(),
                    view.edit_employee.firstNameTextField.getText(),
                    view.edit_employee.jobIdTextField.getText(),
                    view.edit_employee.ageTextField.getText(),
                    view.edit_employee.phoneNoTextField.getText(),
                    view.edit_employee.emailTextField.getText(),
                    view.edit_employee.hireDateTextField.getText(),
                    view.edit_employee.fullAddressTextField.getText(),
                    view.edit_employee.branchIdTextField.getText());

            view.goBack();
        });

        view.employee_crud.deleteButton.addActionListener(_ -> {
            model.employee.delete_Employee(currentEmployeeId);

            view.employee_crud.list.removeAll();

            for (String e : model.getAllEmployeeIds())  {
                view.employee_crud.createTextBox(e);
            }

            view.moveToFront(view.employee_crud);

            view.employee_crud.deleteButton.setEnabled(false);
            view.employee_crud.editButton.setEnabled(false);
        });

        view.manage.patronsButton.addActionListener(_ -> {
            view.patron_crud.list.removeAll();

            for (String e : model.getAllPatronIds())  {
                view.patron_crud.createTextBox(e);
            }

            view.moveToFront(view.patron_crud);
        });

        view.patron_crud.addButton.addActionListener(_ -> {
            view.add_patron.firstNameTextField.setText("");
            view.add_patron.lastNameTextField.setText("");
            view.add_patron.ageTextField.setText("");
            view.add_patron.genderTextField.setText("");
            view.add_patron.phoneNoTextField.setText("");
            view.add_patron.emailTextField.setText("");
            view.moveToFront(view.add_patron);
        });


        view.add_patron.okButton.addActionListener(_->{
            model.patron.add_patron(
                    view.add_patron.lastNameTextField.getText(),
                    view.add_patron.firstNameTextField.getText(),
                    view.add_patron.ageTextField.getText(),
                    view.add_patron.genderTextField.getText(),
                    view.add_patron.phoneNoTextField.getText(),
                    view.add_patron.emailTextField.getText());

            view.patron_crud.list.removeAll();

            for (String e : model.getAllPatronIds())  {
                view.patron_crud.createTextBox(e);
            }

            view.goBack();
        });

        view.patron_crud.editButton.addActionListener(_-> {
            view.edit_patron.firstNameTextField.setText("");
            view.edit_patron.lastNameTextField.setText("");
            view.edit_patron.ageTextField.setText("");
            view.edit_patron.genderTextField.setText("");
            view.edit_patron.phoneNoTextField.setText("");
            view.edit_patron.emailTextField.setText("");
            view.moveToFront(view.edit_patron);
        });

        view.edit_patron.okButton.addActionListener(_-> {
            model.patron.update_patron(
                    currentPatronId,
                    view.edit_patron.lastNameTextField.getText(),
                    view.edit_patron.firstNameTextField.getText(),
                    view.edit_patron.ageTextField.getText(),
                    view.edit_patron.genderTextField.getText(),
                    view.edit_patron.phoneNoTextField.getText(),
                    view.edit_patron.emailTextField.getText());

            view.goBack();
        });

        view.patron_crud.deleteButton.addActionListener(_ -> {
            model.patron.delete_patron(currentPatronId);

            view.patron_crud.list.removeAll();

            for (String e : model.getAllPatronIds())  {
                view.patron_crud.createTextBox(e);
            }

            view.moveToFront(view.patron_crud);

            view.patron_crud.deleteButton.setEnabled(false);
            view.patron_crud.editButton.setEnabled(false);
        });



        view.manage.booksButton.addActionListener(_ -> {

            view.book_crud.list.removeAll();

            for (String e : model.getAllISBN())  {
                view.book_crud.createTextBox(e);
            }

            view.moveToFront(view.book_crud);
        });

        view.book_crud.addButton.addActionListener(_ -> {
            view.add_book.isbnTextField.setText("");
            view.add_book.titleTextField.setText("");
            view.add_book.priceTextField.setText("");
            view.add_book.firstNameTextField.setText("");
            view.add_book.lastNameTextField.setText("");
            view.moveToFront(view.add_book);
        });

// Add a new book
        view.add_book.okButton.addActionListener(_ -> {
            model.book.add_BookDetails(
                    view.add_book.isbnTextField.getText(),
                    view.add_book.titleTextField.getText(),
                    view.add_book.priceTextField.getText(),
                    view.add_book.lastNameTextField.getText(),
                    view.add_book.firstNameTextField.getText());

            view.book_crud.list.removeAll();

            for (String e : model.getAllISBN())  {
                view.book_crud.createTextBox(e);
            }

            view.goBack();
        });

// Edit a book
        view.book_crud.editButton.addActionListener(_ -> {
            view.edit_book.isbnTextField.setText("");
            view.edit_book.titleTextField.setText("");
            view.edit_book.priceTextField.setText("");
            view.edit_book.lastNameTextField.setText("");
            view.edit_book.firstNameTextField.setText("");
            view.moveToFront(view.edit_book);
        });

// Update a book
        view.edit_book.okButton.addActionListener(_ -> {
            model.book.update_BookDetails(
                    currentBookId,
                    view.edit_book.titleTextField.getText(),
                    view.edit_book.priceTextField.getText(),
                    view.edit_book.lastNameTextField.getText(),
                    view.edit_book.firstNameTextField.getText());

            view.goBack();
        });

// Delete a book
        view.book_crud.deleteButton.addActionListener(_ -> {
            model.book.delete_BookDetails(currentBookId);

            view.book_crud.list.removeAll();

            for (String e : model.getAllISBN())  {
                view.book_crud.createTextBox(e);
            }

            view.moveToFront(view.book_crud);

            view.book_crud.deleteButton.setEnabled(false);
            view.book_crud.editButton.setEnabled(false);
        });

        view.manage.inventoryButton.addActionListener(_ -> {

            view.inventory_crud.list.removeAll();

            for (String e : model.getAllInventoryIds())  {
                view.inventory_crud.createTextBox(e);
            }

            view.moveToFront(view.inventory_crud);
        });


        view.inventory_crud.addButton.addActionListener(_ -> {

            view.branch_list_acquisition.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_list_acquisition.createTextBox(e);
            }

            view.moveToFront(view.branch_list_acquisition);
        });

        view.inventory_crud.addButton.addActionListener(_ -> {

            view.branch_list_acquisition.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_list_acquisition.createTextBox(e);
            }

            view.moveToFront(view.branch_list_acquisition);

        });

        view.add_inventory.okButton.addActionListener(_-> {
                    model.acquisition.add_Book_acquisition(
                            view.add_inventory.supplierTextField.getText(),
                            view.add_inventory.priceTextField.getText(),
                            view.add_inventory.copiesAcquiredTextField.getText(),
                            currentEmployeeId,
                            view.add_inventory.isbnTextField.getText(),
                            currentBranchId);

                    view.inventory_crud.list.removeAll();

                    for (String e : model.getAllInventoryIds()) {
                        view.inventory_crud.createTextBox(e);
                    }

                    view.goBack();
                    view.goBack();
                    view.goBack();

                });


        // Edit inventory
        view.inventory_crud.editButton.addActionListener(_ -> {
            view.edit_inventory.isbnTextField.setText("");

            view.moveToFront(view.edit_inventory);
        });

        view.edit_inventory.okButton.addActionListener(_ -> {
            model.inventory.update_Book(
                    currentInventoryId,
                    view.edit_inventory.isbnTextField.getText(),
                    view.edit_inventory.BranchidTextField.getText());

            view.goBack();
        });

// Delete inventory
        view.inventory_crud.deleteButton.addActionListener(_ -> {
            model.inventory.delete_Book(currentInventoryId);

            view.inventory_crud.list.removeAll();

            for (String e : model.getAllInventoryIds()) {
                view.inventory_crud.createTextBox(e);
            }

            view.moveToFront(view.inventory_crud);

            view.inventory_crud.deleteButton.setEnabled(false);
            view.inventory_crud.editButton.setEnabled(false);
        });

        view.view_inventory.okButton.addActionListener(_ -> {

            Acquisition acquisitioninfo = model.getAcquisitionDetails(currentAcquisitionId);


            view.view_acquisition.priceValueLabel.setText(String.valueOf(acquisitioninfo.acquisitionPrice));
            view.view_acquisition.archivistValueLabel.setText(acquisitioninfo.archivistId);
            view.view_acquisition.dateValueLabel.setText(String.valueOf(acquisitioninfo.acquisitionDate));
            view.view_acquisition.isbnValueLabel.setText(acquisitioninfo.isbn);
            view.view_acquisition.branchDeliveredValueLabel.setText(acquisitioninfo.branchDelivered);
            view.view_acquisition.copiesValueAcquiredValueLabel.setText(String.valueOf(acquisitioninfo.copiesAcquired));
            view.view_acquisition.idValueLabel.setText(currentAcquisitionId);

            view.moveToFront(view.view_acquisition);

        });




        //simulate booking section
        view.main.simulateButton.addActionListener(_ -> {

            view.moveToFront(view.simulate);
            view.returnButton.setVisible(true);
            view.homeButton.setVisible(true);
        });

        view.simulate.borrowButton.addActionListener(_ -> {

            view.branch_list_borrow.textBoxList.clear();
            view.branch_list_borrow.list.removeAll();

            view.branch_list_borrow.list.removeAll();

            for (String e : model.getBranchIds())  {
                view.branch_list_borrow.createTextBox(e);
            }

            view.moveToFront(view.branch_list_borrow);
        });

        view.simulate.borrowListButton.addActionListener(_ -> {

            view.borrowing_list.list.removeAll();

            for (String e : model.getBorrowIds())  {
                view.borrowing_list.createTextBox(model.getBorrowStatus(e));
            }

            view.moveToFront(view.borrowing_list);
        });

        view.borrowing_view.returnButton.addActionListener(_ -> {

            model.updateBorrowStatusToReturned(currentBorrowingId);
            view.goHome(view.main);
        });


        view.borrowing_view.lostButton.addActionListener(_ -> {

            model.updateBorrowStatusToLost(currentBorrowingId);
            view.goHome(view.main);

        });


        view.simulate.finesButton.addActionListener(_ -> {

            view.fines_list.textBoxList.clear();
            view.fines_list.list.removeAll();

            finesIds.clear();
            finesIds.addAll(model.getFines());

            for (String e : finesIds)  {
                view.fines_list.createTextBox(e);
            }

            view.moveToFront(view.fines_list);
        });

        view.simulate.bookReview.addActionListener(_-> {

            view.borrowing_list_review.list.removeAll();

            for (String e : model.getUnratedBorrowIds())  {
                view.borrowing_list_review.createTextBox(e);
            }

            view.moveToFront(view.borrowing_list_review);


        });

        view.simulate.viewbookReview.addActionListener(_-> {

            view.review_list.list.removeAll();

            for (String e : model.getAllReviews())  {
                view.review_list.createTextBox(e);
            }

            view.moveToFront(view.review_list);
        });

        view.add_review.createButton.addActionListener(_-> {

            model.review.setBorrow_id(currentBorrowingId);
            model.review.setRating_score(view.add_review.scoreTextField.getText());
            model.review.setRating_comment(view.add_review.commentTextField.getText());
            model.review.create_Review();

            view.goHome(view.main);
            view.returnButton.setVisible(false);
            view.homeButton.setVisible(false);
        });

        view.manage_fines.paidButton.addActionListener(_->{

            model.updatePaymentDate(currentFinesId);
            view.goHome(view.main);
            view.returnButton.setVisible(false);
            view.homeButton.setVisible(false);
        });

        view.manage_fines.cancelButton.addActionListener(_->{

            model.cancelFine(currentFinesId);
            view.goHome(view.main);
            view.returnButton.setVisible(false);
            view.homeButton.setVisible(false);
        });


        view.main.reportsButton.addActionListener(_ -> {

            LocalDate currentDate = LocalDate.now();
            LocalDate past30DaysDate = currentDate.minusDays(30);

            // Current year and month
            int currentYear = currentDate.getYear();
            int currentMonth = currentDate.getMonthValue();

            // Year and month for 30 days ago
            int pastYear = past30DaysDate.getYear();
            int pastMonth = past30DaysDate.getMonthValue();

            ArrayList<String> topBorrowed = model.getMostBorrowedISBNsLastTwoYears();
            ArrayList<String> newlyAcquired = model.getNewlyAcquiredBooks(currentYear, currentMonth, pastYear, pastMonth);
            ArrayList<String> patronActivity = model.getPatronActivity(currentYear, currentMonth);
            ArrayList<String> bookRatings = model.getReviewSummary();

            view.reports.list.removeAll();

            view.reports.createTextBox("- Top Borrowed Books -");
            for (String e : topBorrowed)
            {
                view.reports.createTextBox(e);
            }
            view.reports.createTextBox("- Newly Acquired Books -");
            for (String e : newlyAcquired)
            {
                view.reports.createTextBox(e);
            }
            view.reports.createTextBox("- Patron Activity -");
            for (String e : patronActivity)
            {
                view.reports.createTextBox(e);
            }
            view.reports.createTextBox("- Book Ratings -");
            for (String e : bookRatings)
            {
                view.reports.createTextBox(e);
            }

            view.moveToFront(view.reports);

            view.returnButton.setVisible(true);
            view.homeButton.setVisible(true);




        });



        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.branch_list_borrow.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_list_borrow.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.branch_list_borrow.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBranchId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    view.employee_list_borrow.textBoxList.clear();
                                    view.employee_list_borrow.list.removeAll();

                                    view.returnButton.setVisible(true);
                                    view.homeButton.setVisible(true);

                                    employeeIds.clear();
                                    employeeIds.addAll(model.getEmployeeIds(currentBranchId));

                                    for (String e : employeeIds)  {
                                        view.employee_list_borrow.createTextBox(e);
                                    }

                                    view.moveToFront(view.employee_list_borrow);

                                    clearTextBox(view.branch_list_borrow.textBoxList);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.branch_list_borrow.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                                if (view.branch_list_borrow.textBoxList.contains(textBox)) {
                                    for (JTextPane textPane : view.branch_list_borrow.textBoxList) {
                                        if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                            textPane.setBackground(Color.white);
                                            textPane.setForeground(Color.black);
                                        }
                                    }

                                    if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                        textBox.setBackground(Color.lightGray);
                                    }
                                }
                            } else {
                                for (JTextPane textPane : view.branch_list_borrow.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }
                            }
                        }
                    }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.branch_list_employee.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_list_employee.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.branch_list_employee.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBranchId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    view.add_employee.firstNameTextField.setText("");
                                    view.add_employee.lastNameTextField.setText("");
                                    view.add_employee.jobIdTextField.setText("");
                                    view.add_employee.ageTextField.setText("");
                                    view.add_employee.phoneNoTextField.setText("");
                                    view.add_employee.emailTextField.setText("");
                                    view.add_employee.hireDateTextField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))); view.add_employee.hireDateTextField.setEnabled(false);
                                    view.add_employee.fullAddressTextField.setText("");
                                    view.add_employee.branchIdTextField.setText(currentBranchId); view.add_employee.branchIdTextField.setEnabled(false);

                                    view.moveToFront(view.add_employee);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.branch_list_employee.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_list_employee.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.branch_list_employee.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.branch_list_employee.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.branch_list_acquisition.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_list_acquisition.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.branch_list_acquisition.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBranchId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    view.employee_list_acquisition.list.removeAll();

                                    view.returnButton.setVisible(true);
                                    view.homeButton.setVisible(true);

                                    for (String e : model.getEmployeeIds(currentBranchId))  {
                                        view.employee_list_acquisition.createTextBox(e);
                                    }

                                    view.moveToFront(view.employee_list_acquisition);

                                    clearTextBox(view.branch_list_acquisition.textBoxList);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.branch_list_acquisition.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_list_acquisition.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.branch_list_acquisition.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.branch_list_acquisition.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.employee_list_acquisition.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.employee_list_acquisition.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.employee_list_acquisition.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentEmployeeId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    view.add_inventory.isbnTextField.setText("");
                                    view.add_inventory.acquisitionDateTextField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))); view.add_inventory.acquisitionDateTextField.setEnabled(false);
                                    view.add_inventory.supplierTextField.setText("");
                                    view.add_inventory.priceTextField.setText("");
                                    view.add_inventory.archivistTextField.setText(currentEmployeeId); view.add_inventory.archivistTextField.setEnabled(false);
                                    view.add_inventory.copiesAcquiredTextField.setText("");
                                    view.add_inventory.branchDeliveredTextField.setText(currentBranchId); view.add_inventory.branchDeliveredTextField.setEnabled(false);
                                    view.moveToFront(view.add_inventory);

                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.employee_list_acquisition.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.employee_list_acquisition.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.employee_list_acquisition.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.employee_list_acquisition.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.employee_list_borrow.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.employee_list_borrow.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.employee_list_borrow.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);
                                    currentEmployeeId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    view.patron_list_borrow.list.removeAll();

                                    for (String e : model.getAllPatronIds())  {
                                        view.patron_list_borrow.createTextBox(e);
                                    }

                                    view.moveToFront(view.patron_list_borrow);

                                    clearTextBox(view.employee_list_borrow.textBoxList);

                                    view.returnButton.setVisible(true);
                                    view.homeButton.setVisible(true);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.employee_list_borrow.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.employee_list_borrow.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.employee_list_borrow.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.employee_list_borrow.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.patron_list_borrow.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.patron_list_borrow.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.patron_list_borrow.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);
                                    currentPatronId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    view.book_list_borrow.list.removeAll();

                                    for (String e : model.getAvailableInventoryIds())  {
                                        view.book_list_borrow.createTextBox(e);
                                    }

                                    view.moveToFront(view.book_list_borrow);

                                    clearTextBox(view.book_list_borrow.textBoxList);

                                    view.returnButton.setVisible(true);
                                    view.homeButton.setVisible(true);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.patron_list_borrow.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.patron_list_borrow.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.patron_list_borrow.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.patron_list_borrow.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.book_list_borrow.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.book_list_borrow.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.book_list_borrow.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);
                                    currentBookId = currentTextPane.getText();

                                } else if (evt.getClickCount() == 2) {

                                    String date = java.time.LocalDate.now().toString();
                                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    try {
                                        java.util.Date utilDate = df.parse(date);
                                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                                        // Calculate date_due as sqlDate + 7 days
                                        java.sql.Date dateDue = java.sql.Date.valueOf(sqlDate.toLocalDate().plusDays(7));

                                        model.borrowing.setBook_id(currentBookId);
                                        model.borrowing.setBorrow_status("B");
                                        model.borrowing.setClerk_id(currentEmployeeId);
                                        model.borrowing.setDate_borrowed(sqlDate);
                                        model.borrowing.setDate_due(dateDue);
                                        model.borrowing.setPatron_id(currentPatronId);
                                        model.borrowing.setDate_returned(null);
                                        model.borrowing.setTransaction_status("A");

                                        model.borrowing.create_Borrowing();
                                        view.goBack();
                                        view.goBack();
                                        view.goBack();
                                        view.goBack();

                                    } catch (ParseException e) {
                                        throw new RuntimeException(e);
                                    }

                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.book_list_borrow.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.book_list_borrow.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.book_list_borrow.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.book_list_borrow.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.branch_crud.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_crud.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.branch_crud.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBranchId = currentTextPane.getText();

                                    view.branch_crud.deleteButton.setEnabled(true);
                                    view.branch_crud.editButton.setEnabled(true);


                                } else if (evt.getClickCount() == 2) {

                                    Branch branchInfo = model.getBranchDetails(currentBranchId);

                                    view.moveToFront(view.view_branch);
                                    view.view_branch.branchIdValueLabel.setText(currentBranchId);
                                    view.view_branch.fullAddressValueLabel.setText(branchInfo.fullAddress);
                                    view.view_branch.phoneNoValueLabel.setText(branchInfo.phoneNo);
                                }
                            }
                        }
                        else if (!(evt.getSource().equals(view.branch_crud.deleteButton) || evt.getSource().equals(view.branch_crud.editButton)))
                        {
                            clearTextBox(view.branch_crud.textBoxList);

                            view.branch_crud.deleteButton.setEnabled(false);
                            view.branch_crud.editButton.setEnabled(false);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.branch_crud.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.branch_crud.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.branch_crud.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.employee_crud.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.employee_crud.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.employee_crud.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentEmployeeId = currentTextPane.getText();

                                    view.employee_crud.deleteButton.setEnabled(true);
                                    view.employee_crud.editButton.setEnabled(true);
                                } else if (evt.getClickCount() == 2) {

                                    Employee employeeInfo = model.getEmployeeDetails(currentEmployeeId);

                                    view.moveToFront(view.view_employee);
                                    view.view_employee.employeeIdValueLabel.setText(currentEmployeeId);
                                    view.view_employee.firstNameValueLabel.setText(employeeInfo.firstName);
                                    view.view_employee.lastNameValueLabel.setText(employeeInfo.lastName);
                                    view.view_employee.jobIdValueLabel.setText(employeeInfo.jobName);
                                    view.view_employee.ageValueLabel.setText(String.valueOf(employeeInfo.age));
                                    view.view_employee.phoneNoValueLabel.setText(employeeInfo.phoneNo);
                                    view.view_employee.emailValueLabel.setText(employeeInfo.email);
                                    view.view_employee.hireDateValueLabel.setText(String.valueOf(employeeInfo.hireDate));
                                    view.view_employee.fullAddressValueLabel.setText(employeeInfo.fullAddress);
                                    view.view_employee.branchIdValueLabel.setText(employeeInfo.branchId);
                                }
                            }
                        }
                        else if (!(evt.getSource().equals(view.employee_crud.deleteButton) || evt.getSource().equals(view.employee_crud.editButton)))
                        {
                            clearTextBox(view.employee_crud.textBoxList);

                            view.employee_crud.deleteButton.setEnabled(false);
                            view.employee_crud.editButton.setEnabled(false);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.employee_crud.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.employee_crud.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.employee_crud.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.patron_crud.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.patron_crud.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.patron_crud.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentPatronId = currentTextPane.getText();

                                    view.patron_crud.deleteButton.setEnabled(true);
                                    view.patron_crud.editButton.setEnabled(true);
                                } else if (evt.getClickCount() == 2) {

                                    Patron patroninfo = model.getPatronDetails(currentPatronId);

                                    view.moveToFront(view.view_patron);
                                    view.view_patron.patronIdValueLabel.setText(currentPatronId);
                                    view.view_patron.firstNameValueLabel.setText(patroninfo.first_name);
                                    view.view_patron.lastNameValueLabel.setText(patroninfo.last_name);
                                    view.view_patron.ageValueLabel.setText(patroninfo.age);
                                    view.view_patron.genderValueLabel.setText(patroninfo.gender);
                                    view.view_patron.phoneNoValueLabel.setText(patroninfo.phone_no);
                                    view.view_patron.emailValueLabel.setText(patroninfo.email);

                                }
                            }
                        }
                            else if (!(evt.getSource().equals(view.patron_crud.deleteButton) || evt.getSource().equals(view.patron_crud.editButton))) {
                                clearTextBox(view.patron_crud.textBoxList);

                                view.patron_crud.deleteButton.setEnabled(false);
                                view.patron_crud.editButton.setEnabled(false);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.patron_crud.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.patron_crud.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.patron_crud.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.book_crud.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.book_crud.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.book_crud.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBookId = currentTextPane.getText();

                                    view.book_crud.deleteButton.setEnabled(true);
                                    view.book_crud.editButton.setEnabled(true);
                                } else if (evt.getClickCount() == 2) {

                                    Book bookInfo = model.getBookDetails(currentBookId);

                                    view.moveToFront(view.view_book);
                                    view.view_book.isbnValueLabel.setText(currentBookId);
                                    view.view_book.titleValueLabel.setText(bookInfo.title);
                                    view.view_book.priceValueLabel.setText(bookInfo.price);
                                    view.view_book.authorFirstNameValueLabel.setText(bookInfo.authorFirstName);
                                    view.view_book.authorLastNameValueLabel.setText(bookInfo.authorLastName);
                                }
                            }
                        } else if (!(evt.getSource().equals(view.book_crud.deleteButton) || evt.getSource().equals(view.book_crud.editButton))) {
                            clearTextBox(view.book_crud.textBoxList);

                            view.book_crud.deleteButton.setEnabled(false);
                            view.book_crud.editButton.setEnabled(false);
                        }
                    } else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.book_crud.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.book_crud.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.book_crud.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.inventory_crud.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.inventory_crud.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.inventory_crud.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentInventoryId = currentTextPane.getText();

                                    view.inventory_crud.deleteButton.setEnabled(true);
                                    view.inventory_crud.editButton.setEnabled(true);
                                } else if (evt.getClickCount() == 2) {
                                    Inventory inventoryInfo = model.getInventoryDetails(currentInventoryId);

                                    currentAcquisitionId = inventoryInfo.acquisitionId;

                                    view.moveToFront(view.view_inventory);
                                    view.view_inventory.inventoryIdValueLabel.setText(currentInventoryId);
                                    view.view_inventory.isbnValueLabel.setText(inventoryInfo.isbn);
                                    view.view_inventory.branchIdValueLabel.setText(inventoryInfo.branchId);
                                    view.view_inventory.acquisitionIdValueLabel.setText(String.valueOf(inventoryInfo.acquisitionId));
                                }
                            }
                        } else if (!(evt.getSource().equals(view.inventory_crud.deleteButton) || evt.getSource().equals(view.inventory_crud.editButton))) {
                            clearTextBox(view.inventory_crud.textBoxList);

                            view.inventory_crud.deleteButton.setEnabled(false);
                            view.inventory_crud.editButton.setEnabled(false);
                        }
                    } else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.inventory_crud.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.inventory_crud.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.inventory_crud.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.borrowing_list.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.borrowing_list.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.borrowing_list.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBorrowingId = model.removeTextSuffix(currentTextPane.getText());


                                } else if (evt.getClickCount() == 2) {


                                    Borrowing borrowinginfo = model.getBorrowingDetails(currentBorrowingId);

                                    view.borrowing_view.clerkidValueLabel.setText(borrowinginfo.clerkId);
                                    view.borrowing_view.clerknameValueLabel.setText(model.getEmployeeFullName(borrowinginfo.clerkId));
                                    view.borrowing_view.patronidValueLabel.setText(borrowinginfo.patronId);
                                    view.borrowing_view.patronnameValueLabel.setText(model.getPatronFullName(borrowinginfo.patronId));
                                    view.borrowing_view.bookidValueLabel.setText(borrowinginfo.bookId);
                                    view.borrowing_view.booknameValueLabel.setText(model.getBookTitleByInventoryId(borrowinginfo.bookId));

                                    view.moveToFront(view.borrowing_view);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.borrowing_list.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.borrowing_list.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.borrowing_list.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.borrowing_list.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.fines_list.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.fines_list.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.fines_list.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentFinesId = model.removeTextSuffix(currentTextPane.getText());


                                } else if (evt.getClickCount() == 2) {

                                    Fines fineinfo = model.getFineDetailsByFineId(currentFinesId);

                                    view.manage_fines.fineid.setText(fineinfo.fineId);
                                    view.manage_fines.fineamount.setText(String.valueOf(fineinfo.fineAmount));
                                    view.manage_fines.paymentdate.setText(fineinfo.paymentDate);
                                    view.manage_fines.borrowid.setText(fineinfo.borrowId);
                                    view.manage_fines.clerkid.setText(fineinfo.clerkId);
                                    view.manage_fines.status.setText(fineinfo.status);


                                    view.moveToFront(view.manage_fines);



                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.fines_list.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.fines_list.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.fines_list.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.fines_list.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (view.borrowing_list_review.isVisible()) {
                if (event instanceof MouseEvent evt) {
                    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.borrowing_list_review.textBoxList.contains(textBox)) {
                                if (evt.getClickCount() == 1) {
                                    clearTextBox(view.borrowing_list_review.textBoxList);

                                    currentTextPane = textBox;
                                    currentTextPane.setBackground(new Color(31, 117, 254));
                                    currentTextPane.setForeground(Color.white);

                                    currentBorrowingId = currentTextPane.getText();


                                } else if (evt.getClickCount() == 2) {
                                    view.add_review.scoreTextField.setText("");
                                    view.add_review.commentTextField.setText("");

                                    view.moveToFront(view.add_review);
                                }
                            }
                        }
                        else
                        {
                            clearTextBox(view.borrowing_list_review.textBoxList);
                        }
                    }
                    else {
                        if (evt.getSource() instanceof JTextPane textBox) {
                            if (view.borrowing_list_review.textBoxList.contains(textBox)) {
                                for (JTextPane textPane : view.borrowing_list_review.textBoxList) {
                                    if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                        textPane.setBackground(Color.white);
                                        textPane.setForeground(Color.black);
                                    }
                                }

                                if (!textBox.getBackground().equals(new Color(31, 117, 254))) {
                                    textBox.setBackground(Color.lightGray);
                                }
                            }
                        } else {
                            for (JTextPane textPane : view.borrowing_list_review.textBoxList) {
                                if (!textPane.getBackground().equals(new Color(31, 117, 254))) {
                                    textPane.setBackground(Color.white);
                                    textPane.setForeground(Color.black);
                                }
                            }
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);


    }




    public void clearTextBox(ArrayList<JTextPane> textBox) {
        for (JTextPane textPane : textBox) {
            textPane.setBackground(Color.white);
            textPane.setForeground(Color.black);
        }
    }



}