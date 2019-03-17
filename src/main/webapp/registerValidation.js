<script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js"></script>
<script src="resources/additional-methods.min.js"></script> 

	$(document).ready(	function() {
				$("#userRegistration").validate(
										{
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
												lastName : 
													{
														lettersonly: true,
											       	 	required: true
													},
												middleName :
												{
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
													number : true
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
												aadharNo : "Please enter Aadhar Number",
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
							
							$("#userRegistration").valid();
													
						});

					});
