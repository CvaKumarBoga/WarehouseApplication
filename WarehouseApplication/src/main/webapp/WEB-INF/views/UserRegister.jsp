<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to User Register page</h3>
<form:form action="save" method="POST" modelAttribute="user">
<table>
	<tr>
		<td>NAME</td>
		<td><form:input path="userName"/></td>
	</tr>
	<tr>
		<td>EMAIL</td>
		<td><form:input path="userEmail"/></td>
	</tr>
	<tr>
	<td>PASSWORD</td>
	<td><form:password path="userPwd"/></td>
	</tr>
	<tr>
		<td>ROLES</td>
		<td><form:checkbox path="roles" value="ADMIN"/>ADMIN
		<form:checkbox path="roles" value="MANAGER"/>MANAGER</td>
	</tr>
	<tr>
	<td><input type="submit" value="REGISTER"></td>
	</tr>
</table>
</form:form>
${msg}
</body>
</html>