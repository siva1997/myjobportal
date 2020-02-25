<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div id="organisation">
			<h1>MyFirstJob.com</h1>
		</div>
		<div id="links">
			<div id="home">
				<a href="index.jsp"><button>HOME</button></a>
			</div>
			<div>
				<h3>LOGIN</h3>
				<select onchange="myLoginFunction()" id="signin">
					<option value="" index="-1">Select</option>
					<option value="hrlogin.jsp">HR</option>
					<option value="jobseekerlogin.jsp">JobSeeker</option>
				</select>
			</div>
				<div>
				<h3>REGISTER</h3>
				<select onchange="myRegistrationFunction()" id="signup">
				<option value="" index="-1">Select</option>
					<option value="hrregistration.jsp">HR</option>
					<option value="jobseekerregistration.jsp">JobSeeker</option>
				</select>
			</div>
		</div>
	</header>
</body>
</html>