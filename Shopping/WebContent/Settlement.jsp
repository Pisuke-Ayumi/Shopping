<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ProductBean" import="bean.UsersBean" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="PaymentDec" method="post">

	<table>
		<c:forEach var="obj" items="${cartlist}" varStatus="status">
		<tr>
			<td>${obj.productname}</td>
			<td>${obj.color}</td>
			<td>${obj.quantity}個</td>
			<td>${obj.price}</td>
		</tr>
	</c:forEach>
		<tr>
			<th>合計</th>
			<th>${sum}</th>
		</tr>
	</table>

	<ul>支払い方法
		<li><input type="radio" name="payment" value="代金引換">代金引換</li>
		<li><input type="radio" name="payment" value="コンビニ払い">コンビニ払い</li>
		<li><input type="radio" name="payment" value="後払い">後払い</li>
		<li><input type="radio" name="payment" value="銀行振込">銀行振込</li>
	</ul>

	登録済みの住所に送付します

	<table>
		<tr>
			<td>氏名</td>
			<td>${usersbean.username}</td>
		</tr>
		<tr>
			<td>住所</td>
			<td>〒${usersbean.post}</td>
		</tr>
		<tr>
			<td></td>
			<td>${usersbean.address}</td>
		</tr>
		<tr>
			<td>電話番号</td>
			<td>${usersbean.phone}</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="確認へ"></td>
		</tr>
	</table>

</form>
</body>
</html>