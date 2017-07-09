<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ming big company</h1>
<hr/>
<jsp:include page="Jsp10jspTag.jsp">
	<jsp:param value="123" name="x"/>
	<jsp:param value="456" name="y"/>	
</jsp:include>
</body>
</html>