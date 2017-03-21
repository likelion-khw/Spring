<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인결과</title>
</head>
<body>
	<%
		if (request.getAttribute("id").equals("")) {
	%>
	<h1><spring:message code="id.required" /></h1>
	<%
		} else {
	%>
	<h1><spring:message code="id.value"/> ${id} </h1>
	<%
		}
	%>
	
	<%
		if (request.getAttribute("pw").equals("")) {
	%>
	<h1><spring:message code="pw.required" /></h1>
	<%
		} else {
	%>
	<h1><spring:message code="pw.value"/> ${pw} </h1>
	<%
		}
	%>
</body>
</html>