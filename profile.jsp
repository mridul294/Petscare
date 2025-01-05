<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>Welcome, ${user.name}!</h1>
    <p><strong>Email:</strong> ${user.email}</p>
    <p><strong>Password:</strong> ${user.password}</p>

    <a href="/register.jsp">Register a New User</a>
</body>
</html>
