<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ProductBean"  import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String id=(String)session.getAttribute("id"); %>
<%int count=1;%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<form action="ProductListDP" method="post">
		<input type=text name=key>
		<input type=submit value="検索">
	</form>

	<table>
		<c:forEach var="obj" items="${colorlist}" varStatus="status">
		<%session.setAttribute("count",count);%>
			<%if((count % 5) == 1){ %><tr><%}%>
				<td><img src="${pageContext.request.contextPath}/${obj.img}" width="241" height="108"><br><c:out value="${obj.code}"/></td>
			<%if((count % 5) == 0){%></tr><%}%>
			<%count=count+1;%>
		</c:forEach>
	</table>
<br><br><br>


<%if(id != null){ %>
<form action="CartIn" method="post">
	<table>
		<tr>
			<th>1.</th>
			<td>カラー<input type="text" name="color1"></td>
			<td>個数<input type="number" name="number1" size="2"></td>
		</tr>

	</table>
	<input type="submit" value="カートに入れる">
</form>
<%}else{%>
<form action="Login.jsp">
	<table>
		<tr>
			<th>1.</th>
			<td>カラー<input type="text" name="color1"></td>
			<td>個数<input type="number" name="number1" size="2"></td>
		</tr>
	</table>
	<input type="submit" value="カートに入れる">
</form>
<%}%>
</body>
</html>