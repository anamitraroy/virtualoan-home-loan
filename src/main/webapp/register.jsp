<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js"></script>
<script src="resources/additional-methods.min.js"></script> 
<script type="text/javascript" src="resources/register1.js"></script>
<link rel="stylesheet" type="text/css" href="mystyle.css">
 </head>
<body>
	<fieldset>
		<legend align="center">
			<b><h1>Register</h1></b>
		</legend>

		<form id="userRegistration" name="userRegistration" action="controller/register" method="post">
					
			<b>FIRSTNAME:</b><input type="text" name="firstName" id="firstName" 	placeholder=" Enter Firstname "><br /> <br /> 
								
			<b>LASTNAME:</b> <input type="text" name="lastName" placeholder=" Enter Lastname "><br /><br />
						
			<b>MIDDLENAME*:</b><input type="text" name="middleName"	placeholder=" Enter Middlename "><br /><br />
							 
			<b>EMAIL ID:</b><input type="text" name="emailId" placeholder=" xyz@gmail.com "><br /><br /> 
						
			<!-- <b>GENDER:</b> <br>
			<label>
				<input type="radio" name="gender" value="male"    style="vertical-align: middle">MALE<br>
			</label>
			<label>	
				<input type="radio" name="gender" value="female" style="vertical-align: middle">FEMALE<br>
			</label>
			<label>
				<input type="radio" name="gender" value="others"  style="vertical-align: middle">OTHERS<br><br>
			</label> -->
								
			<b>GENDER</b>
			<select name="gender" id="gender" >
				<option value="">None</option>
				<option value="MALE">Male</option>
				<option value="FEMALE">Female</option>
				<option value="OTHERS">Others</option>
			</select><br>
			
			<b>PASSWORD:</b><input type="password" id="password" name="password" placeholder=" ********** "> <br /><br />
						
			<b>CONFIRM PASSWORD:</b><input type="password" id="confirmPassword" name="confirmPassword" placeholder=" **********"> <br />
						
			<br /> <b>DOB:</b><input type="date" name="dob"><br /> <br />
			
			<!-- <b>MARITAL STATUS:</b><br /> <br /> 
				<input type="radio" name="maritalStatus" value="married"><label>MARRIED</label><br /> 
				<input type="radio" name="maritalStatus" value="unmarried"><label>UNMARRIED</label><br /> -->
				
			<b>MARITAL STATUS</b>
			<select name="maritalStatus" id="maritalStatus" >
				<option value="">None</option>
				<option value="MARRIED">Married</option>
				<option value="UNMARRIED">Unmarried</option>				
			</select>

				
			<b>AADHAR NO.:</b><input type="text" name="aadharNo" placeholder="XXXX-XXXX-XXXX" maxlength="12" ><br /><br />
							
			<b>PAN	NO.:</b><input type="text" name="panNo" placeholder=" abx11122 " maxlength="8"><br /><br /> 
			 			 
			<b>MOBILE NO:</b><input type="text"  name="mobileNo" placeholder=" 1000000000" maxlength="10"><br /><br />
						
			<b>SECURITY QUESTION</b>
			<select name="question" id="question" >
				<option value="">None</option>
				<option value="What is your first pet name?">What is your first pet name?</option>
				<option value="What is your mother's middle name?">What is your mother's middle name?</option>
				<option value="What is your nickname?">What is your nickname?</option>
			</select>

			<b>ANSWER</b>
			<input type="text" name="answer"  	id="answer" placeholder=" Enter Answer "><br /> <br />
						
			<input type="submit" id="SubmitForm" value="REGISTER" class="registerbtn"  tab index="-1">
		</form>
	</fieldset></body>
</html>