<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원등록</title>
</head>
<body>
	<form action="insert.emp" method="post">
		<table>
			<tr>
				<td>사번 : <input type="text" name="id"></td>
			</tr>
			<tr>
				<td>이름 : <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>이메일 : <input type="text" name="email"></td>
			</tr>
			<tr>
				<td>직종 : <select name="job_id">
						<c:forEach items="${joblist}" var="job">
							<option>${job.job_id}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>급여 : <input type="text" name="salary"></td>
			</tr>
		</table>
		<input type="submit" value="등록완료">
	</form>
</body>
</html>