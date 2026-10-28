<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
</head>
<body>
	<h1>할인점 주문프로그램 ver 1.0</h1>
	<hr>
	<div class="menu-header">
		<a href="insert">주문등록</a> <a href="orderselect">주문목록 조회</a> <a
			href="shoplist">점포별주문현황</a> <a href="productlist">제품코드조회</a> <a
			href="index4.jsp">홈으로</a>
	</div>
	<h2>주문 목록</h2>
		<table border="1">
			<tr>
				<td>할인점코드</td>
				<td>점포명</td>
				<td>주문번호</td>
				<td>주문일자</td>
				<td>제품코드</td>
				<td>제품명</td>
				<td>주문수량</td>
				<td>단가</td>
				<td>소비자가격</td>
				<td>할인가격</td>
			</tr>
			<c:forEach var="s" items="${list}">
				<tr>
					<td>${s.shopno}</td>
					<td>${s.shopname}</td>
					<td>${s.orderno}</td>
					<td>${s.orderdate}</td>
					<td>${s.pcode}</td>
					<td>${s.pname}</td>
					<td>${s.amount}</td>
					<td>${s.cost}</td>
					<td>${s.costPrice}</td>
					<td>${s.discountPrice}</td>
				</tr>
			</c:forEach>
		</table>
</body>
<script>
	

</script>
</html>