<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
</head>
<body>
	
	<h2>Add Teacher</h2>
	<div>
		<form:form action="/save-teacher" method="post" modelAttribute="command">
			<label for="name">Name</label>
			<form:input type="text" id="name" path="name" placeholder="Enter Name" />
			<br><br>
			<label for="subject">Subject</label>
			<form:input type="text" id="subject" path="subject" placeholder="Enter Subject" />		
			
			<form:hidden path="id" />
			<br>
			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>