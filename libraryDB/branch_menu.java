package libraryDB;

import java.util.ArrayList;
import java.util.Scanner;

public class branch_menu {

    public static String current_BranchID;

    public branch_menu() {
    }

    public static String getCurrentBranchID() {
        return current_BranchID;
    }

    private void displayBranches(ArrayList<String> branches){
        System.out.println("Current Branch Information:  ");
        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < branches.size(); i++){
            System.out.println(i + ". BranchID: " + branches.get(i));
        }
        System.out.println("-------------------------------------------------------------------");
    }

    private void inputBranchInfo(branch_management b) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter branch information: ");
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

    private void inputAddressInfo(ref_address_management a) {
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
    public int branch_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        branch_management b = new branch_management();
        employee_record_management e = new employee_record_management();
        ref_address_management a = new ref_address_management();

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
                    inputAddressInfo(a);
                    e.address_id = a.add_Address();
                    b.manager_id = e.add_Employee(); // must set the job_id to J01

                    if (e.add_Employee() != null)
                        System.out.println("Employee record created successfully!");
                    else{
                        System.out.println("Error creating employee record.");
                        break;
                    }
                    //Create Branch Address
                    inputAddressInfo(a);
                    b.address_id = a.add_Address();

                    if (b.add_Branch() != null)
                        System.out.println("Branch record created successfully!");
                    else{
                        System.out.println("Error creating branch record.");
                    }
                    break;
                case 2:
                    ArrayList<String> branches = b.get_Branches();
                    displayBranches(branches);

                    System.out.println("Enter Branch ID to be updated: ");
                    System.out.println("Branch ID        : "); b.branch_id = scanner.nextLine();

                    if (b.get_Branch() == 0) {
                        System.out.println("Branch record not found. Please input a proper ID.");
                    } else {
                        current_BranchID = b.branch_id;

                    }
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
