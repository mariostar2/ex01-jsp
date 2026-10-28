<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>할인점 주문프로그램 ver 1.0</h1>
	<hr>
	<div class="menu-header">
		<a href="insert">주문등록</a> 
		<a href="orderselect">주문목록 조회</a> 
		<a href="shoplist">점포별주문현황</a> 
		<a href="productlist">제품코드조회</a> 
		<a href="index4.jsp">홈으로</a>
	</div>
	<form>
		<table border="1">
			<tr>
				<td>제품코드</td>
				<td>제품명</td>
				<td>단가</td>
				<td>할인율(10%)</td>
				<td>할인율(15%)</td>
			</tr>
			<c:forEach var="s" items="${list}">
				<tr>
					<td>${s.pcode}</td>
					<td>${s.pname}</td>
					<td>${s.cost}</td>
					<td>${s.discountPrice}</td>
					<td>${s.dispriced}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>