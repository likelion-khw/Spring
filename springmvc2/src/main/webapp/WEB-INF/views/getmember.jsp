<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,edu.bit.mymvc2.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1><%=request.getAttribute("msg") %></h1> --%>
	<c:forEach items="${amvo}" var="vo">
		<c:if test="${vo.id == param.id}">
			<h1>아이디는 ${vo.id} 패스워드는 ${vo.pw} 입니다</h1>
		</c:if>
	</c:forEach>
	
	<br>
	
	==================================================
	<%
		ArrayList<MemberVO> amvo = (ArrayList<MemberVO>) request.getAttribute("amvo");
		String id = (String) request.getAttribute("id");
		boolean ist = false;
		for (MemberVO vo : amvo) {
			if (vo.getId().equals(id)) {
				ist = true;
				out.print("<h1> id : " + vo.getId() + " pw : " + vo.getPw());
			}
		}

		if (ist == false) {
			out.print("<h1>해당 id : " + id + "은(는) 존재하지 않습니다.</h1>");
		}
	%>
</body>
</html>