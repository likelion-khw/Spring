<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>이메일</td>
			<td>입사일</td>
			<td>직종</td>
			<td>급여</td>
		</tr>
			<tr>
				<td>${oneEmp.id}</td>
				<td>${oneEmp.name}</td>
				<td>${oneEmp.email}</td>
				<td>${oneEmp.hire_date}</td>
				<td>${oneEmp.job_id}</td>
				<td>${oneEmp.salary}</td>
			</tr>
	</table>
</body>
</html>