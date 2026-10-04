package Assignment23;

import java.sql.*;

public class ResultSetNavigation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/siu_library_db";
        String user = "root";
        String password = "ROLAQVARI2=H";

        String sql = "SELECT eid, empname, salary, lid FROM EMPLOYEE";

        try (Connection con = DriverManager.getConnection(url, user, password);
             // TYPE_SCROLL_INSENSITIVE lets the cursor move forward AND backward
             Statement stmt = con.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("--- Forward (one by one using next()) ---");
            while (rs.next()) {
                printRow(rs);
            }

            System.out.println("\n--- Jump to last record ---");
            rs.last();
            printRow(rs);

            System.out.println("\n--- Backward (one by one using previous()) ---");
            while (rs.previous()) {
                printRow(rs);
            }

            System.out.println("\n--- Jump to first record ---");
            rs.first();
            printRow(rs);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    static void printRow(ResultSet rs) throws SQLException {
        int eid = rs.getInt("eid");
        String name = rs.getString("empname");
        double salary = rs.getDouble("salary");
        int lid = rs.getInt("lid");

        System.out.println("Emp ID: " + eid + " | Name: " + name
                + " | Salary: " + salary + " | Library ID: " + lid);
    }
}