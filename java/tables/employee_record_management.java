package tables;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class employee_record_management {

    private Connection connection;

    public employee_record_management(Connection connection) {
        this.connection = connection;
    }

    public int add_Employee(String last_name, String first_name, String job_id, String age, String phone_no, String email, String full_address, String branch_id) {
        try {

            String hire_date = java.time.LocalDate.now().toString();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(employee_id) FROM Employees");

            String maxEmployeeid = "E0000";
            while(rs.next())
                maxEmployeeid = rs.getString(1);

            int employeeIdNumber = Integer.parseInt(maxEmployeeid.substring(1)) + 1;
            String employee_id = "E" + String.format("%04d", employeeIdNumber);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = df.parse(hire_date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Employees (employee_id, last_name, first_name, job_id, age, phone_no, email, hire_date, full_address, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, employee_id);
            pstmt.setString(2, last_name);
            pstmt.setString(3, first_name);
            pstmt.setString(4, job_id);
            pstmt.setInt(5, Integer.parseInt(age));
            pstmt.setString(6, phone_no);
            pstmt.setString(7, email);
            pstmt.setDate(8, sqlDate);
            pstmt.setString(9, full_address);
            pstmt.setString(10, branch_id);

            int rowsAdded = pstmt.executeUpdate();
            rs.close();
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

    public int update_Employee(String employee_id, String last_name, String first_name, String job_id, String age, String phone_no, String email, String hire_date, String full_address, String branch_id) {
        try {

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date utilDate = df.parse(hire_date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            PreparedStatement pstmt = connection.prepareStatement("UPDATE Employees SET last_name=?, first_name=?, age=?, phone_no=?, email=?, job_id=?, hire_date=?, full_address=?, branch_id=? WHERE employee_id=?");

            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.setString(4, phone_no);
            pstmt.setString(5, email);
            pstmt.setString(6, job_id);
            pstmt.setDate(7, sqlDate);
            pstmt.setString(8, full_address);
            pstmt.setString(9, branch_id);  // CURRENT BRANCH TO BE FIXED
            pstmt.setString(10, employee_id);

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

    // Delete an Existing Record
    public int delete_Employee(String employee_id) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Employees WHERE employee_id=?");
            pstmt.setString(1, employee_id);

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
/*
    // View one Record
    public int get_Employee() {
        int recordcount = 0;

        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Employees WHERE employee_id = ?");
            pstmt.setString(1, employee_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                last_name    = rs.getString("last_name");
                first_name   = rs.getString("first_name");
                age          = rs.getString("age");
                phone_no     = rs.getString("phone_no");
                email        = rs.getString("email");
                job_id       = rs.getString("job_id");
                hire_date    = rs.getDate("hire_date");
                full_address = rs.getString("full_address");
                branch_id    = rs.getString("branch_id");
                recordcount++;
            }

            rs.close();
            pstmt.close();
            return recordcount;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }*/
}