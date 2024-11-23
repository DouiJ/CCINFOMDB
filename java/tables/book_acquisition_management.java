package tables;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class book_acquisition_management {

    private final Connection connection;
    private final book_inventory_management book;

    public book_acquisition_management(Connection connection) {
        this.connection = connection;
        book = new book_inventory_management(connection);
    }

    public int add_Book_acquisition(String supplier_name, String acquisitions_price, String copies_acquired, String archivist_id, String isbn, String branch_delivered) {
        try {
            // Get the current date
            String acquisition_date = java.time.LocalDate.now().toString();

            // Get the highest acquisition_id
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(acquisition_id) FROM Book_Acquisitions");

            String maxAcquisitionID = "Q0000";
            if (resultSet.next()) {
                maxAcquisitionID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxAcquisitionID = "Q0000";
            }

            int acquisitionIDNumber = Integer.parseInt(maxAcquisitionID.substring(1)) + 1;
            String acquisition_id = "Q" + String.format("%04d", acquisitionIDNumber);


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = df.parse(acquisition_date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Prepare the SQL query
            String sql = "INSERT INTO Book_Acquisitions (acquisition_id, acquisition_date, supplier_name, acquisitions_price, copies_acquired, archivist_id, isbn, branch_delivered, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, supplier_name);
            pstmt.setDouble(4, Double.parseDouble(acquisitions_price));
            pstmt.setInt(5, Integer.parseInt(copies_acquired));
            pstmt.setString(6, archivist_id);
            pstmt.setString(7, isbn);
            pstmt.setString(8, branch_delivered);
            pstmt.setString(9, "A");

            // Execute the query
            int rowsAdded = pstmt.executeUpdate();
            pstmt.close();

            if (rowsAdded > 0) {
                System.out.println("Record successfully created.");

                for (int i=0; i<Integer.parseInt(copies_acquired); i++) {
                    book.add_Book(isbn, branch_delivered);
                }

                return 1;
            } else {
                System.out.println("Record unsuccessfully created.");
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int update_Book_acquisition(String acquisition_id, String acquisition_date, String supplier_name, String acquisitions_price, String copies_acquired, String archivist_id, String isbn, String branch_delivered) {
        try {

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date utilDate = df.parse(acquisition_date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            String sql = "UPDATE Book_Acquisitions SET acquisition_date=?, supplier_name=?, acquisitions_price=?, copies_acquired=?, archivist_id=?, isbn=?, branch_delivered=? WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setDate(1, sqlDate);
            pstmt.setString(2, supplier_name);
            pstmt.setDouble(3, Double.parseDouble(acquisitions_price));
            pstmt.setInt(4, Integer.parseInt(copies_acquired));
            pstmt.setString(5, archivist_id);
            pstmt.setString(6, isbn);
            pstmt.setString(7, branch_delivered);
            pstmt.setString(8, acquisition_id);

            int rowsUpdated = pstmt.executeUpdate();
            pstmt.close();

            if (rowsUpdated > 0) {
                System.out.println("Record successfully updated.");
                return 1;
            } else {
                System.out.println("Record unsuccessfully updated.");
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int cancel_Book_acquisition(String acquisition_id) {
        try {
            String sql = "UPDATE Book_Acquisitions SET status=? WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, "C");
            pstmt.setString(2, acquisition_id);

            int rowsCancelled = pstmt.executeUpdate();
            pstmt.close();

            if (rowsCancelled > 0) {
                System.out.println("Record successfully cancelled.");
                return 1;
            } else {
                System.out.println("Record unsuccessfully cancelled.");
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int get_Book_acquisition(String acquisition_id) {
        int recordcount = 0;

        try {
            String sql = "SELECT * FROM Book_Acquisitions WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                // Process result set
                recordcount++;
            }

            resultSet.close();
            pstmt.close();
            return recordcount;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }
}