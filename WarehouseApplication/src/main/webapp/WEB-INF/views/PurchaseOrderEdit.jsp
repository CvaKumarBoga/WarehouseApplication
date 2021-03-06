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
<h2>Welcome to PurchaseOrder Edit Page</h2>
<form:form action="update" method="POST" modelAttribute="purchaseOrder">
<table>
<tr>
<td>ID</td>
<td><form:input path="id" readOnly="true"/></td>
</tr>
<tr>
				<td>ORDER CODE</td>
				<td><form:input path="orderCode" /></td>
			</tr>
			<tr>
			<td>SHIPMENT CODE</td>
			<td><form:select path="stype.id">
				<form:option value="">-SELECT-</form:option>
				<form:options items="${shob}" itemLabel="shipmentCode" itemValue="id"/>
				</form:select>
			<tr>
			<td>VENDOR</td>
			<td><form:select path="whuser.id">
				<form:option value="">-SELECT--</form:option>
				<form:options items="${whob}" itemLabel="userType" itemValue="id"/>
				</form:select></td>
			</tr>
			<tr>
				<td>REFERENCE NUMBER</td>
				<td><form:input path="referenceNmber" readOnly="true"/></td>
			</tr>
			<tr>
				<td>QUALITY CHECK</td>
				<td><form:radiobutton path="qualiyCheck" value="required" />Required
				 <form:radiobutton path="qualiyCheck" value="not required" />Not Required</td>
			</tr>
			<tr>
				<td>DEFAULT STATUS</td>
				<td><form:input path="dafaultStatus" value="OPEN" readOnly="true"/></td>
			</tr>
			<tr>
			<td>DESCRIPTION</td>
			<td><form:textarea path="note"/></td>
			</tr>
			<tr>
			<td><input type="submit" value="UPDATE"></td>
			</tr>
</table>
</form:form>
<a href="all">view all</a>
</body>
</html>