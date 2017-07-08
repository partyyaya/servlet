<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
boolean[] check = new boolean[52];
int []poker=new int[52];
int temp;
	for(int i=0;i<52;i++){
		do{
			temp=(int)(Math.random()*52);
			
		}while(check[temp]);
			poker[i]=temp;
			check[temp]=true;	
		}
int[][]player=new int[4][13];
for(int i=0;i<poker.length;i++){
	player[i%4][i/4]=poker[i];
}
String[] suits = {"&spades;","&hearts;","&diams;","&clubs;"}; // suit[0]
String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "}; // values[0]
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='100%'>
	<tr>
	<%
		for(int []cards:player){
			out.print("<tr>");
			Arrays.sort(cards);
			for(int card:cards){
				out.print("<td>");
				out.print(suits[card/13] + values[card%13]);
				out.print("</td>");
			}
			out.print("</tr>");
		}
	%>
	</tr>
</table>
&spades;<br/>
&hearts;<br/>
&diams;<br/>
&clubs;<br/>
</body>
</html>