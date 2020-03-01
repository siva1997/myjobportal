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
<title>Hr Welcome Page</title>
</head>
<link rel='stylesheet' type='text/css' media='screen' href='styles/hrmain.css'>
<body>
  <%@include file="hrheader.jsp" %>
  
  <div id="jobslist">
  <c:if test="${jobList!=null }">
  	<table border="1" bordercolor="blue" >
  		<tr>
  		<th>Designation</th>
  		<th>Experience required</th>
  		<th>Job Description</th>
  		<th>Skills Required</th>
  		<th>Employment Type</th>
  		<th>salary</th>
  		<th>Location</th>
  		</tr>
  		
  		<c:forEach var="jobList" items="${jobList }">
  		<tr>
  		    <td>${jobList.designation}</td>
  		    <td>${jobList.experience}</td>
  		    <td>${jobList.description}</td>
  		    <td>${jobList.skills}</td>
  		    <td>${jobList.employmentType}</td>
  		    <td>${jobList.salary}</td>	
  		    <td>${jobList.location }</td>
  		    </tr>        
  		</c:forEach>
  		
  	</table>
  	</c:if>
  	<c:if test="${jobList==null }">
  		<h1>no jobs to display</h1>
  	</c:if>
  	
  </div>
  
  
</body>
</html>