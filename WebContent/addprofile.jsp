<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add job seeker profile</title>
</head>
<link rel='stylesheet' type='text/css' media='screen' href='styles/profile.css'>
<body>
<div id="title">
<h1>Fill Your Profile Details</h1>
</div>
	<div id=profile>
		<form action="addjobseekerprofile" method="post" enctype="multipart/form-data">
			<table >
				<tr class="row">
					<td><label >Highest Qualification:</label></td>
					<td ><input  class="inputs" type="text" name="qualification" required="required"></td>
				</tr>
				<tr class="row">
					<td><label >UG Percentage:</label></td>
					<td><input class="inputs" type="number" name="ugpercentage"  required="required"></td>
				</tr>
				<tr class="row">
					<td><label >10+2 Percentage:</label></td>
					<td><input  class="inputs" type="number" name="plustwopercentage"  required="required"></td>
				</tr>
				<tr class="row">
					<td><label >Tenth Percentage:</label></td>
					<td><input class="inputs"  type="number" name="tenthpercentage"  required="required"></td>
				</tr>
				<tr class="row">
					<td><label >Skills Known:</label></td>
					<td><input class="inputs" type="text" name="skills"  required="required"></td>
				</tr>
				<tr class="row">
					<td><label >Languages You Speak:</label></td>
					<td><input class="inputs" type="text" name="languages"  required="required"></td>
				</tr>
				<tr class="row">
					<td><label >Experience:</label></td>
					<td><input class="inputs" type="number" name="experience"  required="required"></td>
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