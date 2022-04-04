<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<style>
body {
	text-align: center;
	background-color: powderblue;
}


</style>
</head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<h1>REGISTER</h1>
	<form:form method="post" action="addusersave">			
			<form:input path="username" required="required" placeholder="USERNAME" />
		<br><br>
			<form:input type="password" path="password" required="required"  placeholder="PASSWORD"/>
		<br><br>
			<form:input type="password" path="password" required="required"  placeholder="CONFIRM PASSWORD"/>
		<br><br>
			<form:input type="email" path="username" required="required"  placeholder="EMAIL" />
		<br><br>
			<form:input path="username" required="required"  placeholder="PHONE NUMBER"/>
		<br><br>
		<input type="submit" value="Register" />
		<br><br><br><br>

		<a href="./index.jsp">Back to Home page </a>
	</form:form>
	<br />
	<br />
</body>
</html>