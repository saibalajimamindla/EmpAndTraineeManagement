<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title><style>
<style>
input {
	border-radius: 5px;
	height: 25px;
	border-bottom-color: black;
	border-left-style: hidden;
	border-right-style: hidden;
	border-top-style: hidden;
	background-color: pink;
}
</style>
</head>
<body>
<div style="text-align: center; padding-bottom: 20px; background-color: #ffe6e6; padding-top: 15px;">
<form:form action="login" method="get"><!-- we can use @RequestParam annotation to get email and password to valid if not using security --> 
			<h2 style="color: navy; font-family: sans-serif;">Login</h2>
			<table>
				<tr>
					<td><input type="email" placeholder="EmailID" /></td>
				</tr>
				<tr>
					<td><input type="password" placeholder="Password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form:form>

</div>
</body>
</html>