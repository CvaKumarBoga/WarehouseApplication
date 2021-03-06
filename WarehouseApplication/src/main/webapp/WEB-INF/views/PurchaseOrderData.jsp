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
	<h4>Welcome to PurchaseOrder Data Page</h4>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>CODE</th>
			<th>SCODE</th>
			<th>VENDOR</th>
			<th>NUMBER</th>
			<th>QUALITY</th>
			<th>STATUS</th>
			<th>DESCRIPTION</th>
			<th colspan="3">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id}" /></td>
				<td><c:out value="${ob.orderCode}" /></td>
				<td><c:out value="${ob.stype.shipmentCode}"/></td>
				<td><c:out value="${ob.whuser.userType}"/></td>
				<td><c:out value="${ob.referenceNmber}" /></td>
				<td><c:out value="${ob.qualiyCheck}" /></td>
				<td><c:out value="${ob.dafaultStatus}" /></td>
				<td><c:out value="${ob.note}" /></td>
				<td><a href="delete?id=${ob.id}">DELETE</a>
				<td><a href="edit?id=${ob.id}">EDIT</a>
				<td><a href="view?id=${ob.id}">VIEW</a>
		</c:forEach>
	</table>
	${msg}
</body>
</html>