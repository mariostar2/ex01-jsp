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
	<a href = "p3.jsp">p3 이동</a>
	<br>
	<!-- 쿼리스트링  -->
	<a href = "a.jsp?x=xxx">a.jsp로 이동</a>
	<br>
	<a href = "test">TestServlet 호출</a>
	<br>
	<a href ="login">로그인 페이지로 이동</a>
	<br>
	<a href ="member">맴버로 이동</a>
	<br>
	<a href = "eltest.jsp?id=aaa">EL 연습 페이지 파라미터 전송용 링크</a>
	<br>
	<a href = "send.jsp">액션태그 연습1</a>
	<br>
	<a href ="actionTagForm.jsp">사용자 관리자 관련 액션 태그 로그인 연습 1</a> -->
	<br>
	<a href="userbean.jsp">jstl bean 태그 학습(연습)</a>
	<br>
	<a href="dbcp_test.jsp">dbcp 연습</a>
	<br>
	<a href="dbcp/session_info.jsp">세션 유효시간 연습 </a>
	<a href= "cookie/logincookie.jsp">쿠키 로그인 로그아웃 공지사항 연습 파일</a>
</body>

<style>
	a{
		text-align: center;
	}
</style>
</html>