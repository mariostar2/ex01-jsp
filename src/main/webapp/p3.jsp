<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	/*
		type:servlet
		setvlet이 가지고 있는 4대 저장소
		pageContext,request,session,application
	*/
	String page1 = "page 영역데이터"; //페이지
	String request1 = "request영역 데이터"; //요청
	String session1 = "session영역 데이터"; //사용자 
	String application1 = "application 영역 데이터"; //사용자 구분x 모든 사용자
	
	pageContext.setAttribute("x", page1); //페이지 영역: 페이지가 끝나면 사라짐
	request.setAttribute("x", request1); // request 영역: 1번 유지, forward로 넘기면 사용가능, 응답 끝나면 사라짐
	//session.setAttribute("x", session1);//session 영역 1.같은 사용자(브라우저) 가 접속해 있는 동안만 유지	 2.브라우저가 닫히면 세션 만료 시 사라짐 3. 로그인 정보 , 장바구니 등에 사용
	application.setAttribute("x", application1); // application 영역 :웹 애플리케이션 전체에서 공유
	/*로그인이 성공 하면 session 영역에 저장 그렇게 안하면 계속 로그인해야함  */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>4대 저장소 데이터 보기 : ${x }</div>
		<!-- el 표기법 -->
		<!-- 가독성을 높이기 위해 나옴  -->
		<!-- 지역변수 중복 나면안됨  -->
		<!-- 정해진 저장소에 넣어야한다el로 접근할거면  -->
		<a href = "p6.jsp">p 페이지로  가기</a>
</body>
</html>