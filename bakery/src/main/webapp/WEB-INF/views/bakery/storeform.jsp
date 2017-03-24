<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/hanna.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>상품 관리페이지</title>
<style type="text/css">
* {
	font-family: 'Hanna';
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

img {
	width: 250px;
	height: 250px;
}
</style>
</head>
<body>

	<div style="margin: 40px;">
		<h1>상품관리</h1>
		<div class="row">
			<c:forEach items="${list}" var="vo">
				<form action="store.bakery" method="post"
					enctype="multipart/form-data" id="form${vo.bakeryid}">
					<input type="hidden" value="${vo.bakeryid}" name="bakeryid">
					<div class="col s3 m3">
						<div class="card-panel hoverable">
							<div class="card-image">
								<img src="${vo.image}">
							</div>
							<div class="card-content">
								<table class="centered bordered">
									<tr>
										<td></td>
										<td style="width: 150px">기존</td>
										<td>변경</td>
									</tr>
									<tr>
										<td>품명</td>
										<td style="color:red">${vo.bakeryname}</td>
										<td><input type="text" value="${vo.bakeryname}"
											name="bakeryname"></td>
									</tr>
									<tr>
										<td>가격</td>
										<td style="color:red">${vo.price}</td>
										<td><input type="text" value="${vo.price}" name="price"></td>
									</tr>
									<tr>
										<td>수량</td>
										<td style="color:red; font-style:bold">${vo.balance}</td>
										<td><input type="text" value="${vo.balance}"
											name="balance"></td>
									</tr>
									<tr>
										<td colspan="3"><input type="submit" class="btn"
											value="변경"></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>

	<div class="fixed-action-btn horizontal" style="bottom: 90%">
		<a class="btn-floating btn-large red"> <i class="material-icons">menu</i>
		</a>
		<ul>
			<li><a class="btn-floating red" href="order.bakery"><i
					class="material-icons">shopping_basket</i></a></li>
			<li><a class="btn-floating green" href="insert.bakery"><i
					class="material-icons">publish</i></a></li>
			<li><a class="btn-floating blue" href="store.bakery"><i
					class="material-icons">view_module</i></a></li>
		</ul>
	</div>

	<div id="result" class="modal" style="width:300px;">
		<div class="modal-content">
			<h4>상품 변경 완료</h4>
			<img src="">
			<p></p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat">확인</a>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('form').on('submit', function(e) {
				e.preventDefault();
				var data = $(this).serialize();
				$.ajax({
					type : 'post',
					data : data,
					url : 'store.bakery',
					success : function(result) {
						$('#result img').attr("src",result.image);
						$('#result p').html("<p>상품명 : " + result.bakeryname +"</p><p>가격 : " + result.price +"</p><p>수량 : " + result.balance+"</p>");
						$('#result').modal('open');
					}
				})

			})
			$('.modal').modal({
				ready : function(){
						$('div#result a').on('click',function(){
								$(location).attr("href","store.bakery");
							})
					}
				});
		})
	</script>
</body>
</html>