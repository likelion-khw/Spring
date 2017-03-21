<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<style>
* {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 800px;
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<h1>게시물 수정</h1>
	<table class="centered z-depth-5">
		<tr>
			<td>TITLE</td>
			<td><div class="input-field">
					<input id="title" name="title" type="text" class="validate" value="${bvo.title}">
					<label for="title">제목을 입력하세요</label>
				</div></td>
		</tr>
		<tr>
			<td>CONTENT</td>
			<td><div class="input-field">
					<textarea id="contents" name="contents"
						class="materialize-textarea">${bvo.contents}</textarea>
					<label for="contents">내용을 입력하세요</label>
				</div></td>
		</tr>
		<tr>
			<td>WRITER</td>
			<td><div class="input-field">
					<input id="writer" name="writer" type="text" class="validate" value ="${bvo.writer}">
					<label for="writer">작성자(java, ggabi, pokemon)</label>
				</div></td>
		</tr>
		<tr>
			<td>PASSWORD</td>
			<td><div class="input-field">
					<input id="password" name="password" type="text" class="validate" value="${bvo.password}">
					<label for="password">패스워드는 숫자</label>
				</div></td>
		<tr>
	</table>
	<input id="seq" type="hidden" value="${bvo.seq}">
	<input id="sub" type="button" class="btn red accent-3" value="수정완료">
	<input id="return" type="button" class="btn" value="돌아가기">

	<script type="text/javascript">
		$("#sub").on('click', function() {
			var ist = confirm("수정을 완료하시겠습니까?");
			var seq = $("#seq").val();
			var title = $("#title").val();
			var contents = $("#contents").val();
			var writer = $("#writer").val();
			var password = $("#password").val();

			if (ist == true) {
				$.ajax({
					type : "post",
					data : {
						"seq":seq,
						"title" : title,
						"contents" : contents,
						"writer" : writer,
						"password" : password
					},
					url : "update.board",
					success : function(result) {
						if (result == true) {
							alert("==== 게시물 변경 완료! ==== \n 게시물 리스트로 이동합니다.");
							$(location).attr("href", "list.board");
						} else {
							alert("=== 게시물 변경 오류 === \n 필요 사항을 재 확인하세요.")
						}
					}
				});
			}
		});

		$("#return").on('click', function(e) {
			var ist = confirm("게시물 리스트로 돌아가시겠습니까?");
			if (ist == true) {
				$(location).attr("href", "list.board");
			}
		});
		$('#contents').trigger('autoresize');
	</script>
</body>
</html>