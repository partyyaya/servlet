<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.ming.javabeans.*" %>
<%
	//bean01 bean = new bean01();
	//bean.setId("001");bean.setName("ming");
	bean01 bean2 = new bean01("002","ming2");
	//setAttribute可存放物件
	application.setAttribute("member", bean2);
	bean2.setId("005");//當此頁面跑完後在傳入application
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome,<%=bean2.getName() %><br/>
<%=bean2 %>
<%bean2.m1(); %>
</body>
</html>