<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//可在google進階設定>語言:設定國家,回發現不同
	Locale locale =  request.getLocale();
%>
Locale:<%=locale.getCountry() %><br/>
Locale:<%=locale.getDisplayCountry() %><br/>
Locale:<%=locale.getLanguage() %><br/>
<hr/>
<fmt:setBundle basename="res"/>
<fmt:message key="Hello"/>
<fmt:message key="World"/>
<hr/>
<fmt:message key="CompanyName"/>
<hr>
<%
Date now = new Date();
out.print(now);
pageContext.setAttribute("now", now);//需放入區域才能拿到物件
%>
<hr/>
<fmt:setTimeZone value="Africa/Kampala"/>
<fmt:formatDate value="${now }" type="both" dateStyle="long"/>

<fmt:setTimeZone value="Asia/Taipei"/>
<fmt:formatDate value="${now }" type="both" dateStyle="long"/>
<hr/>

Default:<fmt:formatNumber value="${123456.8907 }"/><br/>
沒有千分位:<fmt:formatNumber value="${123456.8907 }" groupingUsed="false"/><br/>
Max 4 digit(整數最大4位):<fmt:formatNumber value="${123456.8907 }" maxIntegerDigits="4"/><br/>
Min 4 digit(整數最小8位):<fmt:formatNumber value="${123456.8907 }" minIntegerDigits="8" groupingUsed="false"/><br/>
Faction Max 2 digit(小數點取兩位):<fmt:formatNumber value="${123456.8907 }" maxFractionDigits="2"/><br/>
貨幣:<fmt:formatNumber value="${123}" type="currency" currencyCode="JPY"/><br/>

</body>
</html>