<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.bit.mymvc2.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MemberVO mvo = (MemberVO)session.getAttribute("memberVO"); %>

<h3><%=mvo.getId() %></h3>
<h3><%=mvo.getName() %></h3>
<h3><%=mvo.getEmail() %></h3>
<h3><%=mvo.getPhone() %></h3>

<h4>이제 이메일 , 장바구니, 자기정보수정 메뉴를 이용할 수 있습니다.</h4>
</body>
</html>