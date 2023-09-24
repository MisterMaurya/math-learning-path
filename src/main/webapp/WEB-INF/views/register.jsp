<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register | mathlearningpath.com</title>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css2/style.css" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Anton&amp;subset=latin-ext,vietnamese" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/custom.css">
<link href='https://fonts.googleapis.com/css?family=Aclonica' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Nova Slim' rel='stylesheet'>
</head>
<body>
<%@include file="header.jsp"%>
<h4 class="text-center" style="color: #dff; font-family:sans-serif;">${email}${error}</h4>
<div class="center-container" >

	<div class="w3layouts_main_grid">
		<form:form method="post" modelAttribute="users" action="insert" cssClass="w3_form_post">
			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Username </label> 
				<form:input path="name"  placeholder="ABC"></form:input>
				<form:errors class="error" path="name"/></span>
			</div>

			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label> Email </label> 
				<form:input path="email"  placeholder="abc@gmail.com"></form:input>
					<form:errors class="error" path="email"/> </span>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Password </label>
				 <form:input path="password"  placeholder="*******"></form:input>
				 	 <form:errors class="error" path="password"/>
				 	 </span>
			
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Gender </label>
					<form:select path="gender">
						<form:option value="">Select</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
						
   				</form:select>
   				 <form:errors  class="error" path="gender"/>
				</span>
			</div>
		<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Date Of Birth </label>
				<form:input path="dob" type="date" placeholder="dd-MM-yyyy" value="dd-MM-yyyy"></form:input>
				<form:errors  class="error" path="dob"></form:errors>
				</span>
			</div>
<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Contact no. </label>
				 <form:input path="contact"  placeholder="0777712877"></form:input>
				 <form:errors class="error" path="contact"/></span>
			</div>
		
				<div class="w3_main_grid">
				<div class="w3_main_grid_right">
					<input type="submit" value="Register">
				</div>
			</div>
			
		</form:form>
	</div>
</div>
<br><br><br>
 <%@include file="footer.jsp"%>	
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/css2/jquery-2.1.4.min.js"></script>
<script	src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
<script	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>