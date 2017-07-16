<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag dynamic-attributes="product"%>
<%
	out.print("<h1> ming big company</h1>");

%>
<table border="1" width="100%">
	<tr>
		<th>item</th>
		<th>value</th>
	</tr>
	<c:forEach var="prod" items="${product}">
		<tr>
			<td>${prod.key }</td>
			<td>${prod.value }</td>
		</tr>
	</c:forEach>

</table>