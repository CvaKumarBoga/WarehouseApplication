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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style>
.err {
	color: red
}

label {
	margin-bottom: 20px;
}

input[type="radio"] {
	margin-left: 0;
}

.form-check-label {
	margin-left: 20px;
}
</style>
</head>
<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<center>
					<h5>WELCOME TO DEBIT AMOUNT FORM</h5>
				</center>
			</div>
			<div class="card-body">
				<form:form action="debit" method="post" modelAttribute="debitEntity">

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="debitAccountNo" class="control-label">ACCOUNT
								NUMBER</label>
						</div>
						<div class="col-5">
							<input type="text" name="debitAccountNo" class="form-control"
								placeholder="Enter To account number" />
						</div>
					</div>
					<div class="row">
						<div class="col-5"></div>
						<div class="col-4 ">
							<form:errors path="debitAccountNo" cssClass="err"></form:errors>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="IFCCode" class="control-label">IFC CODE</label>
						</div>
						<div class="col-5">
							<input type="text" name=IFCCode class="form-control"
								placeholder="Enter current location" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="debitType" class="control-label">DEBIT TYPE</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="debitType"
								value="ToCash"> <label class="form-check-label"
								for="debitType"> TO CASH </label>
						</div>

						<div class="form-check">
							<input class="form-check-input" type="radio" name="debitType"
								value="ToAccount"> <label class="form-check-label"
								for="debitType"> TO ACCOUNT </label>
						</div>
					</div>
					
					<script>
						$(function() {
							$('input[name="debitType"]').on('click',
									function() {
										if ($(this).val() == 'ToAccount') {
											$('#customCheckbox').show();
										} else {
											$('#customCheckbox').hide();
										}
									});
						});
					</script>

					<div class="row" id="customCheckbox" style="display: none">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="fromAccount" class="control-label">FROM
								ACCOUNT</label>
						</div>
						<div class="col-5">
							<input type="text" name="fromAccount" class="form-control"
								placeholder="Enter From account number" />
						</div>
					</div>
					<div class="row">
						<div class="col-5"></div>
						<div class="col-4 ">
							<form:errors path="fromAccount" cssClass="err"></form:errors>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="debitAmount" class="control-label">AMOUNT</label>
						</div>
						<div class="col-5">
							<input type="text" name="debitAmount" class="form-control"
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