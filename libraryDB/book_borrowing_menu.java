package libraryDB;

import java.util.Scanner;

import static libraryDB.branch_menu.getCurrentBranchID;

public class book_borrowing_menu {

    public book_borrowing_menu() {
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
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Create a Borrowing Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Return a Book");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Update a Borrowing Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "Delete a Borrowing Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[5]", "View a Borrowing Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-4) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //
                    // Patron_id as well generate clerk id
                    // User Input the BOOK_ID or Inventory_id -- Show the list for inventory of specific branch in menu


                    break;
                case 2:
                    //

                case 3:

                    break;
                case 4:
                    //

                    break;
                case 0:
                    System.out.println("Exiting Book Borrowing System.");
                    scanner.close();
                    return 0;
                default:
                    System.out.println("⚠️ Invalid choice! Please select a valid option.");
            }
            return 0;
        }
    }

}
