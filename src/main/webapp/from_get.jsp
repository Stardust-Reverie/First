<%--
  Created by IntelliJ IDEA.
  User: 836365689
  Date: 2020/11/1
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="layui/css/layui.css">
</head>
<body>

<form class="layui-form" action="from.jsp" method="post">
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">验证手机</label>
        <div class="layui-input-inline">
            <input type="tel" name="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">验证邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" autocomplete="off" class="layui-input">
        </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-input-block">
        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</div>
</form>
<script src="layui/layui.all.js" ></script>
</body>
</html>
