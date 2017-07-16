<%@page import="java.util.Enumeration"%>
<%@page import="java.io.*"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="Jsp07errorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	//web.xml:context:upload-path:自己的路徑
	String uploadPath = pageContext.getServletContext().getInitParameter("upload-path");
	
	MultipartRequest req = new MultipartRequest(request,uploadPath,"UTF-8");
	
	Enumeration items = req.getFileNames();
	while(items.hasMoreElements()){
		String str = (String)items.nextElement();
		File file = req.getFile(str);
		String FSName = req.getFilesystemName(str);
		String OrgName = req.getOriginalFileName(str);
		out.print(str+":"+FSName+":"+OrgName+"<br/>");
	}
	out.print("<hr/>");
	Enumeration params = req.getParameterNames();
	while(params.hasMoreElements()){
		String param = (String)params.nextElement();
		String value = req.getParameter(param);
		out.print(param+":"+value+"<br/>");
	}
%>
</body>
</html>