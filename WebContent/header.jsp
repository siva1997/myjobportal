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
			<div class="dropdown" >
				<button class="dropbtn">LOGIN</button>
				<div class="dropdown-content" >
					<a href="hrlogin.jsp">HR LOGIN</a>
					<a href="jobseekerlogin.jsp">JOBSEEKER LOGIN</a>
				</div>
			</div>
				<div class="dropdown" >
				<button class="dropbtn">REGISTRATION</button>
				<div class="dropdown-content" >
					<a href="hrregistration.jsp">HR REGISTRATION</a>
					<a href="jobseekerregistration.jsp">JOBSEEKER REGISTRATION</a>
				</div>
			</div>
			</div>
	</header>
</body>
</html>