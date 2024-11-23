package tables;

import java.sql.*;

public class patron_management {

    private final Connection connection;

    public patron_management(Connection connection) {
        this.connection = connection;
    }

    public int add_patron(String last_name, String first_name, String age, String gender, String phone_no, String email) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(patron_id) FROM Patrons");

            String maxID = "P0000";
            if (resultSet.next()) {
                maxID = resultSet.getString(1);
                if (resultSet.wasNull())
                    maxID = "P0000";
            }

            int idNumber = Integer.parseInt(maxID.substring(1)) + 1;
            String patron_id = "P" + String.format("%04d", idNumber);

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

    public int update_patron(String patron_id, String last_name, String first_name, String age, String gender, String phone_no, String email) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE patrons SET last_name = ?, first_name = ?, age = ?, gender = ?, phone_no = ?, email = ? WHERE patron_id = ?");
            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.setString(4, gender);
            pstmt.setString(5, phone_no);
            pstmt.setString(6, email);
            pstmt.setString(7, patron_id);

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

    public int delete_patron(String patron_id) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM patrons WHERE patron_id=?");
            pstmt.setString(1, patron_id);

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