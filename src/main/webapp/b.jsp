<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 	//@requestparam 은 getparameter랑 같은 방식 
	//String param  =  request.getParameter("x");
	//pageContext.setAttribute("x",param);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- index = a.jsp의 파라미터를 전달받아(뷰 반응안함)
forward 방식을 이용해서 바로 보내줌(request를 복사함)
 b로 바로 보내줌 -->
<h1>b.jsp 입니다</h1>
<hr>
<p>${param.x}</p>
<p>${x }</p>
</body>
</html>