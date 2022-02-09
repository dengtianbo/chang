$(function() {
	if (error) {
		layer.alert(error);
	}
	

	//重置按钮
	$(".re-btn").click(function() {
		location.href = ctx + "/department/edit";
	});
});