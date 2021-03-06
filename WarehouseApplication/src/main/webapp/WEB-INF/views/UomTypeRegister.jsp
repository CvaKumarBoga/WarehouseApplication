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
<h3>WELCOME TO UOM REGISTER PAGE</h3><hr/>
<form:form action="save" method="POST" modelAttribute="uomType">
		<table border="1">
			<tr>
				<td>UOM TYPE   </td>
				<td><form:select path="uomType">
						<form:option value="">--SELECT--</form:option>
						<form:option value="packing">PACKING</form:option>
						<form:option value="no packing">NO PACKING</form:option>
						<form:option value="na">-NA-</form:option>
					</form:select></td>
			</tr>
			<tr>
			<td>UOM MODEL</td>
			<td><form:input path="uomModel"/></td>
			</tr>
			<tr>
			<td>DESCRIPTION</td>
			<td><form:textarea path="note"/></td>
			</tr>
			<tr>
			<td><input type="submit" value="CreateUom"></td>
			</tr>
			</table>
			</form:form>
			${msg}
			<a href="all">View All</a>

</body>
</html>