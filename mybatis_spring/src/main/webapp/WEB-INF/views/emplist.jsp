<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.spring.mybatis.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 리스트</title>
</head>
<body>
	<%-- <%
		List<EmpVO> list = (List<EmpVO>) request.getAttribute("emplist");
		for (EmpVO vo : list) {
	%>
	<h4><%=vo.toString()%></h4>
	<%
		}
	%> --%>

	<h2>====================================================================</h2>

	<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>이메일</td>
			<td>입사일</td>
			<td>직종</td>
			<td>급여</td>
		</tr>
		<c:forEach items="${emplist}" var="vo">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.email}</td>
				<td>${vo.hire_date}</td>
				<td>${vo.job_id}</td>
				<td>${vo.salary}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>