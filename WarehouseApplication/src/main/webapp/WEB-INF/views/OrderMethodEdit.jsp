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
<h4>WELCOME TO ORDERMETHOD EDIT PAGE</h4>
	<form:form action="update" method="POST" modelAttribute="orderMethod">
		<table>
		<tr>
				<td>ID </td>
				<td><form:input path="id" readOnly="true" /></td>
			</tr>
			<tr>
				<td>ORDERCODE</td>
				<td><form:radiobutton path="orderMode" value="Sale" />Sale
				 <form:radiobutton path="orderMode" value="Purchase" />Purchase</td>
			</tr>
			<tr>
				<td>ORDERCODE</td>
				<td><form:input path="orderCode" readOnly="true"/></td>
			</tr>
			<tr>
				<td>EXECUTECODE</td>
				<td><form:select path="exeuteType">
						<form:option value="">--SELECT--</form:option>
						<form:option value="fifo">FIFO</form:option>
						<form:option value="lifo">LIFO</form:option>
						<form:option value="fcfo">FCFO</form:option>
						<form:option value="fefo">FEFO</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>ORDER ACCEPT</td>
				<td><form:checkbox path="orderAccept" value="Multi"
						label="Multi-Model" /><br> <form:checkbox path="orderAccept"
						value="Accept" label="Accept Return" /><br> <form:checkbox
						path="orderAccept" value="Service" label="Service Extend" /><br>
				</td>
			</tr>
			<tr>
				<td>DESCRIPTION</td>
				<td><form:textarea path="note" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Order Method"></td>
			</tr>
		</table>
	</form:form>
	${msg}
	<a href="all">view all</a>
</body>
</html>