<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${user.name}'sScore | Mathlearningpath.com</title>

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
<style type="text/css">
#score {
	border-radius: 60%;
	border: 1px solid black;
	width: 200px;
	height: 300px;
	padding-top: 120px;
left: 500px;
}
</style>
</head>
<body>
	<%@include file="userheader.jsp"%>


	<div class="container text-center">
	<center>	<h1 id="score">
			${score}/5
		</h1></center><br>

		<p>
			<a class="btn btn-primary btn-lg" href="/mathlearningpath/user/playquiz"
				role="button">Play Again</a>
		</p>
	</div>


	<br></br>
	<%@include file="footer.jsp"%>

	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>