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


<h1>Registration form</h1>

<h3>${message}</h3>

<form:errors path="student.*"></form:errors>

<form:form  action="saveForm" method="post" modelAttribute="student">

	<table>
	<form:hidden path="id"/>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName"/><td>
		</tr>
		
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName"/><td>
		</tr>
		
		<tr>
			<td>email</td>
			<td><form:input path="email"/><td>
		</tr>
		
		<tr>
			<td>address</td>
			<td><form:input path="address"/><td>
		</tr>
		
		<tr>
			<td>phoneNumber</td>
			<td><form:input path="phoneNumber"/><td>
		</tr>
		
		<tr>
			<td>dateOfBirth</td>
			<td><form:input path="dateOfBirth" /><td>	
		</tr>
		
		<tr>
			<td>gender</td>
			<td><form:radiobutton path="gender" value="Male"/>Male</td>
			<td><form:radiobutton path="gender" value="Female"/>Female</td>
		</tr>
		
		<tr>
			<td>userName</td>
			<td><form:input path="userName"/><td>
		</tr>
		
		<tr>
			<td>password</td>
			<td><form:input path="password"/><td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>

</form:form>
</body>
</html>