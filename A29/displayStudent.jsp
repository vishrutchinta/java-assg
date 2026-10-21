<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Student Details</title></head>
<body>
    <%-- Scriptlet: read request parameters (implicit object: request) --%>
    <%
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String section = request.getParameter("section");
        String branch = request.getParameter("branch");
    %>
    <h2>Student Details</h2>
    <p><b>Name:</b> <%= name %></p>
    <p><b>Roll No:</b> <%= roll %></p>
    <p><b>Class/Section:</b> <%= section %></p>
    <p><b>Branch:</b> <%= branch %></p>
    <p>Page generated at: <%= new java.util.Date() %></p>
    <a href="student.html">Back</a>
</body>
</html>
