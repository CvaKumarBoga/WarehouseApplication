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
			<th>ORD CODE</th>
			<th>SHIP CODE</th>
			<th>CUSTOMER</th>
			<th>REF NUMB</th>
			<th>STOCK MODE</th>
			<th>STATUS</th>
			<th>STOCK CODE</th>
			<th>DESCRIPTION</th>
			<th colspan="3">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id}" /></td>
				<td><c:out value="${ob.orderCode}" /></td>
				<td><c:out value="${ob.shipment.shipmentCode}" /></td>
				<td><c:out value="${ob.whuser.userType}" /></td>
				<td><c:out value="${ob.refNumber}" /></td>
				<td><c:out value="${ob.stockMode}" /></td>
				<td><c:out value="${ob.stockSource}" /></td>
				<td><c:out value="${ob.defaultStatus}" /></td>
				<td><c:out value="${ob.note}" /></td>
				<td><a href="delete?id=${ob.id}">DELETE</a>
				<td><a href="edit?id=${ob.id}">EDIT</a>
				<td><a href="view?id=${ob.id}">VIEW</a>
		</c:forEach>
	</table>
	${msg}
</body>
</html>