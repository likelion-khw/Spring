<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드 결과</title>
</head>
<body>
	<h1>현재 전송파일</h1>
	<h3>작성자는 : ${uploadvo.id}</h3>
	<h3>파일설명은 : ${uploadvo.description}</h3>
	<h3>파일 1 : ${uploadvo.file1.getOriginalFilename()}</h3>
	<h3>파일 2 : ${uploadvo.file2.getOriginalFilename()}</h3>
</body>
</html>