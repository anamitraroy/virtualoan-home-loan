<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script>
	function doSubmit() 
	{ 
		window.open("incomeDetails.jsp","_self"); 
	} 
</script> 

<style>
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
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid grey;
	border-radius: 4px;
}

label {
	cursor: pointer
}

.error {
	color: red;
}

.registerbtn {
	background-color: #4CAF50;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid grey;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}
</style>
</head>
<body>
	<form align="center">
		<input type="button" onclick="doSubmit();" value="APPLY" class="registerbtn">
		<input type="button" onclick="doSubmit();" value="STATUS" class="registerbtn">
	</form>
</body>
</html>