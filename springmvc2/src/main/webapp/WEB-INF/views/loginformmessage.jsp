<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>로그인폼</title>
</head>
<body>
	<select id="lang">
		<option>언어설정</option>
		<option value="ko">한국어</option>
		<option value="en">English</option>
	</select>

	<h1>
		<spring:message code="title.value" />
	</h1>
	<form action="login.message" method="post">
		<spring:message code="id.value" />
		<input type="text" name="id"><br>
		<spring:message code="pw.value" />
		<input type="text" name="pw"><br>
		<button>
			<spring:message code="submit.value" />
		</button>
	</form>

	<script type="text/javascript">
		$("#lang").on("change", function() {
			var lang = $(this).val();
			$(location).attr("href", ("login.message?lang=" + lang));
		})
	</script>
</body>
</html>