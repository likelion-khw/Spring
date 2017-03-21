<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="i18n.do?lang=ko">한국</a>
<a href="i18n.do?lang=en">English</a>

<h1>${sitecount}</h1>

<h1><spring:message code="site.title" text="default value"/></h1>
<h1><spring:message code="site.count" text="default value" arguments="첫번째"/></h1>
<h1><spring:message code="msg.first" text="default value"/></h1>
</body>
</html>