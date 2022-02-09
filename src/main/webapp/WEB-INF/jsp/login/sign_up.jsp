 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">
	<head>
		<meta charset="UTF-8">
		<title>sign-up</title>
		<link rel="stylesheet" href="assets/login/userlogin.css">
	</head>
	<body>
		<header>
			<div class="header-line"></div>
		</header>
		<div class="content">
			<img class="content-logo" src="assets/img/hello.png" alt="logo">
			<h1 class="content-title">创建账户</h1>
			<div class="content-form">
				<form method="post" action="" >
					<div id="change_margin_1">
						<input class="user" type="text" name="username" placeholder="请输入用户名">
					</div>
					<!-- input的value为空时弹出提醒 -->
					<p id="remind_1"></p>
					<div id="change_margin_2">
						<input class="password" type="password" name="password" placeholder="请输入密码">
					</div>
					<!-- input的value为空时弹出提醒 -->
					<p id="remind_2"></p>
					<div id="change_margin_3">
						<input class="content-form-signup" type="submit" value="创建账户">
					</div>
				</form>
			</div>
			<div class="content-login-description">已经拥有账户？</div>
			<div><a class="content-login-link" href="jsp/login/userlogin.jsp">登录</a></div>
		</div>
	</body>
</html>
