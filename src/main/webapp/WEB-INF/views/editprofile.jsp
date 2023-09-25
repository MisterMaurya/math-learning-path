<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile | Mathlearningpath.com</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css2/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/custom.css">
<link href='https://fonts.googleapis.com/css?family=Aclonica' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Nova Slim' rel='stylesheet'>
</head><body>
<%@include file="userheader.jsp"%>
<div class="center-container">
<div class="w3layouts_main_grid">
		<form action="update" method="post" class="w3_form_post">
			<input type="hidden" name="userid" placeholder="" value=${user.userid}>
			<input type="hidden" name="date" placeholder="" value=${user.date}><input
				type="hidden" name="time" placeholder="" value=${user.time}>
			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Username </label> <input
					type="text" name="name" placeholder="" value="${user.name}">
				</span>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" hidden>
				<span class="agileits_grid"> <label>Email</label> <input
					type="text" name="email" placeholder="" value=${user.email} readonly>
				</span>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Password</label> <input
					type="text" name="password" placeholder=""
					value=${user.password}>
				</span>
			</div>

			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Gender</label> <select
					name="gender">
					<option value=${user.gender}>${user.gender}</option>
					<c:if test="${user.gender=='Male'}">
					<option value="Female">Female</option></c:if>
				
					<c:if test="${user.gender=='Female'}">
					<option value="Male">Male</option></c:if>
					</select>
				</span>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Date of birth</label> <input
					 name="dob"  type="date" placeholder="" value=${user.dob}>
				</span>
			</div>


			<div class="w3_agileits_main_grid w3l_main_grid">
				<span class="agileits_grid"> <label>Contact</label> <input
					type="text" name="contact" placeholder="" value=${user.contact}>
				</span>
			</div>


			<div class="w3_main_grid">
				<div class="w3_main_grid_right">
					<input type="submit" value="Update">
				</div>
			</div>
		</form>
	</div></div>
	
<%@include file="footer.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/css2/jquery-2.1.4.min.js"></script>
 <script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
	</html>