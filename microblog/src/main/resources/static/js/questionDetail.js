$(function(){
	//检查是否登录
	checkLoginState();
	//初始化关注按钮
	btnStyle("#follow","+关注","已关注","取消关注","/followQuestion");
	btnStyle("#ok","+点赞","已点赞","取消点赞","/okQuestion");
});

/**
 * 动态设置样式
 * @param btnClass
 * @param str1 
 * @param str2 
 * @param str3 
 * @param url 
 * @returns
 */
function btnStyle(btnClass,str1,str2,str3,url){
	$(btnClass).click(function(){
		let flag=$(this).hasClass("hh");
		
		
		$.ajax({
			url:url,
			data:{
				followState:flag,
				questionId:questionId
			},
			dataType:"json",
			type:"post",
			async:false,
			success:function(res){
				if(!(res.state)){
					$("#userModal").modal("show");
					return; 
				}
				
				if(flag){
					$(btnClass).text(str1)
					$(btnClass).addClass("cur")
					$(btnClass).removeClass("hh")
				}else{
					// $(this).addClass()
					$(btnClass).text(str2)
					$(btnClass).addClass("hh")
					$(btnClass).removeClass("cur")
				}
			},
			error:function(){
				
			}
		});
		
		
	});
	$(btnClass).mouseover(function(){
		let flag=$(this).hasClass("hh");
		console.log(flag,888)
		if(flag){
			$(this).text(str3)
		}else{
			$(this).text(str1)
		}
		
	});
	$(btnClass).mouseout(function(){
		let flag=$(this).hasClass("hh");
		if(flag){
			$(this).text(str2)
		}
	});
}

function answerBtn(){
	$.ajax({
		url:"answerQuestion",
		data:{
			answerText:$("#answerText").val(),
			questionId:questionId
		},
		dataType:"json",
		type:"post",
		async:false,
		success:function(res){
			if(!(res.state)){
				$("#userModal").modal("show");
				return;
			}else{
				location.reload();
			}
		},
		error:function(){
			
		}
	});
	
}




