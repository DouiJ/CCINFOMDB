package libraryDB;

import java.sql.*;

public class borrowing_fines_management {

    private String fine_id;

    private String fine_amount;
    private String payment_date;
    private String status;

    private String clerk_id;
    private String borrow_id;

    public borrowing_fines_management() {
        this.fine_id = "";
        this.fine_amount = "";
        this.payment_date = "";
        this.borrow_id = "";
        this.clerk_id = "";
        this.status = "";
    }

    public String add_Borrowing_fines() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(fine_id) FROM Borrowing_Fines");

            //Get the highest id value
            String maxID = "F0000";
            if (resultSet.next()) {
                maxID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxID = "F0000";
            }

            int iDNumber = Integer.parseInt(maxID.substring(1)) + 1; //Extract the number part only and add 1
            this.fine_id = "B" + String.format("%04d", iDNumber);

            String sql = "INSERT INTO Borrowing_Fines (fine_id, fine_amount, payment_date, borrow_id, clerk_id, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, fine_id);
            pstmt.setDouble(2, Double.parseDouble(fine_amount));
            pstmt.setString(3, payment_date);
            pstmt.setString(4, borrow_id);
            pstmt.setString(5, clerk_id);
            pstmt.setString(6, status);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            connection.close();
            return fine_id;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    public int update_Branch() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "UPDATE Borrowing_Fines SET fine_amount=?, payment_date=?, borrow_id=?, clerk_id=?, status=? WHERE fine_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setDouble(1, Double.parseDouble(fine_amount));
            pstmt.setString(2, payment_date);
            pstmt.setString(3, borrow_id);
            pstmt.setString(4, clerk_id);
            pstmt.setString(5, status);
            pstmt.setString(6, fine_id);

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

    public int cancel_Book_details() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "UPDATE Borrowing_Fines SET status=? WHERE fine_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, "C");
            pstmt.setString(2, fine_id);

            pstmt.executeUpdate();
            System.out.println("Transaction was cancelled");

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

    public int get_Book_details() {
        int recordcount = 0;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            String sql = "SELECT * FROM Borrowing_Fines WHERE fine_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, fine_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {  // Since ISBN should be unique, just check once
                fine_amount = rs.getString("fine_amount");
                payment_date= rs.getString("payment_date");
                borrow_id = rs.getString("borrow_id");
                clerk_id = rs.getString("clerk_id");
                status = rs.getString("status");
                recordcount++; // Only one record expected for a unique ISBN
            }

            rs.close();
            return recordcount;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }

    }

    public void setBorrow_id(String borrow_id) {
        this.borrow_id = borrow_id;
    }

    public void setClerk_id(String clerk_id) {
        this.clerk_id = clerk_id;
    }

    public void setFine_amount(String fine_amount) {
        this.fine_amount = fine_amount;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFine_id() {
        return fine_id;
    }

    public String getBorrow_id() {
        return borrow_id;
    }

    public String getClerk_id() {
        return clerk_id;
    }

    public String getFine_amount() {
        return fine_amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getStatus() {
        return status;
    }
}
