<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback | Mathlearningpath.com</title>
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
<link href="https://fonts.googleapis.com/css?family=Hi+Melody"
	rel="stylesheet">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/w3.css">
</head>
<body>
	<%@include file="userheader.jsp"%>
	<div class="container">${fsuccess}<br>
	</div>

	<div class="container">
		<div class="row">
			<form:form role="form" cssClass="contact-form"
				modelAttribute="feedback" action="sendfeedback" method="post">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<form:input type="text" path="name" cssClass="form-control"
								autocomplete="off" placeholder="Name*" />
							<form:errors cssClass="error" path="name" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<form:input type="email" cssClass="form-control" path="email"
								autocomplete="off" placeholder="E-mail*" />
							<form:errors cssClass="error" path="email" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<form:textarea cssClass="form-control textarea" rows="3"
								path="msg" id="Message" placeholder="Message*"></form:textarea>
							<form:errors cssClass="error" path="msg" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<button type="submit" Class="btn btn-primary pull-right">Send
							a message</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<br>
	<br>
	
	<br>
	<div class="container">
		<strong class="aboutus-title">Feedbacks</strong>
	</div>

	<c:forEach items="${flist}" var="feedback">
		<div class="w3-container">
			<div class="w3-card-4 pull-right"
				style="width: 30%; border-radius: 5px; font-size: 34px">
				<div class="w3-container "
					style="background-color: #f1f1f1; font-family: 'Hi Melody', cursive;">
					<p>
						<c:out value="${feedback.name}" />
					</p>
				</div>

				<footer class="w3-container ">
				<h5>
					<c:out value="${feedback.msg}" />
				</h5>
				<h6>
					<c:out value="${feedback.date}" />
					<c:out value="${feedback.time}" />
				</h6>
				</footer>
			</div>
		</div>
		<br>
		<br>
	</c:forEach>

	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@include file="footer.jsp"%>

	
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>