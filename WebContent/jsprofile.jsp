<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker Profile</title>
<link rel='stylesheet' type='text/css' media='screen' href='styles/jsmain.css'>
<link rel='stylesheet' type='text/css' media='screen' href='styles/viewprofile.css'>
<%@include file="jobseekerheader.jsp" %>
</head>
<body>
 <div id="title">
<h1>view profile</h1>
</div>
<div id=profile>
    <table >
				<tr class="row">
					<td><label >Highest Qualification</label></td>
					<td><label>:${profile.highestQualification}</label></td>
				</tr>
				<tr class="row">
					<td><label >UG Percentage</label></td>
					<td><label>:${profile. ugPercentage}</label></td>
				</tr>
				<tr class="row">
					<td><label >10+2 Percentage</label></td>
					<td><label>:${profile.plusTwoPercentage}</label></td>
				</tr>
				<tr class="row">
					<td><label >Tenth Percentage</label></td>
					<td><label>:${profile.tenthPercentage }</label></td>
				</tr>
				<tr class="row">
					<td><label >Skills Known</label></td>
					<td><label>:${profile.skills }</label></td>
				</tr>
				<tr class="row">
					<td><label >Languages You Speak</label></td>
					<td><label>:${profile.languagesKnown }</label></td>
				</tr>
				<tr class="row">
					<td><label >Experience</label></td>
					<td><label>:${profile.experience }</label></td>
				</tr>
				<tr class="row">
					<td><label >Resume</label></td>
					<td><a href="${resumePath}"><button>Download</button></a> </td>
				</tr>
				<tr class="row">
				<td> </td>
				<td><label></label></td>
				</tr>
				
			</table>
			</div> 
</body>
</html>