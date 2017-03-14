<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,edu.bit.mymvc2.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c 태크를 사용하기 위해 추가해야되는 선언문 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${amvo}" var="vo">
		<h3>
			<a href="get.member?id=${vo.id}">${vo.id}</a>
		</h3>
	</c:forEach>
	
	<!-- c라는 태크 라이브러리가 필요. 이후 jsp 파일에 c태크 설정 -->
	<%
		ArrayList<MemberVO> amvo = (ArrayList<MemberVO>) request.getAttribute("amvo");
		for (MemberVO vo : amvo) {
	%>
	<h3>
		멤버 ID : <a href="get.member?id=<%=vo.getId()%>&pw=<%=vo.getPw()%>"><%=vo.getId()%></a>
	</h3>
	<%
		}
	%>
</body>
</html>