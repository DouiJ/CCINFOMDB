package libraryDB;

import java.sql.*;

public class employee_record_management {

    public String employee_id;  // VARCHAR(10)
    public String last_name;    // VARCHAR(45)
    public String first_name;   // VARCHAR(45)
    public int job_id;          // Parse int since VARCHAR(1)
    public int age;             // INT
    public String phone_no;     // VARCHAR(13)
    public String email;        // VARCHAR(45)
    public Date hire_date;      // DATE
    public String address_id;   // VARCHAR(10)
    public String branch_id;    // VARCHAR(10)

    public employee_record_management() {
        employee_id = "";
        last_name = "";
        first_name = "";
        job_id = 0;
        age = 0;
        phone_no = "";
        email = "";
        hire_date = null;
        address_id = "";
        branch_id = "";
    }

    //        1. Core Data Tables
//                - Managed with Records Management
//                - Create a new Record
//                - Update an Existing Record
//                - Delete an Existing Record
//                - Deactivate an Existing Record
//                - View one Record
//        - List Records using a Filter

    // Create a new Record
    public int add_Employee() {
        try {

            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Employees (employee_id, last_name, first_name, job_id, age, phone_no, email, hire_date, address_id, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, employee_id);        // Automated, starts at "E0001" parse to add 1 per record
            pstmt.setString(2, last_name);
            pstmt.setString(3, first_name);
            pstmt.setInt(4, job_id);                // User assigns role (1 - 4)
            pstmt.setInt(5, age);
            pstmt.setString(6, phone_no);
            pstmt.setString(7, email);
            pstmt.setDate(8, hire_date);
            pstmt.setString(9, address_id);         // Creates record for branch id, get current max + 1 and that would be the id
            pstmt.setString(10, branch_id);         // Implement a search for branch_id to guide user input

            pstmt.executeUpdate();
            System.out.println("Record was created");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Update an Existing Record
    public int update_Employee() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE Employees SET last_name=?, first_name=?, job_id=?, age=?, phone_no=?, email=?, hire_date=?, address_id=?, branch_id=? WHERE employee_id=?");

            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setInt(3, job_id);
            pstmt.setInt(4, age);
            pstmt.setString(5, phone_no);
            pstmt.setString(6, email);
            pstmt.setDate(7, hire_date);
            pstmt.setString(8, address_id);     // Updates address record
            pstmt.setString(9, branch_id);      // Updates branch record
            pstmt.setString(10, employee_id);

            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Delete an Existing Record
    public int delete_Employee() {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Employees WHERE employee_id=?");
            pstmt.setString(1, employee_id);


            pstmt.executeUpdate();
            System.out.println("Record was deleted");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // View one Record
    public int get_Employee() {
        int recordcount = 0;

        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Employees WHERE employee_id = ?");
            pstmt.setString(1, employee_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                last_name = rs.getString("last_name");
                first_name = rs.getString("first_name");
                job_id = rs.getInt("job_id");
                age = rs.getInt("age");
                phone_no = rs.getString("phone_no");
                email = rs.getString("email");
                hire_date = rs.getDate("hire_date");
                address_id = rs.getString("address_id");
                branch_id = rs.getString("branch_id");
                recordcount++;
            }

            return recordcount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


}
