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
			<div class="card-header bg-info text-white">
				<center>
					<h5>CHECK USER STATUS PAGE!!..</h5>
				</center>
			</div>

			<div class="card-body">
				<form action="checkbalance" method="post">

					<div class="row">
						<div class="col-2">
							<label for="acNo" class="control-label">ACCOUNT NUMBER</label>
						</div>
						<div class="col-1"></div>
						<div class="col-3">
							<input type="text" name="acNo" class="form-control"
								placeholder="Enter account number">
						</div>
						<div class="col-2"></div>
						<input type="submit" value="Submit" class="btn btn-primary" />
					</div>
				</form>
				<br /> <br />

				<c:if test="${!empty ac}">
						<table class="table table-bordered">
							<thead>
								<tr class="thead-light">
									<th scope="col">A/C NUMBER</th>
									<th scope="col">IFC CODE</th>
									<th scope="col">NAME</th>
									<th scope="col" class="text-danger">AMOUNT</th>
								</tr>
							</thead>
							<tr>
								<td><c:out value="${ac.acNo}" /></td>
								<td><c:out value="${ac.ifcCode}" /></td>
								<td><c:out value="${ac.hdName}" /></td>
								<td><c:out value="${ac.amount}"></c:out>
							</tr>
						</table>
				</c:if>
			</div>
		</div>
	</div>
</body>

</html>