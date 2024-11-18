package libraryDB;

import java.sql.*;

public class patron_management {

    public String patron_id; // VARCHAR(10.)
    public String last_name; // VARCHAR(45)
    public String first_name; // VARCHAR(45)
    public int age; // INT

    public enum Gender {
        M, F
    }; // ENUM("M","F")

    public Gender gender; // ENUM ("M", "F")
    public String phone_no; // VARCHAR(13)
    public String email; // VARCHAR(45)

    public patron_management() {
        patron_id = "";
        last_name = "";
        first_name = "";
        age = 0;
        gender = null;
        phone_no = "";
        email = "";
    }

    public int add_patron() {
        try {
            /*
             * Common Algorithm when interacting with databases
             * 1. Connect to the MySQL Database
             * 2. Preparing your SQL Statement
             * 3. Close your SQL Statement
             * 4. Close your Connection to the MySQL Database
             */

            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Patrons VALUES {?,?,?,?,?,?,?}");
            pstmt.setString(1, patron_id);
            pstmt.setString(2, last_name);
            pstmt.setString(3, first_name);
            pstmt.setInt(4, age);
            pstmt.setString(5, gender.name());
            pstmt.setString(6, phone_no);
            pstmt.setString(7, email);
            System.out.println("SQL Statement prepared.");
            pstmt.executeUpdate();
            System.out.println("Record was screated.");
            pstmt.close();
            conn.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int update_patron() {
        try {
            /*
             * Common Algorithm when interacting with databases
             * 1. Connect to the MySQL Database
             * 2. Preparing your SQL Statement
             * 3. Close your SQL Statement
             * 4. Close your Connection to the MySQL Database
             */

            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE patrons SET patron_id = ?, last_name = ?, first_name = ?, age = ?, gender = ?, phone_no = ?, email = ? WHERE patron_id = ?");
            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setInt(3, age);
            pstmt.setString(4, gender.name());
            pstmt.setString(5, phone_no);
            pstmt.setString(6, email);
            pstmt.setString(9, patron_id);
            System.out.println("SQL Statement prepared.");
            pstmt.executeUpdate();
            System.out.println("Record was updated.");
            pstmt.close();
            conn.close();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int delete_patron() {
        try {
            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE from Patrons WHERE patron_id = ?");
            pstmt.setString(1, patron_id);
            System.out.println("SQL Statement Prepared.");
            pstmt.executeUpdate();
            System.out.println("Record successfully deleted.");
            pstmt.close();
            conn.close();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int get_patron() {
        try {
            /*
             * Common Algorithm when interacting with databases
             * 1. Connect to the MySQL Database
             * 2. Preparing your SQL Statement
             * 3. Close your SQL Statement
             * 4. Close your Connection to the MySQL Database
             */

            // Connect to the MySQL Database
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");
            System.out.println("Connection to DB Successful.");

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM Patrons WHERE patron_id = ?");
            pstmt.setString(9, patron_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                last_name = rs.getString("last_name");
                first_name = rs.getString("first_name");
                age = rs.getInt("age");
                gender = Gender.valueOf(rs.getString("gender"));
                phone_no = rs.getString("phone_no");
                email = rs.getString("email");
                System.out.println("Record was retrieved.");
            }
            pstmt.close();
            conn.close();
            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}