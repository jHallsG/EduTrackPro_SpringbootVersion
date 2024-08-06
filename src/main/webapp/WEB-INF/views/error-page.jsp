<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h1> Oopppssss... there seems to be an error. </h1>
	<hr>
	<p> Please try again later or send me the error message </p>
	
	<br>
	<p> Error message: ${error} </p>
	
	<a href="./sendEmail?error=${error}"><button>Send Email</button></a>
	
	
</body>
</html>