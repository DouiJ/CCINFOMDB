package tables;

import java.sql.*;
import java.util.ArrayList;

public class branch_management {

    private final Connection connection;

    public branch_management(Connection connection) {;
        this.connection = connection;
    }

    public int add_Branch(String full_address, String phone_no) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(branch_id) FROM branches");

            // Get the highest id value
            String maxBranchID = "L0000";
            if (resultSet.next()) {
                maxBranchID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxBranchID = "L0000";
            }

            int branchIDNumber = Integer.parseInt(maxBranchID.substring(1)) + 1; // Extract the number part only and add 1
            String branch_id = "L" + String.format("%04d", branchIDNumber);

            String sql = "INSERT INTO Branches (branch_id, full_address, phone_no) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);
            pstmt.setString(2, full_address);
            pstmt.setString(3, phone_no);

            int rowsAdded = pstmt.executeUpdate();
            pstmt.close();

            if (rowsAdded > 0) {
                System.out.println("Record successfully created.");
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
    public int update_Branch(String branch_id, String full_address, String phone_no) {
        try {
            String sql = "UPDATE Branches SET full_address=?, phone_no=? WHERE branch_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, full_address);
            pstmt.setString(2, phone_no);
            pstmt.setString(3, branch_id);

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

    public int delete_Branch(String branch_id) {
        try {
            String sql = "DELETE FROM Branches WHERE branch_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);

            int rowsDeleted = pstmt.executeUpdate();
            pstmt.close();

            if (rowsDeleted > 0) {
                System.out.println("Record successfully deleted.");
                return 1;
            } else {
                System.out.println("Record unsuccessfully deleted.");
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

}