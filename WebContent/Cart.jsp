<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.CartBean"  import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
padding-right: 10px;
}
</style>
</head>
<body>
<form action="Top.jsp">
	<input type="submit" value="トップへ">
</form>
<form action="ProductList.jsp">
	<input type="submit" value="商品一覧へ">
</form>
	<table>
	<c:forEach var="obj" items="${cartlist}" varStatus="status">
		<tr>
			<td>${obj.productname}</td>
			<td>カラー：${obj.color}</td>
			<td>${obj.quantity}個</td>
			<td><form action="CartUpdate" method="post">
			    <input type="hidden" name="listnumber" value=${status.index}>
			    <input type="submit" value="変更"></form></td>
			<td><form action="CartDelete" method="post">
				<input type="hidden" name="listnumber" value=${status.index}>
				<input type="submit" value="削除"></form></td>
		</tr>
	</c:forEach>
	</table>
	<form action="Settlement" method="post">
		<input type="submit" value="購入へ">
	</form>
</body>
</html>