<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<form name="frm" action="save" method="POST">
		<label for="name">NAME</label>
		<input type="text" name="name" value=""/> <br> <br>
		<label for="email">EMAIL</label>
		<input type="text" name="email" value=""/> <br> <br>
		<label for="contact">CONTACT</label>
		<input type="text" name="contact" value=""/> <br> <br>
		<input type="Submit" name="registerBtn" value="Register"/> <br> <br>
	</form>
</body>
</html>