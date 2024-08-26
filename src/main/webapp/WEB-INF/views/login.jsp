<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login_register.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<script src="${pageContext.request.contextPath}/javascript/register.js"></script>
<link rel = "icon" type ="image/png" href = "${pageContext.request.contextPath}/images/EduTrackPro.png">
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<div class="title">
				<span>Login Form</span>
			</div>
			
			<div class = "login-error">
				<c:if test="${param.error != null}">
					<i style="color: red;">Invalid login credentials</i>
				</c:if>
			</div>
			
			<form:form action = "submitLogin" modelAttribute="userLogin" method = "POST">
				<div class="row">
					<i class="fas fa-user"></i>
					<form:input type="text" placeholder="Email" path="userEmail" required = "true"></form:input>
					<form:errors path="userEmail" cssClass="form-error" />
				</div>
				<div class="row">
					<i class="fas fa-lock"></i>
					<form:input type="password" placeholder="Password" path="password" required = "true"></form:input>
					<form:errors path="password" cssClass="form-error" />
				</div>

				<div class="row button">
					
					<input type="submit" value="Login">
				</div>
				<div class="signup-link">
					Not a member? <a href="../register/">Signup now</a>
				</div>
			</form:form>
		</div>
	</div>
	<input type="hidden" id="successMessage" value="${successMessage}" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<script src="${pageContext.request.contextPath}/javascript/JSFunctions.js"></script>
</body>
</html>