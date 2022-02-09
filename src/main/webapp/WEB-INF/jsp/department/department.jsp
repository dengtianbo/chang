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
<title>部门列表</title>
</head>
<link rel="stylesheet" type="text/css" href="assets/department/department.css"/>
<script type="text/javascript" language="javascript" src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" language="javascript" src="assets/public/lib/layer/layer.js"></script>
<script type="text/javascript" language="javascript" src="assets/public/lib/laydate/laydate.js"></script>
<script type="text/javascript" language="javascript" src="assets/department/department.js"></script>

<script type="text/javascript">
var ctx="${ctx}"
	var pageNo = "${p.pageNum}";//当前页
	var pages = "${p.pages}";//总页数
	var pageSize = "${p.pageSize}";//页面大小
	var error = "${error}";//页面错误信息
</script>
<body>
<div class="container">

		<!-- 表单区域，可以向后台提交数据 -->
		<div class="search-form">
			<form action="department/list" method="post">
			<div>
				<label for="id">部门编号：</label><input type="text" name="id" id="id" placeholder="请输入部门编号" value="${dsb.id }">
			</div>
			<div>
				<label for="name">部门姓名：</label><input type="text" name="name" id="name" placeholder="请输入姓名" value="${dsb.name }">
			</div>
				<!-- 页码 -->
				<input type="hidden" name="pageNo" />
				<!-- 页面大小 -->
				<input type="hidden" name="pageSize" value="${p.pageSize}" />
			</form>
		</div>
	
		
		<!-- 工具栏，按钮操作区 -->
		<div class="op">
			<ul>
				<li><a class="add-btn" href="javascript:void(0)">添加</a></li>
				<li><a class="edit-btn" href="javascript:void(0)">修改</a></li>
				<li><a class="search-btn" href="javascript:void(0)">查询</a></li>
				<li><a class="del-btn" href="javascript:void(0)">删除</a></li>
				<li><a class="re-btn"  href="javascript:void(0)">重置</a></li>
				<li><a class="emp-btn"  href="javascript:void(0)">员工管理</a></li>
			</ul>
		</div>

	
	<!-- 数据展示 -->
	<table id="tbl">
		<tr>
			<th><input type="checkbox" id="checkall"></th>
			<th>部门编号</th>
			<th>姓名</th>
		</tr>
		<c:forEach items="${departments}" var="depart">
		<tr>
			<td><input type="checkbox" ></td>
		  	<td>${depart.id }</td>
			<td>${depart.name }</td>
			
		</tr>
		</c:forEach>
	</table>
	
		<!--分页区  -->
		<div class="paginate">
				<span class="first"><a>首页</a></span>
				<span class="prev"><a>上一页</a></span>
				<ul>
					<c:forEach begin="${p.navigateFirstPage }" end="${p.navigateLastPage }" var="pi">
						<c:choose>
						<c:when test="${pi == pageNum }">
							<li ><a class="qq" href="javascript:void(0)">${pi }</a></li>
						</c:when>
						<c:otherwise>
							<li><a  href="javascript:void(0)">${pi }</a></li>
						</c:otherwise>
						</c:choose>
					</c:forEach>
					
				</ul>
				<input type="text" id="bt" value="${p.pageNum }"/><span class="go">前往</span>
				<span class="next"><a>下一页</a></span>
				<span class="last"><a>尾页</a></span>
				<select>
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
				
			</div>
		
</div>	


</body>
</html>