package Assignment19;

import java.sql.*;


public class BookDetailSet {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/siu_library_db";
        String user = "root";
        String password = "ROLAQVARI2=H";

        String query = "SELECT b.bid, b.bname, n.no_of_copies, b.price " +
                        "FROM BOOKS b JOIN NOOFCOPIES n ON b.bid = n.bid";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Book ID\tName\t\t\tQuantity\tPrice");
            System.out.println("------------------------------------------------------");

            while (rs.next()) {
                int bid = rs.getInt("bid");
                String bname = rs.getString("bname");
                int qty = rs.getInt("no_of_copies");
                double price = rs.getDouble("price");

                System.out.println(bid + "\t" + bname + "\t\t" + qty + "\t\t" + price);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
