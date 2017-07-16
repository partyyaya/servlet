<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="Jsp07errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="theString" value="I am a String"/>
${fn:contains(theString,'test') }
<hr/>
<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:substringAfter(string1, 'is')}" />

<c:set var = "string1" value = "This is first String "/>
      <p>String (1) Length : ${fn:length(string1)}</p>

      <c:set var = "string2" value = "${fn:trim(string1)}" />
      <p>String (2) Length : ${fn:length(string2)}</p>
      <p>Final string : ${string2}</p>

<%
	String str = (String)pageContext.getAttribute("theString");
	out.print(str.contains("test")+"<br/>");
	String str2 = (String)pageContext.getAttribute("string2");
	out.print(str2);

%>
</body>
</html>