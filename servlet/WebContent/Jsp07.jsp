<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*,java.io.*" %>
<%@page session="true" buffer="8kb" autoFlush="true"%>
<!-- session預設為true ,buffer預設8k:緩衝區,autoFlush(預設為true):資料滿了則輸出出去
%@page,include,taglib:代表只是元素
-->
<%@page info="測試一下" %>
<%@ page errorPage="Jsp08errorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=getServletInfo() %>
<% 
	int a=10,b=0;
	out.print(a/b);
%>
</body>
</html>