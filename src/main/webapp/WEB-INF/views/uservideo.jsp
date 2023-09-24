<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stream Tutorial | mathlearningpath.com</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/custom.css">
<link href='https://fonts.googleapis.com/css?family=Aclonica'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Nova Slim'
	rel='stylesheet'>

</head>
<body>
	<%@include file="userheader.jsp"%>
	<div class="table-responsive">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<td><b>Video Title</b></td>
					<td><b>Video Description</b></td>
					<td><b>Video Category</b></td>
					<td><b>select</b></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="file">
					<tr>
						<td><c:out value="${file.videoTitle}" /></td>
						<td><c:out value="${file.videoDescription}"/></td>
						<td><c:out value="${file.videoCategory}" /></td>
						<td><a href="${file.fileLocation}" target="_blank">View</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp"%>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>


