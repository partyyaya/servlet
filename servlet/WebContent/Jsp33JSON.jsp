<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%@ page errorPage="Jsp07errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/ming" 
	user="root" password="root" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 利用c:import 抓遠端資料 -->
<c:import url="http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx" var="data"/>
<%
	//須先把org.json包export成jar包,再將其胞在lib裡面使用
	String strJSON = (String)pageContext.getAttribute("data");
	JSONArray root = new JSONArray(strJSON);
	for(int i=0;i<root.length();i++){
		JSONObject objData = root.getJSONObject(i);
		String name=objData.getString("Name");
		String tel=objData.getString("Tel");
		String address=objData.getString("Address");
		out.println(name+":"+tel+":"+address+"<br/>");
	}
%>
</body>
</html>