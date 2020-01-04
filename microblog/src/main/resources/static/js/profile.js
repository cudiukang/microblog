$(function(){
	checkLoginState();
	initTable();
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
				$("#userLogo").text(res.obj.uName);
			}
		},
		error:function(){
			alertModel("系统繁忙，请稍后再试。");
		}
	});
}

function initTable(){
	// 先销毁表格
    $('#tb').bootstrapTable('destroy');
    // 初始化表格,动态从服务器加载数据
    $("#tb").bootstrapTable({
        method: "post",
        contentType: "application/x-www-form-urlencoded",
        showHeader:false,
        url: "/profilePage", // 获取数据的地址
        striped: true, // 表格显示条纹
        pagination: true, // 启动分页
        pageSize: 10, // 每页显示的记录数
        pageNumber: 1, // 当前第几页
        minimumCountColumns: 1, // 最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        pageList: [10, 25, 50], // 记录数可选列表
        search: false, // 是否启用查询
        sidePagination: "server", // 表示服务端请求
        // 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        // 设置为limit可以获取limit, offset, search, sort, order
        queryParamsType: "undefined",
        queryParams: function queryParams(params) { // 设置查询参数
            var param = {
                curPage: params.pageNumber,
                pageSize: params.pageSize,
                searchInfo: $("#searchInfo").val().trim()
            };
            return param;
        },
        columns: [{
            field: 'id',
            formatter:function(value,row,index){
            	var strs = "";
            	//计算创建间隔时间
				var createDate = row.gmtCreate;
				var time = new Date().getTime()-createDate;
				var info = "";
				if((time/1000/60)<60	){
					info = parseInt(time/1000/60)+"分钟";
				}else if((time/1000/60/24)<60){
					info = parseInt(time/1000/60)+"小时";
				}else if((time/1000/60/24/30)<12){
					info = parseInt(time/1000/60)+"月";
				}else{
					info = parseInt(time/1000/60/12)+"年";
				}
				
				//绑定数据
				strs += '<div class="media"> '+
				  '<a class="pull-left" href="#"> '+
				  '  <img style="width:60px;" class="media-object" src="'+row.uHeadUrl+'"> '+
				  '</a> '+
				  '<div class="media-body"> '+
					'  <h4 class="media-heading">'+row.qTitle+'</h4> '+
					'  <a>点击查看详情。。。</a> '+
					'  <br> '+
					row.commentCount+' 个回复    |    '+row.viewCount+' 次浏览    |    '+info+' 前    |     '+row.likeCount+' 次点赞 '+
				  '</div> '+
				'</div> '+
				'<br> ';
				
				return strs;
            }
        }],
        onLoadError: function () { // 加载失败时执行
            console.log("请求失败！");
        },
        responseHandler: function (res) {
            return {
                "total": res.obj.total,// 总页数
                "rows": res.obj.data || []
                // 数据
            };
        }
    });
}

function searchQuestion(){
	initTable();
}
