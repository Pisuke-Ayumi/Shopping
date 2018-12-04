<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.UsersBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Top.jsp">
<input type=submit value="トップへ">
</form>
	<form action="UpdateChoice" method="post">
	<table>
		<tr>
			<th align="left"><input type="radio" name="item" value="user_id">メールアドレス</th>
			<td>${userbean.id}</td>
		</tr>
		<tr>
			<th align="left"><input type="radio"name="item"value="password">パスワード</th>
			
		<tr>
			<th align="left"><input type="radio" name="item" value="user_name">氏名</th>
			<td>${userbean.username}</td>
		</tr>
		<tr>
			<th align="left"><input type="radio" name="item" value="street_address">住所</th>
			<td>${userbean.address}</td>
		</tr>
		<tr>
			<th align="left"><input type="radio" name="item" value="postal_code">郵便番号</th>
			<td>${userbean.post}</td>
		</tr>
		<tr>
			<th align="left"><input type="radio" name="item" value="phone_number">電話番号</th>
			<td>${userbean.phone}</td>
		</tr>
		<tr>
			<th align="left">　　誕生日</th>
			<td>${userbean.birthday}</td>
		</tr>
		<tr>
			<th align="left">　　性別</th>
			<td>${userbean.sex}</td>
		</tr>
	</table>
	<input type="submit" value="変更へ">
	</form>

</body>
</html>