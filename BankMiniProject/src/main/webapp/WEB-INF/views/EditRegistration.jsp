<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
.col-6 {
	margin-bottom: 7px;
	margin-top: 7px;
}

input[type="text"] {
	margin-bottom: 7px;
}

fieldset {
	margin-left: 100%;
	margin-right: 100%;
	border: 3px solid black;
}

fieldset {
	margin-left: 10%;
	margin-right: 10%;
	border: 3px solid black;
}
</style>
</head>
<body>
<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<div class="card">
			<div class="card-header bg-info text-white">
				<center>
					<h5>WELCOME TO EDIT REGISTRATION PAGE!!..</h5>
				</center>
			</div>
			<div class="card-body">
				<form:form action="editpage" method="post">

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="id" class="control-label">ID</label>
						</div>
						<div class="col-5">
							<input type="text" name="id" class="form-control"
								placeholder="Enter your id">
						</div>
					</div>
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="phoneNo" class="control-label">MOBILE NUMBER</label>
						</div>
						<div class="col-5">
							<input type="text" name="phoneNo" class="form-control"
								placeholder="Enter your mobile no">
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
				</form:form>
			</div>
			<c:if test="${err !=null}">
				<div class="card-footer bg-info text-white">${err}</div>
			</c:if>
		</div>
	</div>
</body>
</html>