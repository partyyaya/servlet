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
<c:catch var="errorMesg">
	<%
		String num=request.getParameter("num");
		int n= Integer.parseInt(num);
		out.print(n);	
	%>
</c:catch>
Hello,ok<br/>
${errorMesg }
<hr/>

<c:if test="${param.name =='admin' }">admin</c:if>
<c:if test="${param.name !='admin'}" var='result'>user</c:if>
<hr/>
${result}

</body>
</html>