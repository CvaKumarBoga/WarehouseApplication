<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Menubarjsp.jsp"%>
	<h3>WELCOME TO VIEW ONE ACCOUNT PAGE</h3>
	<table border="1">
		<tr>
			<th>ACCOUNT NUMBER</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>DATE OF BIRTH</th>
			<th>ACCOUNT TYPE</th>
			<th>AMOUNT</th>
			<th>DATE</th>
		</tr>
		</table>
		<table>
		<tr>
			<td>${obj.accountNumber}</td>
			<td>${obj.holderName}</td>
			<td>${obj.holderEmail}</td>
			<td>${obj.dob}</td>
			<td>${obj.accountType}</td>
			<td>${obj.amount}</td>
			<td>${obj.date}</td>
			<td>${obj.date}</td>
		</tr>
	</table>
</body>
</html>