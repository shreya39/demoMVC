<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="./base.jsp"%>
<title><c:out value="${page }"></c:out></title>
</head>

<body>
	<div class="container mt-3">
		<div style="background-color: LightGray; width: 100%">
			<h1 class="text-center">Registration Page</h1>
		</div>
		<div class="row mt-4">
			<div class="col-md-5">
				<h3 class="text-center">Options</h3>
				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active">
						Menu</button>
					<a href='<c:url value='/add'></c:url>'
						class="list-group-item list-group-item-action">Add Student</a> <a
						href='<c:url value='/home'></c:url>'
						class="list-group-item list-group-item-action">View Student</a> <a
						href='<c:url value='/departments'></c:url>'
						class="list-group-item list-group-item-action">Departments</a>
				</div>
			</div>
			<div class="col-md-10">
				<c:if test="${page=='home' }">
					<h1 class="text-center">All students</h1>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">NAME</th>
								<th scope="col">DEPARTMENT</th>
								<th scope="col">ADDRESS</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${students }" var="stu">
								<tr>
									<th scope="row">${stu.sId }</th>
									<td>${stu.sName }</td>
									<td>${stu.sDept }</td>
									<td>${stu.address }</td>
									<td><a href="deletestudent/${stu.sId}"><i
											class="fa fa-trash"></i></a></td>
									<td><a href="updatestudent/${stu.sId }"><i
											class="fa fa-pencil"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</c:if>

				<c:if test="${page=='add' }">
					<h1 class="text-center">Add student</h1>
					<form:form action="savestudent" method="post"
						modelAttribute="student">
						<div class="form-group">
							<form:input path="sId" placeholder="Enter student Id" />
						</div>
						<div class="form-group">
							<form:input path="sName" placeholder="Enter student name" />
						</div>
						<div class="form-group">
							<form:input path="sDept" placeholder="Enter student department" />
						</div>
						<div class="form-group">
							<form:textarea path="address" placeholder="Enter student address" />
						</div>
						<div class="container">
							<button class="btn btn-outline-info">Add</button>
						</div>
					</form:form>

				</c:if>
				<c:if test="${page=='updatestudent' }">
					<h1 class="text-center">Update Student</h1>
					<form:form action="${pageContext.request.contextPath }/savestudent"
						method="post" modelAttribute="studentobj">
						<div class="form-group">
							<label for="sId">ID:</label><br>
							<form:input path="sId" placeholder="Enter student Id"
								value="${studentobj.sId }" />
						</div>
						<br>
						<div class="form-group">
							<label for="sName">Student Name:</label><br>
							<form:input path="sName" placeholder="Enter student name"
								value="${studentobj.sName }" />
						</div>
						<br>
						<div class="form-group">
							<label for="sDept">Student Department:</label><br>
							<form:input path="sDept"
								placeholder="Enter the student department"
								value="${studentobj.sDept }" />
						</div>
						<br>
						<div class="form-group">
							<label for="address">Address :</label><br>
							<form:input path="address"
								placeholder="Enter address"
								value="${studentobj.address }" />
						</div>
						<br>
						<div class="container">
							<button class="btn btn-outline-info">Update</button>
						</div>
					</form:form>

				</c:if>
			</div>
		</div>
	</div>
</body>
</html>