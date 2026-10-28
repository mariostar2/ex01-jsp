<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문등록</title>
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
		<a href ="login">로그인</a>
	</div>
	<h2>주문등록</h2>
	<form id="insertform" action="${pageContext.request.contextPath}/insert" method="post">
		<table border ="1">
			<tr>
				<td>주문번호 <input type="text" name="orderno"></td>
			</tr>
			<tr>
				<td>주문점포
					<select name="shopno">
						<option value="">선택하세요</option>
						<option value="S001">AA할인점</option>
						<option value="S002">BB할인점</option>
						<option value="S003">CC할인점</option>
						<option value="S004">DD할인점</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>주문일자 <input type="text" name="orderdate" placeholder=""></td>
			</tr>
			<tr>
				<td>제품코드
					<select name="pcode">
						<option value="">선택하세요</option>
						<option value="AA01">AA01</option>
						<option value="AA02">AA02</option>
						<option value="AA03">AA03</option>
						<option value="AA04">AA04</option>
						<option value="AA05">AA05</option>
						<option value="AA06">AA06</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>주문수량 <input type="text" name="amount"></td>
			</tr>
		</table>
		<button type="submit">주문등록</button>
		<button type="reset">다시쓰기</button>
	</form>
</body>
<script>
	document.getElementById("insertform").addEventListener("submit", (e) => {
		const insertTarget = e.target;
		const insertRequired = [
			["orderno", "주문번호가 입력되지 않았습니다"],
			["shopno", "주문 점포가 선택되지 않았습니다"],
			["orderdate", "주문 일자를 입력부탁드립니다"],
			["pcode", "제품 코드가 선택되지 않았습니다"],
			["amount", "주문 수량을 입력 해주세요"]
		];
		for (const [name, msg] of insertRequired) {
			if (insertTarget[name].value.trim() === "") {
				alert(msg);
				insertTarget[name].focus();
				e.preventDefault();
				return;
			}
		}
		alert("주문 등록이 완료 되었습니다");
	});
</script>
</html>