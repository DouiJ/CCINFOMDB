package libraryDB;

import java.sql.*;

public class ref_address_management {

    public String address_id;
    public String unit_no;      // Can be NULL for branches, Not null for employees
    public String barangay;
    public String city;
    public String province;
    public String region;
    public int zip_code;

    public ref_address_management() {
        address_id = "";
        unit_no = "";
        barangay = "";
        city = "";
        province = "";
        region = "";
        zip_code = 0;
    }

    public String add_Address() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC&user=root&password=3d6%vQmT");

            // Get the highest address ID
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(address_id) FROM Addresses");

            String maxAddressId = "A0000";
            while (rs.next())
                maxAddressId = rs.getString(1);


            // Generate new address ID
            int addressIdNumber = Integer.parseInt(maxAddressId.substring(1)) + 1;
            address_id = "A" + String.format("%04d", addressIdNumber);

            // Insert new address
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Addresses (address_id, unit_no, barangay, city, province, region, zip_code) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, address_id);
            if (unit_no.isEmpty() || unit_no.equals("NULL"))
                pstmt.setNull(2, Types.VARCHAR);
            else
                pstmt.setString(2, unit_no);
            pstmt.setString(3, barangay);
            pstmt.setString(4, city);
            pstmt.setString(5, province);
            pstmt.setString(6, region);
            pstmt.setInt(7, zip_code);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return address_id;
        } catch (Exception e) {
            System.out.println("Error adding address: " + e.getMessage());
            return null;
        }
    }




}
