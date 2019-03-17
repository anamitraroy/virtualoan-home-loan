<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>APPLY</title>
</head>
<style>
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid black;
  border-radius: 4px;
}
form {
	margin: 0 auto;
	width: 300px
}

input {
	margin-bottom: 3px;
	padding: 10px;
	width: 100%;
	border: 1px solid #CCC
}

button {
	width: 100%;
	padding: 10px
}

label {
	cursor: pointer
}



</style>
<body>
	<fieldset>
	<legend align="center"><b><h1>Application</h1></b></legend>
		<form action="controller/application" method="post">
			<b>USERNAME</b><input type="text" name="username"
				placeholder="Enter Username"><br> <br>
			<b>AADHAR NO.</b><input
				type="text" name="aadharNo" placeholder="Enter AadharNo."><br>
			<br>
			<b> AMOUNT</b><input type="text" name="amount"
				placeholder="Enter Amount"><br> <br> <br> <input
				type="submit" value="APPLY">
		</form>
	</fieldset>
</body>
</html>