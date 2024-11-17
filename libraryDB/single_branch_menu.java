package libraryDB;

import java.util.Scanner;

public class single_branch_menu {

    //VARIABLES
    private String single_branchID;

    public single_branch_menu() {
    }

    public int menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Update Branch Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Delete Branch Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "View an Employee Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-3) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

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

