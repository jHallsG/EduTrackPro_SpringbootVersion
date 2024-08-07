<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login_register.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
	<div class="container">
      <div class="wrapper">
        <div class="title"><span>Registration Form</span></div>
        <form:form action="submitRegistration" modelAttribute="userRegistration">
          <div class="row">
            <i class="fas fa-user"></i>
            <form:input type="text" placeholder="Email" path="userEmail"/>
            <form:errors path="userEmail" class="form-error"/>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <form:input type="password" placeholder="Password" path="password"/>
            <form:errors path="password" class="form-error"/>
          </div>
          
          <div class="row button">
            <input type="submit" value="Register">
          </div>
          
        </form:form>
      </div>
    </div>
</body>
</html>