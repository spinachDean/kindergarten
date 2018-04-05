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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<title>添加菜单列表</title>

</head>
<body>
<article class="page-container">
	<form action="menulist/add" method="post" class="form form-horizontal" id="form-member-add">
	<c:if test="${menuinfo.id!=null}"><input type="hidden" name="id" value="${id}" /></c:if>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">父菜单：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="partent" type="radio" ">
					<label for="sex-1">无</label>
				</div>
				<c:forEach var="menu" items="${menulist}">
				<div class="radio-box">
					<input type="radio" id="partent${menu.id }" name="partent" value="${menu.id }" ${menu.id==menuinfo.parent?'checked':''}>
					<label for="partent${menu.id }">${menu.name }</label>
				</div>
				</c:forEach>
			</div>
			
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${menuinfo.icon}" placeholder="&#xe643;" id="icon" name="icon">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${menuinfo.name}" placeholder="" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${menuinfo.url}" placeholder="/" name="url" id="url">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">可用角色：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
			
			<c:forEach var="role" items="${rolesName}">
			<dd>
				<label class="">
					<input type="checkbox" value="${role.key }" name="role" ${menuinfo.roleMap[role.key]!= null?'checked':'' }>
					${role.value}</label>
				
				</dd>
			</c:forEach>
				
			
			</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>序号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${menuinfo.index}" placeholder="数值越小越靠前" name="index" id="index">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			name:{
				required:true,
				minlength:2,
				maxlength:16
			}
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			
			$(form).ajaxSubmit();
			alert("提交成功");
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			
			parent.layer.close(index);
			parent.location.reload(); //刷新父页面
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>