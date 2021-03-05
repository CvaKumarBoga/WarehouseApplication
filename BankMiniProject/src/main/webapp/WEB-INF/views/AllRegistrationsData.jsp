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
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.blinking {
	animation: blinkingText 1.2s infinite;
}

@
keyframes blinkingText { 1000%{
	color: red;
}
100%{
color






:



 



red






;
}
0%{
color






:



 



red






;
}
99%{
color






:transparent






;
}
100%{
color






:



 



#000






;
}
}
</style>
</head>
<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="container mr-4">
		<div class="card">
			<div class="card-header bg-info text-white">
				<center>
					<h5>WELCOME TO ALL APPLICANTS DATA!!</h5>
				</center>
			</div>

			<div class="card-body">
				<table class="table table-bordered">
					<thead>
						<tr class="thead-light">
							<th scope="col">ID</th>
							<th scope="col">NAME</th>
							<th scope="col">EMAIL</th>
							<th scope="col">PHONE</th>
							<th scope="col">PHOTO</th>
							<th scope="col" class="text-danger">STATUS*</th>
							<th scope="col">OPERATIONS</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="applicants">
						<tr>
							<td><c:out value="${applicants[0]}" /></td>
							<td><c:out value="${applicants[1]}" /></td>
							<td><c:out value="${applicants[2]}" /></td>
							<td><c:out value="${applicants[3]}" /></td>
							<td><img width="100" height="100"
								src="getphoto/<c:out value='${applicants[0]}'/>"></td>

							<td><c:choose>
									<c:when test="${applicants[5] == 'REQUEST STATE' }">
										<a class="text-danger font-weight-bold"><span
											class="blinking">REQUEST STATE</span></a>
									</c:when>
									<c:otherwise>
										<a class="text-primary font-weight-bold">APPROVE STATE</a>
									</c:otherwise>
								</c:choose></td>

							<td><c:choose>
									<c:when test="${applicants[5] == 'APPROVE STATE' }">
										<a class="btn btn-success text-white">CREATED</a>
									</c:when>
									<c:otherwise>
										<a href="getone?id=${applicants[0]}" class="btn btn-primary">CREATE
											A/C</a>
										<a href="construction" class="btn btn-danger">REJECTED</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>