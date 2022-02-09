$(function() {
	if (error) {
		layer.alert(error);
	}
	//根据后台的性别实现选中
	if (sex) {
		$(".student-form>.div-wrapper :radio[value=" + sex + "]").prop("checked", true);
	}

	//出生日期date
	laydate.render({
		elem: "#birthday"
	});


	//重置按钮
	$(".re-btn").click(function() {
		location.href = ctx + "/employee/edit";
	});
});