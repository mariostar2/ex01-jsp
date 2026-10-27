<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.table-border {
	display: flex;
	justify-content: left;
}
</style>
<body>
	<h1>쇼핑몰 회원 관리 ver 1.0</h1>
	<hr>
	<header>
		<div class="cotainer">
			<a href="create">회원등록</a> 
			<a href="memberselect">회원목록조회/수정</a> 
			<a href="moneylist">회원매출조회</a> 
			<a href="index">홈으로</a>
		</div>
	</header>
	<hr>
	<div class="table-border">
		<form>
			<table>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
				<c:forEach var="m" items="${list}">
					<tr>
						<td><a href="update?custno=${m.custno}">${m.custno}</a></td>
						<td>${m.custname}</td>
						<td>${m.phone}</td>
						<td>${m.address}</td>
						<td>${m.joindate}</td>
						<td><c:choose>
								<c:when test="${m.grade == 'A'}">VIP</c:when>
								<c:when test="${m.grade == 'B'}">일반</c:when>
								<c:when test="${m.grade == 'C'}">직원</c:when>
								<c:otherwise>${m.grade}</c:otherwise>
							</c:choose></td>
						<td>${m.city}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>