<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>job seeker welcome</title>
</head>
<style type="text/css">
#jobslist{
padding-left:25%;
padding-top:5%;
}
</style>
<link rel='stylesheet' type='text/css' media='screen' href='styles/jsmain.css'>
<%@include file="jobseekerheader.jsp" %>
<body>
<div id="jobslist">
<c:if test="${jobsList.size()>0}">
	<table border="1" bordercolor="blue">
	<tr>
	<th>designation</th>
	<th>experience</th>
	<th>description</th>
	<th>skills</th>
	<th>employmentType</th>
	<th>salary</th>
	<th>location</th>
	<c:if test="${notapplied==1 }">
	<th>Apply</th>
	</c:if>
	</tr>
	<c:forEach var="jobsList" items="${jobsList}" >
		<tr>
		<td>${ jobsList.designation}</td>
		<td>${ jobsList.experience}</td>
		<td>${ jobsList.description}</td>
		<td>${ jobsList.skills}</td>
		<td>${ jobsList.employmentType}</td>
		<td>${ jobsList.salary}</td>
		<td>${ jobsList.location}</td>
		<c:if test="${notapplied==1 }">
		<td><a href="applyjob?jobid=${jobsList.jobId}"><button>Apply</button></a></td>
		</c:if>
		</tr>
	</c:forEach>
	</table>
	</c:if>
	<c:if test="${notapplied==1 }">
	<c:if test="${jobsList.size()==0}">
		<h1>no jobs to display</h1>
	</c:if>
	</c:if>
	<c:if test="${notapplied==0 }">
	<c:if test="${jobsList.size()==0}">
		<h1>no jobs Applied</h1>
	</c:if>
	</c:if>
	</div>
</body>
</html>