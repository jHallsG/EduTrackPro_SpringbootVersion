<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my-stylesheet.css" />
<link rel = "icon" type ="image/png" href = "${pageContext.request.contextPath}/images/EduTrackPro.png">
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<div class="auth-title">
				<h1>Confirm Logout</h1>
			</div>

			<div class="ok-cancel">
				<a href="${pageContext.request.contextPath}/students/show"><button class="btn bnt-cancel">Cancel</button></a>
				<form action="${pageContext.request.contextPath}/logout/" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button type="submit" class="btn btn-logout">Logout</button>
				</form>
			</div>

		</div>
	</div>
	
	
</body>
</html>