<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 -->
 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mathlearningpath-home</title>

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
	<%@include file="header.jsp"%>
	<div class="container" style="margin-top: 40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Sign in to continue</strong>
					</div>
					<div class="panel-body">
						<form role="form" action="perform_login" method="POST">
							<fieldset>
								<div class="row">
									<div class="text-center">
										<img class="profile-img"
											src="<%=request.getContextPath()%>/resources/img/profile1.png"
											alt="img">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-user"></i>
												</span> <input class="form-control" placeholder="Username"
													name="email" type="text" autofocus>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-lock"></i>
												</span> <input class="form-control" placeholder="Password"
													name="password" type="password" value="">
											</div>
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block"
												value="Sign in">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
						Don't have an account! <a href="/mathlearningpath/register" onClick="">
							Sign Up Here </a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container text-center">
		<h4 style="color: red">Login failed wrong user credentials!</h4>
	</div>

	<h4 class="text-center" style="color: #dff; font-family: sans-serif">${name}${success}</h4>

	<%@include file="footer.jsp"%>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>