<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
</head>
<body>
<%-- <h2><%=request.getAttribute("title")%></h2> --%>
<h2>${title }</h2> <!-- 업으면 null포인트 exception이 발생하는데 el표현식은 없으면 그냥 공백으로 출력하고 실행됨 -->
<form action="login.session" method="POST">
	아이디입력 : <input type="text" name="id" value="${memberVO.id}"><br>
	암호입력 : <input type="password" name="pw"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>