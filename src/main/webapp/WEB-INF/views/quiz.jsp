<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.min.css">
<link href='https://fonts.googleapis.com/css?family=Aclonica'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Nova Slim'
	rel='stylesheet'>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/custom.css">

</head>
</head>
<body>
	<%@include file="adminheader.jsp"%>
 ${addQuiz}
 ${qdelete}

	<form:form method="POST" action="savequiz" modelAttribute="quiz">
    <table>
			<tr>
				<td><form:label path="ques">Question</form:label></td>
				<td><form:textarea path="ques" /></td>
			</tr>
			<tr>
				<td><form:label path="op1">A</form:label></td>
				<td><form:input path="op1" /></td>
			</tr>
			<tr>
				<td><form:label path="op2">B</form:label></td>
				<td><form:input path="op2" /></td>
			</tr>
			<tr>
				<td><form:label path="op3">C</form:label></td>
				<td><form:input path="op3" /></td>
			</tr>
			<tr>
				<td><form:label path="op4">D</form:label></td>
				<td><form:input path="op4" /></td>
			</tr>
			<tr>
				<td><form:label path="res"> Correct Answer</form:label></td>
				<td>
				<form:radiobutton path="res"  value="A"/>A
				<form:radiobutton path="res"  value="B"/>B
				<form:radiobutton path="res"  value="C"/>C 
				<form:radiobutton path="res"  value="D"/>D
				</td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Question" /></td>
			</tr>
		</table>
	</form:form>



<div class="table-responsive" style="color:black">

	<table class="table table-hover table-bordered" >
		<thead>
			<tr>
				<td><b>Question</b></td>
				<td><b>A</b></td>
				<td><b>B</b></td>
				<td><b>C</b></td>
				<td><b>D</b></td>
				<td><b>Correct Answer</b></td>
				<td><b>Delete</b></td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${qlist}" var="quiz">
				<tr>

					<td><c:out value="${quiz.ques}" /></td>
					<td><c:out value="${quiz.op1}" /></td>
					<td><c:out value="${quiz.op2}" /></td>
					<td><c:out value="${quiz.op3}" /></td>
					<td><c:out value="${quiz.op4}" /></td>
					<td><c:out value="${quiz.res}" /></td>
					
					
				
					<td><a  href="/mathlearningpath/admin/quiz/delete?quizid=${quiz.quizid}">Delete</a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<br><br><br>

	<%@include file="footer.jsp"%>
	
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	
</body>
</html>