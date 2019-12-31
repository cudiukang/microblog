function publish(){
	var param = $("#publishForm").serialize();
	$.ajax({
		url:"addQuestion",
		data:param,
		dataType:"json",
		type:"post",
		success:function(res){
			alertModel(res.msg);
			if(res.state){
				location.href = "/";
			}
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。")
		}
	});
}