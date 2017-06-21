<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#g1").click(function() {
			$("#teacher_form").attr("style", "display: none;");
			$("#student_form").removeAttr("style");
		});
		
		$("#g2").click(function() {
			$("#student_form").attr("style", "display: none;");
			$("#teacher_form").removeAttr("style");
		});
		
		$("#btn").click(function() {
			var path = '';
			
			$(".g").each(function() {
				if($(this).prop("checked")) {
					path = $(this).val() + "Join";
				}
			});
			
			$("#frm").attr("action", path);
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<form action="" id="frm" method="post" enctype="multipart/form-data">
		<div>
			STUDENT JOIN<input type="radio" name="grade" class="g" id="g1" value="student" checked="checked">
			TEACHER JOIN<input type="radio" name="grade" class="g" id="g2" value="teacher">
		</div>
		<div>
			<p>id : <input type="text" name="id"></p>
			<p>pw : <input type="text" name="pw"></p>
			<p>name : <input type="text" name="name"></p>
			<p>age : <input type="number" name="age"></p>
			<p>file : <input type="file" name="f1"></p>
		</div>
		<div id="student_form">
			<p>sid : <input type="text" name="sid"></p>
			<p>phone : <input type="text" name="phone"></p>
			<p>tid : <input type="text" name="tid"></p>
		</div>
		<div id="teacher_form" style="display: none;">
			<p>tid : <input type="text" name="tid"></p>
			<p>subject : <input type="text" name="subject"></p>
			<p>hiredate : <input type="date" name="hiredate"></p>
		</div>
		<input type="button" value="join" id="btn">
	</form>
</body>
</html>