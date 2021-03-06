<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<h3>Welcome to Documents Page!!</h3>
	<form action="upload" method="POST" enctype="multipart/form-data">
		<pre>
	Document : <input type="file" name="fob" />
	<input type="submit" value="Upload" />
</pre>
	</form>
	<table border="1">
		<tr>
			<th>FILE NAME</th>
			<th>LINK</th>
		</tr>
		<c:forEach items="${list}" var="ob">
		<tr>
		<td><c:out value="${ob[1]}"/></td>
		<td><a href="download?fileId=${ob[0]}">DOWNLOAD</a>
		</tr>
		</c:forEach>
	</table>
</body>
</body>
</html>