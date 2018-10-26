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
<%@include file="header.jsp" %>
<!--  
<%
String sendTo=(String)session.getAttribute("sendTo");
 %>
 -->
 
<form  action="sendEmails" method="post">
<table>
<tr>
<!--  <td>SendTo:<input type="text"  value="<%=sendTo%>" name="sendTo"><br></td>-->
</tr>
<tr>	
<td>Subject:<input type="text" name="subject"></td>
</tr>
<tr>
	<td>Message:<textarea name="message"  rows=4 cloumn=50  "></textarea></td>
</tr>
<tr>
	<td><input type="submit"  value="send"  ></td>
</tr>
</table>	
</form>

</body>
</html>