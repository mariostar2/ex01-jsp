<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class =container>
	<form>
		<div class="sub-form">
		<label>아이디 :<input type="text" id ="id"></label>
		<button type ="button" onclick ="check()">중복확인</button><br>
		<div id = "result"></div>
		</div> 
	</form>
	</div>
</body>
<script>
	function check(){
		const id = document.getElementById("id").value;
		const xhr = new XMLHttpRequest();
		xhr.open("GET","/ex00/LoginForm?id=" + id);
		xhr.onload = function(){
		document.getElementById("result").textContent= xhr.responseText;
		}	
		xhr.send();
	};
</script>
</html>