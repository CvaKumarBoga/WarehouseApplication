<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="excel">ExcelExport</a>
	<a href="pdf">PdfExport</a>
	<a href="charts">Charts</a>
	<h4>WELCOME TO ORDERMETHOD DATA</h4>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>MODE</th>
			<th>CODE</th>
			<th>TYPE</th>
			<th>ACCEPT</th>
			<th>DESCR</th>
			<th colspan="3">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id}" /></td>
				<td><c:out value="${ob.orderMode}" /></td>
				<td><c:out value="${ob.orderCode}" /></td>
				<td><c:out value="${ob.exeuteType}" /></td>
				<td><c:out value="${ob.orderAccept}" /></td>
				<td><c:out value="${ob.note}" /></td>
				<td><a href="delete?id=${ob.id}">DELETE</a>
				<td><a href="edit?id=${ob.id}">EDIT</a>
				<td><a href="view?id=${ob.id}">VIEW</a>
		</c:forEach>
	</table>
</body>
</html>