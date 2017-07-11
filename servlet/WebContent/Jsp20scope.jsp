<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.ming.javabeans.beanUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//pageContext:只存在於同一jsp頁面
	//request HTTP請求開始到結束這段時間 (對指定對象)
	//session HTTP會話開始到結束這段時間
	//application 伺服器啟動到停止這段時間
	
	//Scope
	//1.page
	pageContext.setAttribute("name", "<h2>page</h2>");
	//2.request
	request.setAttribute("name", "<h3>request</h3>");
	//3.session
	session.setAttribute("name", "<h4>session</h4>");
	//4.application
	application.setAttribute("name", "app");
%>

Page:${pageScope.name}<br/>
Request:${requestScope.name}<br/>
Session:${sessionScope.name}<br/>
Application:${applicationScope.name}<br/>

1.m1():<%=beanUtil.m1() %><br/>
2.m1():${beanUtil.m1()}<br/>
<!-- 方法傳入參數方式 -->
3.m1():${beanUtil.m1(param.x,param.y)}<br/>
4.con():${beanUtil("123")}<br/>


</body>
</html>