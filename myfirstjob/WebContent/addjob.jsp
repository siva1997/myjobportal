<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
</head>
<link rel='stylesheet' type='text/css' media='screen'  href='styles/hrmain.css'>
<%@include file="hrheader.jsp"%>
<body>
     <br><br><br><br><br><br><br>
	<div id="jobdetails">
		<form action="addjob"  method="get">
			<table style="background-color: aqua;" align="center"  >
				<tr >
					<td><label class="lables" >Designation</label></td>
					<td><input class="boxes" type="text" name="designation" required="required"></td>
				</tr>
				<tr >
					<td><label class="lables">Experience</label></td>
					<td><input class="boxes" type="text" name="experience" required="required"></td>
				</tr>
				<tr>
					<td><label class="lables">Description</label></td>
					<td><textarea name="description" rows="5" cols="25" required="required"></textarea> </td>
				</tr>
				<tr >
					<td><label class="lables">Skills Required</label> </td>
					<td><textarea  name="skills" rows="3" cols="25"></textarea> </td>
				</tr>
				<tr >
					<td><label class="lables">Employment Type</label></td>
					<td><input class="boxes" type="text" name="employmenttype" required="required"></td>
				</tr>
				<tr>
					<td><label class="lables">Salary</label></td>
					<td><input class="boxes" type="text" name="salary" required="required"></td>
				</tr>
				<tr>
					<td><label class="lables">Location</label></td>
					<td><input class="boxes" type="text" name="location" required="required"></td>
				</tr>
				<tr>
					<td></td>
					<td><input  type="submit" value="ADD JOB" >  </td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>