<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.ming.javabeans.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='controlServlet' method='post'>
		<input type='text' name='guessNumber' /><br />
		<input type='submit' value='Go'>
		<input type='submit'  name='giveUp' value='giveUp'>
	</form>
	<hr/>
	${bean.guessNumber} ${bean.a}A${bean.b}B
	<hr/>
	<%
	String giveup = (String)request.getAttribute("giveUp");
	if( giveup!=null) {
		%>
			${bean.randNumber}
		<% 	 
	}
	%>
</body>
</html>