package libraryDB;

import java.sql.*;

public class branch_management {

    //FIELDS
    public String branch_id;  // VARCHAR 10 (PK)
    public String manager_id; // VARCHAR 10 (FK)
    public String address_id; // VARCHAR 10 (FK)
    public String phone_no;    // VARCHAR 13

    public branch_management() {
        this.branch_id = "";
        this.manager_id = "";
        this.address_id = "";
        this.phone_no = "";
    }

    public int add_Branch_Management() {
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
            branch_id = "B" + String.format("%04d", branchIDNumber);

            String sql = "INSERT INTO Branches (branch_id, manager_id, address_id, phone_no) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);
            pstmt.setString(2, manager_id);
            pstmt.setString(3, address_id);
            pstmt.setString(4, phone_no);

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            connection.close();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int update_Branch() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            String sql = "UPDATE Branches SET branch_id=?, manager_id=?, address_id=?, phone_no=? WHERE branch_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, branch_id);
            pstmt.setString(2, manager_id);
            pstmt.setString(3, address_id);
            pstmt.setString(4, phone_no);

            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                manager_id = resultSet.getString("manager_id");
                address_id = resultSet.getString("address_id");
                phone_no = resultSet.getString("phone_no");
                recordcount++;
            }

            pstmt.close();
            connection.close();
            return recordcount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }



}


