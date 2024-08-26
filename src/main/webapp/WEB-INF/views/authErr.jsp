<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login_register.css">
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<div class="auth-title">
				<h1>Account Authorization</h1>
			</div>
			<hr>
			<form action="./email/requestAuth">
				<p for="textarea">Your account currently does not have the
					authorization required to perform <span style="color: red;">DELETE</span> actions.  If you think this is a
					mistake, or want to request for authorization, send me a message.</p>
				<br>
				<textarea id="textarea" rows="3" cols="52" readonly>${authMessage}></textarea>
				<input type="hidden" name="usermessage" value="${authMessage}">
				<br>
				<div class="row button">
					<input type="submit" value="Send Message">
				</div>
			</form>
		</div>
	</div>
</body>
</html>