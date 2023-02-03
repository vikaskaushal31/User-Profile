<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>

</head>
<body>
	<h1>Login Page</h1>
	<form>
		EmailId: <input type="text" id="emailId"><br> 
		Password: <input type="password" id="password"><br> 
		OTP: <input type="text" id="otp"><br> 
			<input type="button" value="Submit" onclick="submitForm()"> 
			<input type="button" value="Send Otp" onclick="sendOtp()"> 
			<input type="button" value="Validate Otp" onclick="validateOtp()">
	</form>
</body>
<script>
	function submitForm() {
		var emailId = $('#emailId').val();
		var password = $('#password').val();

		$.ajax({
			type : 'POST',
			url : 'http://localhost:8080/users/createuser',
			data : JSON.stringify({
				emailId : emailId,
				password : password
			}),
			contentType : 'application/json',
			success : function(data) {
				console.log(data);
				// process the response from the server
			},
			error : function(xhr, status, error) {
				console.error(error);
				// handle the error
			}
		});
	}
	function sendOtp() {
		var emailId = $('#emailId').val().toString();

		$.ajax({
			type : 'GET',
			url : 'http://localhost:8080/users/generateotp',
			data : {
				"emailId" : emailId
			},
			contentType : 'application/json',
			success : function(data) {
				console.log(data);
				// process the response from the server
			},
			error : function(xhr, status, error) {
				console.error(error);
				// handle the error
			}
		});
	}
	function validateOtp() {
		var emailId = $('#emailId').val().toString();
		console.log(emailId);
		var otp = parseInt(document.getElementById("otp").value);
		console.log(otp);
		$.ajax({
			type : 'GET',
			url : 'http://localhost:8080/users/validateotp',
			data : {
				"emailId" : emailId,
				"otp" : otp
			},
			contentType : 'application/json',
			success : function(data) {
				console.log(data);
				// process the response from the server
			},
			error : function(xhr, status, error) {
				console.error(error);
				// handle the error
			}
		});
	}
</script>
</html>