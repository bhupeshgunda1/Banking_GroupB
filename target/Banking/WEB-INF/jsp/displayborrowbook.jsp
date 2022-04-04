<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Borrow Book</title>
</head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
@charset "ISO-8859-1";

.center {
	display: block;
	margin-top: 20px;
	margin-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
	background-color: powderblue;
}

form {
	border: 3px solid #f1f1f1;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 10%;
	border-radius: 25%;
}

.container {
	padding: 16px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.containerCenter {
	padding: 10px;
	display: block;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

/* menu */
.navbar {
	border-radius: 10px;
	overflow: hidden;
	background-color: #335;
}

.navbar a {
	border-radius: 10px;
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: #1B5BD2;
}

.dropdown-content {
	border-radius: 18px;
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.imgcontainer {
	text-align: center;
	margin: 10px 0 10px 0;
	padding: 2px 2px 2px 2px;
}
</style>



<body>



	<div class="container">

		<div class="navbar">

			<div class="dropdown">
				<button class="dropbtn">Home</button>
				<div class="dropdown-content">
					<a href="home">Home Page</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Member</button>
				<div class="dropdown-content">
					<a href="memberform">Add Member</a> <a href="viewmember">View
						Member</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Publisher</button>
				<div class="dropdown-content">
					<a href="publisherform">Add Publisher</a> <a href="viewpublisher">View
						Publisher</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Book</button>
				<div class="dropdown-content">
					<a href="bookform">Add Book</a> <a href="viewbook">View Book</a> <a
						href="borrowbook">Issue Book</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">User</button>
				<div class="dropdown-content">
					<a href="registerUser">Add User</a> <a href="viewuser">View
						User</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Logout</button>
				<div class="dropdown-content">
					<a href="index.jsp">Logout</a>
				</div>
			</div>
		</div>

		<h1>Borrow Book List</h1>
		<table class="containerCenter" border="2" width="50%" cellpadding="2">
			<tr bgcolor="#f58e0f">
				<th>Issue Book ID</th>
				<th>Book ID</th>
				<th>Author</th>
				<th>Title</th>
				<th>Price</th>
				<th>Available</th>
				<th>Member ID</th>
				<th>Issue Date</th>
				<th>Return Date</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="issuebook" items="${list}">
				<tr bgcolor="#f5f50f">
					<td>${issuebook.issuebookid}</td>
					<td>${issuebook.bookid}</td>
					<td>${issuebook.author}</td>
					<td>${issuebook.title}</td>
					<td>${issuebook.price}</td>
					<td>${issuebook.available}</td>
					<td>${issuebook.membid}</td>
					<td>${issuebook.issuedate}</td>
					<td>${issuebook.returndate}</td>
					<td><a href="editissuebook/${issuebook.issuebookid}">Edit</a></td>
					<td><a href="deleteissuebook/${issuebook.issuebookid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="bookform">Add New Book</a> <a href="borrowbook">Borrow
			Book</a> <a href="displayborrowbook">Display Borrow List</a>
	</div>



</body>
</html>