<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String uname=(String)session.getAttribute("userName");
out.println(new Date(session.getCreationTime()));
 %>
<h4 align="right"><a href="logout">Hello <%=uname+"==>" %>LogOut</a></h4>
</body>
</html>