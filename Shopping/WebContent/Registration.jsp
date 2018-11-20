<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("frg",0);
  String iderr=(String)request.getAttribute("iderr");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(iderr != null){%>
	<%=iderr%>
<%}else{%>
	全ての項目を入力してください
<%}%>
<br><br>
	<form action="UsersRegist" method="post" name="form1">

	<table>
	  <tr>
		<th>メールアドレス</th>
		<td><input type="text" name="id" size="30"></td>
	  </tr>

	  <tr>
		<th>パスワード</th>
		<td><input type="password" name="pass" size="30" maxlength="20" placeholder="半角英数字"></td>
	  </tr>
	  <tr>
		<th>確認</th>
		<td><input type="password" name="pass2" size="30" maxlength="20" placeholder="パスワード再入力　半角英数字"></td>
	  </tr>

	  <tr>
		<th>氏名</th>
		<td><input type="text" name="name" size="30" maxlength="20"></td>
	  </tr>

	  <tr>
	    <th>住所</th>
	    <td><input type="text" name="address" size="30" maxlength="20" placeholder="県から入力"></td>
	  </tr>

	  <tr>
	    <th>郵便番号</th>
	    <td><input type="text" name="post" size="30" maxlength="20" placeholder="例)000-0000　半角"></td>
	  </tr>

	  <tr>
	    <th>電話番号</th>
	    <td><input type="text" name="phone" size="30" maxlength="20" placeholder="例)09011112222　半角"></td>
	  </tr>

	  <tr>
	    <th>生年月日</th>
	    <td><input type="text" name="birthday" size="30" maxlength="20" placeholder="例)1990/01/01　半角"></td>
	  </tr>

	  <tr>
		<th>性別</th>
		<td><input type="radio" name="sex" value="男"> 男
			<input type="radio" name="sex" value="女"> 女</td>
	  </tr>
	</table>

	<input type="hidden" name="authority" value="U">

	<input type="submit" value="確認画面へ" onClick="return checkForm();">
	</form>

<script>
function checkForm(){
    if(document.form1.id.value == "" || document.form1.pass.value == ""
    		|| document.form1.pass2.value == "" || document.form1.name.value == ""
    		|| document.form1.address.value == "" || document.form1.post.value == ""
    		|| document.form1.phone.value == "" || document.form1.birthday.value == ""
    		|| document.form1.sex.value == "" ){
        alert("必須項目を入力して下さい。");
	return false;
    }else{
    	if (form1.pass.value != form1.pass2.value){
    		alert("パスワードが一致していません。再度入力して下さい。");
    		return false;
    	}else{
    		return true;
    	}
    }
}

</script>


</body>
</html>