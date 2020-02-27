<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hr registration</title>
<link rel='stylesheet' type='text/css' media='screen' href='styles/main.css'>
</head>
<%@include file="header.jsp" %>
<body>
    <center>
    <div id="title">
        <h2>HR REGISTRATION</h2>
    </div>
    <form action="hrregistration" method="post">
        
            <table>
                <tr>
                    <td><label>Organisation</label></td>
                    <td><input type="text" name="organisation" required></td>
                </tr>
                <tr>
                    <td><label>UserName</label></td>
                    <td><input type="text" name="username" required></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td><label>Mobile Number</label></td>
                    <td><input type="tel" name="mobile" placeholder="ex-9999999999" 
                        pattern="[0-9]{10}" required></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <td><input type="password"  name="password" 
                    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                    title="Must contain at least one number and one uppercase and lowercase letter,
                     and at least 8 or more characters" required></td>
                </tr>
                <tr>
                    <td><label>Confirm Password</label></td>
                    <td><input type="password"  name="confirmpassword" 
                    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                    title="Must contain at least one number and one uppercase and lowercase letter,
                     and at least 8 or more characters" required></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="register"></td>
                </tr>
            </table>
        </center>
    </form>
     <script src='main.js'></script>
</body>
</html>