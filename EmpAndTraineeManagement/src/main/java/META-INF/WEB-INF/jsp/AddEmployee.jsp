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
		<form:form action="register" method="post"
			modelAttribute="addEmployee">
			<h2 style="color: navy; font-family: sans-serif;">Register Here</h2>
			<table align="center">
				<tr>

					<td><form:input path="empId" placeholder="EmployeeId" /></td>
				</tr>
				<tr>

					<td><form:input path="empName" placeholder="EmployeeName" /></td>
				</tr>
				<tr>

					<td><form:input path="dateOfJoining"
							placeholder="DateOfJoining" /></td>
				</tr>
				<tr>

					<td><form:input path="trainingTrack"
							placeholder="TrainingTrack" /></td>
				</tr>
				<tr>

					<td><form:input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>