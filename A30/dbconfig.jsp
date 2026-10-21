<%@ page import="java.sql.*" %>
<%!
    // Shared helper included by the CRUD pages. Update the credentials for your system.
    Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_db", "root", "root");
    }
%>
