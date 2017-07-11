<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="tw.ming.javabeans.bean01"/>
<%
	bean01 bean = new bean01();
	bean.setId("008");bean.setName("ming05");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 統稱名叫:XML Tag -->>
<!-- declaration:宣告使用 -->
<jsp:declaration>
	int i;String name;
</jsp:declaration>

<!-- scriptlet:邏輯使用 -->
<jsp:scriptlet>
	i=10;
	name="ming06";
</jsp:scriptlet>

<!-- expression:輸出name -->
<jsp:expression>name</jsp:expression>

<!--bean物件會自動使用toString方法  -->
<jsp:expression>bean</jsp:expression>

<!-- 輸出文字使用 -->
<jsp:text> I am ming</jsp:text>
</body>
</html>