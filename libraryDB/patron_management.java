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

    public patron_management() {
        patron_id = "";
        last_name = "";
        first_name = "";
        age = "";
        gender = null;
        phone_no = "";
        email = "";
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public int add_patron() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT")
        ) {
            System.out.println("Connection to DB Successful.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(patron_id) FROM Patrons");

            String maxID = "P0000";
            if (resultSet.next()) {
                maxID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxID = "P0000";
            }

            int idNumber = Integer.parseInt(maxID.substring(1)) + 1;
            this.patron_id = "P" + String.format("%04d", idNumber);

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Patrons (patron_id, last_name, first_name, age, gender, phone_no, email) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, patron_id);
            pstmt.setString(2, last_name);
            pstmt.setString(3, first_name);
            pstmt.setInt(4, Integer.parseInt(age));
            pstmt.setString(5, gender);
            pstmt.setString(6, phone_no);
            pstmt.setString(7, email);

            int rowsAdded = pstmt.executeUpdate();
            pstmt.close();
            connection.close();

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

    public int delete_patron() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library",
                "root",
                "3d6%vQmT"
        )) {
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM patrons WHERE patron_id=?");
            pstmt.setString(1, patron_id);

            int rowsDeleted = pstmt.executeUpdate();
            pstmt.close();
            connection.close();

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

    public int get_patron() {
        int recordcount = 0;

        try {
            // Connect to the MySQL Database

            Connection conn = DriverManager.getConnection(
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