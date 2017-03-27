<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.khw.bakery.*,login.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../advice.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/hanna.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 결제 리스트</title>
<style type="text/css">
* {
	font-family: 'Hanna';
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.main {
	width: 70%;
}
</style>
</head>
<body>
	<%
		if (session.getAttribute("loginvo") != null) {
			if (lvo.getUserid().equals("admin")) {
	%>
	<form action="orderhistory.bakery" method="post">
		<div
			style="margin-top: 30px; width: 300px; background-color: #e0f2f1; border: 1px gray dotted">
			<h5>고객 조회</h5>
			<div class="input-field col s2">
				<i class="material-icons prefix">mode_edit</i> <input type="text"
					name="userid">
			</div>
		</div>
	</form>
	<%
		}
		}
	%>

	<h2>${userid}님구매내역</h2>
	<table class="centered striped main">
		<tr style="background-color: #4db6ac">
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td>결제일</td>
			<td>결제 금액</td>
			<td>잔여금액</td>
		</tr>
		<c:forEach items="${ovo}" var="vo">
			<tr>
				<td>${vo.bakeryname}</td>
				<td>${vo.price}</td>
				<td>${vo.amount}</td>
				<td>${vo.orderdate}</td>
				<td>${vo.pay}</td>
				<td>${vo.money}</td>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
		})
	</script>
</body>
</html>