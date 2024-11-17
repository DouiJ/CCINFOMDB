package libraryDB;

import java.util.Scanner;

public class employee_management_menu {

    public employee_management_menu() {
    }

    public int employee_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

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
                        // Ask user input
                        employee_record_management e = new employee_record_management();
                        ref_address_management a = new ref_address_management();

                        System.out.print("Enter employee information: ");
                        scanner.nextLine();
                        System.out.println("\nLast Name       : "); e.last_name      = scanner.nextLine();
                        System.out.println("First Name        : "); e.first_name     = scanner.nextLine();
                        System.out.println("Job ID (1-4)      : "); e.job_id         = Integer.parseInt(scanner.nextLine());
                        System.out.println("Age               : "); e.age            = Integer.parseInt(scanner.nextLine());
                        System.out.println("Phone No.         : "); e.phone_no       = scanner.nextLine();
                        System.out.println("Email Address     : "); e.email          = scanner.nextLine();

                        System.out.println("\n Enter Address Information: (Type NULL if N/A)");
                        scanner.nextLine();
                        System.out.println("Unit No.         : "); a.unit_no        = scanner.nextLine();
                        System.out.println("Street No.       : "); a.street_no       = scanner.nextLine();
                        System.out.println("Barangay         : "); a.barangay        = scanner.nextLine();
                        System.out.println("City             : "); a.city           = scanner.nextLine();
                        System.out.println("Province         : "); a.province       = scanner.nextLine();
                        System.out.println("Region           : "); a.region          = scanner.nextLine();
                        System.out.println("Zip Code         : "); a.zip_code         = Integer.parseInt(scanner.nextLine());

                        // Adding an address record
                        e.address_id = a.add_Address();

                        // System.out.println("Branch ID         : "); e.branch_id      = scanner.nextLine();

                        if (e.add_Employee() == 1) {
                            System.out.println("Employee record created successfully!");
                        } else {
                            System.out.println("Error creating employee record.");
                        }
                        break;
                    case 2:


                        break;
                    case 3:
                        System.out.println("    ");
                        break;
                    case 4:
                        System.out.println("    ");
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
