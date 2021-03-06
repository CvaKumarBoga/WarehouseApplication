<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO ITEM VIEW PAGE</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.itemCode}</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${ob.itemWidth}</td>
		</tr>
		<tr>
			<th>LENGTH</th>
			<td>${ob.itemLength}</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${ob.itemHight}</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${ob.itemCost}</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${ob.baseCurrency}</td>
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