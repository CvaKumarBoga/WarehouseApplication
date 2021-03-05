<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<h5>GET ONE EMPLYEE ACCOUNT DETAILS</h5>
				</center>
			</div>

			<div class="card-body">
				<form action="viewone" method="post">
				
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="accountNumber" class="control-label">ACCOUNT
								NUMBER</label>
						</div>
						<div class="col-5">
						<input type="text" name="accountNumber" class="form-control" placeholder="Enter account number">
					</div>
					</div>
					<br>
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2"></div>
						<div class="col-5">
							<input type="submit" value="Submit" class="btn btn-primary" />
						</div>
					</div>
				</form>
			</div>
			<%-- <div class="card-footer">${message}</div> --%>
		</div>
	</div>
</body>
</html>