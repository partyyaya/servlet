<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 會自動建構,所以會自動用預設建構式,useBean id="可自取名子",setProperty name="id設的名子" -->
<jsp:useBean id="member" class="tw.ming.javabeans.bean01" ></jsp:useBean>
<jsp:setProperty name="member" property="id" value="${param.id}"/>
<jsp:setProperty name="member" property="name" value="${param.name}"/>
<!-- 網址後加上?id=222&name=er,${param.id}就會得到id的參數 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ${member.name}:會自動呼叫getName方法,${member}:會自動呼叫toString方法 -->
Welcome, ${member.name} <br/> ${member}
<jsp:getProperty property="name" name="member"/>

</body>
</html>