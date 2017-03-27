<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="login.*"%>
	
<%
	LoginVO lvo = (LoginVO) session.getAttribute("loginvo");
	if (lvo != null) {
		response.sendRedirect("http://localhost:8082/bakery/order.bakery");
	}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/hanna.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지 입니다</title>
<style>
* {
	font-family: 'Hanna';
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<form action="start.bakery" method="post">
		<table class="centered z-depth-5"
			style="width: auto; border: 4px silver solid; margin-top: 100px;">
			<tr>
				<td colspan="2" style="background-color: #b2dfdb;"><span
					style="font-size: 50px; color: #00897b;">LOGIN</span></td>
			</tr>
			<tr>
				<td>ID :</td>
				<td><input class="validate" type="text" value="${id}"
					name="userid" placeholder="아이디를 입력하세요"> <input
					type="checkbox" name="idstore" id="idstore" value="checked">
					<label for="idstore">아이디기억</label></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><input type="password" name="password"
					placeholder="암호를 입력하세요"></td>
			</tr>
			<tr>
				<td colspan="2"><input class="waves-effect waves-light btn"
					type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<h3>${msg}</h3>
</body>
</html>