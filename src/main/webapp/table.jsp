<%--
  Created by IntelliJ IDEA.
  User: 836365689
  Date: 2020/11/21
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script src="/layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        const $ = layui.$;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '/stu/all' //数据接口
            // ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'stuNum', title: '学号', sort: true, fixed: 'left'}
                ,{field: 'stuName', title: '姓名'}
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
            ]]
            ,response: {

                statusCode: 200 //规定成功的状态码，默认：0

            }
        });
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if(layEvent === 'detail'){ //查看

                layer.open({
                    type: 2 ,
                    area: ["700px","500px"],
                    content: 'detail.jsp', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function(layero, index){
                        console.log(layero, index);
                        const body = layer.getChildFrame('body', index);
                        body.find('#stu_num').val(data.stuNum);
                        body.find('#stu_name').val(data.stuName);
                    }
                    //数据绑定
                });
                //do somehing
            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type:'POST',
                        url: '/stu/del',
                        data: { id: data.stuNum },
                        success: function (res){
                            if (res.code === 200)
                            {
                                layer.msg('操作成功');
                                tableIns.reload();
                            }
                            else
                            {
                                layer.msg('操作失败');
                            }

                        },
                        error: function (error){
                            layer.msg(error);
                        }
                    });

                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){ //编辑
                //do something
                layer.open({
                    type: 2 ,
                    area: ["700px","500px"],
                    content: 'edit.jsp', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function(layero, index){
                        console.log(layero, index);
                        const body = layer.getChildFrame('body', index);
                        body.find('#stu_num').val(data.stuNum);
                        body.find('#stu_name').val(data.stuName);
                    }
                    //数据绑定
                });
                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    ,title: 'xxx'
                });
            } else if(layEvent === 'LAYTABLE_TIPS'){
                layer.alert('Hi，头部工具栏扩展的右侧图标。');
            }
        });
    });

</script>
</body>
</html>
