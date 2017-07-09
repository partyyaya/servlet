<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	//application比session範圍大
	application.setAttribute("x", 123);
	request.setAttribute("x", (int)(Math.random()*49+1));
	String x=request.getParameter("x");
	
	Integer intx = (int)request.getAttribute("x");
	
	out.println(x+"<br/>");
	out.println(intx+"<br/>");
%>
<br/>
<a href="Jsp11applicationGet.jsp">go to 12</a>
</body>
</html>