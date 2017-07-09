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
<%
	String[] names = {"brad","iii","ok","world"};
	pageContext.setAttribute("names", names);
	pageContext.setAttribute("step", 1);

%>

<table border='1' width='100%'>
	<tr>
		<th>index</th>
		<th>name</th>
		<th>count</th>
		<th>First</th>
		<th>Last</th>
	</tr>
	<c:forEach items="${names}" var="name" varStatus="status" begin="0" end="3" step="${step }">
		<tr>
			<td>${status.index }</td>
			<td>${name}</td>
			<td>${status.count}</td>
			<td>${status.first}</td>
			<td>${status.last}</td>
		</tr>	
	</c:forEach>
</table>
<hr/>
<%
	String line = "1,ming,male,0912-123456,2000-01-02,台中市太平區";
	pageContext.setAttribute("line", line);
%>
<c:forTokens items="${line }" delims="," var="field" varStatus="status">
${status.index}:${field }<br/><!-- 從0開始 -->
${status.count}:${field }<br/><!-- 從1開始 -->
</c:forTokens>
<hr/>

<c:import url="Jsp24.jsp" var="data2">
	<c:param name="x" value="1"></c:param>
	<c:param name="y" value="2"></c:param>
</c:import>
<c:out value="${data2 }"/>	
<hr/>

<c:import var = "data" url="https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm"/>
<c:out value="${data }"/>	
</body>
</html>