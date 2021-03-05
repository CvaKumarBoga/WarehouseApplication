<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<center>
					<h5>WELCOME TO ACCOUNTS DETAILS PAGE</h5>
				</center>
			</div>

			<div class="card-body">
				<table class="table table-bordered">
					<thead>
						<tr class="thead-light">
							<th scope="col">A/C NUMBER</th>
							<th scope="col">IFC CODE</th>
							<th scope="col">HOLDER NAME</th>
							<th scope="col">AMOUNT</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="list">
						<tr>
							<td><c:out value="${list.acNo}"></c:out></td>
							<td><c:out value="${list.ifcCode}"></c:out></td>
							<td><c:out value="${list.hdName}"></c:out></td>
							<td><c:out value="${list.amount}"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>