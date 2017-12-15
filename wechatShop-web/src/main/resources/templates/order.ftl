<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>华新商城</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="icon" type="image/png" href="/theme/default/images/favicon.png">
        <link href="css/amazeui.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/date.js"></script>
        <script src="js/iscroll.js"></script>
        <script src="js/base64.js"></script>
        <script type="text/javascript">
            $(function(){
                $('#beginTime').date();
                $('#endTime').date({theme:"datetime"});
            });
            function glAddress(){
                var b = new Base64();  
                window.location.href=('gladdress?backUrl='+b.encode(window.location.href));
            }
        </script>
    </head>
    <body>
        <header data-am-widget="header" class="am-header am-header-default sq-head ">
            <div class="am-header-left am-header-nav">
                <a href="javascript:history.back()" class="">
                    <i><img src="images/arow.png"/></i>
                </a>
            </div>
            <h1 class="am-header-title">
                <a href="" class="">提交订单</a>
            </h1>
        </header>
        <div style="height: 49px;"></div>
        <h5 class="order-tit">收货人信息</h5>
        <div class="order-name">
            <#if address ??>
            <!--<a href="gladdress.html">
                <p class="order-tele">宋科&nbsp;&nbsp;&nbsp;15180163170</p>
                <p class="order-add">江西省南昌市 青云谱区解放西路258号</p>
            </a>
            <a><img src="images/rigarrow.png" style="float: left;"/></a>-->
            <div style="width: 10%;float: left;height: 100%;">
                <img src="images/1-icon5.png" style="float: left;width: 100%;padding: 1rem 1px;"/>
            </div>
            <div style="width: 83%;float: left;height: 100%;">
                <a onclick="glAddress()">
                <p class="order-tele">${address.receiver!''}&nbsp;&nbsp;&nbsp;${address.phone!''}</p>
                <p class="order-add">${address.address!''}</p>
            </a>
            </div>
            <div style="width: 7%;float: left;height: 100%;padding: 1.5rem 1px;">
                <img src="images/rigarrow.png" style="float: left;width: 100%;"/>
            </div>
            </#if>
        </div>
        <div style="background: #eee; height: 10px;"></div>
        <h5 class="order-tit">订单详情</h5>
        <#if goodsList??>
        <ul class="shopcart-list" style="padding-bottom: 0; margin-top: 0;">
            <#list goodsList as goods>
            <li>
                <img src="images/${goods.pictureUrl}" class="shop-pic" />
                <div class="order-mid">
                    <div class="tit">${goods.goodsName}</div>
                    <div class="order-price">${goods.price?string.currency}<i>X${goods.num}</i></div>
                </div>
            </li>
            <li class="order-infor-first">
                <span>商品总计：</span>
                <i>${goods.amount?string.currency}</i>
            </li>
            </#list>
        </ul>
        </#if>
        <div style="background: #eee; height: 10px;"></div>
        
        <p class="pay-style-box">请选择以下支付方式：</p>
        <div class="pay-style">
            <label class="am-radio am-warning">
                <input type="radio" name="radio3" value="Z" checked>在线支付
            </label>
            <label class="am-radio am-warning" style="margin-top: 10px;">
                <input type="radio" name="radio3" value="H" >货到付款
            </label>
        </div>
        <div style="background: #eee; height: 10px;"></div>
        <textarea placeholder="备注说明" class="bz-infor"></textarea>
        <div style="background: #eee; height: 10px;"></div>
        <div style="height: 55px;"></div>
        <div style="height: 5rem; position: fixed; bottom: 0px; background: #F7F7F7; width: 100%; padding: 0 3%;">
            <div class="order-text">
                应付总额：<span>${amount?string.currency}</span>
            </div>
            <a class="js-btn" id="submit">提交订单</a>
        </div>
</body>
<script>
    $('#submit').bind('click',function(){
        var address = '';
        <#if address ??>
            address = '${address.receiver}'+'${address.phone}'+'${address.address}';
        </#if>
        var payWay = $('input:radio:checked').val();
        var amount = ${amount};
        var order = {address:address,payWay:payWay,amount:amount};
        var odList = [];
        <#if goodsList??>
        <#list goodsList as goods>
        var goodsid = 1;
        var price = ${goods.price};
        var goodsname = '${goods.goodsName}';
        var nums = ${goods.num};
        var amount = ${goods.amount};
        var od = {goodsname:goodsname,nums:nums,amount:amount,goodsid:goodsid,price:price};
        odList.push(od);
        </#list>
        </#if>
        $.ajax({type:'POST',url:"/saveOrder",data:{order:1,odList:2},success:function(datas){
            alert('下单成功！')
        }});
    })
</script>
</html>
