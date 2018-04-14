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
<link rel="stylesheet" href="./css/layui.css">
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

			<blockquote class="layui-elem-quote news_search">
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" value="" placeholder="请输入关键字"
							class="layui-input search_input">
					</div>
					<a class="layui-btn search_btn">查询</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-normal newsAdd_btn">添加文章</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn recommend" style="background-color: #5FB878">推荐文章</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn audit_btn">审核文章</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
				</div>
				<div class="layui-inline">
					<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
				</div>
			</blockquote>
			 <div class="layui-row">
				<!-- <div class="layui-col-md6" style="padding-top: 10px">
					<div class="layui-btn-group demoTable" style="padding-left: 20px">
						<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
						<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
						<button class="layui-btn" data-type="isAll">验证是否全选</button>
					</div>
				</div>
			-->

			</div>

			<div class="layui-tab-item layui-show " style="padding: 10px 15px;">
				
				<table class="layui-table" lay-data="{width: 892, height:332, url:'<%=path%>/TestJson', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
      <th lay-data="{field:'id', width:90, sort: true, fixed: true}">ID</th>
      <th lay-data="{field:'username', width:130}">名称</th>
      <th lay-data="{field:'sex', width:100, sort: true}">月收费</th>
<!--       <th lay-data="{field:'city', width:90}">容量</th> -->
<!--       <th lay-data="{field:'sign', width:90}">教师</th> -->
      <th lay-data="{field:'experience', width:320}">描述</th>
      
<!--       <th lay-data="{field:'classify', width:80}">职业</th> -->
<!--       <th lay-data="{field:'wealth', width:135, sort: true}">财富</th> -->
<!--       <th lay-data="{field:'score', width:80, sort: true, fixed: 'right'}">评分</th> -->
      <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
			</div>
			<script type="text/html" id="barDemo">
  				<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  				<a class="layui-btn layui-btn-xs" href="<%=path%>/fee_form.jsp" lay-event="edit">编辑</a>
 				 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" >删除</a>
			</script>

		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>
	<script src="./layui.js"></script>
	<script>
layui.use('table', function(){
  var table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.cId + ' 的查看操作');
      
      
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
  });
  
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据
      var checkStatus = table.checkStatus('idTest')
      ,data = checkStatus.data;
      layer.alert(JSON.stringify(data));
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus('idTest')
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus('idTest');
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});
</script>
</body>
</html>