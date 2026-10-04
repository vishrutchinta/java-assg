package Assignment20;

import java.sql.*;
import java.util.Scanner;


public class StudentCRUD {
    static String url = "jdbc:mysql://localhost:3306/siu_library_db";
    static String user = "root";
    static String password = "ROLAQVARI2=H";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student CRUD (siu_library_db.STUDENT) ---");
            System.out.println("1. Create  2. Read All  3. Update Email  4. Delete  5. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Student ID (stuid): ");
                int stuid = Integer.parseInt(sc.nextLine());
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Member ID (free memid, e.g. 606): ");
                int memid = Integer.parseInt(sc.nextLine());
                System.out.print("Department ID (e.g. 501): ");
                int deptid = Integer.parseInt(sc.nextLine());
                createStudent(stuid, name, email, memid, deptid);

            } else if (choice == 2) {
                readStudents();

            } else if (choice == 3) {
                System.out.print("Student ID to update: ");
                int stuid = Integer.parseInt(sc.nextLine());
                System.out.print("New Email: ");
                String email = sc.nextLine();
                updateStudent(stuid, email);

            } else if (choice == 4) {
                System.out.print("Student ID to delete: ");
                int stuid = Integer.parseInt(sc.nextLine());
                deleteStudent(stuid);

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    static void createStudent(int stuid, String name, String email, int memid, int deptid) {
        String sql = "INSERT INTO STUDENT (stuid, sname, email, memid, deptid) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, stuid);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, memid);
            ps.setInt(5, deptid);

            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void readStudents() {
        String sql = "SELECT * FROM STUDENT";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("stuid") + "\t" + rs.getString("sname") + "\t"
                        + rs.getString("email") + "\tmemid=" + rs.getInt("memid") + "\tdeptid=" + rs.getInt("deptid"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void updateStudent(int stuid, String email) {
        String sql = "UPDATE STUDENT SET email = ? WHERE stuid = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setInt(2, stuid);

            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteStudent(int stuid) {
        String sql = "DELETE FROM STUDENT WHERE stuid = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, stuid);

            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) deleted.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
