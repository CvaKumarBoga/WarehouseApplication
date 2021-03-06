<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO WHUSER VIEW PAGE</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.userType}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.userCode}</td>
		</tr>
		<tr>
			<th>USER</th>
			<td>${ob.userFor}</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>${ob.userEmail}</td>
		</tr>
		<tr>
			<th>CONTACT</th>
			<td>${ob.userContact}</td>
		</tr>
		<tr>
			<th>ID TYPE</th>
			<td>${ob.userIdtype}</td>
		</tr>
		<tr>
			<th>ID TYPE</th>
			<td>${ob.idNumber}</td>
		</tr>

	</table>
	<pre>
	<a href="delete?id=${ob.id}">DELETE FROM HERE</a>
	<a href="edit?id=${ob.id}">EDIT FROM HERE</a>
	<a href="excel?id=${ob.id}">EXCEL EXPORT</a>
	<a href="pdf?id=${ob.id}">PDF EEPORT</a>
	</pre>
</body>
</body>
</html>