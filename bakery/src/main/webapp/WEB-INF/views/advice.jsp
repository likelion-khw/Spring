<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.khw.bakery.*,login.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	LoginVO lvo = (LoginVO) session.getAttribute("loginvo");
	if (lvo == null) {
		response.sendRedirect("http://localhost:8082/bakery/start.bakery");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/hanna.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>베이커리 마트</title>
<style>
.toast {
	border-radius: 30px;
	background-color: blue;
}

#toast-container {
	top: 90%;
	right: 5px;
}

.nav-wrapper {
	background-color: #6d4c41;
}

body{	

 background-color: #efebe9;
}
</style>
</head>
<body>
	<div class="navbar-fixed">
		<nav>
		<div class="nav-wrapper">
			<a href="order.bakery" class="brand-logo center">Bakery Mart</a>
			<ul class="right hide-on-med-and-down">
				<li style="color: white; margin-left: 40px;"><span
					style="font-size: 20px;">${loginvo.name}님 </span></li>
				<li><a href="end.bakery">로그아웃</a></li>
			</ul>
		</div>
		</nav>
	</div>

	<div class="fixed-action-btn horizontal" style="bottom: 80%">
		<a class="btn-floating btn-large red pulse"> <i class="material-icons">menu</i>
		</a>
		<ul>
			<li><a class="btn-floating red" href="order.bakery"><i
					class="material-icons">shopping_basket</i></a></li>
			<li><a class="btn-floating gray"
				href="orderhistory.bakery?userid=${loginvo.userid}"><i
					class="material-icons">perm_identity</i></a></li>
			<%
				if (session.getAttribute("loginvo") != null) {
					if (lvo.getUserid().equals("admin")) {
			%>
			<li><a class="btn-floating green" href="insert.bakery"><i
					class="material-icons">publish</i></a></li>
			<li><a class="btn-floating purple" href="store.bakery"><i
					class="material-icons">view_module</i></a></li>
			<%
				}
				}
			%>
		</ul>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			Materialize.toast($('#toast').val());
		})
	</script>
</body>
</html>