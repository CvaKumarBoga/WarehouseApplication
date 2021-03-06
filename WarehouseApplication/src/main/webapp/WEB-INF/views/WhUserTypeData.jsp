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

	<h3>WELCOME TO SHIPMENT TYPE DATA</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>TYPE</th>
			<th>CODE</th>
			<th>USER</th>
			<th>EMAIL</th>
			<th>CONACT</th>
			<th>ID TYPE</th>
			<th>ID NUMBER</th>
			<th colspan="3">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id}"/></td>
				<td><c:out value="${ob.userType}"/></td>
				<td><c:out value="${ob.userCode}"/></td>
				<td><c:out value="${ob.userFor}"/></td>
				<td><c:out value="${ob.userEmail}"/></td>
				<td><c:out value="${ob.userContact}"/></td>
				<td><c:out value="${ob.userIdtype}"/></td>
				<td><c:out value="${ob.idNumber}"/></td>
				<td><a href="delete?id=${ob.id}">DELETE</a>
				<td><a href="edit?id=${ob.id}">EDIT</a>
				<td><a href="view?id=${ob.id}">VIEW</a>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>