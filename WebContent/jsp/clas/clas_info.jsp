<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path =request.getContextPath();
//http：//localhost：8080/Day01/
String basePath = request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>layout 后台大布局 - Layui</title>
<link rel="stylesheet" href="<%=path %>/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>


					<dl class="layui-nav-child">

						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>

			</ul>

			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">所有商品</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">列表一</a>
							</dd>
							<dd>
								<a href="javascript:;">列表二</a>
							</dd>
							<dd>
								<a href="javascript:;">列表三</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">解决方案</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">列表一</a>
							</dd>
							<dd>
								<a href="javascript:;">列表二</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="">云市场</a></li>
					<li class="layui-nav-item"><a href="">发布商品</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->

			<div style="margin-bottom: 5px;">

				<!-- 示例-970 -->
				<ins class="adsbygoogle"
					style="display: inline-block; width: 970px; padding: 10px"
					data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

			</div>

			<div class="demoTable">
		搜索：
		<div class="layui-inline">
			<input class="layui-input" placeholder="请输入班级" name="keyword" id="demoReload"
				autocomplete="off">
	 	</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	</div>
	<table id="demo" lay-filter="test"></table>
	
	
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" href="<%=path%>/jsp/clas/clas_form.jsp" lay-event="edit">编辑</a>
 		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" >删除</a>
	</script>
	</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>

	<script src="<%=path %>/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
var chk_value =[]; 
layui.use('table', function() {
	var table = layui.table;
	
	//第一个实例
	table.render({
		elem : '#demo',
		height : 500,
		url : '${pageContext.request.contextPath }/GetClasServlet',//数据接口 
		id : 'testReload',
		page : true ,//是否开启分页
		cols: [[ //表头
			{checkbox: true, fixed: true}
	      	,{field:'cId',title: 'ID', width:70, sort: true, fixed: true}
	      	,{field:'cName', title: '名称',width:110}
	      	,{field:'cAlias', title: '别名', width:90, sort: true}
	      	,{field:'cContent', title: '班容量', width:90}
	      	,{field:'cTeacher', title: '辅导教师', width:100}
	      	,{field:'cDescription', title: '描述', width:210}
	      	,{field:'kgName', title: '所属幼儿园', width:90}
	      	,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
			] ]
			
	});
	var $ = layui.jquery,
	active = {
        reload: function(){
            var demoReload = $('#demoReload');

            table.reload('testReload', {
            	url: '${pageContext.request.contextPath }/GetClasServlet'
                ,where: {
                    keyword: demoReload.val()
                }
            });
        }
    };
	$('.demoTable .layui-btn').on('click', function(){
    	var type = $(this).data('type');
    	active[type] ? active[type].call(this) : '';
	});
	//复选框监听事件
	table.on('checkbox(test)', function(obj){
        //console.log(obj.data.chid);
        if($.inArray(obj.data.chid,chk_value)<0){
        	chk_value.push(obj.data.chid);
        }else{
            chk_value = $.grep(chk_value,function(value){
            	return value != obj.data.chid;
            });
        }
    });
	  table.on('tool(test)',function(obj){
		 var data = obj.data;
		 if(obj.event === 'edit'){
			 layer.prompt({
		            formType: 2
		            ,title: '添加缺勤原因：'
		            ,value: ''
		        }, function(value, index){
		         //发送修改的Ajax请求
		            EidtUv(data,value,index,obj);
		        });
	 	 }if(obj.event === 'charge'){
	 		window.location.href='${pageContext.request.contextPath }/chargeServlet?id='+data.chid;
	 	 }
		 
 	}); 
	  function  EidtUv(data,value,index,obj) {
		    $.ajax({
		        url: '${pageContext.request.contextPath }/absence',
		        type: "POST",
		        data:{"chid":data.chid,"abreason":value},
		        dataType: "json",
		        success: function(data){
		            if(data.state==1){
		               //关闭弹框
		                layer.close(index);
		                layer.msg("缺勤记录成功");
		            }else{
		            	 layer.close(index);
		                layer.msg("请勿重复记录");
		            }
		        }
		    });
		}
});

</script>

</body>
</html>