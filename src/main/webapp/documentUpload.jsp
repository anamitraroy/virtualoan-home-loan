<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="/virtuloan-home-loan/">
<title>Document Upload</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<form action="controller/documentUpload" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend align="center">
			<b><h1>Upload Documents</h1></b>
		</legend>
		<label class="fileContainer">
		<b>Aadhar No :</b><br><input type="file" name="aadharCard" /> <br>
				
		<b>Voter Id :</b><br><input type="file" name="voterId" /> <br>
				
		<b>Salary Slip :</b><br><input type="file" name="salarySlip" /> <br>
			
		<b>LOA :</b><br><input type="file" name="letterOfAgreement" /> <br>
			
		<b>NOC from Builder :</b><br><input type="file" name="noc" /> <br>
			
		<b>Agreement To Sale :</b><br><input type="file" name="agreement" /> <br><br>
		
		<input type="submit" id="SubmitForm" value="SUBMIT" class="registerbtn"> 
		</label>
		</fieldset>
</form>
</body>
</html>