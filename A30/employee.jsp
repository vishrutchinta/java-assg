<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="dbconfig.jsp" %>
<html>
<head><title>Employee Management</title></head>
<body>
<h2>Employee Management (CRUD)</h2>
<%
    String action = request.getParameter("action");
    String msg = "";
    String editId = "", editName = "", editDept = "", editSalary = "";

    try (Connection con = getConnection()) {
        if ("add".equals(action)) {                                   // CREATE
            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee(name,department,salary) VALUES(?,?,?)")) {
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("department"));
                ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                ps.executeUpdate();
                msg = "Employee added.";
            }
        } else if ("update".equals(action)) {                         // UPDATE
            try (PreparedStatement ps = con.prepareStatement(
                    "UPDATE employee SET name=?, department=?, salary=? WHERE emp_id=?")) {
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("department"));
                ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                ps.setInt(4, Integer.parseInt(request.getParameter("id")));
                ps.executeUpdate();
                msg = "Employee updated.";
            }
        } else if ("delete".equals(action)) {                         // DELETE
            try (PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE emp_id=?")) {
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ps.executeUpdate();
                msg = "Employee deleted.";
            }
        } else if ("edit".equals(action)) {                           // load row into form
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE emp_id=?")) {
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    editId = r.getString("emp_id");
                    editName = r.getString("name");
                    editDept = r.getString("department");
                    editSalary = r.getString("salary");
                }
            }
        }
%>
<p style="color:green"><%= msg %></p>

<form method="post" action="employee.jsp">
    <input type="hidden" name="action" value="<%= editId.isEmpty() ? "add" : "update" %>">
    <input type="hidden" name="id" value="<%= editId %>">
    Name: <input type="text" name="name" value="<%= editName %>" required>
    Department: <input type="text" name="department" value="<%= editDept %>" required>
    Salary: <input type="number" step="0.01" name="salary" value="<%= editSalary %>" required>
    <input type="submit" value="<%= editId.isEmpty() ? "Add Employee" : "Update Employee" %>">
</form>

<h3>Employee List</h3>
<table border="1" cellpadding="6">
    <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th><th>Actions</th></tr>
<%
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM employee")) {   // READ
            while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("emp_id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("department") %></td>
        <td><%= rs.getDouble("salary") %></td>
        <td>
            <a href="employee.jsp?action=edit&id=<%= rs.getInt("emp_id") %>">Edit</a> |
            <a href="employee.jsp?action=delete&id=<%= rs.getInt("emp_id") %>"
               onclick="return confirm('Delete this employee?')">Delete</a>
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
