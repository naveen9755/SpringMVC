<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>New Marksheet page</title>
</head>
<body > <h1>New Marksheet page</h1>
	<form:form method="POST" commandName="marksheet" action="${pageContext.request.contextPath}/marksheet/create.html">
		<table >
			<tbody>
				<tr>
					<td> Name:</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Roll no:</td>
					<td><form:input path="rollno" /></td>
					<td><form:errors path="rollno" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Physics:</td>
					<td><form:input path="physics" /></td>
				</tr>
				<tr>
					<td>Chemistry:</td>
					<td><form:input path="chemistry" /></td>
				</tr>
				<tr>
					<td>Maths:</td>
					<td><form:input path="maths" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Create" /></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>