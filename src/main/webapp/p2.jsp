<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 값을 표현할때 사용하는 기호 %  
	 결과값을 구현 할때 
-->
<%
	String s= "hello";	
%>
<!-- 결과 값을 화면에 뿌릴때는 여기에  
	 함수 안에 쓰는 처리문이다 (함수처리문)
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%=s %></h1>
</body>
</html>