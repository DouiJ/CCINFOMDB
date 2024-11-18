package libraryDB;

import java.util.Scanner;

public class patron_management_menu {

    /*
     * Algorithm for Menu Processing
     * 1. Display the Menu
     * 2. Ask the user for function selection
     * 3. Depending on the selected function, ask user for input
     * 4. Perform the function
     */
    public patron_management_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Create a new Patron Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Update an Patron Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Delete an Patron Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "View an Patron Record");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-4) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            patron_management p = new patron_management();

            switch (choice) {
                case 1: // create patron
                    // Ask user input
                    System.out.print("Enter patron informtion: ");
                    // System.out.println("\nPatron ID : ");
                    // TODO: search through the list and find the last number
                    // split the string, add the letter to the front
                    System.out.println("Last name       : ");
                    try {
                        p.last_name = scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid name entered. Please enter a valid string.");
                        break;
                    }
                    System.out.println("First name      : ");
                    try {
                        p.first_name = scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid name entered. Please enter a valid string.");
                        break;
                    }
                    System.out.println("Age               : ");
                    try {
                        p.age = Integer.parseInt(scanner.nextLine());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid age entered. Please enter a postive whole number.");
                        break;
                    }
                    System.out.println("Gender            : ");
                    try {
                        p.gender = patron_management.Gender.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid gender entered. Please enter a valid gender.");
                        break;
                    }
                    System.out.println("Phone Number      : ");
                    p.phone_no = scanner.nextLine();
                    System.out.println("Email             : ");
                    p.email = scanner.nextLine();

                    if (p.add_patron() == 1) {
                        System.out.println("Patron record created successfully!");
                    } else {
                        System.out.println("Error creating patron record.");
                    }

                    break;
                case 2: // update patron
                    // Ask user input
                    System.out.println("Current patron information: ");
                    System.out.println("--------------------------------------------");
                    System.out.println("Last name         : " + p.last_name);
                    System.out.println("First name        : " + p.first_name);
                    System.out.println("Age               : " + p.age);
                    System.out.println("Gender            : " + p.gender);
                    System.out.println("Phone Number      : " + p.phone_no);
                    System.out.println("Email             : " + p.email);

                    System.out.print("\nEnter updated patron informtion: ");
                    // System.out.println("\nPatron ID : ");
                    // TODO: search through the list and find the last number
                    // split the string, add the letter to the front
                    System.out.println("Last name       : ");
                    try {
                        p.last_name = scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid name entered. Please enter a valid string.");
                        break;
                    }
                    System.out.println("First name      : ");
                    try {
                        p.first_name = scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid name entered. Please enter a valid string.");
                        break;
                    }
                    System.out.println("Age               : ");
                    try {
                        p.age = Integer.parseInt(scanner.nextLine());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid age entered. Please enter a postive whole number.");
                        break;
                    }
                    System.out.println("Gender            : ");
                    try {
                        p.gender = patron_management.Gender.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid gender entered. Please enter a valid gender.");
                        break;
                    }
                    p.update_patron();

                    break;
                case 3:
                    // logic to delete patrons
                    System.out.println("Enter patron information");
                    System.out.println("Patron ID       : ");
                    p.patron_id = scanner.nextLine();

                    p.delete_patron();

                    System.out.println("    ");
                    break;
                case 4:
                    // logic to view patron records

                    System.out.println("    ");
                    break;
                case 0:
                    // logic to exit patron menu
                    scanner.close();
                    break;
                default:
                    System.out.println("⚠️ Invalid choice! Please select a valid option.");
            }
            System.out.println();

        }
    }
}
