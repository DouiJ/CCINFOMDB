package libraryDB;

import java.sql.*;

public class ref_job_title_management {

//    Reference Tables
//   - Managed by System Management
//   - Create a new Reference
//   - Deactivate a Reference
//   - Update a Reference
//   - Delete a Reference
//   - List Reference Records


    public String job_id;          // VARCHAR(1) numbers 1 - 4
    public String job_title;    // VARCHAR(20) based on id - 1 - Manager, 2 - Archivist, 3 - Clerk, 4 - Tech Support
    public float salary;        // DECIMAL(6,2)

    public ref_job_title_management() {
        job_id = "";
        job_title = "";
        salary = 0.00F;
    }

    public int add_Job_Title() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(job_id) FROM Ref_job_title");

            String maxJobId = "J0";
            while (rs.next())
                maxJobId = rs.getString(1);

            int jobIdNumber = Integer.parseInt(maxJobId.substring(1)) + 1;
            job_id = "J" + String.format("%01d", jobIdNumber);

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Job_Titles (job_id, job_title, salary) VALUES (?,?,?)");

            pstmt.setString(1, job_id);
            pstmt.setString(2, job_title);
            pstmt.setFloat(3, salary);
            pstmt.executeUpdate();

            System.out.println("Job Title Added Successfully");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println("Error adding job title: " + e.getMessage());
            return 0;
        }
    }

    public int update_Job_Title() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE Job_Titles SET job_title=?, salary=? WHERE job_id=?");

            pstmt.setString(1, job_title);
            pstmt.setFloat(2, salary);
            pstmt.setString(3, job_id);
            pstmt.executeUpdate();
            System.out.println("Record was updated");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println("Error updating job title: " + e.getMessage());
            return 0;
        }
    }

    public int delete_Job_Title() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE FROM Job_Titles WHERE job_id=?");

            pstmt.setString(1, job_id);
            pstmt.executeUpdate();
            System.out.println("Record was deleted");

            pstmt.close();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println("Error updating job title: " + e.getMessage());
            return 0;
        }
    }

    public int get_Job_Title() {
        int recordcount = 0;

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Ref_job_title WHERE job_id=?");
            pstmt.setString(1, job_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                job_title = rs.getString("job_title");
                salary = rs.getFloat("salary");
                recordcount++;
            }

            pstmt.close();
            conn.close();
            return recordcount;
        } catch (Exception e) {
            System.out.println("Error updating job title: " + e.getMessage());
            return 0;
        }
    }
}
