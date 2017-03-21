<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<title>게시물 상세페이지</title>

<style>
* {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 1000px;
	margin-bottom: 30px;
}

td {
	border: 3px silver solid;
}

.tag {
	background-color: #d7ccc8;
}

.title {
	height: 40px;
}

.contents {
	height: 300px;
}
</style>
</head>
<body>
	<h1>게시물 상세 내용입니다.</h1>
	<table class="centered bordered z-depth-5 hoverable">
		<tr>
			<td class="tag">게시물번호</td>
			<td class="tag">작성자</td>
			<td class="tag">작성시간</td>
			<td class="tag">조회수</td>
		</tr>
		<tr>
			<td>${bvo.seq}</td>
			<td>${bvo.writer}</td>
			<td>${bvo.time}</td>
			<td>${bvo.review}</td>
		</tr>
		<tr>
			<td class="tag title">제목</td>
			<td colspan="3">${bvo.title}</td>
		</tr>
		<tr>
			<td class="tag contents">내용</td>
			<td colspan="3">${bvo.contents}</td>
		</tr>
	</table>
	
	${bvo.file1.getOriginalFilename()}
	${bvo.file2.getOriginalFilename()}
	<button id="return" class="waves-effect waves-light btn">돌아가기</button>
	<button id="update" class="waves-effect waves-light btn  blue darken-4" value="${bvo.seq}">수정하기</button>
	<button id="delete" class="waves-effect waves-light btn red accent-3"
		value="${bvo.seq}">삭제하기</button>

	<script type="text/javascript">
		(function($) {
			$(document).ready(function() {
				$('#return').on("click", function() {
					$(location).attr("href", "list.board");
				});

				$('#update').on("click", function() {
					var password = prompt("게시물 패스워드를 입력하세요");
					var seq = $("#delete").val();

					$.ajax({
						type : "post",
						data : {
							"seq" : seq,
							"password" : password
						},
						url : "pwcheck.board",
						success : function(result) {
							if (result == true) {
								alert("게시물 수정 페이지로 이동합니다!");
								$(location).attr("href", ("update.board?seq="+seq));
							}else{
								alert("패스워드가 틀립니다.");
							}
						}
					});
				});

				$('#delete').on("click", function() {
					var password = prompt("게시물 패스워드를 입력하세요");
					var seq = $("#delete").val();

					$.ajax({
						type : "post",
						data : {
							"seq" : seq,
							"password" : password
						},
						url : "pwcheck.board",
						success : function(result) {
							if (result == true) {
								alert("게시물 삭제 완료!");
								$(location).attr("href", ("delete.board?seq="+seq));
							}else{
								alert("패스워드가 틀립니다.");
							}
						}
					});
				});
			});
		})(jQuery)
	</script>
</body>
</html>