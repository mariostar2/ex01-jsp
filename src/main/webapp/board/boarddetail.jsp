<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
</head>
<body>
	<h1>상세 화면</h1>
	<hr>

	<table border="1">
		<tr>
			<td>번호</td>
			<td>${board.noticeNo}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><c:out value="${board.noticeName}"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><c:out value="${board.noticeTitle}"/></td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><img src="${pageContext.request.contextPath}/uploads/${board.noticeImage}" width="300"></td>
		</tr>
		<tr>
			<td>이미지 설명</td>
			<td><c:out value="${board.noticeForm}"/></td>
		</tr>
		<tr>
			<td>올린 날짜</td>
			<td>${board.noticeDate}</td>
		</tr>
		<c:if test="${not empty board.noticeUpdate}">
		<tr>
			<td>수정한 날짜</td>
			<td>${board.noticeUpdate}</td>
		</tr>
		</c:if>
	</table>

	<p>
		<c:if test="${sessionScope.loguser.id eq board.noticeName}">
			<a href="${pageContext.request.contextPath}/boardupdate?noticeNo=${board.noticeNo}">수정</a>
			<a href="${pageContext.request.contextPath}/boarddelete?noticeNo=${board.noticeNo}"
			   onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/boardlist">목록으로</a>
	</p>
</body>
</html>