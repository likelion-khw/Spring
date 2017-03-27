<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.khw.bakery.*,login.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../advice.jsp"%>
<%
	int total = 0;
	List<BakeryVO> list = (List<BakeryVO>) request.getAttribute("list");
	int col = 0;
	if (list.size() == 1) {
		col = 12;
	} else if (list.size() == 2) {
		col = 6;
	} else if (list.size() == 3) {
		col = 4;
	} else {
		col = 3;
	}
	for (BakeryVO vo : list) {
		total += vo.getPrice() * vo.getBalance();
	}
%>
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
<title>결제완료</title>
<style type="text/css">
* {
	font-family: 'Hanna';
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

img {
	width: 300px;
	height: 300px;
}
</style>
</head>
<body>
	<h2>구매 목록</h2>
	<div class="row">
		<c:forEach items="${list}" var="vo">
			<div class="col s<%=col%>">
				<div class="card-panel hoverable">
					<div class="card-image">
						<img src="${vo.image}">
					</div>
					<div class="card-content">
						<h4>
							<p>${vo.bakeryname}<br>(code :${vo.bakeryid})
							</p>
						</h4>
						<p>구입수량 : ${vo.balance}개</p>
						<p>${vo.price}원</p>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="col s12">
			<h2>
				총
				<%=total%>원 입니다
			</h2>
		</div>
	</div>
	<a href="orderhistory.bakery?userid=${loginvo.userid}"><input style="margin-bottom: 50px;"
		type="button" value="결제목록" class="btn blue"></a>
	<script type="text/javascript">
		$(document).ready(function() {
		})
	</script>
</body>
</html>