<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document Upload</title>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
		Id: <input type="text" name="id" /> <br> 
		Document: <input type="file" name="document" /> <br> 
		<input type="submit" name="submit" value="Upload"> <br>
	</pre>
	</form>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Download Link</th>
		</tr>
		<c:forEach items="${documents}" var="document">
			<tr>
				<td>${document.id}</td>
				<td>${document.name}</td>
				<td><a href="download?id=${document.id}">Download</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>