<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>doC</title>
</head>
<body>
	<h1>이곳은 doC입니다</h1>
	<h3>
	아이디 : ${map.member.id }<br>
	비번 : ${map.member.pw }<br>
	이름 : ${map.member.name }
	</h3>
</body>
</html>