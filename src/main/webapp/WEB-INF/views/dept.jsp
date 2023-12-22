<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${page }"></c:out></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="./base.jsp" %>
</head>
<body>
	<div class="container pt-5 mt-3 text-center">
		<h1 class="text-center">All Departments</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">dName</th>
					<th scope="col">noOfSeatsAvailable</th>
					<th scope="col">noOfSeatsBooked</th>
					<th scope="col">dHOD</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${departments }" var="dep">
					<tr>
						<th scope="row">${dep.dId }</th>
						<td>${dep.dName }</td>
						<td>${dep.noOfSeatsAvailable }</td>
						<td>${dep.noOfSeatsBooked }</td>
						<td>${dep.dHOD }</td>
						<td><a href="deleteDept/${dep.dId}"><i
								class="fa fa-trash"></i></a></td>
						<td><a href="updateDept/${dep.dId }"><i
								class="fa fa-pencil"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href='<c:url value='/addDept'></c:url>'
			class="list-group-item list-group-item-action">Add Department</a>

		<div>
			<c:if test="${page=='addDept' }">
				<h1 class="text-center">Add</h1>
				<form:form action="saveDept" method="post"
					modelAttribute="department">
					<div class="form-group">
						<form:input path="dId" placeholder="Enter department Id" />
					</div>
					<div class="form-group">
						<form:input path="dName" placeholder="Enter department name" />
					</div>
					<div class="form-group">
						<form:input path="noOfSeatsAvailable"
							placeholder="Enter seats available in the department" />
					</div>
					<div class="form-group">
						<form:input path="noOfSeatsBooked"
							placeholder="Enter seats booked" />
					</div>
					<div class="form-group">
						<form:textarea path="dHOD" placeholder="Enter the name of HOD" />
					</div>
					<div class="container">
						<button class="btn btn-outline-info">Add</button>
					</div>
					<a href='<c:url value='/home'></c:url>'
						class="list-group-item list-group-item-action">Home</a>
				</form:form>

			</c:if>
			<c:if test="${page=='updateDept' }">
				<h1 class="text-center">Update Department</h1>
				<form:form action="${pageContext.request.contextPath }/saveDept"
					method="post" modelAttribute="departmentobj">
					<div class="form-group">
						<label for="dId">ID:</label><br>
						<form:input path="dId" placeholder="Enter department Id"
							value="${departmentobj.dId }" />
					</div>
					<br>
					<div class="form-group">
						<label for="dName">Department Name:</label><br>
						<form:input path="dName" placeholder="Enter department name"
							value="${departmentobj.dName }" />
					</div>
					<br>
					<div class="form-group">
						<label for="noOfSeatsAvailable">No Of Seats Available:</label><br>
						<form:input path="noOfSeatsAvailable"
							placeholder="Enter seats available in the department"
							value="${departmentobj.noOfSeatsAvailable }" />
					</div>
					<br>
					<div class="form-group">
						<label for="noOfSeatsBooked">No Of Seats Booked:</label><br>
						<form:input path="noOfSeatsBooked" placeholder="Enter seats booked"
							value="${departmentobj.noOfSeatsBooked }" />
					</div>
					<br>
					<div class="form-group">
						<label for="dHOD">Department HOD:</label><br>
						<form:textarea path="dHOD" placeholder="Enter the name of HOD"
							value="${departmentobj.dHOD }" />
					</div>
					<br>
					<div class="container">
						<button class="btn btn-outline-info">Update</button>
					</div>
				</form:form>

			</c:if>
		</div>
	</div>
</body>
</html>