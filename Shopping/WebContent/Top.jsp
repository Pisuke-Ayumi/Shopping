<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String id=(String)session.getAttribute("id");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<h1>Top</h1>
<%@include file="header.jsp" %>
<%if(id != null){ %>
 	<form class="logout" action="Login" method="get">
 		<input type="submit" value="ログアウト">
 	</form>

 	<form action="CartDP" method="post">
 		<input type="submit" value="カート">
 	</form>


 		<form action="UsersDelete" method="post">
 		<input type="submit" onClick="return clickdelete();"value="ユーザ削除">
 		<script>
 		function clickdelete(){
 		var delete1 = window.confirm("ユーザ情報を削除しますか？");
 			if(delete1){
 				return true;
 			}
 			return false;
 		}request.getRequestDispatcher("Top.jsp").forward(request,response);
 		</script>
 	</form>
	<form class="logout" action="UserInfo" method="post">
 		<input type="submit" value="登録情報確認">
 	</form>
 	<form action="PurchaseDP" method="get">
 		<input type="submit" value="購入履歴">
 	</form>

<%}else{ %>
	<form class="logout" action="Login.jsp" method="post">
 		<input type="submit" value="ログイン">
	</form>
<%}%>
<br><br>
<center><a href="ProductListDP" class="bt-samp30">商品一覧表示</a></center>

  <div>
  <p id="slideshow">
    <img src="${pageContext.request.contextPath}/img/img1.jpg" alt="画像1" class="active" width="100%">
    <img src="${pageContext.request.contextPath}/img/img2.jpg" alt="画像2" width="100%">
    <img src="${pageContext.request.contextPath}/img/img3.jpg" alt="画像3" width="100%">
    <img src="${pageContext.request.contextPath}/img/img4.jpg" alt="画像4" width="100%">
  </p>
</div>




  <script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
  <script type="text/javascript">
function slideSwitch() {
   var $active = $('#slideshow img.active');

   if ( $active.length == 0 ) $active = $('#slideshow img:last');

   var $next =  $active.next().length ? $active.next()
      : $('#slideshow img:first');

   $active.addClass('last-active');

   $next.css({opacity: 0.0})
      .addClass('active')
      .animate({opacity: 1.0}, 1000, function() {
           $active.removeClass('active last-active');
      });
}

$(function() {
   setInterval( "slideSwitch()", 3000 );
});
</script>

</body>
</html>
