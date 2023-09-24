<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${user.name}'s Profile | Mathlearningpath.com</title>
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
	<div class="bg"
		style="background-image:url('<%=request.getContextPath()%>/resources/bootstrap/css/banner.jpg')"></div>
	<div class="container-fluid text-center">
		<h4 class="text-center" style="color: green; font-family:sans-serif"> ${update}${fsuccess}</h4>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="panel text-center">
						<h1>You Are Creative</h1>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel">
						<h1>You Are Amazing</h1>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel">
						<h1>You Are Smart</h1>
					</div>
				</div>

			</div>

		</div></div>
		<%@include file="footer.jsp"%>
		<br><br><br>
		<script
			src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
			<script src="https://apis.google.com/js/platform.js" async defer></script>
			
</body>
</html>