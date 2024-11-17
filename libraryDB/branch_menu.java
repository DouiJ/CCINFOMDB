package libraryDB;

import java.util.Scanner;

public class branch_menu {

    public branch_menu() {
    }

    private void displayBranchInfo(branch_management b) {
        System.out.println("Current Branch Information:  ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Manager ID         : "  + b.manager_id);
        System.out.println("Address ID        : "  + b.address_id);
        System.out.println("Phone No.         : "  + b.phone_no);
        System.out.println("-------------------------------------------------------------------");
    }

    private void inputBranchInfo(branch_management b) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee information: ");
        scanner.nextLine();
        System.out.println("\nManager ID        : "); b.manager_id = scanner.nextLine();
        System.out.println("Phone No.         : "); b.phone_no = scanner.nextLine();
    }

    private void inputEmployeeInfo(employee_record_management e) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee information: ");
        scanner.nextLine();
        System.out.println("\nLast Name       : "); e.last_name = scanner.nextLine();
        System.out.println("First Name        : "); e.first_name = scanner.nextLine();
        e.job_id = 1; // Assigning as Manager of the Branch
        System.out.println("Age               : "); e.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Phone No.         : "); e.phone_no = scanner.nextLine();
        System.out.println("Email Address     : "); e.email = scanner.nextLine();
    }

    private void inputEmployeeAddressInfo(ref_address_management a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Enter Employee Address Information: (Type NULL if N/A)");
        scanner.nextLine();
        System.out.println("Unit No.         : "); a.unit_no        = scanner.nextLine();
        System.out.println("Street No.       : "); a.street_no       = scanner.nextLine();
        System.out.println("Barangay         : "); a.barangay        = scanner.nextLine();
        System.out.println("City             : "); a.city           = scanner.nextLine();
        System.out.println("Province         : "); a.province       = scanner.nextLine();
        System.out.println("Region           : "); a.region          = scanner.nextLine();
        System.out.println("Zip Code         : "); a.zip_code         = Integer.parseInt(scanner.nextLine());
    }

    private void inputBranchAddressInfo(ref_address_management a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Enter Branch Address Information: (Type NULL if N/A)");
        scanner.nextLine();
        a.unit_no = "NULL";
        System.out.println("Street No.       : "); a.street_no       = scanner.nextLine();
        System.out.println("Barangay         : "); a.barangay        = scanner.nextLine();
        System.out.println("City             : "); a.city           = scanner.nextLine();
        System.out.println("Province         : "); a.province       = scanner.nextLine();
        System.out.println("Region           : "); a.region          = scanner.nextLine();
        System.out.println("Zip Code         : "); a.zip_code         = Integer.parseInt(scanner.nextLine());
    }
    public int branch_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        branch_management b = new branch_management();
        employee_record_management e = new employee_record_management();
        ref_address_management aE = new ref_address_management();
        ref_address_management aB = new ref_address_management();

        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Create a Branch");
            System.out.printf("   %-2s �� %-40s%n", "[2]", "Choose a Branch to Manage");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Reports Generation ~~ Report 1");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "Reports Generation ~~ Report 2");
            System.out.printf("   %-2s ➤ %-40s%n", "[5]", "Reports Generation ~~ Report 3");
            System.out.printf("   %-2s ➤ %-40s%n", "[6]", "Reports Generation ~~ Report 4");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-5) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Create Branch
                    inputBranchInfo(b);

                    //Create Manager
                    inputEmployeeInfo(e);
                    inputEmployeeAddressInfo(aE);
                    e.address_id = aE.add_Address();
                    b.manager_id = e.add_Employee();

                    if (e.add_Employee() != null)
                        System.out.println("Employee record created successfully!");
                    else{
                        System.out.println("Error creating employee record.");
                        break;
                    }

                    //Create Branch Address
                    inputBranchAddressInfo(aB);
                    b.address_id = aB.add_Address();

                    if (b.add_Branch() != null)
                        System.out.println("Branch record created successfully!");
                    else{
                        System.out.println("Error creating branch record.");
                    }
                    break;
                case 2:
                    System.out.println("    ");
                    break;
                case 3:
                    System.out.println("    ");
                    break;
                case 4:
                    System.out.println("    ");
                    break;
                case 5:
                    System.out.println("    ");
                    break;
                case 0:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    return 0;
                default:
                    System.out.println("⚠️ Invalid choice! Please select a valid option.");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        branch_menu bm = new branch_menu();
        while(bm.branch_menu() != 0) {}
    }

}
