<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="mystyle.css">
 <script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js"></script>
<script src="resources/additional-methods.min.js"></script> 
<script type="text/javascript">
	$(document).ready(function() {
 				// $("#aadharNo").keyup(function(){
				// 	jQuery.validator.addMethod("numbersOnly", function(value, element) {
				// 		if(/^[0-9\-]+@/i.test(value)) {
				// 			return true;
				// 		} else {
				// 			return false;
				// 		}
							
				// 	}, "Numbers and dashes only!");
				// });
			
		$("#userRegistration").validate({

			submitHandler : function(form) {
				if ($(form).valid()) {
					alert("submitted");
					form.submit();
				}
				return false; // prevent normal form posting
			},

			rules : {
				firstName: {
					lettersonly: true,
					required: true
					},
				lastName : {
					lettersonly: true,
					required: true
					},
				middleName : {
					lettersonly: true,
					required: true
				},
				emailId : {
					required : true,
					email : true
				},
				gender : "required",
				password : {
					required : true,
					minlength : 5,
				},
				confirmPassword : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				},
				dob : "required",
				maritalStatus : "required",

				aadharNo : {
					required : true,
					minlength : 12,
					maxlength : 12,
					pattern: /^[1-9][0-9]$/
				},
				panNo : {
					required : true,
					minlength : 8,
					maxlength : 8,
				},
				mobileNo : {
					required : true,
					minlength : 10,
					maxlength : 10,
					number : true
				},
				question:"required",
				answer:"required"
			},

			messages : {
				firstName:  {
					required: "Enter your first name, please.",
					lettersonly: "Please enter letters only not numbers."
				},												 
				lastName:  {
					required: "Enter your last name, please.",
					lettersonly: "Please enter letters only not numbers."
				},	
				middleName:  {
					required: "Enter your middle name, please.",
					lettersonly: "Please enter letters only not numbers."
				},	
				password : {
					required : "Please provide a password",
					minlength : "Your password must be at least 5 characters long"
				},
				confirmPassword : {
					required : "Please provide a password",
					minlength : "Your password must be at least 5 characters long"
				},
				emailId : "Please enter a valid email address",
				gender : "Please select gender",
				dob : "Please enter dob",
				aadharNo : {
					minlength: "Please enter a 12 digit number",
					pattern: "Please enter only digits"
				},
				panNo : "Please enter Pan Number ",
				mobileNo : "Please enter a valid mobile number",
				question: {
						required: "Please select an option from the list, if none are appropriate please select 'Other'",
						},
				answer:{
						required: "Please answer the question",
				}
			}

		});

		$('#SubmitForm').click(function() {
				
				/* var email = $('#emailId').val();
								
				if(email== ''){
					$('#emailId').next().show();
					return false;
				}
				if(IsEmail(email)==false){
					$('#invalid_emailId').show();
					return false;
				} */
				$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
					$(this).val($(this).val().replace(/[^\d].+/, ""));
						if ((event.which < 48 || event.which > 57)) {
							event.preventDefault();
						}
					});
				$("#userRegistration").valid();
									
		});

	});
	 /* function IsEmail(email) {
	        var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	        if(!regex.test(email)) {
	           return false;
	        }else{
	           return true;
	        }
	      } */
</script>

</head>
<body>
	<fieldset>
		<legend align="center">
			<b><h1>Register</h1></b>
		</legend>

		<form id="userRegistration" action="controller/register" method="post">
					
			<b>FIRSTNAME:</b><input type="text" name="firstName" id="firstName" 	placeholder=" Enter Firstname "><br /> <br /> 
								
			<b>LASTNAME:</b> <input type="text" name="lastName" placeholder=" Enter Lastname "><br /><br />
						
			<b>MIDDLENAME*:</b><input type="text" name="middleName"	placeholder=" Enter Middlename "><br /><br />
							 
			<b>EMAIL ID:</b><input type="text" name="emailId" placeholder=" xyz@gmail.com "><br /><br /> 
			<span class="form_error" id="invalid_emailId">This email is not valid</span></td></tr>			
			
			<b>GENDER:</b> <br>
				<input type="radio" name="gender" value="male"    style="vertical-align: middle">MALE<br>
				<input type="radio" name="gender" value="female" style="vertical-align: middle">FEMALE<br>
				<input type="radio" name="gender" value="others"  style="vertical-align: middle">OTHERS<br><br>
								
			<b>PASSWORD:</b><input type="password" id="password" name="password" placeholder=" ********** "> <br /><br />
						
			<b>CONFIRM PASSWORD:</b><input type="password" id="confirmPassword" name="confirmPassword" placeholder=" **********"> <br />
						
			<br /> <b>DOB:</b><input type="date" name="dob"><br /> <br />
			
			<b>MARITAL STATUS:</b><br /> <br /> 
				<input type="radio" name="maritalStatus" value="married">MARRIED<br /> 
				<input type="radio" name="maritalStatus" value="unmarried">UNMARRIED<br />
				
			<b>AADHAR NO.:</b><input type="text" id="aadharNo"name="aadharNo" placeholder="XXXX-XXXX-XXXX" maxlength="12" class='allownumericwithoutdecimal'><br /><br />
							
			<b>PAN	NO.:</b><input type="text" name="panNo" placeholder=" abx11122 " maxlength="8"><br /><br /> 
			 			 
			<b>MOBILE NO:</b><input type="number" id="mobileNo" name="mobileNo" placeholder=" 1000000000" maxlength="10"><br /><br />
						
			<b>SECURITY QUESTION</b>
			<select name="question" id="question" >
				<option value="">None</option>
				<option value="What is your first pet name?">What is your first pet name?</option>
				<option value="What is your mother's middle name?">What is your mother's middle name?</option>
				<option value="What is your nickname?">What is your nickname?</option>
			</select>
		
			
			<b>ANSWER</b>
			<input type="text" name="answer"  	id="answer" placeholder=" Enter Answer "><br /> <br />
						
			<input type="submit" id="SubmitForm" value="REGISTER" class="registerbtn">

		</form>
	</fieldset>
</body>
</html>