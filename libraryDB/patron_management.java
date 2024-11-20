package libraryDB;

import java.sql.*;

public class patron_management {

    private String patron_id; // VARCHAR(10.)
    private String last_name; // VARCHAR(45)
    private String first_name; // VARCHAR(45)
    private String age;        // INT
    private String gender;     // ENUM ("M", "F")
    private String phone_no;   // VARCHAR(13)
    private String email;      // VARCHAR(45)
    private String status;     // ENUM ("'A', 'C'")

    public patron_management() {
        patron_id = "";
        last_name = "";
        first_name = "";
        age = 0;
        gender = null;
        phone_no = "";
        email = "";
        status = null;
    }

    // GETTERS AND SETTERS
    public String getPatronId() {
        return patron_id;
    }

    public void setPatronId(String patron_id) {
        this.patron_id = patron_id;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phone_no;
    }

    public void setPhoneNo(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String generatePatronId() {
        String query = "SELECT patron_id FROM patrons ORDER BY patron_id ASC";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            int expectedId = 1;
            while (rs.next()) {
                String currentId = rs.getString("patron_id");
                int currentIdNumber = Integer.parseInt(currentId.substring(1));
                if (currentIdNumber != expectedId) {
                    break;
                }
                expectedId++;
            }
            return "P" + String.format("%04d", expectedId);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    public int add_patron() {
        try {
            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            String patron_id = generatePatronId();

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Patrons (patron_id, last_name, first_name, age, gender, phone_no, email, status) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, patron_id);
            pstmt.setString(2, last_name);
            pstmt.setString(3, first_name);
            pstmt.setInt(4, Integer.parseInt(age));
            pstmt.setString(5, gender);
            pstmt.setString(6, phone_no);
            pstmt.setString(7, email);
            pstmt.setString(8, "A");

            System.out.println("Record was created.");
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int update_patron() {
        try {
            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("UPDATE patrons SET last_name = ?, first_name = ?, age = ?, gender = ?, phone_no = ?, email = ? WHERE patron_id = ?");
            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.setString(4, gender);
            pstmt.setString(5, phone_no);
            pstmt.setString(6, email);
            pstmt.setString(7, patron_id);

            System.out.println("Record was updated.");
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int cancel_patron() {
        try {
            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE from Patrons SET status = ? WHERE patron_id = ?");
            pstmt.setString(1, "C");
            pstmt.setString(2, patron_id);

            pstmt.executeUpdate();
            System.out.println("Record successfully deleted.");

            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

    public int get_patron() {
        try {
            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM Patrons WHERE patron_id = ?");
            pstmt.setString(1, patron_id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                last_name = rs.getString("last_name");
                first_name = rs.getString("first_name");
                age = rs.getString("age");
                gender = rs.getString("gender");
                phone_no = rs.getString("phone_no");
                email = rs.getString("email");
                status = rs.getString("status");
                System.out.println("Record was retrieved.");
            }

            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return 0;
        }
    }

}