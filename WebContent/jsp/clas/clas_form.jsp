<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%
String path =request.getContextPath();
//http：//localhost：8080/Day01/
String basePath = request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=path %>/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
          

              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>添加班级</legend>
</fieldset>
 
<form class="layui-form" action="<%=path%>/ClasUpdate" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">班级名称</label>
    <div class="layui-input-block">
      <input type="text" name="cName" placeholder="班级名称" autocomplete="off" class="layui-input" lay-verify="required|">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">下拉选择框</label>
    <div class="layui-input-block">
      <select name="cAlias" lay-filter="bieming">
        <option value="0">小班</option>
        <option value="1">中班</option>
        <option value="1">大班</option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">班级容量</label>
    <div class="layui-input-block">
      <input type="text" name="cContent" placeholder="填写班级的人数" autocomplete="off" class="layui-input" lay-verify="required|number">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">联系教师</label>
    <div class="layui-input-block">
      <input type="text" name="cTeacher" placeholder="联系教师" autocomplete="off" class="layui-input" lay-verify="required">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">所属幼儿园</label>
    <div class="layui-input-block">
      <input type="text" name="cTeacher" placeholder="幼儿园" autocomplete="off" class="layui-input" lay-verify="required">
    </div>
  </div>
 
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">请填写描述</label>
    <div class="layui-input-block">
      <textarea name="cDescription" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1" >立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 

          
<script src="<%=path %>/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
  //监听提交
  form.on('submit(demo1)', function(data){
    $('form').submit();
  });
  
  
});
</script>

</body>
</html>