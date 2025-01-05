<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pets Care Management</title>
</head>
<body>
    <h1>Pets Care Management</h1>
    <h2>List of Pets</h2>

    <c:choose>
        <c:when test="${empty pets}">
            <p>No pets available.</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="pet" items="${pets}">
                    <li>${pet.name} (${pet.type}) - ID: ${pet.id}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>

    <h2>Add a Pet</h2>
    <form action="/pets" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="type">Type:</label>
        <input type="text" id="type" name="type"><br>
        <button type="submit">Add Pet</button>
    </form>

    <h2>Delete a Pet</h2>
    <form action="/pets" method="post">
        <label for="id">Pet ID:</label>
        <input type="text" id="id" name="id"><br>
        <input type="hidden" name="action" value="delete">
        <button type="submit">Delete Pet</button>
    </form>
</body>
</html>
