<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.khw.bakery.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<BakeryVO> list = (List<BakeryVO>)request.getAttribute("list");
	int size = list.size()-1;
%>
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
<title>주문 페이지</title>
<style type="text/css">
* {
	font-family:'Hanna';
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.main{
	width:300px;
}
.sub{
	width:150px;
}	

.hide{
	visibility: visible;
}

div.main{
	margin-top:50px;w
}

</style>
</head>
<body>
	<div class="input-field main">
		<h3>상품 구매하기</h3>
		<form action="order.bakery" method="post">
			<select id="item" class="sub">
				<option>상품선택</option>
				<%
					for (BakeryVO vo : list) {
				%>
				<option value="<%=vo.getBakeryid()%>" id="<%=vo.getBakeryid()%>"><%=vo.getBakeryname()%></option>
				<%
					}
				%>
			</select>
			<select id="balanceform" class="hide sub">
			</select>
			<br> 
			 	<input type="button" value="상품추가하기" id="cartadd" class="hide">
			 	<input type="submit" value="상품결제" class="hide" id="sub">
			<a href="#" data-activates="slide-out" class="button-collapse btn green" style="margin-top:30px">카트목록</a>
			 	
		  <ul id="slide-out" class="side-nav">
		    <li><div class="userView">
	     		<h3>장바구니 목록</h3>
		    </div></li>
		    <li>
		    <input type="button" value="모두 비우기" class="btn red">
		    <div id="items"></div>
		    </li>
		  </ul>
		</form>
	</div>
	
	 <!--  현재 모든 상품 이미지 조회 -->
	<div class="carousel">
		<%
		for (BakeryVO vo : list) {
		%>
     		 <div class="carousel-item"><%=vo.getBakeryname()%><img src="<%=vo.getImage() %>"><%=vo.getPrice()%>원</div>
     	<%} %>
    </div>
    
   <!-- 추가 푸쉬 버튼 들  -->
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
  
  
  <!-- 장바구니 추가 없이 구입 후 에러 메시지 -->
  <div id="error" class="modal main">
    <div class="modal-content">
      <h4>상품 결제오류</h4>
      <p>장바구니에 상품을 추가 후 구매하세요.</p>
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">확인</a>
    </div>
  </div>

	<script type="text/javascript">
			 (function($){
					$(document).ready(function() {
						
						$(document).on('click','#itembtn', function(){
								$(this).parent().remove();
							})
							
						$('#slide-out input').on('click',function(){
								$('#items').empty('div');
							});

						$('input#sub').on('click',function(e){
								var cart = $("div#items").html();
								if(cart == '')
									{
										$('#error').modal('open');
										e.preventDefault();
									}
							});
						$('#cartadd').on('click',function(){
								var item = $("#item").val();
								var bal = $("#balanceform").val();
								var hidden = "<div><input type=\"hidden\" name=\"item\" value=\""+ parseInt(item) +":"+parseInt(bal)+"\">";
								var button = "<input type=\"button\" value=\"X\" id=\"itembtn\">";

								$.ajax({
									type : 'post',
									data : {'bakeryid' : item },
									url : 'itemSearch.bakery',
									success : function(result){
											var image = "<img src=\""+result.image+"\" style=\"width:250px\"><br>"
											$("div#items").html($("div#items").html()+  hidden+ image +"상품명 = " + result.bakeryname + " || 구입 수량 = " + bal +"개 "+button +"<br></div>");
										}
									})
								$(".button-collapse").sideNav('show');
							});
						
						$("#item").on('change', function() {
							var bakeryid = $(this).val();
							$('#cartadd').attr("class","btn");
							$('#sub').attr("class","btn red");
							$.ajax({
								type : 'post',
								data : {
									'bakeryid' : bakeryid
								},
								url : 'balance.bakery',
								success : function(result) {
									for (var i = 1; i <= result; i++) {
										$("#balanceform").html($("#balanceform").html()+"<option value=\""+i+"\">"+i+"</option>").attr("class","sub");
									}
									$('select').material_select('update');
								}
							})
						})
					})

					$('select').material_select();
					$('.modal').modal();
					$('.carousel').carousel();
					  setInterval(function() {
					    $('.carousel').carousel('next');
					  }, 2000);
			 })(jQuery)
		
			 $(".button-collapse").sideNav({menuWidth: 500});
	</script>
	
</body>
</html>