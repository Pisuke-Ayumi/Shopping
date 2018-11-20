<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="UsersUpdate" method="post">
	<table>
		<tr>
			<th>登録済み</th>
			<th>${content}</th>
		</tr>
		<tr>
			<td>変更入力</td>
			<td><input type="text" name="content" size="30" maxlength="20"></td>
		</tr>
	</table>
	<input type="submit" value="変更">
	</form>

</body>
</html>