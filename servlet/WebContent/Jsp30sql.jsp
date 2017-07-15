<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/ming" 
	user="root" password="root" />
<sql:query sql="select * from member" var="result" />
<sql:update var="count">
insert into member (account,passwd,realname) values(?,?,?)
<sql:param>World</sql:param>
<sql:param>Hello</sql:param>
<sql:param>Hello,World</sql:param>
</sql:update>

${count }

</body>
</html>