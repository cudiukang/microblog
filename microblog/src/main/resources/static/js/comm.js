/**
 * 格式化日期
 * @param str 日期字符串
 * @returns
 */
function formatDate(str){
	//根据字符串创建日期对象
	if(!str){
		return ;
	}
	var timeNum = parseInt(str);
	var date = new Date(timeNum);
	
	//格式化日期对象输出结果
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var min = date.getMinutes();
	var sec = date.getSeconds();
	
	return year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
}

//初始化日期控件
//inputId input的id
function initDatepicker(inputId){
	var today = new Date();
    var format_td = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    $('#'+inputId).datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        language: 'zh-CN',
        todayBtn: 'linked',
        //maxView: 90,
        //minView: 1,
        autoClose: true,
        minuteStep: 30,
        startDate: format_td,
        pickerPosition: 'bottom-right'
    });
}

/**
 * 用法：alertModel('你需要的文本写这里');
 * */
var idn = 0;
function alertModel(message,func){
	idn = idn+1;
	var html='';
	html+='<div class="modal fade" id="alertModel'+ idn +'" tabindex="-1" role="dialog">';
	html+='<div class="modal-dialog" role="document">';
	html+='<div class="modal-content">';
	html+='<div class="modal-header">';
	html+='<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
	html+='<h4>系统提示</h4>';
	html+='</div>';
	html+='<div class="modal-body">';
	html+='<p>'+ message +'</p >';
	html+='</div>';
	html+='<div class="modal-footer">';
	html+='<button type="button" id="closeModel'+idn+'" data-dismiss="modal" class="btn btn-default">关闭</button>';
	html+='</div>';
	html+='</div>';
	html+='</div>';
	html+='</div>';
	$('body').append(html);
	$("#closeModel"+idn).bind("click",function(){
		$('#alertModel'+ idn ).modal('hide');
		if(func){
			 return func();
		}
	});
	$("#alertModel"+idn+" .close").bind("click",function(){
		$('#alertModel'+ idn ).modal('hide');
		if(func){
			 return func();
		}
	});
	$('#alertModel'+ idn ).modal('show').unbind();
}

/**---------------*/
//确认提示框
/**
* 用法：confirmModel('您要删除吗','confirmOk');
* function confirmOk(){};
* */
var ids = 0;
function confirmModel(message, func){
	ids = ids+1;
	var str='';
	str+='<div class="modal fade delModel" id="delModel'+ ids +'">';
	str+='<div class="modal-dialog">';
	str+='<div class="modal-content message_align">';
	str+='<div class="modal-header">';
	str+='<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>';
	str+='<h4 class="modal-title">提示信息</h4>';
	str+='</div>';
	str+='<div class="modal-body">';
	str+='<p>'+message+'</p>';
	str+='</div>';
	str+='<div class="modal-footer">';
	str+='<input type="hidden" id="url" value="true"/>';
	str+='<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-top:4px;">取消</button>';
	str+='<button onclick="'+func+'()" class="btn btn-success" data-dismiss="modal">确定</button>';
	str+='</div>';
	str+='</div>';
	str+='</div>';
	str+='</div>';
	$('body').append(str);
	$('#delModel'+ ids).modal('show');
}

/**
 * 动态设置 select的内容
 * 调用方法 appendSelect("paymentMethod",paymenyMethod,"dict_id","dict_name","","付款方式");
 * @param selectId select标签ID（必填）
 * @param item 数据集合
 * @param valueCol 取值字段
 * @param textCol 取显示字段
 * @param id 默认选中id
 * @param title 默认显示名称 请选中+title
 * @returns
 */
function appendSelect(selectId,item,valueCol,textCol,id,title){
	$('#'+selectId).empty();//删除之前的数据
	var s = '';
	if(title!=null&&title!=""){
		$("#"+selectId).append("<option value=''>" +'--请选择'+title+'--'+ "</option>");
	}
	$.each(item,function(i,v){

		$("#"+selectId).append("<option value='"+v[valueCol]+"' "+(id==v[valueCol]?"selected='selected'":"")+">" +v[textCol]+ "</option>");
	});
}

/**
 * 删除对应信息
 * @param elementId 元素id
 * @param delUrl 删除的后台路径
 * @returns
 */
function delInfo(eleId,delUrl){
    var ids = getIds(eleId);
	
	//判断和提示
	if(ids.length<1){
		alertModel("请至少选择一条数据。");
		return;
	}
	var flag = confirm("请确认是否需要删除"+ids.length+"条数据。");
	if(!flag){
		return;
	}
	
	//删除数据
	$.ajax({
		url:delUrl,
		data:{
			idStr:ids.join(",")
		},
		dataType:"json",
		type:"post",
		success:function(res){
			if(res.state){
				initTable();
			}
			alertModel(res.msg);
		},
		error:function(){
			alertModel("服务器繁忙。");
		}
		
	});
}

/**
 * 根据元素id查找选中的信息id
 * @param eleId table id
 * @returns
 */
function getIds(eleId){
	//获取选中的ids
	var ids = [];
	var trs = $("#"+eleId).bootstrapTable('getSelections');
	
	//获取id
	for(var i=0;i<trs.length;i++){
		//获取checkbox
		ids.push(trs[i].id);
	}
	return ids;
}
/**
 * 新增和修改共有方法
 * @param params 参数
 * @param url 后端地址
 * @param modalId 模态框id
 * @returns
 */
function saveChange(params,url,modalId){
	$.ajax({
		url:url,
		data:params,
		dataType:"json",
		type:"post",
		success:function(res){
			if(res.state){
				initTable();
				$("#"+modalId).modal("hide");
			}
			alertModel(res.msg);
		},
		error:function(){
			alert("服务器繁忙。");
		}
		
	});
}

/**
 * 新增和修改共有方法
 * @param params 参数
 * @param url 后端地址
 * @param returnUrl 需要返回页面的url
 * @returns
 */
function saveChangeForHtml(params,url,returnUrl){
	$.ajax({
		url:url,
		data:params,
		dataType:"json",
		type:"post",
		success:function(res){
			alertModel(res.msg);
			if(res.state){
				location.href = returnUrl;
			}
		},
		error:function(){
			alert("服务器繁忙。");
		}
		
	});
}


/**
 * 给指定的select加载option
 * @param selectName
 * @param data
 * @returns
 */
function addOptionToSelect(selectName,url){
	$.ajax({
		url:url,
		data:{},
		dataType:"json",
		async:false,
		type:"post",
		success:function(res){
			//根据id找到对应的对象
			var selectObj = $("#"+selectName);
			//清空内部的元素
			selectObj.html("");
			var data = res.obj;
			var str = "<option value='-1'>请选择</option>";
			for(var i=0;i<data.length;i++){
				str += "<option value='"+data[i].id+"'>"+data[i].workshopName+"</option>";
			}
			
			selectObj.html(str);
		},
		error:function(){
			
		}
	});
	
	
}

/**
 * 给指定的select加载option
 * @param selectName
 * @param data
 * @returns
 */
function addOptionToSelect1(selectName,url,id){
	$.ajax({
		url:url,
		data:{
			id:id
		},
		dataType:"json",
		async:false,
		type:"post",
		success:function(res){
			//根据id找到对应的对象
			var selectObj = $("#"+selectName);
			//清空内部的元素
			selectObj.html("");
			var data = res.obj;
			var str = "<option value='-1'>请选择</option>";
			for(var i=0;i<data.length;i++){
				str += "<option value='"+data[i].id+"'>"+data[i].groupName+"</option>";
			}
			
			selectObj.html(str);
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}

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
				$("#userLogo").text(res.obj.uName);
			}
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}

//即时搜索
function searchOnCurrent(){
	initTable();
}

//打开登录模态框
function login(){
	$("#userModal").modal("show");
}

//检查是否登录
function checkLogin(){
	var param = $("#userForm").serialize();
	$.ajax({
		url:"/login",
		type:"post",
		data:param,
		dataType:"json",
		success:function(res){
			if(res.state){
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

//退出
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




