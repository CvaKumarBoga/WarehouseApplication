<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO UOMTYPE VIEW PAGE</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		</tr>
		<tr>
			<th>MODE</th>
			<td>${ob.uomType}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.uomModel}</td>
		</tr>
		<tr>
			<th>note</th>
			<td>${ob.note}</td>
		</tr>
	</table>
	<pre>
	<a href="delete?id=${ob.id}">DELETE FROM HERE</a>
	<a href="edit?id=${ob.id}">EDIT FROM HERE</a>
	<a href="excel?id=${ob.id}">EXCEL EXPORT</a>
	<a href="pdf?id=${ob.id}">PDF EEPORT</a>
	</pre>
</body>
</html>