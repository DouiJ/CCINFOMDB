package libraryDB.reports;

import javax.swing.*;
import java.awt.*;

public class patronActivityPanel extends JPanel {

    public patronActivityPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // Create a JTextArea to display employee information
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        textArea.setEditable(false);

        // Add the JTextArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);

        // Example employee and address information
        employee_record_management e = new employee_record_management("Doe", "John", "J123", 30, "123-456-7890",
                "john.doe@example.com", "2021-01-01", "A123", "B001");
        ref_address_management a = new ref_address_management("123 Main St", "Apt 4B", "New York", "NY", "10001");

        // Display employee information
        displayEmployeeInfo(e, a, textArea);
    }

    private void displayEmployeeInfo(employee_record_management e, ref_address_management a, JTextArea textArea) {
        textArea.append("Current Employee Information:\n");
        textArea.append("-------------------------------------------------------------------\n");
        textArea.append("Last Name         : " + e.last_name + "\n");
        textArea.append("First Name        : " + e.first_name + "\n");
        textArea.append("Job ID            : " + e.job_id + "\n");
        textArea.append("Age               : " + e.age + "\n");
        textArea.append("Phone No.         : " + e.phone_no + "\n");
        textArea.append("Email Address     : " + e.email + "\n");
        textArea.append("Hire Date         : " + e.hire_date + "\n");
        textArea.append("Address ID        : " + e.address_id + "\n");
        textArea.append("Branch ID         : " + e.branch_id + "\n");
        textArea.append("-------------------------------------------------------------------\n");
        textArea.append("Current Address Information:\n");
        textArea.append("-------------------------------------------------------------------\n");
        textArea.append("Street Address    : " + a.street_address + "\n");
        textArea.append("Apartment         : " + a.apartment + "\n");
        textArea.append("City              : " + a.city + "\n");
        textArea.append("State             : " + a.state + "\n");
        textArea.append("ZIP Code          : " + a.zip_code + "\n");
        textArea.append("-------------------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Patron Activity Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new patronActivityPanel());
        frame.setVisible(true);
    }
}

class employee_record_management {
    String last_name;
    String first_name;
    String job_id;
    int age;
    String phone_no;
    String email;
    String hire_date;
    String address_id;
    String branch_id;

    public employee_record_management(String last_name, String first_name, String job_id, int age, String phone_no,
            String email, String hire_date, String address_id, String branch_id) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.job_id = job_id;
        this.age = age;
        this.phone_no = phone_no;
        this.email = email;
        this.hire_date = hire_date;
        this.address_id = address_id;
        this.branch_id = branch_id;
    }
}

class ref_address_management {
    String street_address;
    String apartment;
    String city;
    String state;
    String zip_code;

    public ref_address_management(String street_address, String apartment, String city, String state, String zip_code) {
        this.street_address = street_address;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }
}