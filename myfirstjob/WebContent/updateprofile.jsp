<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update job seeker profile</title>
</head>
<link rel='stylesheet' type='text/css' media='screen' href='styles/profile.css'>
<link rel='stylesheet' type='text/css' media='screen' href='styles/jsmain.css'>
<%@include file="jobseekerheader.jsp" %>
<body>
 <div id="title">
<h1>update profile</h1>
</div>
	<div id=profile>
		<form action="updateprofile" method="post" enctype="multipart/form-data">
		
			<table >
				<tr class="row">
					<td><label >Highest Qualification:</label></td>
					<td ><input  class="inputs" type="text" name="qualification" required="required" value="${profile.highestQualification}"></td>
				</tr>
				<tr class="row">
					<td><label >UG Percentage:</label></td>
					<td><input class="inputs" type="number" name="ugpercentage"  required="required" value="${profile.ugPercentage }"></td>
				</tr>
				<tr class="row">
					<td><label >10+2 Percentage:</label></td>
					<td><input  class="inputs" type="number" name="plustwopercentage"  required="required" value="${profile.plusTwoPercentage }"></td>
				</tr>
				<tr class="row">
					<td><label >Tenth Percentage:</label></td>
					<td><input class="inputs"  type="number" name="tenthpercentage"  required="required" value="${profile.tenthPercentage }"></td>
				</tr>
				<tr class="row">
					<td><label >Skills Known:</label></td>
					<td><input class="inputs" type="text" name="skills"  required="required" value="${profile.skills }"></td>
				</tr>
				<tr class="row">
					<td><label >Languages You Speak:</label></td>
					<td><input class="inputs" type="text" name="languages"  required="required" value="${profile.languagesKnown }"></td>
				</tr>
				<tr class="row">
					<td><label >Experience:</label></td>
					<td><input class="inputs" type="number" name="experience"  required="required" value="${profile.experience }"></td>
				</tr>
				<tr class="row">
					<td><label >Upload Resume:</label></td>
					<td><input type="file" name="resume"  required="required"></td>
				</tr>
				<tr class="row">
				<td> </td>
				<td><input type="submit" value="Submit Profile" > </td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>