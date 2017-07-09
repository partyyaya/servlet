<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.score>=90}">A</c:when>
	<c:when test="${param.score>=80}">B</c:when>
	<c:when test="${param.score>=70}">C</c:when>
	<c:when test="${param.score>=60}">D</c:when>
	<c:otherwise>down</c:otherwise>
</c:choose>
</body>
</html>