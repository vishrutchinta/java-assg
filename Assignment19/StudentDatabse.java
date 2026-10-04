package Assignment19;

import java.sql.*;

public class StudentDatabse {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/siu_library_db";
        String user = "root";
        String password = "ROLAQVARI2=H";

        String query = "SELECT stuid, sname, email, memid, deptid FROM STUDENT";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("StuID\tName\t\tEmail\t\t\tMemID\tDeptID");
            System.out.println("-----------------------------------------------------------");

            while (rs.next()) {
                int stuid = rs.getInt("stuid");
                String sname = rs.getString("sname");
                String email = rs.getString("email");
                int memid = rs.getInt("memid");
                int deptid = rs.getInt("deptid");

                System.out.println(stuid + "\t" + sname + "\t\t" + email + "\t" + memid + "\t" + deptid);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}