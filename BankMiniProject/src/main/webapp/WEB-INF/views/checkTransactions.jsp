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
				<form action="check" method="post">

					<div class="row">
						<div class="col-2">
							<label for="accountNo" class="control-label">Account
								Number</label>
						</div>
						<div class="col-1"></div>
						<div class="col-3">
							<input type="text" name="accountNo" class="form-control"
								placeholder="Enter account number">
						</div>
						<div class="col-1"></div>
						<input type="submit" value="SubmitA/C" class="btn btn-primary" />
					</div>
				</form>
				<br /> <br />
				<c:if test="${!empty list}">
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
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>