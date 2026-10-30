<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h1>게시판 목록</h1>
	<hr>
	<p>
		<c:out value="${sessionScope.loguser.id}"/>님 로그인 중
		<a href="${pageContext.request.contextPath}/boardlogout">로그아웃</a>
	</p>
	<a href="${pageContext.request.contextPath}/boardwrite">글쓰기</a>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>수정일</th>
			<th>수정</th>
		</tr>
		<c:forEach var="b" items="${boardlist}">
			<tr>
				<td>${b.noticeNo}</td>
				<td><c:out value="${b.noticeName}"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/boardchecked?noticeNo=${b.noticeNo}">
						<c:out value="${b.noticeTitle}"/>
					</a>
				</td>
				<td>${b.noticeDate}</td>
				<td>${b.noticeUpdate}</td>
				<td>
					<c:if test="${sessionScope.loguser.id eq b.noticeName}">
						<a href="${pageContext.request.contextPath}/boardupdate?noticeNo=${b.noticeNo}">수정하기</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty boardlist}">
			<tr><td colspan="6">등록된 게시글이 없습니다.</td></tr>
		</c:if>
	</table>
</body>
</html>