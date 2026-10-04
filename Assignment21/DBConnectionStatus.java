package Assignment21;

import java.sql.*;

public class DBConnectionStatus {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/siu_library_db";
        String user = "root";
        String password = "ROLAQVARI2=H";

        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                System.out.println("Connection Status: SUCCESS");
                System.out.println("SIU Library database is connected successfully.");
                System.out.println("Connected to: " + con.getCatalog());

                // simple proof the connection actually works
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS totalLibraries FROM ILIBRARY");
                if (rs.next()) {
                    System.out.println("Total libraries in DB: " + rs.getInt("totalLibraries"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection Status: FAILED");
            System.out.println("Error: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}