<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.khw.bakery.*,login.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<BakeryVO> list = (List<BakeryVO>)request.getAttribute("list");
	int size = list.size()-1;
%>
<%@ include file="../advice.jsp" %>
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
	margin-top:50px;
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
		    <input type="hidden" name="userid" value=${loginvo.userid}>
		    <div id="items" style="margin:10px"></div>
		    </li>
		  </ul>
		</form>
	</div>
	
	 <!--  현재 모든 상품 이미지 조회 -->
	<div class="carousel">
		<%
		for (BakeryVO vo : list) {
		%>
     		 <div class="carousel-item"><%=vo.getBakeryname()%><a href="download.file?name=<%=vo.getImage() %>"><img src="<%=vo.getImage() %>"></a><%=vo.getPrice()%>원</div>
     	<%} %>
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
								$(this).parent().parent().remove();
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
						
						$(document).on('click','#cartadd',function(){
								var item = $("#item").val();
								var bal = $("#balanceform").val();
								var hidden = "<div id=\""+item+"add\"><input type=\"hidden\" name=\"item\" value=\""+ parseInt(item) +":"+parseInt(bal)+"\">";
								var button = "<input type=\"button\" value=\"X\" id=\"itembtn\">";
								var array = new Array;
								array = itemadd();

								for(var i=0; i<array.length; i++)
									{
										var check = array[i].split(':');
										var id = ('#'+item+'add');
											if(item == check[0])
												{
													var temp = $(id).text().split('||');
													$(id+' input[name=item]').val(parseInt(item) +":"+ ( parseInt(bal) + parseInt(check[1])));
													$(id+' div').html(temp[0] + " || 구입 수량 = " + ( parseInt(bal) + parseInt(check[1])) +"개 "+button);
													$(".button-collapse").sideNav('show');
													return false;
												}
									}
										
										$.ajax({
											type : 'post',
											data : {'bakeryid' : item },
											url : 'itemSearch.bakery',
											success : function(result){
													var image = "<img src=\""+result.image+"\" style=\"width:250px\"><br>"
													$("div#items").html($("div#items").html() + hidden + image +"<div>상품명 = " + result.bakeryname + " || 구입 수량 = " + bal +"개 "+button +"</div><br></div>");
												}
											})
								$(".button-collapse").sideNav('show');
							});

						var itemadd = function(){
							var temp = new Array;
								$('input[name=item]').each(function(){
									temp.push($(this).val());
								})

							return temp;
						};

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
					$(".button-collapse").sideNav({menuWidth: 500});
			 })(jQuery)
	</script>
</body>
</html>