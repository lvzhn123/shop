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
        <script src="js/base64.js"></script>
    </head>
    <body>
        <header data-am-widget="header" class="am-header am-header-default sq-head ">
            <div class="am-header-left am-header-nav">
                <a onclick="goback()" class="">
                    <i><img src="images/arow.png"/></i>
                </a>
            </div>
            <h1 class="am-header-title">
                <a href="" class="">管理收货地址</a>
            </h1>
            <div class="am-header-right am-header-nav">
                <a onclick="gotoEdit(0)" class="">
                    <i><img src="images/add.png"/></i>
                </a>
            </div>
        </header>
        <div style="height: 49px;"></div>
        <#if addresses ??>
        <ul class="address-list">
            <#list addresses as address>
            <li class="curr">
                <p>收货人：${address.receiver!''}&nbsp;&nbsp;${address.phone!''}</p>
                <p class="order-add1">收货地址：${address.address!''}</p>
                <hr />
                <div class="address-cz">
                    <label class="am-radio am-warning">
                       <input type="radio" name="radio3" class="default" aid="${address.id}" value="" <#if address.isdefault == '1'>checked </#if>> 设为默认
                    </label>
                    <a onclick="gotoEdit(${address.id})"><img src="images/bj.png" width="18" />&nbsp;编辑</a>
                    <a onclick ="deleteAddr('${address.id}')">删除</a>
                </div>
            </li>
            </#list>
        </ul>
        </#if>
        <script src="js/base64.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script> 
    </body>
    <script>
        $('.default').bind('click',function(){
           // alert($(this).attr('aid'));
            $.ajax({url:"/updateDefault",data:{addressId:$(this).attr('aid')},success:function(datas){
            }});
        })
        function gotoEdit(addressId){
        	var b = new Base64();  
        	var url='/address?backUrl='+b.encode(window.location.href); 
        	if(addressId != 0){
        		url+=('&addressId='+addressId)
        	}
        	window.location.href=url;
        }
        function goback(){
            var b = new Base64(); 
            window.location.href=b.decode('${backUrl}');
        }
        function deleteAddr(addressId){
            $.ajax({url:"/deleteAddr",data:{addressId:addressId},success:function(datas){
                window.location.reload(true);
            }});
        }
    </script>
</html>
