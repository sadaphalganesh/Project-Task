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

<script type="text/javascript" language="JavaScript">
function confirmpopup(){
 var a=confirm("Are you sure to login")

if(a==true){
alert("you pressed ok")
}
else{
alert("you pressed no")}
}
</script>

<form action="login" method="post">
UserName:<input type="text" name="userName"><br><br>
Password:<input type="text" name="password"><br>
<input type="submit" value="Submit" onclick="confirmpopup()">
</form>

<form action="signup" method="get">
<input type="submit" value="SignUp" >
</form> 
<br><br>
<a href="adminLogin" >adminLogin</a>
</body>
</html>