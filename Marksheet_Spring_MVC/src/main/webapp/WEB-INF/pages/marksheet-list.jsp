<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Marksheet List page</title>
</head>
<body><center>
	<h1>Marksheet List page</h1>
	<table style="text-align: center;" border="1px" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>
				<th width="50px">id</th>
				<th width="50px">name</th>
				<th width="50px">rollno</th>
				<th width="75px">physics</th>
				<th width="75px">chemistry</th>
				<th width="50px">maths</th>
				<th width="75px">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="marksheet" items="${marksheetList}">
				<tr>
					<td>${marksheet.id}</td>
					<td>${marksheet.name}</td>
					<td>${marksheet.rollno}</td>
					<td>${marksheet.physics}</td>
					<td>${marksheet.chemistry}</td>
					<td>${marksheet.maths}</td>
					<td><a
						href="${pageContext.request.contextPath}/marksheet/edit/${marksheet.id}.html">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/marksheet/delete/${marksheet.id}.html">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/">Home page</a>
	</center>
</body>
</html>