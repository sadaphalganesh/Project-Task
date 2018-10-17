<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String sendTo=(String)session.getAttribute("sendTo");
 %>
<form  action="sendEmail" method="post">
	SendTo:<input type="text" value="<%=sendTo%>" name="sendTo"><br>
	
	Subject:<input type="text" name="subject"><br>
	
	Message:<textarea name="message"><br>
		
	<input type="submit"  value="send">
</form>

</body>
</html>