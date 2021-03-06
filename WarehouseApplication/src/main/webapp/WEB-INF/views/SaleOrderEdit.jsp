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
<h2>Welcome to SaleOrder Register Page</h2>
	<form:form action="update" method="POST" modelAttribute="saleOrder">
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
			<td><form:select path="shipment.id">
				<form:option value="">-SELECT-</form:option>
				<form:options items="${stob}" itemLabel="shipmentCode" itemValue="id"/>
				</form:select></td>
				</tr>
				<tr>
			<td>CUSTOMER</td>
			<td><form:select path="whuser.id">
				<form:option value="">-SELECT-</form:option>
				<form:options items="${whob}" itemLabel="userType" itemValue="id"/>
				</form:select></td>
				</tr>
		<tr>
				<td>REF NUMBER</td>
				<td><form:input path="refNumber" /></td>
			</tr>
			<tr>
				<td>STOCK MODE</td>
				<td><form:radiobutton path="stockMode" value="Grade" />GRADE <form:radiobutton
						path="stockMode" value="Margin" />MARGIN</td>
			</tr>
			<tr>
				<td>STOCK SORCE</td>
				<td><form:select path="stockSource">
						<form:option value="">-SELECT-</form:option>
						<form:option value="open">OPEN</form:option>
						<form:option value="avail">AVAIL</form:option>
						<form:option value="refund">REFUND</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>DEFAULT STATUS</td>
				<td><form:input path="defaultStatus" value="SALE-OPEN" /></td>
			</tr>
			<tr>
				<td>DESCRIPTION</td>
				<td><form:textarea path="note" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="UPDATE">
		</table>
	</form:form>
	${msg}
	<a href="all">View All</a>
</body>
</html>