<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DBPKG.MemberDto"%>
<%
	MemberDto dao =  new MemberDto();
	request.setAttribute("custno", dao.autoNumber());
	request.setAttribute("joindate", new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date())); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.main-table tr{
		display: grid;
		grid-template-columns: 150px 1fr;
		gap: 8px 12px;
		align-items: center;
	}
	.main-table th { 
		text-align: left; 
	}
	
	.button {
		text-align: center;
	}
</style>
<body>
<h1>쇼핑몰 회원 관리 ver 1.0</h1>
	<hr>
	<header>
		<div class="cotainer">
			<a href="create">회원등록</a>
			<a href="memberselect">회원목록조회/수정</a>
			<a href="moneylist">회원매출조회</a> <a href="index">홈으로</a>
		</div>
	</header>
	<hr>
<div class="main-table">
  <form  id = "createform"action ="create" method ="post">
    <table>
      <tr>
        <th>회원번호(자동생성)</th>
        <td><input type="text" name="custno" value="${custno}" readonly></td>
      </tr>
      <tr>
        <th>회원성명</th>
        <td><input type="text" name="custname" ></td>
      </tr>
      <tr>
        <th>회원전화</th>
        <td><input type="text" name="phone" ></td>
      </tr>
      <tr>
        <th>회원주소</th>
        <td><input type="text" name="address"></td>
      </tr>
      <tr>
        <th>가입일자</th>
        <td><input type="text" name="joindate" value="${joindate}"></td>
      </tr>
      <tr>
        <th>고객등급[A:VIP, B:일반 C:직원]</th>
        <td><input type="text" name="grade" maxlength="1"></td>
      </tr>
      <tr>
        <th>도시코드</th>
        <td><input type="text" name="city" maxlength="1"></td>
      </tr>
    </table>
      <button type= "submit" id="create">등록</button>
      <!-- 컨텍스트 매핑  -->
      <button type="button" onclick="location.href='${pageContext.request.contextPath}/memberselect'">조회</button>
  </form>
</div>
</body>
<script>
/* 유효성 검사 */
document.getElementById("createform").addEventListener("submit" ,(e)=>{
	const formtarget = e.target;
	//각 NAME 값을 담아서 유효성 체크 
	const createRequired =  [
		["custname", "회원 성명이 입력되지 않았습니다"],
		["phone","휴대폰 번호가 입력되지 않았습니다"],
		["address","이메일을 입력하지 않았습니다"],
		["joindate","년월일을 입력하지 않았습니다"],
		["grade","회원등급을 입력하지 않았습니다"],
		["city","지역을 입력하지 않았습니다"]
	]
	for(const [name,msg] of createRequired){
		if(formtarget[name].value.trim() === ""){
			alert(msg);
			formtarget[name].focus();
			e.preventDefault();
			return;
		}
	}
	alert("회원등록이 완료 되었습니다");
});
</script>
</html>