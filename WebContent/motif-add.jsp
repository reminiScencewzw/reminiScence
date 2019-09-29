<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post">
                    <div class="layui-form-item" style="margin:0 auto;width:60%;">
                        <label for="motif" class="layui-form-label">
                            <span class="x-red">*</span>主题名称:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="motif" name="motif" required="" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>
                        </div>
                    </div>
                    <div class="layui-form-item" style="text-align:center;">
                        <button class="layui-btn" lay-filter="add" lay-submit=""style="width:21%;">增加</button></div>
                </form>
            </div>
        </div>
    </body>
	<script>
	layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //监听提交
                form.on('submit(add)',
                		function(data) {
                    console.log(data.field.motif);
                    location.href = "controller.jsp?type=add&motifName="+data.field.motif;
                    //关闭当前frame
                    xadmin.close();

                    // 可以对父窗口进行刷新 
                    xadmin.father_reload();
                    return false;
                });

            });</script>
</html>