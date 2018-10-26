<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<%@ page isELIgnored="false" %>
</head>
<body>

<h4 align="right"><a href="logout">LogOut</a></h4>
<form action="getByFirstName" method="post">
Search Student<input type="text" name="firstName"><input type="submit" value="GO">
</form>


<h2>${msg}</h2>
<script>
	function OnButton(obj){
		if(obj.name=="DeleteButton"){
		document.Form1.action="deleteSelected";
		alert("Do you want to delete?")
		//return true;
		document.Form1.submit()
	}
		if(obj.name=="EditButton"){
			document.Form1.action="edit";
			alert("do you want to edit?")
			//return true;
			document.Form1.submit()
		}
		if(obj.name=="EmailButton"){
			document.Form1.action="sendToMany";
			alert("do you want to SEND EMAIL?")
			//return true;
			document.Form1.submit()
		}
	}
</script>

<br><br>

<h1>Student List</h1>


<form name="Form1" method="post">


<table border="1">
<th>Select</th>
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
			 <td><input type="checkbox" value="${student.id}" name="select"></td>
			<td><c:out value="${student.id}"/></td>
			<td><c:out value="${student.firstName}"/></td>	
			<td><c:out value="${student.lastName}"/></td>
			<td><c:out value="${student.email}"/></td>	
			<td><c:out value="${student.address}"/></td>	
			<td><c:out value="${student.phoneNumber}"/></td>	
			<td><c:out value="${student.gender}"/></td>	
			<td><c:out value="${student.dateOfBirth}"/></td>	
			<!--  <td><a href="email?id=${student.id}">EMAIL</a></td>-->
			<!--<form:form action="email" method="post">
			<input type="hidden" value="${student.email}" name="email">	
			<td><input type="submit" value="EMAIL"></td>
			</form:form>-->	
	</tr>
</c:forEach>


</table>
<input type="button" value="Delete" name="DeleteButton" onclick="OnButton(this);">
<input type="button" value="Edit" name="EditButton" onclick="OnButton(this);">
<input type="button" value="Email" name="EmailButton" onclick="OnButton(this);">

</form>	

</body>

	<%
	String msg="<script>document.writeln(jsmessage)</script>";
	out.println(msg);
	 %>
</html>