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
			<div class="card-header bg-info text-white">
				<center>
					<h5>WELCOME TO ACCOUNT CREATION FORM</h5>
				</center>
			</div>
			<div class="card-body">
				<form:form action="create" method="post"
					modelAttribute="accountEntity">

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="serialNo" class="control-label">SERIAL NUMBER</label>
						</div>
						<div class="col-5">
							<input type="text" name="serialNo" value="${obj.id}"
								class="form-control" readonly="readonly" />
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

					<div class="row">
						<div class="col-5"></div>
						<div class="col-4 ">
							<form:errors path="accountNumber" cssClass="err"></form:errors>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="IFCCode" class="control-label">IFC CODE</label>
						</div>
						<div class="col-5">
							<input type="text" name="IFCCode" class="form-control"
								placeholder="Enter IFC code" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="holderName" class="control-label">ACCOUNTANT
								NAME</label>
						</div>
						<div class="col-5">
							<input type="text" name="holderName" value="${obj.name}"
								class="form-control bg-light" readonly="readonly"
								class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="mobileNo" class="control-label">MOBILE NO</label>
						</div>
						<div class="col-5">
							<input type="text" name="mobileNo" value="${obj.phoneNo}"
								readonly="readonly" class="form-control bg-light" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="holderEmail" class="control-label">EMAIL ID</label>
						</div>
						<div class="col-5">
							<input type="text" name="holderEmail" value="${obj.emailId}"
								class="form-control bg-light" readonly="readonly" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="dob" class="control-label">DATE OF BIRTH</label>
						</div>
						<div class="col-5">
							<input type="text" name="dob" value="${obj.dob}"
								class="form-control bg-light" readonly="readonly" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="accountType" class="control-label">ACCOUNT
								TYPE</label>
						</div>
						<div class="col-5">
							<select name="accountType" class="form-control">
								<option value="">--SELECT--</option>
								<option value="saving account">SAVING ACCOUNT</option>
								<option value="current account">CURRENT ACCOUNT</option>
								<option value="NRI account">NRI ACCOUNT</option>
								<option value="Company account">COMPANY ACCOUNT</option>
							</select>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="address" class="control-label">ADDRESS</label>
						</div>
						<div class="col-5">
							<textarea class="form-control" name="address" rows="3"></textarea>
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
				<div class="card-footer bg-info text-white">${msg}</div>
			</c:if>
		</div>
	</div>
</body>
</html>