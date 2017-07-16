<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="Jsp07errorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Jsp3602.jsp" 
	enctype="multipart/form-data" method="post">
	<input type="text" name="user1" /><br>
	<input type="text" name="user2" /><br>
	<input type="file" name="upload1" /><br>
	<input type="file" name="upload2" /><br>
	<input type="submit" value="Upload" />
</form>
</body>
</html>