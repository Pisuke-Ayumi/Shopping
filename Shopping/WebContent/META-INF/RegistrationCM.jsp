<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UsersRegist" method="post">
	<table>
	  <tr>
		<th>メールアドレス</th>
		<td> ${id}</td>
	  </tr>

	  <tr>
		<th>パスワード</th>
		<td> ${pass}</td>
	  </tr>

	  <tr>
		<th>氏名</th>
		<td> ${name}</td>
	  </tr>

	  <tr>
	    <th>住所</th>
	    <td> ${address}</td>
	  </tr>

	  <tr>
	    <th>郵便番号</th>
	    <td> ${post}</td>
	  </tr>

	  <tr>
	    <th>電話番号</th>
	    <td> ${phone}</td>
	  </tr>

	  <tr>
	    <th>生年月日</th>
	    <td> ${birthday}</td>
	  </tr>

	  <tr>
		<th>性別</th>
		<td> ${sex}</td>
	  </tr>

	</table>
	<%session.setAttribute("frg",1);%>
	<input class="logbt" type="submit" value="登録">
	</form>
	<form action="Registration.jsp"><input type="submit" value="キャンセル"></form>
</body>
</html>