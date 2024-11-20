package libraryDB;

import java.util.Scanner;

public class book_acquisition_menu {

    private String currBranchID;

    public book_acquisition_menu() {
    }

    public void inputBookAcquisitionInfo(book_acquisition_management bookAcq) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        System.out.print("Enter Acquisition information: ");
        scanner.nextLine();
        System.out.println("\nAcquisition date           : "); temp = scanner.nextLine(); bookAcq.setAcquisition_date(temp);
        System.out.println("Acquisition price          : "); temp = scanner.nextLine(); bookAcq.setAcquisition_price(temp);
        System.out.println("Supplier_name          : "); temp = scanner.nextLine(); bookAcq.setSupplier_name(temp);
        System.out.println("Supplier_name          : "); temp = scanner.nextLine(); bookAcq.setSupplier_name(temp);

    }

    public int menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        //Objects
        book_acquisition_management bookAcq = new book_acquisition_management();




        while (true) {
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("                     📚 LIBRARY MANAGEMENT SYSTEM 📚           ");
            System.out.println("                         Command Line Menu                     ");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.printf("   %-2s ➤ %-40s%n", "[1]", "Acquire books");
            System.out.printf("   %-2s ➤ %-40s%n", "[2]", "Cancel a acquisition");
            System.out.printf("   %-2s ➤ %-40s%n", "[0]", "Exit");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("📌 Use numbers (0 - 9) to navigate the menu.");

            System.out.print("➡️  Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getClass()
                    while (sb.sb_menu() != 0) {}
                    break;
                case 2:
                    employee_management_menu e = new employee_management_menu();
                    while (e.employee_menu() != 0) {}
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

    public void setCurrBranchID(String currBranchID) {
        this.currBranchID = currBranchID;
    }
}
