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
<form method="post" action="update">
Id: <input type="text" name="id" value="<c:out value="${user.id }"/>" readonly/><br>
First Name:<input type="text" name="fname" value="<c:out value="${user.fname }"/>"/><br>  
Last Name:<input type="text" name="lname" value="<c:out value="${user.lname }"/>"/><br>  
Password:<input type="password" name="password" value="<c:out value="${user.password }"/>"/><br>  
<input type="submit" value="Save">
</form>
</body>
</html>