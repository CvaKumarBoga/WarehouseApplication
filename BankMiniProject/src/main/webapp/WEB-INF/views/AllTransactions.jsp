<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<h5>WELCOME TO ALL TRANSACTTIONS PAGE</h5>
				</center>
			</div>

			<div class="card-body">
				<table class="table table-bordered">
					<thead>
						<tr class="thead-light">
							<th scope="col">REF NUMBER</th>
							<th scope="col">A/C NUMBER</th>
							<th scope="col">NAME</th>
							<th scope="col">DATE</th>
							<th scope="col">AMOUNT</th>
							<th scope="col">FINAL AMOUNT</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="list" varStatus="loop">
						<tr>
							<td><c:out value="${list.refNumber}"></c:out></td>
							<td><c:out value="${list.accountNo}"></c:out></td>
							<td><c:out value="${list.name}"></c:out></td>
							<td><c:out value="${list.date}"></c:out></td>

							<td><c:choose>
									<c:when test="${list.type == 'debit' }">
										<a class="text-danger font-weight-bold">+ debit</a>
									</c:when>
									<c:otherwise>
										<a class="text-success font-weight-bold">credit -</a>
									</c:otherwise>
								</c:choose> <c:out value="${list.amount}"></c:out></td>
							<td><c:forEach items="${lst}" var="lst">
									<c:if test="${lst.acNo == list.accountNo }">
										<a><c:out value="${lst.amount}" /></a>
									</c:if>
								</c:forEach></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>