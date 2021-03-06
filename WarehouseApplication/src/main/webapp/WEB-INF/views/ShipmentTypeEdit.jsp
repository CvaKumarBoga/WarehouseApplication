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
<h3>WELCOME TO SHIPMENT REGISTER PAGE</h3><hr/>
	<form:form action="update" method="POST" modelAttribute="shipmentType">
		<table>
		<tr>
				<td>ID </td>
				<td><form:input path="id" readOnly="true"/></td>
			</tr>
			<tr>
				<td>SHIPMENT MODE   </td>
				<td><form:select path="shipmentMode">
						<form:option value="">--SELECT--</form:option>
						<form:option value="air">AIR</form:option>
						<form:option value="truck">TRUCK</form:option>
						<form:option value="ship">SHIP</form:option>
						<form:option value="train">TRAIN</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>SHIPMENT CODE   </td>
				<td><form:input path="shipmentCode" readOnly="true"/></td>
			</tr>
			<tr>
				<td>ENABLE SHIPMENT </td>
				<td><form:select path="enableShipment">
						<form:option value="">--SELECT--</form:option>
						<form:option value="yes">YES</form:option>
						<form:option value="no">NO</form:option>
					</form:select></td>
			</tr>
			<tr><td>SHIPMENT GRADE  </td>
				<td><form:radiobutton path="shipmentGrade" value="A" />A 
				<form:radiobutton path="shipmentGrade" value="B" />B
			    <form:radiobutton path="shipmentGrade" value="C" />C</td>
			</tr>
			<tr>
				<td>DESCRIPTION</td>
				<td><form:textarea path="note"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="UPDATE" /></td>
			</tr>

		</table>
	</form:form>
	<a href="all">view all</a>
</body>
</html>