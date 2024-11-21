package libraryDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static libraryDB.branch_menu.getCurrentBranchID;

public class employee_record_management {

    private String employee_id;  // VARCHAR(10)
    private String last_name;    // VARCHAR(45)
    private String first_name;   // VARCHAR(45)
    private String age;          // TINYINT
    private String phone_no;     // VARCHAR(13)
    private String email;        // VARCHAR(45)
    private String job_id;       // ENUM (1 CHAR)
    private Date hire_date;      // DATE
    private String full_address; // VARCHAR(100)
    private String branch_id;    // VARCHAR(10)

    public employee_record_management() {
        employee_id = "";
        last_name = "";
        first_name = "";
        age = "";
        phone_no = "";
        email = "";
        hire_date = null;
        full_address = "";
        //branch_id  // Set to current selected branch ID
    }

    public String getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    // Create a new Record
    public int add_Employee() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(employee_id) FROM Employees");

            // Get the highest employeeID
            String maxEmployeeid = "E0000";
            while(rs.next())
                maxEmployeeid = rs.getString(1);

            // Parse the highest ID and add 1 to get the next ID
            int employeeIdNumber = Integer.parseInt(maxEmployeeid.substring(1)) + 1;
            String employee_id = "E" + String.format("%04d", employeeIdNumber);

            // Inserting new record
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Employees (employee_id, last_name, first_name, job_id, age, phone_no, email, hire_date, full_address, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, employee_id);
            pstmt.setString(2, last_name);
            pstmt.setString(3, first_name);
            pstmt.setString(4, job_id);
            pstmt.setInt(5, Integer.parseInt(age));
            pstmt.setString(6, phone_no);
            pstmt.setString(7, email);
            pstmt.setDate(8, hire_date);
            pstmt.setString(9, full_address);
            pstmt.setString(10, branch_id);

            int rowsAdded = pstmt.executeUpdate();
            rs.close();
            pstmt.close();
            conn.close();

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

    // Update an Existing Record
    public int update_Employee() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Employees SET last_name=?, first_name=?, age=?, phone_no=?, email=?, job_id=?, hire_date=?, full_address=?, branch_id=? WHERE employee_id=?");

            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.setString(4, phone_no);
            pstmt.setString(5, email);
            pstmt.setString(6, job_id);
            pstmt.setDate(7, hire_date);
            pstmt.setString(8, full_address);
            pstmt.setString(9, branch_id);  // CURRENT BRANCH TO BE FIXED
            pstmt.setString(10, employee_id);

            int rowsUpdated = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

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
    public int delete_Employee() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Employees WHERE employee_id=?");
            pstmt.setString(1, employee_id);

            int rowsDeleted = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

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

    // View one Record
    public int get_Employee() {
        int recordcount = 0;

        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Employees WHERE employee_id = ?");
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
            conn.close();
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
