package libraryDB;

import java.util.Scanner;

public class single_branch_menu {

    //VARIABLES
    private String single_branchID;

    public single_branch_menu() {
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

    public int menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        branch_management b = new branch_management();
        b.branch_id = single_branchID;
        ref_address_management a = new ref_address_management();


        while (true) {
            b.get_Branch();
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("Branch" + b.branch_id + "Information:  ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("Manager ID        : "  + b.manager_id);
            System.out.println("Address ID        : "  + b.address_id);
            System.out.println("Phone No.         : "  + b.phone_no);
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Update Branch Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Delete Branch Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "View an Employee Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-3) to navigate the menu\n");
            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    inputBranchInfo(b);

                    if(b.get_Branch_Manager() == 0)
                        System.out.println("Manager ID not found. Please input a proper ID.");
                    else {
                        inputAddressInfo(a);
                        System.out.println("Do you want to to proceed with the update? (Y/N) ");
                        if (scanner.nextLine().equalsIgnoreCase("Y")) {
                            b.update_Branch();
                            a.update_Address();
                        }
                        else
                            System.out.println("Branch record update cancelled.");
                    }
                    break;
                case 2:
                    System.out.println("    ");
                    break;
                case 3:
                    System.out.println("    ");
                    break;
                case 0:
                    System.out.println("Exiting Single Branch Management");
                    scanner.close();
                    return 0;
                default:
                    System.out.println("⚠️ Invalid choice! Please select a valid option.");
            }
            System.out.println();
        }
    }

    public void setSingle_branchID(String single_branchID) {
        this.single_branchID = single_branchID;
    }
}

