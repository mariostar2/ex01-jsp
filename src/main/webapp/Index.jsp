<!-- 이게 없으면 jsp 파일이 아님 html 파일임 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<!-- html -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index page</h1>
	<hr>
	<a href = "p1.jsp">p1 page</a>
	<br>
	<a href = "/ex00/TestSelvets">TestSelvets</a>
	<br>
	<a href ="p2.jsp">p2 page</a>
	<br>
	<a href = "p0">p0 page</a>
	<br>
	<a href = "p4.jsp">p4 page</a>
	<br>
	<a href = "p5.jsp">p5 page</a>
	<br>
	<hr>
	<a href = "select">select page</a>
	<br>
	<a href = "p3.jsp">el표기법</a>
	<br>
	<!-- 쿼리스트링  -->
	<a href = "a.jsp?x=xxx">a.jsp로 이동</a>
	<br>
	<a href = "test">TestServlet 호출</a>
	<br>
	<a href ="login">로그인 페이지로 이동</a>
	<br>
	<a href ="member">맴버로 이동</a>
</body>

<style>
	a{
		text-align: center;
	}
</style>
</html>