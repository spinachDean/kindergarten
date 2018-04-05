<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>没有权限</title>
</head>
<body>
<section class="container-fluid page-404 minWP text-c">
	<p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe688;</i>
		<span class="va-m"> 限制</span>
	</p>
	<p class="error-description">不好意思，您不允许访问这个页面~</p>
	<p class="error-info">您可以：
		<a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回上一页</a>
		<span class="ml-20">|</span>
		<a href="login.jsp" class="c-primary ml-20">登录 &gt;</a>
	</p>
</section>
</body>
</html>