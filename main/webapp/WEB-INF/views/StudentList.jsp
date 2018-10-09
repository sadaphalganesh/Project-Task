<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<%@ page isELIgnored="false" %>
</head>
<body>
<h1>Student List</h1>

<table border="1">
<th>id</th>
<th>First Name</th>
<th>Last Name</th>
<th>email</th>
<th>address</th>
<th>phoneNumber</th>
<th>gender</th>
<th>dateOfBirth</th>



<c:forEach items="${studentList}" var="student">
	<tr>	
			<td><c:out value="${student.id}"/></td>
			<td><c:out value="${student.firstName}"/></td>	
			<td><c:out value="${student.lastName}"/></td>
			<td><c:out value="${student.email}"/></td>	
			<td><c:out value="${student.address}"/></td>	
			<td><c:out value="${student.phoneNumber}"/></td>	
			<td><c:out value="${student.gender}"/></td>	
			<td><c:out value="${student.dateOfBirth}"/></td>	
			<td><a href="edit?id=${student.id}">EDIT</a></td>
			<td><a href="delete?id=${student.id}">DELETE</a></td>
			<td><a href="email?id=${student.id}">EMAIL</a></td>
			
	</tr>
</c:forEach>
	
	</table>
	
<a href="logout">logOut</a>
</body>
</html>