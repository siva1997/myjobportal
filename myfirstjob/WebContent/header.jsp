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
				<select  id="signin">
					<option  onclick="myLoginFunction()" value="hrlogin.jsp">HR</option>
					<option onclick="myLoginFunction()" value="jobseekerlogin.jsp">JobSeeker</option>
				</select>
			</div>
				<div>
				<h3>REGISTER</h3>
				<select id="signup">
					<option onclick="myRegistrationFunction()"
						value="hrregistration.jsp">HR</option>
					<option onclick="myRegistrationFunction()"
						value="jobseekerregistration.jsp">JobSeeker</option>
				</select>
			</div>
		</div>
	</header>
</body>
</html>