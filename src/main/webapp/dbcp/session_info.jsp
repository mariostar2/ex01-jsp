<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id_str = session.getId();
long last_time = session.getLastAccessedTime();
long created_time = session.getCreationTime();
long time_used = (last_time - created_time) / 60000; //분
int inactive =  session.getMaxInactiveInterval() / 60;
session.setMaxInactiveInterval(60);
boolean b_new = session.isNew();

%>
<h1>세션 정보를 얻어오는 메소드 사용 </h1>
<hr>
[1] 세션 ID는 [<%= id_str %>] 입니다<br><hr>
[2] 당신이 웹 사이트에 머문 시간은 <%= time_used %> 분 입니다.<br><hr>
[3] 세션의 유효 시간은 <%= inactive %> 분입니다.<br><hr>
[4] 세션이 새로 만들어졌나?<br><hr>
<%
	if(b_new){
		out.print("예! 새로운 세션을 만들었어요.");
	}else{
		out.print("아니요! 새로운 세션을 만들지 않았어요");
	}
%>
<hr>
세션 ID는 서로 다른 세션인지를 구분하기 위해 사용됨.
세션이 바뀌면 이전에 세션에 저장되었던 정보를 더 이상 사용하지 못하도록 해서 보안을 유지함.
</body>
</html>