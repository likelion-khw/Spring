<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="login.*"%>

<%
	LoginVO lvo = (LoginVO) session.getAttribute("loginvo");
	if (lvo != null) {
		response.sendRedirect("http://localhost:8082/bakery/order.bakery");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
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

body {
	background-image: url("resources/back2.gif");
	background-size: cover;
	background-repeat: no-repeat;
}

table {
	border-radius: 20px;
	width: auto;
	margin-top: 5%;
}

td {
	border-radius: 20px;
}
</style>
</head>
<body>

	<h2 style="color:white; margin-top:5%">" Bakery Mart "</h2>
	<form action="start.bakery" method="post">
		<table class="centered z-depth-5">
			<tr>
				<td colspan="2" style="background-color: #6d4c41;"><span
					style="font-size: 35px; color: white;">LOGIN</span></td>
			</tr>
			<tr style="color: white">
				<td>ID :</td>
				<td><input class="validate" type="text" value="${id}"
					name="userid" placeholder="아이디를 입력하세요"></td>
			</tr>
			<tr style="color: white">
				<td>PASSWORD :</td>
				<td><input type="password" name="password"
					placeholder="암호를 입력하세요"></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn brown darken-1" type="submit"
					value="로그인"></td>
			</tr>
		</table>
	</form>
	<h3 style="color: white">${msg}</h3>

	<div id="error" class="modal" style="width: 300px;">
		<div class="modal-content">
			<h4 style="border: 1px black solid">로그인 오류</h4>
		</div>
		<p></p>
		<div class="modal-footer">
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat">확인</a>
		</div>
	</div>

	<script type="text/javascript">
		(function($) {
			$(document).ready(function() {
				$('input[value=로그인]').on('click', function(e) {
					e.preventDefault();
					var userid = $('input[name=userid]').val();
					var password = $('input[name=password]').val();
					$.ajax({
						type : 'post',
						data : {
							'userid' : userid,
							'password' : password
						},
						url : 'startcheck.bakery',
						success : function(result) {
							if (result == 1) {
								$('#error p').html("해당 아이디는 존재하지 않습니다");
								$('input[name=userid]').val('');
								$('input[name=password]').val('');
								$('#error').modal('open');
							} else if (result == 2) {
								$('#error p').html("패스워드가 다릅니다.");
								$('input[name=password]').val('');
								$('#error').modal('open');
							} else {
								$('form').submit();
							}
						}
					})
				})
			})
		})(jQuery)

		$('.modal').modal();
	</script>

</body>
</html>