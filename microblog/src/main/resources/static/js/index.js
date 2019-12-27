function login(){
	$("#userModal").modal("show");
}

function checkLogin(){
	var param = $("#userForm").serialize();
	$.ajax({
		url:"/login",
		type:"post",
		data:param,
		dataType:"json",
		success:function(res){
			if(res.state){
				alertModel("登录成功。");
			}else{
				alertModel("用户名或者密码错误。");
			}
			$("#userName").val("");
			$("#userPwd").val("");
			$("#userModal").modal("hide");
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}