<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--apache-tomcat-8.5.16\webapps\examples\WEB-INF\lib -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="member" class="tw.ming.javabeans.bean01" ></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("x","123");

%>
<c:out value="${x}" default="no value"></c:out><br/>
<c:out value="${y}" default="no value"></c:out><br/>
<c:out value = "${'Hello world'}"/><br/>

<c:set var="var1" value="123" scope="page"/>
${var1}<br/>
${var1+100}<br/>

<c:set var="var2">
<% out.println("ok");%><br/>
321
</c:set>
${var2}<br/>

<c:set target="${member}" property="id"  >
007
</c:set>
<c:set target="${member}" property="name"  >
ming
</c:set>
${member}<br/>

<c:remove var="var1"/>
<c:out value="${var1 }" default="no value"></c:out>

</body>
</html>