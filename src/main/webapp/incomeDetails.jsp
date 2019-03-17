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
		$("#incomeDetailsForm").validate({
			
			submitHandler: function(form) {  
                if ($(form).valid()) {
                	alert("submitted");
                	form.submit(); 	
                }
                return false; // prevent normal form posting
         	},
         	
			rules: {
				employmentType:"required",
				monthlyIncome:{
					required:true,
					  minlength:1,
					  maxlength:10,
					  number:true
				},
				userId:{
					required:true,
					  minlength:1,
					  maxlength:100,
					  number:true
				},
				organisation:"required",
				retirementAge:{
					required:true,
					  minlength:1,
					  maxlength:2,
					  number:true
				},
			},

			messages: {
				userId:"Please enter userId",
				employmentType: "Please enter typeOfEmployment",
				monthlyIncome: "Please enter monthlyIncome",
				organisation:"Please enter organisation",
				retirementAge:"Please enter retirement age"
			}
			
		});

		$('#SubmitForm').click(function() {
        	$("incomeDetailsForm").valid();
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
	<legend align="center"><b><h1>Income Details</h1></b></legend>
		<form id="incomeDetailsForm"  action="controller/incomeDetails"   method="post">
			<b>UserId</b>
				<input type="number" name="userId" placeholder="1"><br><br>
			<b>Type Of Employment</b>
				<input type="radio" name="employmentType" value="salaried">Salaried<br><br>
				<input type="radio" name="employmentType" value="selfEmployed">selfEmployed<br><br>			
			<b>Monthly Income</b>
			<input type="number" name="monthlyIncome" placeholder="50000"><br><br>
			<b>Organisation</b>
			<input type="text" name="organisation" placeholder="Abc"><br><br>
			<b>Retirement Age</b>
			<input type="number" name="retirementAge" placeholder="55"><br><br><br>
				 
			<input id="SubmitForm" 	type="submit" value="SUBMIT"   class="registerbtn">
		</form>
	</fieldset>
</body>
</html>
