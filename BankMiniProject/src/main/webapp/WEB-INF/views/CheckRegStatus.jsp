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
				<form action="getone" method="post">

					<div class="row">
						<div class="col-1">
							<label for="id" class="control-label">ID</label>
						</div>
						<div class="col-2">
							<input type="text" name="id" class="form-control"
								placeholder="Enter your id">
						</div>
						<div class="col-2">
							<label for="phoneNo" class="control-label">MOBILE NUMBER</label>
						</div>
						<div class="col-2">
							<input type="text" name="phoneNo" class="form-control"
								placeholder="Enter your mobile no">
						</div>
						<div class="col-1"></div>
						<input type="submit" value="Submit" class="btn btn-primary" />
					</div>
				</form>
				<br /> <br />

				<c:if test="${!empty obj}">
						<table class="table table-bordered">
							<thead>
								<tr class="thead-light">
									<th scope="col">ID</th>
									<th scope="col">NAME</th>
									<th scope="col">EMAIL</th>
									<th scope="col">PNONE</th>
									<th scope="col">PHOTO</th>
									<th scope="col" class="text-danger">STATUS*</th>
									<th scope="col">OPERATIONS</th>
								</tr>
							</thead>
							<tr>
								<td><c:out value="${obj.id}" /></td>
								<td><c:out value="${obj.name}" /></td>
								<td><c:out value="${obj.emailId}" /></td>
								<td><c:out value="${obj.phoneNo}" /></td>
								<td><img width="100" height="100"
									src="getphoto/<c:out value='${obj.id}'/>"></td>

								<td><c:choose>
										<c:when test="${obj.status == 'REQUEST STATE' }">
											<a class="text-danger font-weight-bold"><span
												class="blinking">REQUEST STATE</span></a>
										</c:when>
										<c:otherwise>
											<a class="text-success font-weight-bold">APPROVE STATE</a>
										</c:otherwise>
									</c:choose></td>

								<td><c:choose>
										<c:when test="${obj.status == 'APPROVE STATE' }">
											<a href="check"
												class="btn btn-success">A/C DETAILS</a>
										</c:when>
										<c:otherwise>
											<a class="text-primary font-weight-bold">PROCESSING</a>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>