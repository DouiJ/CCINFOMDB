package libraryDB;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static libraryDB.branch_menu.getCurrentBranchID;

public class book_borrowing_menu {

    public book_borrowing_menu() {
    }

    // Can be changed to dropdown in actual
    public void showAvailableBooks() {
        book_inventory_management bm = new book_inventory_management();
        List<String> bookList = bm.get_Books_In_Branch();
        System.out.println("Available Book IDs in Current Branch for Borrowing: ");
        for (String book : bookList)
            System.out.println(book);
    }

    public int employee_menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        employee_record_management e = new employee_record_management();
        ref_address_management a = new ref_address_management();
        book_borrowing_transaction bt = new book_borrowing_transaction();

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
                    // Create a Borrowing Transaction
                    // User Input the BOOK_ID or Inventory_id -- Show the list for inventory of specific branch in menu


                    showAvailableBooks();
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Enter Patron ID     : "); bt.patron_id = scanner.nextLine();
                    System.out.println("Enter Book ID       : "); bt.book_id   = scanner.nextLine();
                    System.out.println("Enter Clerk ID      : "); bt.clerk_id  = scanner.nextLine();
                    if (bt.create_Borrowing() == 1)
                        System.out.println("Borrowing Record created successfully!");
                    else
                        System.out.println("Error creating borrowing record.");
                    break;
                case 2:
                    //

                    // Return a Book -- creates fines record if overdue - create a trigger if 30 days then lost
                    System.out.println("Enter Book ID       : "); bt.book_id   = scanner.nextLine();
                    if (bt.process_Return() == 1)
                        System.out.println("Book returned successfully!");
                    else
                        System.out.println("Error returning book.");
                case 3:

                    // Update a Borrowing Record
                    System.out.println("Enter Borrowing ID to be updated: ");
                    System.out.println("Enter Borrowing ID     : "); bt.borrow_id      = scanner.nextLine();
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Enter Borrowing Date   : "); bt.date_borrowed  = Date.valueOf(scanner.nextLine()); // Fix
                    System.out.println("Enter Date Due         : "); bt.date_due       = Date.valueOf(scanner.nextLine());
                    System.out.println("Enter Borrowing Status : "); bt.borrow_status  = scanner.nextLine();
                    System.out.println("Enter New Clerk ID     : "); bt.clerk_id       = scanner.nextLine();
                    if (bt.update_Borrowing() == 1)
                        System.out.println("Borrowing Record updated successfully!");
                    else
                        System.out.println("Error updating borrowing record.");
                    break;
                case 4:
                    //
                    // Delete Borrowing Record
                    System.out.println("Enter Borrowing ID to be deleted: ");
                    System.out.println("Enter Borrowing ID     : "); bt.borrow_id      = scanner.nextLine();
                    if (bt.delete_Borrowing() == 1)
                        System.out.println("Borrowing Record deleted successfully!");
                    else
                        System.out.println("Error deleting borrowing record.");
                    break;
                case 5:
                    // View a Borrowing Record
                    System.out.println("Enter Borrowing ID to view its Record: ");
                    System.out.println("Enter Borrowing ID     : "); bt.borrow_id      = scanner.nextLine();
                    System.out.println("-------------------------------------------------------------------");

                    if (bt.get_Borrowing() == 1)
                    {
                        System.out.println("Borrowing ID     : " + bt.borrow_id);
                        System.out.println("Patron ID        : " + bt.patron_id);
                        System.out.println("Book ID          : " + bt.book_id);
                        System.out.println("Clerk ID         : " + bt.clerk_id);
                        System.out.println("Fine ID          : " + bt.fines_id);
                        System.out.println("Borrowing Date   : " + bt.date_borrowed);
                        System.out.println("Date Due         : " + bt.date_due);
                        System.out.println("Date Returned    : " + bt.date_returned);
                        System.out.println("Borrowing Status : " + bt.borrow_status);
                    } else
                        System.out.println("Borrowing record not found.");
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