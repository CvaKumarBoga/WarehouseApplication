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
   <h3>Welcome to Item Item Page</h3>
	<form:form action="update" method="POST" modelAttribute="item">
		<table>
		<tr>
			<td>ITEM ID   :</td>
			<td><form:input path="id" readOnly="true"/></td>
		</tr>
			<tr>
				<td >ITEM CODE :</td>
				<td><form:input path="itemCode" readOnly="true"/></td>
			</tr>

			<tr>
				<td>ITEM DIMENSIONS :</td>
				</tr>
				<tr>
				<td>W
				<form:input path="itemWidth" size="5" /></td>
				</tr>
				<tr style="margin:auto" >
				<td colspan="2">L
			<form:input path="itemLength" size="5" /></td>
			</tr>
			<tr>
				<td>H
				<form:input path="itemHight" size="5" /></td>
			</tr>

			<tr>
				<td>BASE COST :</td>
				<td><form:input path="itemCost" /></td>
			</tr>

			<tr>
				<td>BASE CURRENCY :</td>
				<td><form:select path="baseCurrency">
						<form:option value="">--SELECT--</form:option>
						<form:option value="inr">INR</form:option>
						<form:option value="usd">USD</form:option>
						<form:option value="aus">AUS</form:option>
						<form:option value="eru">ERU</form:option>
					</form:select></td>
			</tr>
			<tr>
			<td>ITEM UOM</td>
			<td><form:select path="uom.id">
				<form:option value="">-SELECT-</form:option>
				<form:options items="${uoms}" itemLabel="uomModel" itemValue="id"/>
				</form:select></td>
			<tr>
			<td>ORD METH CODE</td>
			<td><form:select path="om.id">
				<form:option value="">-SELECT-</form:option>
				<form:options items="${oms}" itemLabel="orderCode" itemValue="id"/>
				</form:select></td>
				<tr>
			<tr>
				<td><input type="SUBMIT" value="UPDATE"></td>
			</tr>
		</table>
	</form:form>
	${msg}
	<a href="all">view all</a>
</body>
</html>