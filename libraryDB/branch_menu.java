package libraryDB;

import java.util.Scanner;

public class branch_menu {

    public branch_menu() {
    }

    public int branch_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);


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
                    // Choose Branch operations

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
