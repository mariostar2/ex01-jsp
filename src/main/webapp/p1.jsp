<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>p1 page</h1>
	<a href ="/ex00">Home</a>
	<hr>
	<form action ="/ex00/FormServlet" method ="get">
		<input type ="text" name ="txt">
		
		<button type = "submit">전송</button>
	</form>
</body>

</html>