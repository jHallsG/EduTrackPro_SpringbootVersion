<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
    <script src="${pageContext.request.contextPath}/javascript/register.js"></script>
</head>
<body>
	<div class="container">
      <div class="wrapper">
        <div class="title"><span>Login Form</span></div>
        <form:form modelAttribute="userLogin">
          <div class="row">
            <i class="fas fa-user"></i>
            <form:input type="text" placeholder="Email" path="userEmail" name = "username"></form:input>
            <form:errors path="userEmail" cssClass="form-error"/>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <form:input type="password" placeholder="Password" path="password" name="password"></form:input>
            <form:errors path="password" cssClass="form-error"/>
          </div>
          
          <div class="row button">
            <input type="submit" value="Login">
          </div>
          <div class="signup-link">Not a member? <a href="../register/">Signup now</a></div>
        </form:form>
      </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" id="successMessage" value="${successMessage}" />
</body>
</html>