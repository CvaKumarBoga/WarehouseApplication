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
	<form action="type" method="post">

		<table>
			<tr>
				<td>Account Type</td>
				<td><form:select path="accountType">
						<form:option value="">--SELECT--</form:option>
						<form:option value="saving account">SAVING</form:option>
						<form:option value="current account">CURRENT</form:option>
						<%-- <form:options items="${list}" /> --%>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${!empty list}">
		<c:forEach items="list" var="list"></c:forEach>
		<table>
			<thead>
				<tr>
					<th>NAME</th>
				</tr>
			</thead>
			<tr>
				<td><c:out value="${list.holderName}" /></td>
			</tr>
		</table>
	</c:if>
</body>
</html>