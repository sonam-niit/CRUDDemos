<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="user" value="${requestScope.user }">  </c:set>
<table border="1">
<tr><th>Id</th><td><c:out value="${user.id }"></c:out></td></tr>
<tr><th>First Name</th><td><c:out value="${user.fname }"></c:out></td></tr>
<tr><th>Last Name</th><td><c:out value="${user.lname }"></c:out></td></tr>
<tr><th>Password</th><td><c:out value="${user.password }"></c:out></td></tr>
<tr><td><a href="edit?id=${user.id }">Edit Profile</a></td>
<td><a href="logout">logout</a></tr>
</table>
</body>
</html>