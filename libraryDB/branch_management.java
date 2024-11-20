package libraryDB;

import java.sql.*;
import java.util.ArrayList;

public class branch_management {

    //FIELDS
    public String branch_id;  // VARCHAR 10 (PK)
    public String full_address; // VARCHAR 100
    public String phone_no;    // VARCHAR 13

    public branch_management() {
        this.branch_id = "";
        this.full_address = "";
        this.phone_no = "";
    }

    public String add_Branch() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(branch_id) FROM branches");

            //Get the highest id value
            String maxBranchID = "B0000";
            if (resultSet.next()) {
                maxBranchID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxBranchID = "B0000";
            }

            int branchIDNumber = Integer.parseInt(maxBranchID.substring(1)) + 1; //Extract the number part only and add 1
            this.branch_id = "B" + String.format("%04d", branchIDNumber);

            String sql = "INSERT INTO Branches (branch_id, full_address, phone_no) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);
            pstmt.setString(2, full_address);
            pstmt.setString(3, phone_no);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            resultSet.close();
            pstmt.close();
            connection.close();
            return branch_id;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<String> get_Branches() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT branch_id FROM branches");

            // Print out all the Branch IDs

            ArrayList<String> branches = new ArrayList<String>();

            while (resultSet.next()) {
                String branchID = resultSet.getString(1);
                if (branchID != null) {
                    branches.add(branchID);
                }
            }
            return branches;

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

            String sql = "UPDATE Branches SET full_address=?, phone_no=? WHERE branch_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, full_address);
            pstmt.setString(2, phone_no);
            pstmt.setString(3, branch_id);

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

    public int delete_Branch() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "DELETE FROM Branches WHERE branch_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);

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

    public int get_Branch() {
        int recordcount = 0;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "SELECT * FROM Branches WHERE branch_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                full_address = resultSet.getString("full_address");
                phone_no = resultSet.getString("phone_no");
                recordcount++;
            }

            pstmt.close();
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


