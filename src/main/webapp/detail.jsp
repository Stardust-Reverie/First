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
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
<blockquote class="layui-elem-quote layui-text">

</blockquote>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input id="stu_num" name="stu_num" readonly class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input id="stu_name" name="stu_name" readonly class="layui-input">
            </div>
        </div>
    </div>
</form>
<script src="layui/layui.all.js" ></script>
</body>
</html>
