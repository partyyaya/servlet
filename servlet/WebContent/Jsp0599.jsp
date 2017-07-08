<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='100%'>

	<%
		//要列印幾列
		for(int k=0;k<=4;k++){
			out.print("<tr>");
			//每一列4格
			for(int j=2+4*k;j<=5+4*k;j++){ 
				if((j+k)%2==0){
					out.print("<td bgcolor='pink'>");
				}else{
					out.print("<td bgcolor='yellow'>");
				}
				for(int i=1;i<=9;i++){
					out.print(j+"x"+i+"="+j*i+"<br/>");
				}
				out.print("</td>");				
			}
			out.print("</tr>");
		}
	%>				
	
</table>
</body>
</html>