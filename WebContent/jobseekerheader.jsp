<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jobseeker header</title>
</head>
<body>
	 <header>
		<div id="organisation">
			<h1>MyFirstJob.com</h1>
		</div>
		<div id="links">
				<a href="editprofile"><button>Update profile</button></a>
				<a href="displayprofile"><button>view profile</button></a>
				<a href="displayjobs?notapplied=0"><button>Applied jobs</button></a>
				<a href="displayjobs?notapplied=1"><button>view jobs</button></a>
				<a href="jobseekerlogout"><button>Logout</button></a>
			</div>
	</header>
</body>
</html>