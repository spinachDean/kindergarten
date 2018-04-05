<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>菜单列表管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">

		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> <a href="javascript:;"
				onclick="menulist_add('添加菜单列表','menulist/add','','510')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加菜单列表</a></span> <span class="r">共有数据：<strong>88</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">ID</th>
						<th width="40">父菜单</th>
						<th width="50">图标</th>
						<th width="100">名称</th>
						<th width="260">URL</th>
						<th width="">可显示角色</th>
						<th width="50">排序</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
			<c:forEach items="${menulist}" var="menu">
					<tr class="text-c">
							<td><input type="checkbox" value="${menu.id }"></td>
							<td >${menu.id }</td>
													<td class="td-status"><span
								class="label label-success radius">${menu.parent }</span></td>
								<td><i class="Hui-iconfont">${menu.icon }</i></td>
							<td><u style="cursor: pointer" class="text-primary"
								onclick="member_show('${menu.name }','member-show.html','10001','360','400')">${menu.name }</u></td>
							
							<td>${menu.url}</td>
							<td>
								<c:forEach items="${rolesName[menu.id]}" var="roles">
									${roles}&nbsp;
								</c:forEach>
							</td>
							<td class="text-l">${menu.index}</td>
							<td class="td-manage"> <a title="编辑"
								href="javascript:;"
								onclick="member_edit('编辑','menulist/add?id=${menu.id }','4','','510')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a> 
								<a title="删除" href="javascript:;" onclick="menulist_del(this,'${menu.id }')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
					<c:forEach items="${menu.children }" var="child">
						<tr class="text-c">
							<td><input type="checkbox" value="${child.id }"></td>
							<td >${child.id }</td>
													<td class="td-status"><span
								class="label label-success radius">${child.parent }</span></td>
								<td><i class="Hui-iconfont">${child.icon }</i></td>
							<td><u style="cursor: pointer" class="text-primary"
								onclick="member_show('${child.name }','member-show.html','10001','360','400')">${child.name }</u></td>
							
							<td>${child.url}</td>
							<td>
								<c:forEach items="${rolesName[child.id]}" var="roles">
									${roles}&nbsp;
								</c:forEach>
							</td>
							<td class="text-l">${child.index}</td>
							<td class="td-manage"> <a title="编辑"
								href="javascript:;"
								onclick="member_edit('编辑','member-add.html','4','','510')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a> 
								<a title="删除" href="javascript:;" onclick="menulist_del(this,'${menu.id }')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
				</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.table-sort').dataTable({
				//"aaSorting" : [ [ 0, "desc" ] ],//默认第几个排序
				//"bStateSave" : true,//状态保存
				//"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				 searching: true,
    			ordering:  false
				//]
			});

		});
		/*用户-添加*/
		function menulist_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-查看*/
		function member_show(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		

		/*用户-启用*/
		function member_start(menuid, id) {
			layer
					.confirm(
							'确认要启用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-success radius">已启用</span>');
												$(obj).remove();
												layer.msg('已启用!', {
													icon : 6,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}
		/*用户-编辑*/
		function member_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*密码-修改*/
		function change_password(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-删除*/
		function menulist_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : 'menulist/delete',
					data :  {id:id} ,
					success : function(data) {
				
						$(obj).parents("tr").remove();
						layer.msg(data, {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}
	</script>
</body>
</html>