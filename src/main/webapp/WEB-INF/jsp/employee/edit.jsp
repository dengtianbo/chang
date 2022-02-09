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
	var ids="${ids}";
</script>

</head>
<body>
	<div class="container">
		<fieldset>
			<legend align="center">修改员工</legend>

			<form action="employee/edit" method="post" class="student-form" enctype="multipart/form-data">
				<div>
					<label for="stuId">编号：</label> <input type="text" name="id" id="id" readonly="readonly"
						value="${e.id}">
				</div>
				<div>
					<label for="name">姓名：</label> <input type="text" name="name" id="name" placeholder="请输入姓名"
						value="${e.name}">
				</div>
				<div class="div-wrapper">
					<label>性别：</label>
					<div>
						<input type="radio" id="male" name="sex" value="男" checked="checked"> <label
							for="male">男</label>
					</div>

					<div>
						<input type="radio" id="female" name="sex" value="女"> <label for="female">女</label>
					</div>
				</div>
				<div>
					<label for="birthday">出生日期：</label> <input type="text" name="birthday" id="birthday"
					 value="${e.birthday}" autocomplete="off">
				</div>
				<div>
					<label for="stuId">工资：</label> <input type="text" name="salary" id="salary" placeholder="请输入工资"
						value="${e.salary}">
				</div>
				<div>
					<label for="d_id">部门编号：</label> 
					 	 <select name="d_id" id="d_id" value="${e.d_id}">
					 	 
					 	 <c:forEach items="${ids }" var="id">
					 	 	<option>${id }</option>
					 	 </c:forEach>
						</select>
					</div>
				<div>
					<label for="portrait-pic">上传头像：</label> <input type="file" name="portrait-pic" id="portrait-pic" autocomplete="off">
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