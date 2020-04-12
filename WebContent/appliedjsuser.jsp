<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#jobslist{
padding-left:25%;
padding-top:5%;
}
</style>
<meta charset="ISO-8859-1">
<title>Applied js users</title>
<link rel='stylesheet' type='text/css' media='screen' href='styles/hrmain.css'>
</head>
<body>
  <%@include file="hrheader.jsp" %>
  <div id="jobslist">
  <c:if test="${jsList.size()>0}">
  	<table border="1" bordercolor="blue" >
  		<tr>
  		<th>Full Name</th>
  		<th>Email</th>
  		<th>User Name</th>
  		<th>MObile Number</th>
  		<th>View Profile</th>
  		</tr>
  		
  		<c:forEach var="jsList" items="${jsList }">
  		<tr>
  		    <td>${jsList.fullName}</td>
  		    <td>${jsList.email}</td>
  		    <td>${jsList.userName}</td>
  		    <td>${jsList.mobileNumber}</td>
  		    <td><a href="viewprofile?jsid=${jsList.id}"><button>view Profile</button> </a>
  		    </tr>        
  		</c:forEach>
  		
  	</table>
  	</c:if>
  	<c:if test="${jsList.size()==0 }">
  		<h1>no jobs to display</h1>
  	</c:if>
  	
  </div>
  
</body>
</html>