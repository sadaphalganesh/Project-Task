<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<%String uname=(String)session.getAttribute("userName");
out.println(new Date(session.getCreationTime()));
out.println(session.getCreationTime());
 %>
<h4 align="right"><a href="logout"><%=uname+">>" %>LogOut</a></h4>
<form action="getAllStudents">

GET THE LIST OF ALL STUDENTS<input type="submit" value="GO">
</form>
<form action="getByFirstName" method="post">
GET STUDENT BY FIRSTNAME OR LASTNAME: <input type="text" name="firstName"><input type="submit" value="GO">
</form>
</body>
</html>