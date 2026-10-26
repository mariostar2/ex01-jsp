<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<h1>계산기</h1>
	<hr>
	<form action="/ex00/TestServlet" method="get">
	<input type="text" name ="num1"> + <input type="text" name ="num2">
	<button type ="submit">=</button>
	</form>
	<hr>
	<a href ="/ex00/AddServlet?num1=6&num2=4">6 + 4 = ?</a>
	<hr>
	<form action="/ex00/FormServlet2" method="get">
		이름:<input type="text" name="name"><br>
		성별:<input type="radio" value ="남" name="gender">남
			<input type="radio" value ="여" name ="gender">여
			<br>
			
		취미(2개이상 선택)
		<input type="checkbox" value ="독서" name="hobbies">독서
		<input type="checkbox" value ="게임" name="hobbies">게임
		<input type="checkbox" value="책읽기" name="hobbies">책읽기
		<input type="checkbox" value="운동" name ="hobbies">운동
		<button type ="submit">전송</button>
	</form>
</body>
</html>