<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>

<h2>${msg}</h2>
<form action="login" method="post">

UserName:<input type="text" name="userName"><br><br>
Password:<input type="text" name="password"><br>
<input type="submit" value="Submit">
</form>

<form action="addStudent" method="get">
<input type="submit" value="SignUp">
</form>


</body>
</html>