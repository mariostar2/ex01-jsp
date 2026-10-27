
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쇼핑몰 회원 관리 ver 1.0</h1>
	<hr>
	<header>
		<div class="cotainer">
			<a href="create">회원등록</a> 
			<a href="memberselect">회원목록조회/수정</a> 
			<a href="money">회원매출조회</a> 
			<a href="index">홈으로</a>
		</div>
	</header>
	<hr>
	<h2>홈쇼핑 회원 정보 수정</h2>
	<form id = "updateForm" action="update" method="post">
		<table>
			<tr>
				<th>회원번호</th>
				<td><input type="text" name="custno" value="${me.custno}"
					readonly></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" value="${me.custname}"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone" value="${me.phone}"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address" value="${me.address}"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="text" name="joindate" value="${me.joindate}"></td>
			</tr>
			<tr>
				<th>고객등급[A:VIP, B:일반 C:직원]</th>
				<td><input type="text" name="grade" value="${me.grade}"
					maxlength="1"></td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city" value="${me.city }"
					maxlength="2"></td>
			</tr>
		</table>
		<button type="submit" id="update">수정</button>
		<!-- 컨텍스트 매핑  -->
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/memberselect'">조회</button>
	</form>
	<script>
	 document.getElementById("updateForm").addEventListener("submit",(e) =>{
		const updatetarget =  e.target;
		 const updateRequired = [
			["custname", "이름을 입력부탁드립니다"],
			["phone","휴대폰 번호를 입력부탁드립니다"],
			["address","이메일 입력을 부탁드립니다"],
			["joindate","날짜가 입력되지 않았습니다"],
			["grade","등급의 수정을 부탁드립니다"],
			["city","도시코드를 입력하지 않았습니다"]
		]
		for (const [name,msg] of updateRequired){
			if(updatetarget[name].value.trim() === ""){
				alert(msg);
				updatetarget[name].focus();
				e.preventDefault();
				return;
			}
		}
		alert("회원 정보 수정이 완료 되었습니다");
	 });
	 
	  </script>
</body>
</html>