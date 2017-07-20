<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag dynamic-attributes="product"%>
<%@ attribute name="from" required="true" %>
<%@ attribute name="to" required="true" %>
<!-- name="user"代表標籤內必有屬性( required設為true)  -->
<%@ attribute name="user" required="true" %>
<%@ tag import="java.util.*" %>
<%
out.println("<h1>Brad Big Company</h1>");
	//得到標籤內所有屬性
	HashMap<String ,String> ps= (HashMap<String,String>) jspContext.getAttribute("product");
	//檢查標籤內屬性是否有name這個屬性
	if(ps.containsKey("name")){
		//若有則把name屬性的元素列印出來
		out.println(ps.get("name"));
	}
%>
<table border="1" width="100%">
	<tr>
		<th>item</th>
		<th>value</th>
	</tr>
</table>