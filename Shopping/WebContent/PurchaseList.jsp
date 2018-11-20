<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.PurchaseBean" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Top.jsp">
	<input type="submit" value="戻る">
</form>
	<table>
		<tr>
			<th>購入日</th>
			<th>商品名</th>
			<th>カラーコード</th>
			<th>個数</th>
			<th>支払い方法</th>
		</tr>

		<c:forEach var="obj" items="${purchlist}" varStatus="status">
			<tr>
				<td><c:out value="${obj.history}"/></td>
				<td><c:out value="${obj.puroductname}"/></td>
				<td><c:out value="${obj.color}"/></td>
				<td><c:out value="${obj.quanty}"/></td>
				<td><c:out value="${obj.payment}"/></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>