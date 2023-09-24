<%@include file="adminpage.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">

</head>
<body>
	<div class="container ">
		<form:form cssClass="form-horizontal" method="POST" action="savefile"
			modelAttribute="document" enctype="multipart/form-data">
			<div class="row">
				<div class="form-group">
					<label class="col-sm-2 control-label">File Title</label>
					<div class="col-sm-4">
						<form:input type="text" path="fileTitle" cssClass="form-control"
							placeholder="Enter File Title"></form:input>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label class="col-sm-2 control-label">File Category</label>
					<div class="col-sm-4">
						<form:input type="text" path="fileCategory"
							cssClass="form-control" placeholder="Enter File Category"></form:input>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label class="col-sm-2 control-label">File Description</label>
					<div class="col-sm-4">
						<form:input type="text" path="fileDescription"
							cssClass="form-control" placeholder="Enter File Description"></form:input>
					</div>
				</div>
			</div>
<div class="row">
				<div class="form-group">
					<label class="col-sm-2 control-label">Select File</label>
					<div class="col-sm-4">
						<form:input type="file" path="file" id="file" name="file"
							cssClass="form-control" placeholder="select file"></form:input>
					</div>
				</div>
			</div>
<div class="row">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button type="submit" class="btn btn-default">Upload File</button>
					</div>
				</div>
			</div>
		</form:form>
</div>
<h1>Upload Document</h1>
<h4 style="color: red">${msg}${duplicate}${filedelete}</h4>
<div class="table-responsive">
		<table class="table table-hover table-bordered">
			<thead class="text-center">
				<tr>
					<td><b>File Title</b></td>
					<td><b>File Description</b></td>
					<td><b>File Category</b></td>
					<td><b>Delete</b></td>
				</tr>
			</thead>
			<tbody class="text-center">
				<c:forEach items="${list}" var="file">
					<tr>
						<td><c:out value="${file.fileTitle}" /></td>
						<td><c:out value="${file.fileDescription}"/></td>
						<td><c:out value="${file.fileCategory}"/></td>
						<td><a href="/mathlearningpath/admin/filedelete?fileId=${file.fileId}&fileTitle=${file.fileTitle}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<br>
</body>
</html>