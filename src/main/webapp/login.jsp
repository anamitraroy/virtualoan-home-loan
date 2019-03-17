<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">

<script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js"></script>
<script src="resources/additional-methods.min.js"></script> 
<script type="text/javascript" src="resources/login.js"></script>



</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>

<body>
	<center>
		<form id="LoginForm" action="controller/login" method="post">
			Enter User Name: <input type="text" class="form-control text"
				name="emailId" /> <br /> <br /> Enter Password: <input
				type="password" class="form-control text" name="password" /><br />
			<br /> <input type="submit" id="SubmitForm" class="registerbtn" 
				value="Login" tab index="-1" />
		</form>
	</center>
	<center>
		<a href="register.jsp">Register</a><br>
		 <a href="getUserName.jsp">Forgot Password?</a>

	</center>

</body>
</html>