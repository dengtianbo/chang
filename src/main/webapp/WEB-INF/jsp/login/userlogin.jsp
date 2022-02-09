<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html lang="en">
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">

<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="assets/login/userlogin.css">
	<script type="text/javascript">
	var ctx = "${ctx}";
	</script>
</head>
	
<body>
	<header>
		<div class="header-line"></div>
	</header>
	<div class="content">
		<img class="content-logo" src="assets/img/hello.png" alt="logo">
		<h1 class="content-title">登录</h1>
		<div class="content-form">
			<form method="post" action="login">
				<div id="change_margin_1">
					<input class="user" type="text" name="name" placeholder="请输入用户名">
				</div>
				<!-- input的value为空时弹出提醒 -->
				<p id=" remind_1"></p>
					<div id="change_margin_2">
						<input class="password" type="password" name="password" placeholder="请输入密码">
					</div>
				
				<div>
				<input type="text" name="cap"  class="cap"  >
				<img id="captcha"  src="captcha" style="width: 100px; height: 40px">
				</div>
				<!-- input的value为空时弹出提醒 -->
				<p id=" remind_2"></p>
						<div id="change_margin_3">
							<input class="content-form-signup" type="submit" value="登录">
							<br>
							<span>${info}</span>
						</div>
			</form>
		</div>
		<div class="content-login-description">没有账户？</div>
		<div><a class="content-login-link" href="WEB-INF/login/sign_up.jsp">注册</a></div>
		<span > <a href="jsp/login/adminlogin.jsp" class="admin">管理员登录入口</a></span>
	</div>
</body>
<script type="text/javascript">
	var img = document.querySelector("#captcha");
	img.addEventListener("click", function() {
		img.src = ctx + "/captcha?id" + new Date().getTime();
	});
</script>


</html>
