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
							<th scope="col">MOBILE NO</th>
							<th scope="col">EMAIL</th>
							<th scope="col">DOB</th>
							<th scope="col">ACCOUNT TYPE</th>
							<th scope="col">DATE</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="allAccounts">
						<tr>
							<td><c:out value="${allAccounts.accountNumber}"></c:out></td>
							<td><c:out value="${allAccounts.IFCCode}"></c:out></td>
							<td><c:out value="${allAccounts.holderName}"></c:out></td>
							<td><c:out value="${allAccounts.mobileNo}"></c:out></td>
							<td><c:out value="${allAccounts.holderEmail}"></c:out></td>
							<td><c:out value="${allAccounts.dob}"></c:out></td>
							<td><c:out value="${allAccounts.accountType}"></c:out></td>
							<td><c:out value="${allAccounts.date}"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>