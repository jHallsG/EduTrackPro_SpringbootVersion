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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/my-stylesheet.css" />

</head>
<body>

	<div class="container">
		<h1>EduTrackPro</h1>
		<h4>Student Management</h4>
		<hr>
		<div class="add-search-bar">
			<div class="add-btn">
				<a href="./add"><button class="btn">Add</button></a>
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
						<a href="./delete?userId=${student.id}" onClick="if(!confirm('Confirm delete?')) return false"><button class="btn btn-delete">Delete</button></a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>