<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.jbk.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success page</title>
</head>
<body>
	
	
	<%
	session=request.getSession();
	if(session.isNew()){
	session.invalidate();
	RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
	}
	
	Student student=(Student)session.getAttribute("student");
	String firstName=student.getFirstName();
	 %>
	 WELCOME TO JBK <%=firstName %>
	<form action="logout">
	<input type="submit" value="LOGOUT"> 
	</form>
	
</body>
</html>