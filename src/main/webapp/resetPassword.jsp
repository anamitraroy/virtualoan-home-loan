<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password Page</title>
<base href="/application-module/">
</head>
<body>
	<form action="controller/update" method="post">
		<c:if test="${error!=null }">
			<p>${error}</p>
		</c:if>
		Enter UserName:<input type="text" name="emailId"><br>
		Enter New Password:<input type="password" name="password"><br>
		Enter Confirm Password:<input type="password" name="confirmPassword"><br>
		<input type="submit" value="Submit">

	</form>
</body>
</html>