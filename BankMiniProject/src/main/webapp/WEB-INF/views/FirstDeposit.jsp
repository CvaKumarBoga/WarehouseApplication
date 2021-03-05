<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style type="text/css">
.err {
	color: red
}

label {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-2">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<center>
					<h5>WELCOME TO ACCOUNT FIRST DEBIT FORM</h5>
				</center>
			</div>
			<div class="card-body">
				<form:form action="debit" method="post"
					modelAttribute="accountActivities">

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="acNo" class="control-label">A/C NUMBER</label>
						</div>
						<div class="col-5">
							<input type="text" name="acNo" class="form-control"
								placeholder="Enter account number" />
						</div>
					</div>
					<div class="row">
						<div class="col-5"></div>
						<div class="col-4 ">
							<form:errors path="acNo" cssClass="err"></form:errors>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="ifcCode" class="control-label">IFC CODE</label>
						</div>
						<div class="col-5">
							<input type="text" name="ifcCode" class="form-control"
								placeholder="Enter IFC code" />
						</div>
					</div>
					<div class="row">
						<div class="col-5"></div>
						<div class="col-4 ">
							<form:errors path="ifcCode" cssClass="err"></form:errors>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="hdName" class="control-label">NAME OF
								ACCOUNTANT</label>
						</div>
						<div class="col-5">
							<input type="text" name="hdName" class="form-control"
								placeholder="Enter name" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="amount" class="control-label">AMOUNT</label>
						</div>
						<div class="col-5">
							<input type="text" name="amount" class="form-control"
								placeholder="Enter amount" />
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
			<c:if test="${msg !=null}">
				<div class="card-footer bg-primary text-white">${msg}</div>
			</c:if>
		</div>
	</div>

</body>
</html>