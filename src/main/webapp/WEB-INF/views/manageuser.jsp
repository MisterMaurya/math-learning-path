<%@include file="adminpage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Control</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">
<style>

</style>
</head>
<body>

<h1
	style="text-align: center; font-size: 30px; font-weight: bold; font-family: 'segoe ui';">Users
	List</h1>
${delete}
<div class="table-responsive" style="color:black">

	<table class="table table-hover table-bordered" >
		<thead>
			<tr>
				<td><b>Name</b></td>
				<td><b>Email</b></td>
				<td><b>Gender</b></td>
				<td><b>Date Of Birth</b></td>
				<td><b>Contact No.</b></td>
				<td><b>Registration Date</b></td>
				<td><b>Registration Time</b></td>
				<td><b>Delete</b></td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="user">
				<tr>

					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.gender}" /></td>
					<td><c:out value="${user.dob}" /></td>
					<td><c:out value="${user.contact}" /></td>
					<td><c:out value="${user.date}" /></td>
					<td><c:out value="${user.time}" /></td>
					<td><a  href="/mathlearningpath/admin/delete?email=${user.email}">Delete</a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>














