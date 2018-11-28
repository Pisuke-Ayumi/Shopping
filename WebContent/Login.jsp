<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String err=(String)request.getAttribute("err"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <article>
    <form action="Login" method="post">
      <table class="log">
        <caption class="err">
          <%if(err != null){ %>
            <%=err %>
            <%} %>
        </caption>
        <tr>
          <th>ユーザID</th>
          <th><input type="text" name="id" size="30" maxlength="20"><br></th>
        </tr>
        <tr>
          <th>パスワード</th>
          <th><input type="password" name="pass" size="30" maxlength="20"><br></th>
        </tr>
      </table>
  		<input class="logbt" type="submit" value="ログイン">
  	</form>
  </article>
  <br>
  <form>
  <a href="Registration.jsp">新規会員登録</a>
  </form>

</body>
</html>