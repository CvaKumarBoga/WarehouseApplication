<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome to WhUser Registration page</h4>
	<form:form action="save" method="POST" modelAttribute="whUserType">
		<table border="1">
			<tr>
				<td>USER TYPE</td>
				<td><form:radiobutton path="userType" value="Vendor" />Vendor
				 <form:radiobutton path="userType" value="Customer" />Customer</td>
			</tr>
			<tr>
				<td>USER CODE</td>
				<td><form:input path="userCode" /></td>
			</tr>
			<tr>
				<td>USER FOR</td>
				<td><form:select path="userFor">
						<form:option value="">--SELECT--</form:option>
						<form:option value="purchase">PURCHASE</form:option>
						<form:option value="sale">SALE</form:option>
					</form:select>
			</tr>
			<tr>
				<td>USER EMAIL</td>
				<td><form:input path="userEmail" /></td>
			</tr>
			<tr>
				<td>USER CONTACT</td>
				<td><form:input path="userContact" /></td>
			</tr>
			<tr>
				<td>USER ID TYPE</td>
				<td><form:select path="userIdtype">
						<form:option value="">--SELECT--</form:option>
						<form:option value="pancard">PANCARD</form:option>
						<form:option value="adhar">ADHAR</form:option>
						<form:option value="voter id">VOTER ID</form:option>
						<form:option value="other">OTHER</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>ID NUMBER</td>
				<td><form:input path="idNumber" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="CREATE USER"></td>
			</tr>
		</table>
	</form:form>
	${msg}
	<a href="all">view all</a>
</body>
</html>