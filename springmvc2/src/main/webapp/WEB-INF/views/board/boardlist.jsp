<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,board.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int count = (Integer) request.getAttribute("pagzing");
%>
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


<title>게시판 테스트</title>
<style>
* {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.title {
	width: 650px;
}

.num {
	width: 100px;
}

.writer {
	width: 130px;
}

table {
	width: 1000px;
}

td {
	border: 1px silver solid;
}

.tag {
	color: white;
	background-color: #4db6ac;
}
</style>
</head>
<body>

	<h1>${param.pageNum}페이지게시물</h1>

	<table class="highlight centered bordered z-depth-5">
		<tr>
			<td class="num tag">게시물번호</td>
			<td class="title tag">제목</td>
			<td class="writer tag">작성자</td>
			<td class="tag">조회수</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.seq}</td>
				<td><a href="detail.board?seq=${vo.seq}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.review}</td>
			</tr>
		</c:forEach>
	</table>

	<ul class="pagination">
		<li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
		<%
			for (int i = 1; i <= count; i++) {
		%>
		<li class="waves-effect"><a href="list.board?pageNum=<%=i%>"><%=i%></a></li>
		<%
			}
		%>
		<li class="waves-effect"><a href="#!"><i
				class="material-icons">chevron_right</i></a></li>
	</ul>


	<button id="write" class="waves-effect waves-light btn">글작성하기</button>

	<script type="text/javascript">

		var name;
			$("#write").on("click", function() {
				$(location).attr("href", "write.board");
			});

	</script>
</body>
</html>