<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>할인점 주문프로그램 ver 1.0</h1>
	<hr>

	<% if (session.getAttribute("id") != null) { %>
		<div class="menu-header">
			<a href="insert">주문등록</a>
			<a href="orderselect">주문목록 조회</a>
			<a href="shoplist">점포별주문현황</a>
			<a href="productlist">제품코드조회</a>
			<a href="index4.jsp">홈으로</a>
			<a href="logout">로그아웃</a>
		</div>
	<% } else { %>
		<h2>로그인</h2>
		<form action="memulogin" method="post">
			<label>아이디 <input type="text" name="id" required></label><br>
			<label>비밀번호 <input type="password" name="pw" required></label>	
			<button type="submit">로그인</button>
		</form>

		<% if (request.getAttribute("msg") != null) { %>
			<p style="color:red;"><%= request.getAttribute("msg") %></p>
		<% } %>
	<% } %>
</body>
</html>