<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.khw.bakery.*,login.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../advice.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>상품 등록페이지</title>
<style>
* {
	font-family: 'Hanna';
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	width: 350px;
}

div.main {
	width: 500px;
	margin-top: 2%;
	margin-bottom: 2%;
	border: 1px gray solid;
	padding: 30px;
	background-color: #e0f2f1;
}
</style>
</head>
<body>
	<div class="main">
		<h2>상품추가</h2>
		<form action="insert.bakery" method="post"
			enctype="multipart/form-data">
			<table class="centered">
				<tr>
					<td colspan="2">
						<div class="input-field col s2">
							<i class="material-icons prefix">mode_edit</i> <input
								id="icon_prefix" type="text" class="validate" name="bakeryname">
							<label for="icon_prefix">상품명</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="input-field col s2">
							<i class="material-icons prefix">turned_in</i> <input
								id="icon_prefix" type="text" class="validate" name="price">
							<label for="icon_prefix">가격</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="input-field col s2">
							<i class="material-icons prefix">stars</i> <input
								id="icon_prefix" type="text" class="validate" name="balance">
							<label for="icon_prefix">수량</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="file-field input-field">
							<div class="btn">
								<span>File</span> <input type="file" name="file">
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text">
							</div>
						</div>
					</td>
				</tr>
			</table>
			<img src="" width="200" style="display: none"><br> <input
				type="submit" value="상품등록" class="btn blue">
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('input[type=file]').on('change', function(e) {
				var image = URL.createObjectURL(e.target.files[0]);
				$("img").fadeIn("fast").attr('src', image);
			})
		})
	</script>
</body>
</html>