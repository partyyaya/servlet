<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String method = request.getMethod();
	ServletRequest req = pageContext.getRequest();
	HttpServletRequest req2=(HttpServletRequest)pageContext.getRequest();
	
	//Query:會得到網址列的輸入方式:user=bfdsb&passwd=dsavds
	String query = req2.getQueryString();
	
	String user = req2.getParameter("user");
	String passwd =req2.getParameter("passwd");
	
	String ip =req2.getRemoteAddr();
	//判斷是否同一物件實體=>是
	if(request == req){
		out.print("ok");
	}
%>
Method:<%=method %><br/>
Query:<%=query %><br/>
User:<%=user %><br/>
Password:<%=passwd %><br/>
IP:<%=ip %><br/>
<hr/>
<!--request.method:呼叫屬性 (得到當前使用的方法種類:get or post ?) -->
Method:${pageContext.request.method}
</body>
</html>