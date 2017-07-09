<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- isELIgnored:預設為false,若為true則el表達是功用消失 -->
<%@page isELIgnored="false" %>
<%@page import="java.util.*" %>
<%
	String[] names = {"ming","iii","ok"};
	request.setAttribute("usernames", names);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("AAA");
	list.add("BBB");
	list.add("CCC");
	request.setAttribute("list", list);
	
	HashMap<String,String>map = new HashMap<>();
	map.put("name", "Ming");
	map.put("account", "ming");
	map.put("passwd", "12345");
	request.setAttribute("hashmap", map);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 注意:在EL表達式只能取得作用域內的參數,所以names[0]會取得不到 -->
Name1:${usernames[0]}<br/>
Name2:${usernames[1]}<br/>

<!-- 網址後輸入:?i= -->

List1:${list[0]}<br/>
List1:${list[param.i]}<br/>

HashMap:${hashmap["account"]}<br/>

${10+5}<br/>
${(param.q==1)?"yes":"no"}<br/>
${3>5}<br/>
<!-- 以  AscII碼進行比較 -->
${"a"<"b" }<br/>
${"4">3 }<br/>

</body>
</html>