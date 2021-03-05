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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style type="text/css">

label {
	margin-bottom: 22px;
}

</style>
</head>
<body>
<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<div class="card">
			<div class="card-header bg-info text-white">
				<center>
					<h5>User Registration Form!!....</h5>
				</center>
			</div>
			<div class="card-body">
				<form action="create" method="post" enctype="multipart/form-data">

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="name" class="control-label">NAME</label>
						</div>
						<div class="col-5">
							<input type="text" name="name" class="form-control"
								placeholder="Enter name" />
						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-3"></div>
						<label for="fob" class="col-sm-2 col-form-label">PHOTO</label>

						<div class="col-sm-5">
							<div class="custom-file">
								<input type="file" class="custom-file-input" name="fob" /> <label
									class="custom-file-label" for="fob">Choose file...</label>
							</div>
						</div>
					</div>
					<script>
						$(".custom-file-input").on(
								"change",
								function() {
									var fileName = $(this).val().split("\\")
											.pop();
									$(this).siblings(".custom-file-label")
											.addClass("selected")
											.html(fileName);
									alert('The file "' + fileName +  '" has been selected.');
								});
					</script>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="emailId" class="control-label">EMAIL ID</label>
						</div>
						<div class="col-5">
							<input type="text" name="emailId" class="form-control"
								placeholder="Enter email id" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="phoneNo" class="control-label">PHONE NO</label>
						</div>
						<div class="col-5">
							<input type="text" name="phoneNo" class="form-control"
								placeholder="Enter phone no" />
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="dob" class="control-label">DATE OF BIRTH</label>
						</div>
						<div class="col-5">
							<input type="text" name="dob" class="form-control"
								placeholder="Enter date of birth" />
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
				</form>
			</div>
			<c:if test="${msg !=null}">
				<div class="card-footer bg-info text-white">${msg}</div>
			</c:if>
		</div>
	</div>
</body>
</html>