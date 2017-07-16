<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="x" required="true"%>
<%@attribute name="y" required="true"%>

<%@variable name-given="add"%>
<%@variable name-given="sub"%>
<%@variable name-given="multiply"%>
<%@variable name-given="divide"%>

<%//設置功能 %>
<c:set var="add" value="${x+y }"/>
<c:set var="sub" value="${x-y }"/>
<c:set var="mutiply" value="${x*y }"/>
<c:set var="divide" value="${x/y }"/>

<%//輸出(doBody):只活在(包在)logic.tag裡面->包在<ming:logic>裡面才能輸出 %>
<jsp:doBody/>