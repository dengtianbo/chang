<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>


<html>
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">

	<head>
		<meta charset="utf-8">
		<title>login UI</title>
		<link rel="stylesheet" href="assets/login/adminlogin.css">
		<script src="assets/public/lib/jquery/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="assets/login/adminlogin.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="box">
			<h2>图书管理员登录</h2>
			<form action="login" method="post">
				<div class="inputBox">
					<input id="bt1" type="text" name="username">
					<label>用户名</label>
				</div>
				<div class="inputBox">
					<input id="bt2" type="password" name="password">
					<label>密码</label>
				</div>
				<input type="submit" name="" value="登录">
				<a href="jsp/login/userlogin.jsp" class="zc">用户登录入口</a>
				<span>${info}</span>
			</form>
		</div>
	</body>
</html>
