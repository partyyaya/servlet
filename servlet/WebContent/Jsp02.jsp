<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 沒加!只存在於%%裡面(區域變數) -->
<%int a=10;%>
<!-- !:代表static變數 ,存在於整個Jsp02的類別裡-->
<%!int b=10;%>
a=<%=a++ %><br/>
b=<%=b++ %>
</body>
</html>