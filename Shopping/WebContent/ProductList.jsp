<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ProductBean"  import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%int count=1; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<form>
<button type="button" onclick="history.back()">戻る</button>
</form>
<h2>商品一覧</h2>
	<table>
		 <c:forEach var="obj" items="${productlist}" varStatus="status">
        <tr>
        	<td><img src="${pageContext.request.contextPath}/${obj.url}" width="385" height="172"></td>
			<th><c:out value="${obj.productname}"/></th>
			<td><c:out value="${obj.price}"/>円　</td>
			<td><form action="Colorcode" method="post">
					<input type=submit value=カラー選択へ>
					<input type="hidden" name="product" value="<%=count%>">
				</form></td>
		</tr>
		<%count=count+1; %>
		</c:forEach>
	</table>


</body>
</html>