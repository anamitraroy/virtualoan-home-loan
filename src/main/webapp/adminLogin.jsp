<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="/virtuloan-home-loan/">
<title>Admin Login</title>
</head>
<script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js" ></script>
<script>
	 $(document).ready(function() {
			$("#loginForm").validate({
				rules: {
					userName: "required",
					password: "required"
				},
				messages:{
					userName: "Please enter a username",
					password: "Please provide a password"
				}
			});
			
			$('#submitBtn').click(function() {
				$("#loginForm").valid();
			});
	}); 

</script>
<style>
	input[type=text], input[type=password],input[type=number], input[type=email] , input[type=date]{
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  box-sizing: border-box;
	  border: 2px solid grey;
	  border-radius: 4px;
	}
	
	form {
	  margin:0 auto;
	  width:300px
	}
	input {
	  margin-bottom:3px;
	  padding:10px;
	  width: 100%;
	  border:1px solid #CCC
	}
	button {
	   width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  box-sizing: border-box;
	  border: 2px solid grey;
	  border-radius: 4px;
	}
	label {
		cursor: pointer
	}
	
	.submitBtn {
	  background-color: #4CAF50;
	  padding: 12px 20px;
	  margin: 8px 0;
	  box-sizing: border-box;
	  border: 2px solid grey;
	  cursor: pointer;
	  width: 100%;
	  opacity: 0.9;
	}
	
	.submitBtn:hover {
	  opacity: 1;
	}
	
	.error {
		color: red;
	}
</style>
<body>
<fieldset>
<form action="controller/adminLogin"  method="post" id="loginForm">
	Admin Login <br/>
	Username: <input type="text" name="userName"> <br/> 
	Password: <input type="password" name="password"> <br/> 
	<input type="submit" value="Login" id="submitBtn" class="submitBtn">
	<p>hello</p>
</form>
</fieldset>
</body>
</html>