<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>로그인 폼</h1>
<body>
	<div class =container>
	<form action ="loginform.jsp"  method = "post">
		<div class="sub-form">
		<label>아이디 :<input type="text" name ="id"></label><br>
		<label>비밀번호 :<input type ="text" name="pws"></label>
		<button type = "submit" name ="로그인">로그인</button>
		</div> 
	</form>
	</div>
	
</body>
</html>