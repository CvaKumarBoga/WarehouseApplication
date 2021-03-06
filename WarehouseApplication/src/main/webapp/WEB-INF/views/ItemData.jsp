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
	<h3>Welcome to Item Data Page</h3>
 <table border=1>
 	<tr>
 		<th>ID</th>
 		<th>CODE</th>
 		<th>WIDTH</th>
 		<th>LENGTH</th>
 		<th>HIGHT</th>
 		<th>COST</th>
 		<th>CURRENCY</th>
 		<td>UOM</td>
 		<td>ORDER</td>
 		<th colspan=3>OPERATIONS</th>
 	</tr>
 	<c:forEach items="${list}" var="ob">
 	<tr>
 		<td><c:out value="${ob.id}"/></td>
 		<td><c:out value="${ob.itemCode}"/></td>
 		<td><c:out value="${ob.itemWidth}"/></td>
 		<td><c:out value="${ob.itemLength}"/></td>
 		<td><c:out value="${ob.itemHight}"/></td>
 		<td><c:out value="${ob.itemCost}"/></td>
 		<td><c:out value="${ob.baseCurrency}"/></td>
 		<td><c:out value="${ob.uom.uomModel}"/></td>
 		<td><c:out value="${ob.om.orderCode}"/></td>
 		<td><a href="delete?id=${ob.id}">DELETE</a></td>
 		<td><a href="edit?id=${ob.id}">EDIT</a></td>
 		<td><a href="view?id=${ob.id}">VIEW</a></td>
 	</tr>	
 	</c:forEach>       
 </table>	
 ${msg}
</body>
</html>