<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/my-stylesheet.css" />

</head>
<body>
	<div class="container">
		<h1>${title} Student</h1>
		<hr>

		<div class="center">
			<form:form action="submit" modelAttribute="addStudent" method="POST">
				<!--  required for data binding for "UPDATE" info feature -->
				<form:hidden path="id" />
				<!--  form:input type = "hidden" path = "id" -->

				<div>
					<label for="name"> Name </label>
					<form:input name="name" path="name" class="form-control" required="true"></form:input>
					<form:errors path = "name" class="form-error"></form:errors> 
				</div>
				<br>

				<div>
					<label for="phone"> Phone </label>
					<form:input name="phone" path="phone" class="form-control" required="true"></form:input>
					<form:errors path = "phone" cssClass="form-error"></form:errors> 
				</div>
				<br>

				<div>
					<label for="address"> Address </label>
					<form:input name="address" path="address" class="form-control" required="true"></form:input>
					<form:errors path = "address" cssClass="form-error"></form:errors> 
				</div>
				
				<br>
				
				<input type="submit" value="Submit" class="btn"></input>
			</form:form>
		</div>
	</div>

</body>
</html>