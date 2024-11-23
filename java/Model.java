import tables.*;
import tablesInfo.*;
import panels.*;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class Model {
    private final String password;
    private Connection connection;
    public branch_management branch;
    public employee_record_management employee;
    public patron_management patron;
    public book_detail_management book;
    public book_inventory_management inventory;
    public book_acquisition_management acquisition;
    public book_borrowing_transaction borrowing;
    public book_review_transaction review;
    public borrowing_fines_management fines;


    public Model(String password) {
        this.password = password;
        connectToDatabase();

        branch = new branch_management(connection);
        employee = new employee_record_management(connection);
        patron = new patron_management(connection);
        book = new book_detail_management(connection);
        inventory = new book_inventory_management(connection);
        acquisition = new book_acquisition_management(connection);
        borrowing = new book_borrowing_transaction(connection);
        review = new book_review_transaction(connection);
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root"; // Change this as per your MySQL username

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to the database was successful!");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getBranchIds() {
        ArrayList<String> branchIds = new ArrayList<>();
        String query = "SELECT branch_id FROM Branches";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                branchIds.add(resultSet.getString("branch_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return branchIds;
    }

    public ArrayList<String> getAllEmployeeIds() {
        ArrayList<String> allEmployeeIds = new ArrayList<>();
        String query = "SELECT employee_id FROM Employees";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                allEmployeeIds.add(resultSet.getString("employee_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allEmployeeIds;
    }

    public ArrayList<String> getEmployeeIds(String branchId) {
        ArrayList<String> employeeIds = new ArrayList<>();
        String query = "SELECT employee_id FROM Employees WHERE branch_id = '" + branchId + "'";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                employeeIds.add(resultSet.getString("employee_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeIds;
    }

    public String getEmployeeFullName(String employeeId) {
        String query = "SELECT first_name, last_name FROM Employees WHERE employee_id = '" + employeeId + "'";
        String fullName = null;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                fullName = firstName + " " + lastName;
            } else {
                System.err.println("Employee with ID " + employeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fullName;
    }

    public ArrayList<String> getBorrowIds() {
        ArrayList<String> borrowIds = new ArrayList<>();
        String query = "SELECT borrow_id FROM Borrowing_History";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                borrowIds.add(resultSet.getString("borrow_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowIds;
    }

    public String getBorrowStatus(String borrowId) {
        String query = "SELECT borrow_status FROM Borrowing_History WHERE borrow_id = '" + borrowId + "'";
        String borrowStatus = null;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                borrowStatus = formatBorrowStatus(resultSet.getString("borrow_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowId + ": " + (borrowStatus != null ? borrowStatus : "Unknown");
    }

    private String formatBorrowStatus(String status) {
        switch (status) {
            case "B":
                return "Borrowed";
            case "O":
                return "Overdue";
            case "L":
                return "Lost";
            case "R":
                return "Returned";
            default:
                return "Unknown";
        }
    }

    public ArrayList<String> getFines() {
        ArrayList<String> finesList = new ArrayList<>();
        // SQL query to select fines with 'A' status
        String query = "SELECT fine_id, payment_date FROM Borrowing_Fines WHERE status = 'A'";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String fineId = resultSet.getString("fine_id");
                String paymentStatus = resultSet.getDate("payment_date") == null ? "Not Paid" : "Paid";
                finesList.add(fineId + ": " + paymentStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return finesList;
    }


    public ArrayList<String> getAllPatronIds() {
        ArrayList<String> patronIds = new ArrayList<>();
        String query = "SELECT patron_id FROM Patrons";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                patronIds.add(resultSet.getString("patron_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patronIds;
    }

    public ArrayList<String> getAllISBN() {
        ArrayList<String> bookIds = new ArrayList<>();
        String query = "SELECT isbn FROM book_details";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                bookIds.add(resultSet.getString("isbn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookIds;
    }

    public ArrayList<String> getAllInventoryIds() {
        ArrayList<String> inventoryIds = new ArrayList<>();
        String query = "SELECT inventory_id FROM books_inventory";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                inventoryIds.add(resultSet.getString("inventory_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventoryIds;
    }

    public Branch getBranchDetails(String branchId) {
        String query = "SELECT full_address, phone_no FROM Branches WHERE branch_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, branchId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                String fullAddress = resultSet.getString("full_address");
                String phoneNo = resultSet.getString("phone_no");
                return new Branch(fullAddress, phoneNo);
            } else {
                return null; // No branch found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Employee getEmployeeDetails(String employeeId) {
        String query = "SELECT last_name, first_name, job_id, age, phone_no, email, hire_date, full_address, branch_id FROM Employees WHERE employee_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String jobId = rs.getString("job_id");
                int age = rs.getInt("age");
                String phoneNo = rs.getString("phone_no");
                String email = rs.getString("email");
                java.sql.Date hireDate = rs.getDate("hire_date");
                String fullAddress = rs.getString("full_address");
                String branchId = rs.getString("branch_id");

                return new Employee(lastName, firstName, jobId, age, phoneNo, email, hireDate, fullAddress, branchId);
            } else {
                return null; // No employee found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Patron getPatronDetails(String patron_id) {
        String query = "SELECT patron_id, last_name, first_name, age, gender, phone_no, email FROM Patrons WHERE patron_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patron_id);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String age = resultSet.getString("age");
                String gender = resultSet.getString("gender");
                String phoneNo = resultSet.getString("phone_no");
                String email = resultSet.getString("email");

                return new Patron(patron_id, lastName, firstName, age, gender, phoneNo, email);
            } else {
                return null; // No patron found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBookDetails(String isbn) {
        String query = "SELECT isbn, title, price, author_last_name, author_first_name FROM book_details WHERE isbn = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, isbn);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String price = resultSet.getString("price");
                String authorLastName = resultSet.getString("author_last_name");
                String authorFirstName = resultSet.getString("author_first_name");

                return new Book(isbn, title, price, authorLastName, authorFirstName);
            } else {
                return null; // No book found with the given ISBN
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Inventory getInventoryDetails(String inventoryId) {
        String query = "SELECT isbn, branch_id, acquisition_id FROM books_inventory WHERE inventory_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, inventoryId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String branchId = resultSet.getString("branch_id");
                String acquisitionId = resultSet.getString("acquisition_id");
                return new Inventory(inventoryId, isbn, branchId, acquisitionId);
            } else {
                return null; // No inventory found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Acquisition getAcquisitionDetails(String acquisitionId) {
        String query = "SELECT acquisition_date, supplier_name, acquisitions_price, copies_acquired, archivist_id, isbn, branch_delivered, status FROM Book_Acquisitions WHERE acquisition_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, acquisitionId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                Date acquisitionDate = resultSet.getDate("acquisition_date");
                String supplierName = resultSet.getString("supplier_name");
                double acquisitionPrice = resultSet.getDouble("acquisitions_price");
                int copiesAcquired = resultSet.getInt("copies_acquired");
                String archivistId = resultSet.getString("archivist_id");
                String isbn = resultSet.getString("isbn");
                String branchDelivered = resultSet.getString("branch_delivered");
                String status = resultSet.getString("status");

                return new Acquisition(acquisitionId, acquisitionDate, supplierName, acquisitionPrice, copiesAcquired, archivistId, isbn, branchDelivered, status);
            } else {
                return null; // No acquisition found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getAvailableInventoryIds() {
        String query = """
                    SELECT DISTINCT bi.inventory_id
                    FROM books_inventory bi
                    LEFT JOIN borrowing_history bh ON bi.inventory_id = bh.book_id
                    WHERE bh.book_id IS NULL OR bh.borrow_status = 'R'
                    AND bi.inventory_id NOT IN (
                        SELECT DISTINCT book_id 
                        FROM borrowing_history 
                        WHERE borrow_status IN ('O', 'L', 'B')
                    )
                """;

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet resultSet = pstmt.executeQuery();

            ArrayList<String> availableInventoryIds = new ArrayList<>();
            while (resultSet.next()) {
                availableInventoryIds.add(resultSet.getString("inventory_id"));
            }

            return availableInventoryIds;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list in case of error
        }
    }

    public Borrowing getBorrowingDetails(String borrowId) {
        String query = """
                    SELECT borrow_id, date_borrowed, date_due, date_returned, borrow_status,
                           book_id, patron_id, clerk_id, status
                    FROM borrowing_history
                    WHERE borrow_id = ?
                """;

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, borrowId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                Date dateBorrowed = resultSet.getDate("date_borrowed");
                Date dateDue = resultSet.getDate("date_due");
                Date dateReturned = resultSet.getDate("date_returned");
                String borrowStatus = resultSet.getString("borrow_status");
                String bookId = resultSet.getString("book_id");
                String patronId = resultSet.getString("patron_id");
                String clerkId = resultSet.getString("clerk_id");
                String status = resultSet.getString("status");

                return new Borrowing(borrowId, dateBorrowed, dateDue, dateReturned,
                        borrowStatus, bookId, patronId, clerkId, status);
            } else {
                return null; // No borrowing record found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }

    public String getPatronFullName(String patronId) {
        String query = "SELECT first_name, last_name FROM patrons WHERE patron_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patronId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                return firstName + " " + lastName;
            } else {
                return null; // No patron found with the given ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Return null in case of error
        }
    }

    public String getBookTitleByInventoryId(String inventoryId) {
        String query = "SELECT bd.title FROM book_details bd " +
                "JOIN books_inventory bi ON bd.isbn = bi.isbn " +
                "WHERE bi.inventory_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, inventoryId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("title");
            } else {
                return null; // No book found with the given inventory ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Return null in case of error
        }
    }


    public String removeTextSuffix(String input) {
        if (input != null && input.contains(":")) {
            return input.substring(0, input.indexOf(":")).trim();
        }
        return input; // Return the original string if there's no colon
    }

    public boolean updateBorrowStatusToReturned(String borrowId) {
        String query = "UPDATE Borrowing_History SET borrow_status = ?, date_returned = ? WHERE borrow_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Set status to 'R' for returned and set the current date as date_returned
            pstmt.setString(1, "R");
            pstmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now())); // Current date
            pstmt.setString(3, borrowId);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0; // Return true if update is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there's an error
        }
    }

    public boolean updateBorrowStatusToLost(String borrowId) {
        String query = "UPDATE Borrowing_History SET borrow_status = ?, date_returned = ? WHERE borrow_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Set status to 'L' for lost and set the current date as date_returned
            pstmt.setString(1, "L");
            pstmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now())); // Current date
            pstmt.setString(3, borrowId);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0; // Return true if update is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there's an error
        }
    }

    public ArrayList<String> getMostBorrowedISBNsLastTwoYears() {
        // SQL query to get the most borrowed ISBNs in the past 2 years
        String query = """
        SELECT bh.Book_id, COUNT(bh.Book_id) AS borrow_count
        FROM Borrowing_History bh
        WHERE bh.date_borrowed >= DATE_SUB(CURDATE(), INTERVAL 2 YEAR)
        GROUP BY bh.Book_id
        ORDER BY borrow_count DESC
        LIMIT 10
    """;

        ArrayList<String> results = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) { // Use the global `connection`
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String isbn = rs.getString("Book_id");
                    int count = rs.getInt("borrow_count");
                    results.add(isbn + " (" + count + " times borrowed)");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching most borrowed ISBNs in the past 2 years: " + e.getMessage());
        }

        if (results.isEmpty()) {
            System.err.println("No books found in the past 2 years.");
        }

        return results;
    }




    public ArrayList<String> getNewlyAcquiredBooks(int year1, int month1, int year2, int month2) {
        String query = """
        SELECT ba.acquisition_id, bd.title, bd.author_last_name, bd.author_first_name, ba.acquisition_date, ba.branch_delivered
        FROM Book_Acquisitions ba
        JOIN Book_Details bd ON ba.isbn = bd.isbn
        WHERE 
            (YEAR(ba.acquisition_date) = ? AND MONTH(ba.acquisition_date) = ?)
            OR
            (YEAR(ba.acquisition_date) = ? AND MONTH(ba.acquisition_date) = ?)
        ORDER BY ba.acquisition_date DESC
    """;

        ArrayList<String> results = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, year1);
            pstmt.setInt(2, month1);
            pstmt.setInt(3, year2);
            pstmt.setInt(4, month2);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String entry = "Acquisition ID: " + rs.getString("acquisition_id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author_first_name") + " " + rs.getString("author_last_name") +
                        ", Date: " + rs.getDate("acquisition_date") +
                        ", Branch Delivered: " + rs.getString("branch_delivered");
                results.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    public ArrayList<String> getPatronActivity(int year, int month) {
        String query = """
        SELECT p.patron_id, p.first_name, p.last_name, p.status, 
               COUNT(DISTINCT bh.borrow_id) AS total_borrows, 
               COALESCE(SUM(bf.fine_amount), 0) AS total_fines, 
               SUM(CASE WHEN bh.date_due < bh.date_returned THEN 1 ELSE 0 END) AS books_overdue, 
               AVG(DATEDIFF(bh.date_returned, bh.date_due)) AS avg_days_to_return
        FROM Patrons p
        LEFT JOIN Borrowing_History bh ON p.patron_id = bh.patron_id
        LEFT JOIN Borrowing_Fines bf ON bh.borrow_id = bf.borrow_id
        WHERE (MONTH(bh.date_borrowed) = ? AND YEAR(bh.date_borrowed) = ?)
           OR (MONTH(bf.payment_date) = ? AND YEAR(bf.payment_date) = ?)
        GROUP BY p.patron_id, p.first_name, p.last_name, p.status
        ORDER BY p.last_name, p.first_name
    """;

        ArrayList<String> results = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, month);
            pstmt.setInt(2, year);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String entry = "Patron ID: " + rs.getString("patron_id") +
                        ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") +
                        ", Borrows: " + rs.getInt("total_borrows") +
                        ", Fines: " + rs.getDouble("total_fines") +
                        ", Overdue: " + rs.getInt("books_overdue") +
                        ", Avg Days to Return: " + rs.getDouble("avg_days_to_return");
                results.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results; // Return ArrayList of strings
    }

    public ArrayList<String> getReviewSummary() {
        // SQL query to get the total reviews for a patron, and the average rating for the books reviewed by the patron
        String query = """
        SELECT 
            p.patron_id, 
            COUNT(DISTINCT br.rating_id) AS total_reviews_by_patron,
            AVG(br.rating_score) AS avg_rating_for_patron
        FROM 
            Book_Rating br
        LEFT JOIN 
            Borrowing_History bh ON br.borrow_id = bh.borrow_id
        LEFT JOIN 
            Patrons p ON bh.patron_id = p.patron_id
        WHERE 
            br.rating_score IS NOT NULL  -- Ensuring we're only counting valid ratings
        GROUP BY 
            p.patron_id
        ORDER BY 
            p.patron_id;
    """;

        ArrayList<String> results = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            // Debugging: print the query results to check what's being returned
            int resultCount = 0;

            while (rs.next()) {
                String patronSummary = "Patron ID: " + rs.getString("patron_id") +
                        " Total Reviews: " + rs.getInt("total_reviews_by_patron") +
                        " Avg Rating: " + rs.getDouble("avg_rating_for_patron");
                // Add patron summary to the results
                results.add(patronSummary);
                resultCount++;
            }

            // Debugging: check how many results were fetched
            System.out.println("Total results fetched: " + resultCount);

        } catch (SQLException e) {
            System.err.println("Error while fetching review summary: " + e.getMessage());
        }

        if (results.isEmpty()) {
            System.out.println("No data found. Please check the query and data.");
        }

        return results;  // Return ArrayList of strings
    }



    public ArrayList<String> getUnratedBorrowIds() {
        // SQL query to find borrow_ids that are not in the Book_Rating table
        String query = """
                SELECT bh.borrow_id
                FROM Borrowing_History bh
                LEFT JOIN Book_Rating br ON bh.borrow_id = br.borrow_id
                WHERE br.borrow_id IS NULL
                """;

        ArrayList<String> borrowIds = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    borrowIds.add(rs.getString("borrow_id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching unrated borrow_ids: " + e.getMessage());
        }

        return borrowIds;
    }

    public ArrayList<String> getAllReviews() {
        // SQL query to get all reviews along with the borrow_id, score, and comment
        String query = """
                SELECT br.borrow_id, br.rating_score, br.rating_comment
                FROM Book_Rating br
                JOIN Borrowing_History bh ON br.borrow_id = bh.borrow_id
                WHERE br.status = 'A'  -- Only active reviews
                """;

        ArrayList<String> reviews = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String borrowId = rs.getString("borrow_id");
                    float ratingScore = rs.getFloat("rating_score");
                    String ratingComment = rs.getString("rating_comment");

                    // Format the string and add it to the list
                    String review = "Borrow ID: " + borrowId + ", Score: " + ratingScore + ", Comment: " + ratingComment;
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching reviews: " + e.getMessage());
        }

        return reviews;
    }

    public Fines getFineDetailsByFineId(String fineId) {
        // SQL query to get the fine details by fine_id
        String query = """
                SELECT fine_id, fine_amount, payment_date, borrow_id, clerk_id, status
                FROM Borrowing_Fines
                WHERE fine_id = ?
                """;

        Fines fineDetails = null;

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, fineId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Create FineDetails object and populate it with values from the result set
                    fineDetails = new Fines(
                            rs.getString("fine_id"),
                            rs.getDouble("fine_amount"),
                            rs.getString("payment_date"),
                            rs.getString("borrow_id"),
                            rs.getString("clerk_id"),
                            rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching fine details: " + e.getMessage());
        }

        return fineDetails;
    }

    public int cancelFine(String fineId) {
        // SQL query to update the fine status to 'C'
        String query = "UPDATE Borrowing_Fines SET status = 'C' WHERE fine_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, fineId);  // Set the fine_id parameter

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Fine status updated to 'C' (Cancelled).");
                return 1;  // Success
            } else {
                System.out.println("No fine found with the given fine_id or status already 'C'.");
                return 0;  // No rows updated (either fine doesn't exist or status is already 'C')
            }
        } catch (SQLException e) {
            System.err.println("Error while updating fine status: " + e.getMessage());
            return 0;  // Error during the process
        }
    }

    public int updatePaymentDate(String fineId) {
        // SQL query to update the payment_date to the current date
        String query = "UPDATE Borrowing_Fines SET payment_date = ? WHERE fine_id = ?";

        // Get current date
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);  // Convert LocalDate to java.sql.Date

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, sqlDate);  // Set the current date as the payment_date
            pstmt.setString(2, fineId); // Set the fine_id parameter

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Payment date updated successfully.");
                return 1;  // Success
            } else {
                System.out.println("No fine found with the given fine_id.");
                return 0;  // No rows updated (either fine doesn't exist or already updated)
            }
        } catch (SQLException e) {
            System.err.println("Error while updating payment_date: " + e.getMessage());
            return 0;  // Error during the process
        }
    }





}