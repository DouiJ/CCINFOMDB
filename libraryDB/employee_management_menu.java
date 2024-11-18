package libraryDB;

import java.util.Scanner;

public class employee_management_menu {

    public employee_management_menu() {
    }

    private void displayEmployeeInfo(employee_record_management e, ref_address_management a) {
        System.out.println("Current Employee Information:  ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Last Name         : "  + e.last_name);
        System.out.println("First Name        : "  + e.first_name);
        System.out.println("Job ID            : "  + e.job_id);
        System.out.println("Age               : "  + e.age);
        System.out.println("Phone No.         : "  + e.phone_no);
        System.out.println("Email Address     : "  + e.email);
        System.out.println("Hire Date         : "  + e.hire_date);
        System.out.println("Address ID        : "  + e.address_id);
        System.out.println("Branch ID         : "  + e.branch_id);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Current Address Information:   ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Unit No.         : "  + a.unit_no);
        System.out.println("Street No.       : "  + a.street_no);
        System.out.println("Barangay         : "  + a.barangay);
        System.out.println("City             : "  + a.city);
        System.out.println("Province         : "  + a.province);
        System.out.println("Region           : "  + a.region);
        System.out.println("Zip Code         : "  + a.zip_code);
        System.out.println("-------------------------------------------------------------------");
    }

    private void inputEmployeeInfo(employee_record_management e) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee information: ");
        scanner.nextLine();
        System.out.println("\nLast Name       : "); e.last_name = scanner.nextLine();
        System.out.println("First Name        : "); e.first_name = scanner.nextLine();
        System.out.println("Job ID (J1 - J4)  : "); e.job_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Age               : "); e.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Phone No.         : "); e.phone_no = scanner.nextLine();
        System.out.println("Email Address     : "); e.email = scanner.nextLine();
    }

    private void inputAddressInfo(ref_address_management a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Enter Address Information: (Type NULL if N/A)");
        scanner.nextLine();
        System.out.println("Unit No.         : "); a.unit_no        = scanner.nextLine();
        System.out.println("Street No.       : "); a.street_no       = scanner.nextLine();
        System.out.println("Barangay         : "); a.barangay        = scanner.nextLine();
        System.out.println("City             : "); a.city           = scanner.nextLine();
        System.out.println("Province         : "); a.province       = scanner.nextLine();
        System.out.println("Region           : "); a.region          = scanner.nextLine();
        System.out.println("Zip Code         : "); a.zip_code         = Integer.parseInt(scanner.nextLine());
    }

    private void inputEmployeeID(employee_record_management e) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee ID to be updated: ");
        System.out.println("Employee ID        : "); e.employee_id = scanner.nextLine();
    }

    public int employee_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        employee_record_management e = new employee_record_management();
        ref_address_management a = new ref_address_management();

        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Create a new Employee Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Update an Employee Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Delete an Employee Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "View an Employee Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-4) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Create an employee record with its dependencies
                        inputEmployeeInfo(e);
                        inputAddressInfo(a);
                        e.address_id = a.add_Address();

                        // Assign its Branch_ID to the current selected branch

                        if (e.add_Employee() != null)
                            System.out.println("Employee record created successfully!");
                         else
                            System.out.println("Error creating employee record.");
                        break;
                    case 2:
                        // Update an employee record
                        inputEmployeeID(e);
                        if (e.get_Employee() == 0)
                            System.out.println("Employee record not found. Please input a proper ID.");
                        else {
                            displayEmployeeInfo(e, a);

                            inputEmployeeInfo(e);
                            inputAddressInfo(a);

                            System.out.println("Do you want to to proceed with the update? (Y/N) ");
                            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                                e.update_Employee();
                                a.update_Address();
                            }
                            else
                                System.out.println("Employee update cancelled.");

                            // Update for Branch
                            // Get Branch List - Show from there

                        }
                        break;
                    case 3:
                        inputEmployeeID(e);
                        if (e.get_Employee() == 0)
                            System.out.println("Employee record not found. Please input a proper ID.");
                        else {
                            System.out.println("Do you want to to proceed with the deletion? (Y/N) ");
                            if (scanner.nextLine().equalsIgnoreCase("Y"))
                                e.delete_Employee();
                            else
                                System.out.println("Employee deletion cancelled.");
                        }
                        break;
                    case 4:
                        // View an employee record
                        System.out.println("Enter Employee ID to be updated: ");
                        System.out.println("Employee ID        : "); e.employee_id = scanner.nextLine();

                        if (e.get_Employee() == 0)
                            System.out.println("Employee record not found. Please input a proper ID.");
                        else
                            displayEmployeeInfo(e, a);
                        break;
                    case 0:
                        System.out.println("Exiting Employee Record Management.");
                        scanner.close();
                        return 0;
                    default:
                        System.out.println("⚠️ Invalid choice! Please select a valid option.");
                }
            return 0;
        }
    }




}
