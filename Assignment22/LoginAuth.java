package Assignment22;

import java.sql.*;
import java.util.Scanner;

// Uses LIBRARY_LOGIN (login_id, password, stid, role) — see login_additions.sql.
// Try login_id "suresh.801", password "suresh@123".
public class LoginAuth {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/siu_library_db";
        String dbUser = "root";
        String dbPassword = "ROLAQVARI2=H";

        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        sc.close();

        String sql = "SELECT * FROM LIBRARY_LOGIN WHERE login_id = ? AND password = ?";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful! Welcome, " + username + ".");
            } else {
                System.out.println("Login Failed! Invalid username or password.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}