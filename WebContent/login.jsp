<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>YongIn LMS</h3>
	<form action="login.do" method= "post">
	ID : <input type="text" name="id" /><br>
	PASSWORD : <input type="password" name="pwd" /><br>
	<input type="radio" name="user" value="Professor"/>Professor
	<input type="radio" name="user" value="Student"/>Student
	<input type="submit" value="LogIn"/>
	</form>
</body>
</html>