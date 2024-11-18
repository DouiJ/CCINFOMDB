package libraryDB;

import java.util.Scanner;

public class book_inventory_menu {

    public book_inventory_menu() {
    }

    public int book_menu() {
        book_inventory_management e = new book_inventory_management();

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Add a Book");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Update a Book");
            System.out.printf("   %-2s ➤ %-40s%n", "[3]", "Delete a Book");
            System.out.printf("   %-2s ➤ %-40s%n", "[4]", "View a Book");
            System.out.printf("   %-2s ➤ %-40s%n", "[5]", "Add a Book to inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[6]", "Update a Book from inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[7]", "Delete a Book from inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[8]", "View a Book from inventory");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0-7) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("ISBN: "); e.isbn = scanner.nextLine();
                        System.out.print("Title: "); e.title = scanner.nextLine();
                        System.out.print("Genre: "); e.genre = scanner.nextLine();
                        System.out.print("Price: "); e.price = scanner.nextDouble(); scanner.nextLine();
                        System.out.print("Author First Name: "); e.author_first_name = scanner.nextLine();
                        System.out.print("Author Last Name: "); e.author_last_name = scanner.nextLine();

                       if (e.add_ISBN() == 1) {
                            System.out.println("Book record created successfully!");
                        } else {
                            System.out.println("Error creating book record.");
                        }

                        break;
                    case 2:

                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("ISBN: "); e.isbn = scanner.nextLine();
                        System.out.print("Title: "); e.title = scanner.nextLine();
                        System.out.print("Genre: "); e.genre = scanner.nextLine();
                        System.out.print("Price: "); e.price = scanner.nextDouble(); scanner.nextLine();
                        System.out.print("Author First Name: "); e.author_first_name = scanner.nextLine();
                        System.out.print("Author Last Name: "); e.author_last_name = scanner.nextLine();

                        if (e.update_ISBN() == 1) {
                            System.out.println("Book record updated successfully!");
                        } else {
                            System.out.println("Error updating book record.");
                        }

                        break;
                    case 3:

                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("ISBN: "); e.isbn = scanner.nextLine();

                        System.out.println("ISBN: " + e.isbn);

                        if (e.delete_ISBN() == 1) {
                            System.out.println("Book deleted successfully!");
                        } else {
                            System.out.println("Error deleting book record.");
                        }

                        break;
                    case 4:
                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("ISBN: "); e.isbn = scanner.nextLine();
                        e.get_ISBN();

                        System.out.println("ISBN: " + e.isbn);
                        System.out.println("Title: " + e.title);
                        System.out.println("Genre: " + e.genre);
                        System.out.println("Price: " + e.price);
                        System.out.println("Author First Name: " + e.author_first_name);
                        System.out.println("Author Last Name: " + e.author_last_name);

                        if (e.get_ISBN() == 1) {
                            System.out.println("Book viewed successfully!");
                        } else {
                            System.out.println("Error viewing book record.");
                        }
                        break;


                    case 5:

                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("ISBN: "); e.isbn = scanner.nextLine();
                        System.out.print("Branch ID: "); e.branch_id = scanner.nextLine();

                        if (e.add_Book() == 1) {
                            System.out.println("Book added successfully!");
                        } else {
                            System.out.println("Error adding book record.");
                        }

                    break;
                    case 6:

                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("Inventory ID: "); e.inventory_id = scanner.nextLine();
                        System.out.print("ISBN: "); e.isbn = scanner.nextLine();
                        System.out.print("Branch ID: "); e.branch_id = scanner.nextLine();

                        if (e.update_Book() == 1) {
                            System.out.println("Book updated successfully!");
                        } else {
                            System.out.println("Error updating book record.");
                        }

                        break;
                    case 7:

                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("Inventory ID: "); e.inventory_id = scanner.nextLine();

                        if (e.delete_Book() == 1) {
                            System.out.println("Book deleted successfully!");
                        } else {
                            System.out.println("Error deleting book record.");
                        }

                        break;

                    case 8:

                        System.out.print("Enter book information: \n"); scanner.nextLine();

                        System.out.print("Inventory ID: "); e.inventory_id = scanner.nextLine();

                        e.get_Book();

                        System.out.print("Inventory ID: " + e.inventory_id);
                        System.out.print("ISBN: " + e.isbn);
                        System.out.print("Branch ID: " + e.branch_id);

                        if (e.get_Book() == 1) {
                            System.out.println("Book viewed successfully!");
                        } else {
                            System.out.println("Error viewing book record.");
                        }

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
