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
		<td><input type="text" name="id" size="40"></td>
	  </tr>

	  <tr>
		<th>パスワード</th>
		<td><input type="password" name="pass" size="40" maxlength="20" placeholder="半角英字{大小} 数字　全て含め8文字以上"
		           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"></td>
	  </tr>
	  <tr>
		<th>確認</th>
		<td><input type="password" name="pass2" size="40" maxlength="20" placeholder="パスワード再入力　"
		           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"></td>
	  </tr>

	  <tr>
		<th>氏名</th>
		<td><input type="text" name="name" size="40" maxlength="20"></td>
	  </tr>

	  <tr>
	    <th>住所</th>
	    <td><input type="text" name="address" size="40" maxlength="20" placeholder="県から入力"></td>
	  </tr>

	  <tr>
	    <th>郵便番号</th>
	    <td><input type="text" name="post" size="40" maxlength="20" placeholder="例)000-0000　半角" pattern="\d{3}-?\d{4}"></td>
	  </tr>

	  <tr>
	    <th>電話番号</th>
	    <td><input type="text" name="phone" size="40" maxlength="20" placeholder="例)090-1111-2222　半角" pattern="\d{2,4}-\d{3,4}-\d{3,4}"></td>
	  </tr>

	  <tr>
	    <th>生年月日</th>
	    <td><input type="text" name="birthday" size="40" maxlength="20" placeholder="例)1990/01/01　半角" pattern="\d{4}/\d{2}/\d{2}"></td>
	  </tr>

	  <tr>
		<th>性別</th>
		<td><input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女</td>
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