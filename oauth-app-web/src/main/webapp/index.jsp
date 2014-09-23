<%--
  Created by IntelliJ IDEA.
  User: xiaohao
  Date: 2014/8/15
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
</head>
<body>
<h1>测测你上辈子是谁</h1>
<div id="shareInfo" style="display: none">
    想知道上辈子你是谁？快来测测
</div>
<div id="startInfo">
    点击按钮开始测试
</div>
<input id="start" type="button" value="开始测试"/>
</body>
<script>
    $(function(){
        $("#start").click(function(){
            window.location.href="xxx.do";
        });
    });
</script>
</html>
