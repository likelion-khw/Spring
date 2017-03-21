<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드폼</title>
</head>
<body>
	<form action="upload.file" method="post"
		enctype="multipart/form-data">
		전송하는사람 : <input type="text" name="id"><br> 
		파일설명 : <input type="text" name="description"><br> 
		파일1 : <input type="file" name="file1"><br> 
		파일2 : <input type="file" name="file2"><br> 
		<input type="submit" value="파일전송">
	</form>
</body>
</html>