<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag dynamic-attributes="product"%>
<%@ attribute name="user" required="true" %>
<%@ tag import="java.util.*" %>
<%
out.println("<h1>Brad Big Company</h1>");
	HashMap<String ,String> ps= (HashMap<String,String>) jspContext.getAttribute("product");
	if(ps.containsKey("name")){
		out.println(ps.get("name"));
	}
%>
<table border="1" width="100%">
	<tr>
		<th>item</th>
		<th>value</th>
	</tr>
</table>