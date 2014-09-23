<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaohao
  Date: 2014/8/15
  Time: 10:54
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
    上辈子你是？？？？超级计算机已经计算出来了你是谁?
</div>
<div id="startInfo">
    点击按钮开始测试
</div>
<input id="start" type="button" value="开始测试"/>
<input id="share" style="display: none" value="分享到微博查看结果" type="button"/>
</body>
<script>
    $(function(){
        $("#start").click(function(){
            var t =setTimeout(function(){
                $("#start").hide()
                $("#startInfo").hide();
                $("#share").show();
                $("#shareInfo").show();
                clearTimeout(t);
            },5000)
        });
        $("#share").click(function(){

            window.location.href="showResult.do";

        });
    });
</script>
</html>
