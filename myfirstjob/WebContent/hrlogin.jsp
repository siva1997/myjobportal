<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR LOGIN</title>
<link rel='stylesheet' type='text/css' media='screen'
	href='styles/main.css'>
</head>
<%@include file="header.jsp"%>
<body>
	<center>
		<div id="title">
			<h2>HR LOGIN</h2>
		</div>
		<form action="hrlogin" method="post" id="hrlogin">
			${sqlError}
			<table>

				<tr>
					<td><label>Email</label></td>
					<td><input type="email" name="email" required></td>
					<td>${errorMessagges.email}</td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter,
                     and at least 8 or more characters"
						required></td>
					<td>${errorMessagges.password}</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="LOGIN"></td>
				</tr>
			</table>
		</form>
	</center>

</body>

</html>