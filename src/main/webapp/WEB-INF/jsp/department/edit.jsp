<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">
<meta charset="UTF-8">
<title>添加员工界面</title>
<link rel="stylesheet" type="text/css" href="assets/employee/add.css"/>
<script type="text/javascript" language="javascript" src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" language="javascript" src="assets/public/lib/layer/layer.js"></script>
<script type="text/javascript" language="javascript" src="assets/public/lib/laydate/laydate.js"></script>
<script type="text/javascript" language="javascript" src="assets/employee/edit.js"></script>
<script type="text/javascript">
    var ctx="${ctx}"
    var sex = "${params['sex'][0]}";
	var error = "${error}";//页面错误信息
</script>


</head>
	<body>
		<div class="container">
			<fieldset>
				<legend align="center">修改部门</legend>

				<form action="department/edit" method="post" class="student-form">
						<div>
						<label for="id">部门编号：</label> <input type="text" name="id" id="id"  readonly="readonly"
							value="${d.id}">
					</div>
					<div>
						<label for="name">姓名：</label> <input type="text" name="name" id="name" placeholder="请输入姓名"
							value="${d.name}">
					</div>

					<div>
						<label></label>
						<button type="submit">提交</button>
						<button type="reset" class="re-btn">重置</button>
					</div>
				</form>
			</fieldset>
		</div>
	</body>
</html>