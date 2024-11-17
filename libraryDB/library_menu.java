package libraryDB;

import java.util.Scanner;

public class library_menu {

    public library_menu() {
    }

    public int menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        // 1      Choose Branch (get branch arraylist from branch_management and present options)
        // 2 - 6  (Core Record Management)
        // 7 - 10 (Transactions Processing)
        // 11     (Menu to generate reports)


        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Employee Management");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Patron Management");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Book Inventory Management");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "Book Details Management");
            System.out.printf("   %-2s ➤ %-40s%n", "[5]", "Book Borrowing Processing");
            System.out.printf("   %-2s ➤ %-40s%n", "[6]", "Book Acquisitions Processing");
            System.out.printf("   %-2s ➤ %-40s%n", "[7]", "Book Reviews Processing");
            System.out.printf("   %-2s ➤ %-40s%n", "[8]", "Overdue/Lost Fines Processing");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0 - 8) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    employee_management_menu e = new employee_management_menu();
                    while (e.employee_menu() != 0) {}
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
                case 6:
                    System.out.println("    ");
                    break;
                case 7:
                    System.out.println("    ");
                    break;
                case 8:
                    System.out.println("    ");
                    break;
                case 9:
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
}
