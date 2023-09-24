<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Play Quiz | mathlearningpath.com</title>
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
	<style>
	.question{
    background: #75ba48;
    padding: 20px;
    color: #fff;
    border-bottom-right-radius: 55px;
    border-top-left-radius: 55px;
    width: 30%;

    
}body{
background: #222222;
  font-family: 'Lato', sans-serif;}
label{

left:30%;
  display: block;
  position: relative;
  font-weight: 300;
  font-size: 1.35em;
  padding: 25px 25px 25px 80px;
  margin: 10px auto;
  height: 30px;
   color:white;
}
.btn{ border-bottom-right-radius: 15px;
    border-top-left-radius: 15px;
    background-color: #222222;
    color: white;
    border: 2px solid #75ba48;
}
.btn:HOVER{
color:white;
 background-color: #75ba48;
}
.counter{
float:left;
padding: 5px;
	
	</style>

</head>
<body  style="">
<%@include file="userheader.jsp"%>


  
<form action="quiz/score"
method="post">  
<c:forEach items="${list}" var="playquiz" varStatus='counter'>
    <center> <div class="question"><h2 class="counter">${counter.count}).</h2><h2 class="text-center">${playquiz.ques} </h2></div></center>
      <input type="hidden"  value="${playquiz.quizid}" name="id${counter.count}">
      <label>A  <input type="radio"  value="A" name="r${counter.count}" />&nbsp${playquiz.op1}</label>
      <label>B  <input type="radio"  value="B" name="r${counter.count}"/>&nbsp${playquiz.op2}</label>
      <label>C  <input type="radio"  value="C" name="r${counter.count}"/>&nbsp${playquiz.op3}</label>
      <label>D <input type="radio"   value="D" name="r${counter.count}"/>&nbsp${playquiz.op4}</label><br>
   </c:forEach>
	<center><input type="submit" value ="submit" class="btn btn-lg"></center>
	   </form>
	 <br><br><br><br></br>
<%@include file="footer.jsp"%>
		
		<script
			src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>