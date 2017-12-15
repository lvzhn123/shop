<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>微信商城</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="icon" type="image/png" href="/theme/default/images/favicon.png">
        <link href="css/amazeui.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/time.js"></script>
        <script src="js/MD5.js"></script>
    </head>
    <body>
        <header data-am-widget="header" class="am-header am-header-default sq-head ">
            <div class="am-header-left am-header-nav">
                <a href="javascript:history.back()" class="">
                    <i class="am-icon-chevron-left"></i>
                </a>
            </div>
            <h1 class="am-header-title">
                <a href="" class="">登录</a>
            </h1>
        </header>
        <div style="height: 49px;"></div>
        <div class="login-logo">
            <img src="images/logo.png" />
        </div>
        <input type="text" name="mobile" id="mobile" placeholder="请输入用户名/手机号" class="login-name">
        <input type="password" name="password" id="password" placeholder="请输入密码" class="login-password">
        <input type="button" class="login-btn" value="我要登录">
        <input type="button" class="reg-btn" value="我要注册">
        <div class="agree">
            <a href="forgetpassword.html" class="forget">忘记密码？</a>
        </div>
    </body>
    <script>
        $('.login-btn').bind('click',function(){
            if($('#mobile').val() ==''||$('#password').val() == ''){
                alert('用户名或密码不能为空！');
            }
            $.ajax({url:"/doLogin",type:"post",data:{username:$('#mobile').val(),password:hex_md5($('#password').val())},success:function(datas){
                if(datas.success == "success"){
               		window.location.href="/index";
                }
            }}); 
        })
    </script>
</html>
