<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,board.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물리스트</title>
<style>
* {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

table {
	border: 3px purple solid;
	margin-bottom : 10px;
}

td {
	border: 1px gray solid;
}
</style>
</head>
<body>
	<h1>게시물 리스트입니다.</h1>
	<%
		ArrayList<BoardVO> abvo = (ArrayList<BoardVO>) request.getAttribute("abvo");
	%>

	<table>
		<tr>
			<td>게시물번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>댓글</td>
		</tr>
		<%
			for (BoardVO vo : abvo) {
		%>
		<tr>
			<td><%=vo.getSeq()%></td>

			<td><%=vo.getTitle()%></td>

			<td><%=vo.getWriter()%></td>

			<td><%=vo.getContents()%></td>

			<%
				if (vo.getReply() == null) {
			%>
			<td>
			</td>
				<%
					} else {
				%>
			
			<td><%=vo.getReply().getNickname()%> : <%=vo.getReply().getContents()%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
	<a href="/nonspringexam/insert.board"><button id="list">게시물 추가</button></a>
	<a href="/nonspringexam/update.board"><button id="list">게시물 수정</button></a>
	<a href="/nonspringexam/delete.board"><button id="list">게시물 삭제</button></a>
	<a href="/nonspringexam/reply.board"><button id="list">댓글 추가</button></a>

</body>
</html>