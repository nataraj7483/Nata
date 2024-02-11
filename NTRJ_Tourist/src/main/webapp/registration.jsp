<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Hear</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
 crossorigin="anonymous"></script>


<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
<div class="register-form">
<form action="#" method="post">
<div align="center">Register</div>
<tr><td>Full Name</td><td><input type="text" name="fullname" placeholder="Full Name"></td></tr>
<tr><td>User Name</td><td><input type="text" name="username" placeholder="User Name"></td></tr>
<tr><td>Email</td><td><input type="text" name="email" placeholder="Email"></td></tr>
<tr><td>Password</td><td><input type="password" name="password" placeholder="Password">
<tr><td>confirm Password</td><td><input type="confirmpassword" name="confirm password" placeholder="Confirm Password">

<button type="submit">Register</button>
</form>
</div>
</body>
</html>