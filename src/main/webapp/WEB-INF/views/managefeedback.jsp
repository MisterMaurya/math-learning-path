<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="adminpage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Feedback | Mathlearningpath.com</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

</head>
<body>

${fdelete}

<div class="table-responsive" style="color:black">

	<table class="table table-hover table-bordered" >
		<thead>
			<tr>
				<td><b>Name</b></td>
				<td><b>Email</b></td>
				<td><b>Date</b></td>
				<td><b>Time</b></td>
				<td><b>Message</b></td>
				<td><b>Delete</b></td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${flist}" var="feedback">
				<tr>

					<td><c:out value="${feedback.name}" /></td>
					<td><c:out value="${feedback.email}" /></td>
					<td><c:out value="${feedback.date}" /></td>
					<td><c:out value="${feedback.time}" /></td>
				    <td><c:out value="${feedback.msg}" /></td>
					<td><a  href="/mathlearningpath/admin/feedback/delete?id=${feedback.id}">Delete</a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


	
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>