package libraryDB;

import java.sql.*;

public class book_acquisition_management {
    private String acquisition_id;
    private String acquisition_date;
    private String acquisition_price;
    private String supplier_name;
    private String copies_acquired;
    private String archivist_id;
    private String isbn;
    private String branch_delivered;

    public book_acquisition_management() {
        this.acquisition_id = "";
        this.acquisition_date = "";
        this.acquisition_price = "";
        this.supplier_name = "";
        this.copies_acquired = "";
        this.archivist_id = "";
        this.isbn = "";
        this.branch_delivered = "";
    }

    public String add_Book_acquisition() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT")) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(acquisition_id) FROM Book_Acquisitions");

            // Get the highest id value
            String maxAcquisitionID = "A0000";
            if (resultSet.next()) {
                maxAcquisitionID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxAcquisitionID = "A0000";
            }

            int aquisitionIDNumber = Integer.parseInt(maxAcquisitionID.substring(1)) + 1; // Extract the number part
                                                                                          // only and add 1
            this.acquisition_id = "B" + String.format("%04d", aquisitionIDNumber);

            String sql = "INSERT INTO Book_Acquisitions (acquisition_id, acquisition_date, acquisition_price, supplier_name, copies_acquired, archivist_id, isbn, branch_delivered) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            pstmt.setString(2, acquisition_date);
            pstmt.setDouble(3, Double.parseDouble(acquisition_price));
            pstmt.setString(4, supplier_name);
            pstmt.setInt(5, Integer.parseInt(copies_acquired));
            pstmt.setString(6, archivist_id);
            pstmt.setString(7, isbn);
            pstmt.setString(8, branch_delivered);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            resultSet.close();
            connection.close();
            return acquisition_id;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    public int update_Book_acquisition() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT")) {

            System.out.println("Connection to DB Successful.");

            String sql = "UPDATE Book_Acquisitions SET acquisition_date=?, acquisition_price=?, supplier_name=?, copies_acquired=?, archivist_id=?, isbn=?, branch_delivered=? WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            pstmt.setString(2, acquisition_date);
            pstmt.setDouble(3, Double.parseDouble(acquisition_price));
            pstmt.setString(4, supplier_name);
            pstmt.setInt(5, Integer.parseInt(copies_acquired));
            pstmt.setString(6, archivist_id);
            pstmt.setString(7, isbn);
            pstmt.setString(8, branch_delivered);

            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            connection.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int delete_Book_acqusition() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT")) {
            System.out.println("Connection to DB Successful.");

            String sql = "DELETE FROM Book_Acquisitions WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);

            pstmt.executeUpdate();
            System.out.println("Record was deleted");

            pstmt.close();
            connection.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int get_Book_acquisition() {
        int recordcount = 0;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT")) {
            System.out.println("Connection to DB Successful.");

            String sql = "SELECT * FROM Book_Acquisitions  WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                acquisition_date = resultSet.getString("acquisition_date");
                acquisition_price = resultSet.getString("acquisition_price");
                supplier_name = resultSet.getString("supplier_name");
                copies_acquired = resultSet.getString("copies_acquired");
                archivist_id = resultSet.getString("archivist_id");
                isbn = resultSet.getString("isbn");
                branch_delivered = resultSet.getString("branch_delivered");
                recordcount++;
            }

            pstmt.close();
            resultSet.close();
            connection.close();
            return recordcount;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    // **********************************************
    //              GETTERS AND SETTERS
    // **********************************************

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public void setAcquisition_price(String acquisition_price) {
        this.acquisition_price = acquisition_price;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public void setCopies_acquired(String copies_acquired) {
        this.copies_acquired = copies_acquired;
    }

    public void setArchivist_id(String archivist_id) {
        this.archivist_id = archivist_id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBranch_delivered(String branch_delivered) {
        this.branch_delivered = branch_delivered;
    }

    public String getAcquisition_id() {
        return acquisition_id;
    }

    public String getAcquisition_price() {
        return acquisition_price;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public String getCopies_acquired() {
        return copies_acquired;
    }

    public String getArchivist_id() {
        return archivist_id;
    }

    public String getBranch_delivered() {
        return branch_delivered;
    }
}
