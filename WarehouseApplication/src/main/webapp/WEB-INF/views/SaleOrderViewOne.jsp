<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SALEORDER VIEW PAGE</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.orderCode}</td>
		</tr>
		<tr>
			<th>SHIPCODE</th>
			<td>${ob.shipment.shipmentCode}</td>
		</tr>
		<tr>
			<th>CUSTOMER</th>
			<td>${ob.whuser.userType}</td>
		</tr>
		<tr>
			<th>REF NUM</th>
			<td>${ob.refNumber}</td>
		</tr>
		<tr>
			<th>STOCK MODE</th>
			<td>${ob.stockMode}</td>
		</tr>
		<tr>
			<th>STOCK SURCE</th>
			<td>${ob.stockSource}</td>
		</tr>
		<tr>
			<th>STATUS</th>
			<td>${ob.defaultStatus}</td>
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