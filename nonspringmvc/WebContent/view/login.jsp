<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="mvc.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MemberVO mvo = (MemberVO)request.getAttribute("log"); %>
	<h1><%=mvo.getId()%> : <%=mvo.getPw()%> 회원님이 접속하셨습니다.</h1>
</body>
</html>