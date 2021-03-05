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
<style type="text/css">
.myAlert {
	margin: 20px;
}

.myAlert {
	height: 50px !important;
}

      marquee{
      color: red;
      font-family: sans-serif;
      }
</style>
</head>
<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<div class="card">
			<div class="card-header bg-info text-white">
				<center>
					<h5>WELCOME TO ACCOUNT DETAILS PAGE</h5>
				</center>
			</div>
			<div class="alert alert-warning myAlert">
				<marquee behavior="scroll" direction="left">Here enter
					your Registration Number and Account Number as sended your official
					Email</marquee>
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			</div>
			<div class="card-body">
				<form action="accountpdf" method="post">
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="serialNo" class="control-label">REGISTRATION
								NUMBER</label>
						</div>
						<div class="col-5">
							<input type="text" name="serialNo" class="form-control"
								placeholder="Enter Registration number" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="accountNumber" class="control-label">ACCOUNT
								NUMBER</label>
						</div>
						<div class="col-5">
							<input type="text" name="accountNumber" class="form-control"
								placeholder="Enter account number" />
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
		</div>
	</div>
</body>
</html>