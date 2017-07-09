<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 字串相加 :?x=12&y=12-->
${param.x}+${param.y}=${param.x+param.y}<br/>
${param.a}x${param.b}=${param.a*param.b}<br/>

<form >
	<input type='text' name='x' value="${param.x}" />
	+
	<input type='text' name='y' value="${param.y}" />
	<input type='submit' value='=' />${param.x+param.y}
</form>

<form >
	<input type='text' name='a' value="${param.a}" />
	x
	<input type='text' name='b' value="${param.b}" />
	<input type='submit' value='=' />${param.a*param.b}
</form>
</body>
</html>