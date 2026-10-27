<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${10 mod 3 }</p>
<p>${10 % 3 } </p>
<p>${10 == 10 }</p>
<p>${10 eq 10}</p>
<p>${10 != 10}</p>   
<%-- <p>${10 ne 10}</p> --%>   
<p>${10 > 10} </p>
<p>${10 gt 9} </p>
<p>${8 lt 9} </p>
<p>${8 lt 7} </p>
<p>${8 ge 7} </p>
<p>${8 ge 8} </p>
<p>${7 le 8} </p>
<p>${7 le 7} </p>
<hr>
<p>파라미터 확인</p>
<p>${ empty param.id }</p>
<p>${param.id == null }</p>
<p>${param.id == "" }</p>
<% 
	pageContext.setAttribute("score", 50);
%>
<p>${score >= 60 ? "합격": "불합격" }</p>




</body>
</html>