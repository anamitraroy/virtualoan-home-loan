<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Income Details</title>
</head>
<script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js"></script>
<script>
$(document).ready(function() {
		$("#LoanApplicationForm").validate({
			
			submitHandler: function(form) {  
                if ($(form).valid()) {
                	alert("submitted");
                	form.submit(); 	
                }
                return false; // prevent normal form posting
         	},
         	
			rules: {
				propertyName:"required",
				propertyLocation:"required",
				estimatedAmount:{
					  required:true,
					  minlength:1,
					  maxlength:10,
					  number:true
				},
				duration:{
					  required:true,
					  minlength:1,
					  maxlength:300,
					  number:true
				},
				loanAmount:{
					  required:true,
					  minlength:1,
					  maxlength:10,
					  number:true
				},
			},

			messages: {
				propertyName:"Please enter property name",
				propertyLocation: "Please enter property location",
				estimatedAmount: "Please enter estimated amount",
				duration:"Please enter the duartion",
				loanAmount:"Please enter loan amount"
			}
			
		});

		$('#SubmitForm').click(function() {
        	$("LoanApplicationForm").valid();
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

.error{
	color:red;
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
<body>
	<fieldset>
	<legend align="center"><b><h1>Loan Application</h1></b></legend>
		<form id="LoanApplicationForm"  action="controller/loanDetails"  method="post">
			<b>Property Name</b>
				<input type="text" name="propertyName" placeholder="Lodha"><br><br>
			<b>Property Location</b>
				<input type="text" name="propertyLocation" placeholder="Andheri"><br><br>
			<b>Estimated Amount</b>
			<input type="number" name="estimatedAmount" placeholder="50000"><br><br>
			<b>Duration</b>
			<input type="number" name="duration" placeholder="2"><br><br>
			<b>Loan Amount</b>
			<input type="number" name="loanAmount" placeholder="50000"><br><br><br>
				 
			<input id="SubmitForm" 	type="submit" value="SUBMIT" class="registerbtn">
		</form>
	</fieldset>
</body>
</html>
