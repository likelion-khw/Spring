<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 작성</title>
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
	<h1>게시물 작성</h1>
	<form action="write.board" method="post" enctype="multipart/form-data"
		id="formdata">

		<table class="centered z-depth-5">
			<tr>
				<td>TITLE</td>
				<td><div class="input-field">
						<input id="title" name="title" type="text" class="validate">
						<label for="title">제목을 입력하세요</label>
					</div></td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td><div class="input-field">
						<textarea id="contents" name="contents"
							class="materialize-textarea"></textarea>
						<label for="contents">내용을 입력하세요</label>
					</div></td>
			</tr>
			<tr>
				<td>WRITER</td>
				<td><div class="input-field">
						<input id="writer" name="writer" type="text" class="validate">
						<label for="writer">작성자(java, ggabi, pokemon)</label>
					</div></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><div class="input-field">
						<input id="password" name="password" type="text" class="validate">
						<label for="password">패스워드는 숫자</label>
					</div></td>
			<tr>
			<tr>
				<td>FILE1</td>
				<td><input id="file1" name="file1" type="file" class="validate">
				</td>
			<tr>
			<tr>
				<td>FILE2</td>
				<td><input id="file2" name="file2" type="file" class="validate">
				</td>
			<tr>
		</table>
		<input type="submit" value="작성완료" id="sub1">
	</form>
	<input id="sub" type="button" class="btn red accent-3" value="작성완료">
	<a class="waves-effect waves-light btn" href="#insert">작성완료</a>
	<a class="waves-effect waves-light btn" href="#return">돌아가기</a>


	<!-- 게시물 리스트 이동하는 modal  -->
	<div id="return" class="modal">
		<div class="modal-content">
			<h4>돌아가기</h4>
			<p>게시물 리스트로 돌아가시겠습니까?</p>
		</div>
		<div class="modal-footer" id="tu">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">취소</a>
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">확인</a>
		</div>
	</div>

	<script type="text/javascript">
		$("#sub1").on('click', function(e) {
			var ist = confirm("작성을 완료하시겠습니까?");
			if (ist == false) {
				e.preventDefault();
			}
		});

		$("#sub").on('click', function() {
			var ist = confirm("작성을 완료하시겠습니까?");
			var title = $("#title").val();
			var contents = $("#contents").val();
			var writer = $("#writer").val();
			var password = $("#password").val();

			if (ist == true) {
				$.ajax({
					type : "post",
					data : {
						"title" : title,
						"contents" : contents,
						"writer" : writer,
						"password" : password,
					},
					url : "write.board",
					success : function(result) {
						if (result == true) {
							alert("==== 게시물 등록 완료! ==== \n 게시물 리스트로 이동합니다.");
							$(location).attr("href", "list.board");
						} else {
							alert("=== 게시물 등록 오류 === \n 필요 사항을 재 확인하세요.")
						}
					}
				});
			}
		});

		//textarea 자동적으로 크기 조정
		$('#contents').trigger('autoresize');

		//게시물돌아가기 modal의 이벤트 함수
		$('.modal#return').modal({
			ready : function() {
				$('div a').on('click', function() {
					var temp = $(this).text();

					if (temp == '확인') {
						$(location).attr("href", "list.board");
					}
				})
			}
		});
	</script>
</body>
</html>