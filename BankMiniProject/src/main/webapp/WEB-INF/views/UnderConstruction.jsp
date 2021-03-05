<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.myAlert {
	margin: 20px;
}

.myAlert {
	height: 70px !important;
}
</style>
</head>
<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<p class="text-danger font-weight-bold">Alert message!....</p>
		<div class="alert alert-warning myAlert font-weight-bold">
			<strong>Warning!</strong> This page under construction.Plesae check after some time.
			<button type="button" class="close" data-dismiss="alert">&times;</button>
		</div>
	</div>
</body>
</html>