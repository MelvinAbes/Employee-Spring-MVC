<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<body>
	<div class="container">
	
	

        	<form:form action="updateEmployee" modelAttribute="employee">
		  	Enter name: <form:input path="name" /><br/>
			Enter email: <form:input path="email" /><br/> 
			Enter date of birth: <form:input type="date" path="dob" /><br/>
			Enter Salary: <form:input path="salary" /><br/>
			Enter status: <form:input path="status" /><br/>
			<input type ="hidden" value ="${employee.id}" name="id" /> 
			<button class="btn btn-primary" type:"submit">Save Employee</button>
			</form:form>
		
	</div>
</body>
</html>