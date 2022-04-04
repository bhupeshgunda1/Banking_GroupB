<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
body{
 	font: 28px Arial, sans-serif;
	text-align: center;
    background-color: powderblue;
}
</style>

</head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
		<h1>LOGIN</h1>
		<form:form method="post" action="logincheck">
					<form:input path="username" required="required" placeholder="USERNAME"/> <br>
					<form:input type= "password" path="password" required="required" placeholder="PASSWORD" /> <br>
			        <input type="submit" value="Login"/> <br> <br>
 			        
			        <a href="registerUser">Sign up </a>
		</form:form>


</body>
</html>