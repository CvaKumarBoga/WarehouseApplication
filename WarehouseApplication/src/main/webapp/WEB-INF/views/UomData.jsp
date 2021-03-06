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

<h3>WELCOME TO  UOMTYPE DATA</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>TYPE</th>
			<th>MODEL</th>
			<th>NOTE</th>
			<th colspan="3">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id}"/></td>
				<td><c:out value="${ob.uomType}"/></td>
				<td><c:out value="${ob.uomModel}"/></td>
				<td><c:out value="${ob.note}"/></td>
				<td><a href="delete?id=${ob.id}">DELETE</a>
				<td><a href="edit?id=${ob.id}">EDIT</a>
				<td><a href="view?id=${ob.id}">view</a>
				
			</tr>
		</c:forEach>
	</table>
	${msg}
</body>
</html>