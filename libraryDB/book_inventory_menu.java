package libraryDB;

import java.util.Scanner;

public class book_inventory_menu {

    public book_inventory_menu() {
    }

    public int book_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Add a Book to inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Update a Book from inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Delete a Book from inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "View an Inventory Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-4) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Ask user input
                        book_inventory_management e = new book_inventory_management();

                        System.out.print("Enter book information: ");
                        scanner.nextLine();
                        System.out.println("\nISBN            : "); e.isbn           = scanner.nextLine();

                        // check if isbn exist-- if not

                        // Adding an address record
                        e.inventory_id = a.add_Book();

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
                        System.out.println("    ");
                        scanner.close();
                        return 0;
                    default:
                        System.out.println("⚠️ Invalid choice! Please select a valid option.");
                }
            return 0;
        }
    }




}
