<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my-stylesheet.css" />
<link rel = "icon" type ="image/png" href = "${pageContext.request.contextPath}/images/EduTrackPro.png">
</head>
<body>

	<div class="container">
		<div class="row align-items-center">
            <div class="col-auto">
                <a href="./show" class="btn btn-primary">
                	<i class="fas fa-home"></i>
                </a>
            </div>
            
            <div class="col text-center">
                <h1>EduTrackPro</h1>
                <h4>Student Management</h4>
            </div>
        
            <div class="col-auto">
                <a href="${pageContext.request.contextPath}/logout/" class="btn btn-primary">
                	<i class="fa-solid fa-right-from-bracket"></i>
                </a>
            </div>
            
        </div>
		
		<hr>
		<div class="add-search-bar">
			<div class="add-btn">
				<a href="./add">
					<i class="fa fa-plus fa-2x fa-border" aria-hidden="true"></i>
				</a>
			</div>
			<div class="search-bar">
				<form action="search" method="GET">
					<input type="text" name="query" value="${query}" placeholder="Search..."/>
  					<button type="submit" class="btn-search">Search</button>
				</form>
			</div>
		</div>

		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PHONE</th>
				<th>ADDRESS</th>
				<th>ACTION</th>
			</tr>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.phone}</td>
					<td>${student.address}</td>
					<td>
						<a href="./update?userId=${student.id}"><button class="btn btn-edit">Edit</button></a>
						<a href="./delete?userId=${student.id}" class="delete-link"><button class="btn btn-delete">Delete</button></a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	
	<input type="hidden" id="messageSent" value="${messageSent}" />
	<script src="${pageContext.request.contextPath}/javascript/JSFunctions.js"></script>
</body>
</html>