<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers</title>
</head>
<body>
	<div>
		<a href="/add-teacher">Add Teacher</a>
		<br>
		
		<c:if test="${teachers.size()==0 }">
			<h2>No Records Found !!</h2>
		</c:if>
		
		<c:if test="${teachers.size() gt 0 }">
			<div>
				<table border="2" cellpadding="2" width="70%"> 
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Subject</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="teacher" items="${teachers}">
							<tr>
								<td>${teacher.id}</td>
								<td>${teacher.name}</td>
								<td>${teacher.subject}</td>
								<td><a href="/teacher-update/${teacher.id }">Edit</a></td>
								<td><a href="/teacher-delete/${teacher.id }">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</body>
</html>