<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,edu.bit.mymvc2.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 검색</title>
</head>
<body>
	<form action="searchlist.member">
		<select name="searchTitle">
			<c:forEach items="${conditionlist}" var="con">
				<option>${con}</option>
			</c:forEach>
		</select> <input type="text" name="searchValue"> <input type="submit"
			value="검색">
	</form>

	<table border="2" style="margin-top:20px">
		<c:forEach items="${result}" var="vo">
			<tr>
				<td>아이디</td>
				<td><a href="get.member?id=${vo.id}">${vo.id}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>