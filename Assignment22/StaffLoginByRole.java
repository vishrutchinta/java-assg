package Assignment22;

import java.sql.*;
import java.util.Scanner;

// Original exercise: "hospital staff login (doctor/nurse)". Adapted here to
// siu_library_db's LIBRARY_LOGIN table, whose role column holds
// "Librarian" / "Assistant" instead of "Doctor" / "Nurse".
public class StaffLoginByRole {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/siu_library_db";
        String dbUser = "root";
        String dbPassword = "ROLAQVARI2=H";

        Scanner sc = new Scanner(System.in);
        System.out.print("Login ID: ");
        String loginId = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        sc.close();

        String sql = "SELECT * FROM LIBRARY_LOGIN WHERE login_id = ? AND password = ?";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                System.out.println("Access Granted. Role: " + role);

                if (role.equalsIgnoreCase("Librarian")) {
                    System.out.println("Redirecting to Librarian Dashboard...");
                } else if (role.equalsIgnoreCase("Assistant")) {
                    System.out.println("Redirecting to Assistant Dashboard...");
                }

            } else {
                System.out.println("Access Denied. Invalid credentials.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
