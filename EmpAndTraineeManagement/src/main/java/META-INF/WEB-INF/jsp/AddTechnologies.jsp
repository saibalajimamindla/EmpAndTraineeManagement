<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Add Employee</h1>
		<form:form action="addintechnolgies" method="post"
			modelAttribute="addTechnology">
			<h2 style="color: navy; font-family: sans-serif;">Register Here</h2>
			<table align="center">
				<tr>
					<td><form:input path="techName" placeholder="NameOfTheTechnology" /></td>
				</tr>
				<tr>

					<td><form:input path="techType" placeholder="TechnologyType" /></td>
				</tr><tr>

					<td><form:input path="techDuration" placeholder="TechnologyDuration" /></td>
				</tr>
				<tr>
					<td><form:input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>