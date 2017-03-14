<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.bit.mymvc2.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 결과출력</title>
</head>
<body>
<h1>로그인 결과 출력</h1>
<h3>아이디 : <%=((MemberVO)request.getAttribute("memberVO")).getId()%><br>
아이디 : ${memberVO.id }	<!-- EL표현식getAttribute할 수 있는 값을 불러와 바로 사용할 수 있다. 형변환도 필요없이. 메소드도 get안하고 바로 변수명으로 입력해도 된다. -->
<br>
암호 : ${memberVO.pw }
<br>
암호:<%=((MemberVO)request.getAttribute("memberVO")).getPw()%><br>
</h3>
</body>
</html>