$(function(){
	checkLoginState();
});

function checkLoginState(){
	$.ajax({
		url:"/checkLogin",
		type:"post",
		data:{},
		dataType:"json",
		success:function(res){
			if(res.state){
				//隐藏登录按钮,显示操作按钮
				$("#operationUl,#loginUl").toggle();
				//设置名称
				$("#userLogo").text("您好："+res.obj.uName);
			}
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}

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
			//隐藏模态框
			$("#userModal").modal("hide");
			//隐藏登录按钮,显示操作按钮
			$("#operationUl,#loginUl").toggle();
			//设置名称
			$("#userLogo").text("您好："+res.obj.uName);
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}

function quitBtn(){
	$.ajax({
		url:"/quit",
		type:"post",
		data:{},
		dataType:"json",
		success:function(res){
			if(res.state){
				location.reload();
			}
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}