<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="dbconfig.jsp" %>
<html>
<head><title>Patient Management</title></head>
<body>
<h2>Patient Records (CRUD)</h2>
<%
    String action = request.getParameter("action");
    String msg = "";
    String eId = "", eName = "", eAge = "", eDisease = "", eStatus = "";

    try (Connection con = getConnection()) {
        if ("add".equals(action)) {                                   // CREATE
            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO patient(name,age,disease,treatment_status) VALUES(?,?,?,?)")) {
                ps.setString(1, request.getParameter("name"));
                ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                ps.setString(3, request.getParameter("disease"));
                ps.setString(4, request.getParameter("status"));
                ps.executeUpdate();
                msg = "Patient record added.";
            }
        } else if ("update".equals(action)) {                         // UPDATE
            try (PreparedStatement ps = con.prepareStatement(
                    "UPDATE patient SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?")) {
                ps.setString(1, request.getParameter("name"));
                ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                ps.setString(3, request.getParameter("disease"));
                ps.setString(4, request.getParameter("status"));
                ps.setInt(5, Integer.parseInt(request.getParameter("id")));
                ps.executeUpdate();
                msg = "Patient record updated.";
            }
        } else if ("delete".equals(action)) {                         // DELETE
            try (PreparedStatement ps = con.prepareStatement("DELETE FROM patient WHERE patient_id=?")) {
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ps.executeUpdate();
                msg = "Patient record deleted.";
            }
        } else if ("edit".equals(action)) {
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM patient WHERE patient_id=?")) {
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    eId = r.getString("patient_id");
                    eName = r.getString("name");
                    eAge = r.getString("age");
                    eDisease = r.getString("disease");
                    eStatus = r.getString("treatment_status");
                }
            }
        }
%>
<p style="color:green"><%= msg %></p>

<form method="post" action="patient.jsp">
    <input type="hidden" name="action" value="<%= eId.isEmpty() ? "add" : "update" %>">
    <input type="hidden" name="id" value="<%= eId %>">
    Name: <input type="text" name="name" value="<%= eName %>" required>
    Age: <input type="number" name="age" value="<%= eAge %>" required>
    Disease: <input type="text" name="disease" value="<%= eDisease %>" required>
    Treatment Status:
    <select name="status">
        <option <%= "Ongoing".equals(eStatus) ? "selected" : "" %>>Ongoing</option>
        <option <%= "Completed".equals(eStatus) ? "selected" : "" %>>Completed</option>
        <option <%= "Pending".equals(eStatus) ? "selected" : "" %>>Pending</option>
    </select>
    <input type="submit" value="<%= eId.isEmpty() ? "Add Patient" : "Update Patient" %>">
</form>

<h3>Patient List</h3>
<table border="1" cellpadding="6">
    <tr><th>Patient ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th><th>Actions</th></tr>
<%
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM patient")) {    // READ
            while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("patient_id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getInt("age") %></td>
        <td><%= rs.getString("disease") %></td>
        <td><%= rs.getString("treatment_status") %></td>
        <td>
            <a href="patient.jsp?action=edit&id=<%= rs.getInt("patient_id") %>">Edit</a> |
            <a href="patient.jsp?action=delete&id=<%= rs.getInt("patient_id") %>"
               onclick="return confirm('Delete this record?')">Delete</a>
        </td>
    </tr>
<%
            }
        }
    } catch (Exception e) {
        out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
    }
%>
</table>
</body>
</html>
