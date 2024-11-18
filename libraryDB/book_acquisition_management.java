package libraryDB;

import java.sql.*;

public class book_acquisition_management {
    public String acquisition_id;
    public String acquisition_date;
    public double acquisition_price;
    public String supplier_name;
    public int copies_acquired;
    public String archivist_id;
    public String isbn;
    public String branch_delivered;

    public book_acquisition_management(){
        this.acquisition_id = "";
        this.acquisition_date = "";
        this.acquisition_price = 0.0;
        this.supplier_name = "";
        this.copies_acquired = 0;
        this.archivist_id = "";
        this.isbn = "";
        this.branch_delivered = "";
    }

    public String add_Book_acquisition() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(acquisition_id) FROM Book_Acquisitions");

            //Get the highest id value
            String maxAcquisitionID = "A000000000";
            if (resultSet.next()) {
                maxAcquisitionID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxAcquisitionID = "A000000000";
            }

            int aquisitionIDNumber = Integer.parseInt(maxAcquisitionID.substring(1)) + 1; //Extract the number part only and add 1
            this.acquisition_id = "B" + String.format("%09d", aquisitionIDNumber);

            String sql = "INSERT INTO Book_Acquisitions (acquisition_id, acquisition_date, acquisition_price, supplier_name, copies_acquired, archivist_id, isbn, branch_delivered) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            pstmt.setString(2, acquisition_date);
            pstmt.setDouble(3, acquisition_price);
            pstmt.setString(4, supplier_name);
            pstmt.setInt   (5,(copies_acquired));
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
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "UPDATE Book_Acquisitions SET acquisition_date=?, acquisition_price=?, supplier_name=?, copies_acquired=?, archivist_id=?, isbn=?, branch_delivered=? WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_date);
            pstmt.setDouble(2, acquisition_price);
            pstmt.setString(3, supplier_name);
            pstmt.setInt   (4,(copies_acquired));
            pstmt.setString(5, archivist_id);
            pstmt.setString(6, isbn);
            pstmt.setString(7, branch_delivered);
            pstmt.setString(8, acquisition_id);

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
                "3d6%vQmT"
        )) {
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
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "SELECT * FROM Book_Acquisitions  WHERE acquisition_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, acquisition_id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                acquisition_date = resultSet.getString("acquisition_date");
                acquisition_price = resultSet.getDouble("acquisition_price");
                supplier_name = resultSet.getString("supplier_name");
                copies_acquired = resultSet.getInt("copies_acquired");
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
}

