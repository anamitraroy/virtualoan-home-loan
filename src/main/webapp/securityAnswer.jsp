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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Answer Page</title>
<base href="/application-module/">
</head>
<body>
<center>
<h3>
Security Questions is:<b>  ${ userDetails.question} </b>
</h3>
</center>
<center>
<form id="LoginForm" action ="controller/getanswer" method="post">
<c:if test="${error!=null }">
<p> ${error}</p>
</c:if>
Enter Answer:<input type="text" name="answer" class="form-control text">
<input type="submit" value="Submit"  id="SubmitForm" class="registerbtn"  tab index="-1" >
</form>
</center>
</body>
</html>