<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Registration Result</title></head>
<body>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        // Mask the password instead of printing it
        String masked = (password == null) ? "" : "*".repeat(password.length());
    %>
    <h2>Registration Successful</h2>
    <p><b>Name:</b> <%= name %></p>
    <p><b>Email:</b> <%= email %></p>
    <p><b>Phone:</b> <%= phone %></p>
    <p><b>Password:</b> <%= masked %></p>
    <a href="register.html">Register another user</a>
</body>
</html>
