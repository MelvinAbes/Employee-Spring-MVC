<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Employees</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>

	<div class="container">
		<p>${message}</p>
		<button class="btn btn-primary"
			onclick="window.location.href='${pageContext.servletContext.contextPath}/employee-add-form'">Add
			Employee</button>

		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-dark">
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Age</th>
				<th>Salary</th>
				<th>Status</th>
				<th>Actions</th>

			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.dob}</td>
					<td>${employee.age}</td>
					<td>${employee.salary}</td>
					<td>${employee.status}</td>
					<td><a
						href="${pageContext.request.contextPath}/employee?action=EDIT&id=${employee.id}">Edit</a>
						| <a
						href="${pageContext.request.contextPath}/deleteEmployee?action=DELETE&id=${employee.id}">Delete</a>


					</td>

				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>