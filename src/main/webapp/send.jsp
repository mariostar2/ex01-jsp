<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: = red;
	
}
</style>

<body>
	<h1>forward 액션 태그 예재</h1>
	<hr>
	<h2>이 파일은 red.jsp입니다</h2>
	<p>브라우저에 배경색이 빨간색으로 나타날까요?</p>
	<br>
	<p>노란색으로 나타날까요?</p>
	<hr>
	<jsp:forward page="yellow02.jsp">
		<jsp:param name="url" value="red02.jsp" />
		<jsp:param name="news" value="Happy New Year" />
	</jsp:forward>
</body>
</html>