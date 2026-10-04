package Assignment20;

import java.sql.*;
import java.util.Scanner;

// EMPLOYEE(eid, empname, email, salary, lid) — lid must be an existing ILIBRARY id (101-105)
public class EmployeeCRUD {
    static String url = "jdbc:mysql://localhost:3306/siu_library_db";
    static String user = "root";
    static String password = "ROLAQVARI2=H";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee CRUD (siu_library_db.EMPLOYEE) ---");
            System.out.println("1. Insert  2. Update Salary  3. Delete  4. View All  5. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Employee ID (eid): ");
                int eid = Integer.parseInt(sc.nextLine());
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Salary: ");
                double salary = Double.parseDouble(sc.nextLine());
                System.out.print("Library ID (lid, e.g. 101): ");
                int lid = Integer.parseInt(sc.nextLine());
                insertEmployee(eid, name, email, salary, lid);

            } else if (choice == 2) {
                System.out.print("Employee ID to update: ");
                int eid = Integer.parseInt(sc.nextLine());
                System.out.print("New Salary: ");
                double salary = Double.parseDouble(sc.nextLine());
                updateSalary(eid, salary);

            } else if (choice == 3) {
                System.out.print("Employee ID to delete: ");
                int eid = Integer.parseInt(sc.nextLine());
                deleteEmployee(eid);

            } else if (choice == 4) {
                viewAll();

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    static void insertEmployee(int eid, String name, String email, double salary, int lid) {
        String sql = "INSERT INTO EMPLOYEE (eid, empname, email, salary, lid) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, eid);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setDouble(4, salary);
            ps.setInt(5, lid);

            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void updateSalary(int eid, double salary) {
        String sql = "UPDATE EMPLOYEE SET salary = ? WHERE eid = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, eid);

            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteEmployee(int eid) {
        String sql = "DELETE FROM EMPLOYEE WHERE eid = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, eid);

            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) deleted.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewAll() {
        String sql = "SELECT * FROM EMPLOYEE";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("eid") + "\t" + rs.getString("empname") + "\t"
                        + rs.getString("email") + "\t" + rs.getDouble("salary") + "\tlid=" + rs.getInt("lid"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
