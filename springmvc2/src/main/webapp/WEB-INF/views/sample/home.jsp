<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>시작화면</title>
</head>
<body>
	<h2>컨트롤러 호출 연습(리턴타입)</h2>
	<a href="sample/doA">doA</a>
	<br>
	<a href="sample/doB">doB</a>
	<br>
	<a href="sample/doC">doC</a>
	<br>
	<a href="sample/doD">doD</a>
	<br>
	<a href="sample/doE">doE</a>
	<br>
	<a href="javascript:doF()">doF</a>
	<br>
	<a href="javascript:dolist()">리스트</a>
	<br>
	<table id="result">
	</table>
	
	<img src="resources/image/spring.png" alt="경로오류">

	<script type="text/javascript">
		function doF() {
			$.ajax({ // @RestController 선언
				// @RequestBody --> 리턴값을 json 형태로 (생략가능)
				type : "post",
				url : "sample/doF",
				success : function(result) { //result - json
					$('#result').html(
							"<tr><td><h4>회원 아이디 : " + result.id + " 암호 :" + result.pw + "</h4></td></tr>");
				}

			});
		};

		function dolist() {

			$('#result').empty().css("border","3px gray solid");
			
			$.ajax({
				type : "post",
				url : "sample/memberlist",
				success : function(result) {
					$(result).each(function() {
						$('#result').append("<tr><td><h4>회원아이디 : " + this.id + " 비밀번호 : " + this.pw + "</h4></td></tr>");
					});
				}

			});

			$('td').css("border","1px gray solid");
		};
	</script>
</body>
</html>