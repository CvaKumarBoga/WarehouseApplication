<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<style type="text/css">
label {
	margin-bottom: 22px;
}

.sidebar {
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

/* Sidebar links */
.sidebar a {
	display: block;
	color: blue;
	padding: 16px;
	text-decoration: none;
}

.sidebar a:hover {
	background-color: red;
	color: white;
}

.dropdown-item :hover {
	background-color: red;
}

.navbar-nav .nav-item:hover {
	background-color: DodgerBlue !important;
}

.column.right {
	width: 10%;
	background-color: #012C40;
	color: #ffffff;
}

.section {
	width: 350px;
	float: left;
	padding: 10px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<!-- <nav class="navbar navbar-dark danger-color">
			<nav class="navbar navbar-dark secondary-color"> -->
		<a class="navbar-brand "><img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3QLI980SXhDNKqCRd30rFe4pgr24EK3t-BuWaDZU_zFMu84_I&usqp=CAU"
			width="100" height="50" /></a>
		<!-- Links -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent-555"
			aria-controls="navbarSupportedContent-555" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<ul class="navbar-nav mr-auto ">

			<li class="nav-item active"><a class="nav-link"
				href="${url}/registration/home">Home</a></li>
			<!-- Dropdown -->
			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#" id="nb"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Register
					Here </a>
				<div class="dropdown-menu dropdown-secondary" aria-labelledby="nb">
					<a class="dropdown-item active tab-content"
						href="${url}/registration/show">New Register</a> <a
						class="dropdown-item active" href="${url}/registration/edit">Edit
						Register</a> <a class="dropdown-item active"
						href="${url}/registration/checkstatus">Check Status</a>
				</div></li>
			<li class="nav-item active"><a class="nav-link"
				href="${url}/account/getregistrations">New Applications</a></li>

			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink-4" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Create Account </a>
				<div class="dropdown-menu dropdown-menu-right dropdown-info"
					aria-labelledby="navbarDropdownMenuLink-4">
					<a class="dropdown-item active" href="${url}/account/show">Create
						Account</a> <a class="dropdown-item active" href="${url}/account/all">Get
						Accounts</a> <a class="dropdown-item active" href="#">Check Status</a>
				</div></li>

			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink-4" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Deposit amount</a>
				<div class="dropdown-menu dropdown-menu-right dropdown-info"
					aria-labelledby="navbarDropdownMenuLink-4">
					<a class="dropdown-item active" href="${url}/activities/show">First
						Deposit</a> <a class="dropdown-item active"
						href="${url}/activities/all">Show Accounts</a> <a
						class="dropdown-item active" href="${url}/activities/check">Check
						Balance</a>
				</div></li>

			<li class="nav-item active"><a class="nav-link"
				href="${url}/credit/show">Credit Amount</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="${url}/debitform/show">Debit Amount</a></li>

			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink-4" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Transactions </a>
				<div class="dropdown-menu dropdown-menu-right dropdown-info"
					aria-labelledby="navbarDropdownMenuLink-4">
					<a class="dropdown-item active" href="${url}/transaction/all">Show
						Transactions</a> <a class="dropdown-item active"
						href="${url}/transaction/checktrans">check transactions</a>
				</div></li>

		</ul>
	</nav>


	<!-- Page content -->
	<div class="content"></div>
	<div class="sidebar">
		<a class="active" href="${url}/registration/construction">Home</a> <a
			href="${url}/registration/construction">News</a> <a
			href="${url}/registration/construction">Contact</a> <a
			href="${url}/registration/construction">About</a>
	</div>
	<!-- Page content -->
	<div class="content">..</div>

</body>
</html>