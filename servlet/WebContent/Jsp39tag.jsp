<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- prefix="ming"裡面名稱自取  -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="ming" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ming:test1/>
<hr/>
<ming:hello user="ming"/>
<hr/>
<ming:logic x="12" y="45">
	x+y=${add }
	x-y=${sub }
	x*y=${multiply }
	x/y=${divide }
</ming:logic>
<hr/>
<ming:keyValue name="mouse" id="001" price="100"/>
<hr>
<ming:HashMap user="brad" name="Mouse"/>
</body>
</html>