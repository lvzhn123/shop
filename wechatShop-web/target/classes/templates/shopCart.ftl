<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>购物车</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="icon" type="image/png" href="/theme/default/images/favicon.png">
        <link href="css/amazeui.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="css/loading.css" />
        <link rel="stylesheet" href="css/loaders.min.css" />
        <script src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript">
            $(window).load(function(){
                $(".loading").addClass("loader-chanage");
                $(".loading").fadeOut(300);
                var selectAll =  $('.del').find('input[type="checkbox"]');
                //保证全部选中
               $('.select-gd').each(function(){
                        if(!$(this).is(':checked')){
                            $(this).click();
                        }
                    });
                selectAll.each(function(){
                        if(!$(this).is(':checked')){
                            $(this).click();
                        }
                    });
                <#if shopCart??>
                selectAll.bind('click',function(){
                    if($(this).is(':checked')){
                        $('.select-gd').prop("checked","checked");
                        $('#amountAll').html('${shopCart.amount?string.currency}');
                    }else{
                        $('.select-gd').removeAttr("checked");
                        $('#amountAll').html('￥0.00');
                    }
                })
                $('.select-gd').bind('click',function(){
                    if($(this).is(':checked')){
                        $(this).parent('div')
                        var amount = parseFloat($('#amountAll').html().split('￥')[1])+
                        parseFloat($(this).parent().parent().prev().find('.amount').html().split('￥')[1]);
                        $('#amountAll').html('￥'+amount.toFixed(2));
                    }else{
                        selectAll.removeAttr("checked");
                        var amount = parseFloat($('#amountAll').html().split('￥')[1])-
                        parseFloat($(this).parent().parent().prev().find('.amount').html().split('￥')[1]);
                        $('#amountAll').html('￥'+amount.toFixed(2));
                    }

                })
                </#if>
                $('.js-btn').bind('click',function(){
                    <#if shopCart?? && shopCart.shopCartDetails?? && (shopCart.shopCartDetails?size > 0)>
                    var expids = ''
                    $('.select-gd').each(function(){
                        if(!$(this).is(':checked')){
                            expids+=($(this).attr('scdid')+',');
                        }
                    })
                    expids = expids.substring(0,expids.length-1);
                    window.location.href='/order?fromCart=true&expids='+expids;
                    <#else>
                    alert('购物车为空！')
                    </#if>
                })
            })
            function delShopCart(id){
                $.ajax({url:"/delShopCart",data:{id:id},success:function(datas){
                    alert('删除成功！');
                    window.location.href = "shopCart";

                }});
            }
        </script>
    </head>
    <!--loading页开始-->
<div class="loading">
    <div class="loader">
        <div class="loader-inner pacman">
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
    </div>
</div>
<!--loading页结束-->
    <body>
        <header data-am-widget="header" class="am-header am-header-default sq-head ">
            <div class="am-header-left am-header-nav">
                <a href="javascript:history.back()" class="">
                    <i><img src="images/arow.png"/></i>
                </a>
            </div>
            <h1 class="am-header-title">
                <a href="" class="">购物车</a><a style="display: inline-block;float: right;">编辑</a>
            </h1>
        </header>
        <div style="height: 45px;"></div>
        
        <#if shopCart?? && shopCart.shopCartDetails?? && (shopCart.shopCartDetails?size > 0)>
        <ul class="shopcart-list">
            <#list shopCart.shopCartDetails as shopCartDetail>
            <#if shopCartDetail.goods??>
            <li>
                <!--<div href="detail.html" class="left-div"></div>-->
                <img src="images/${shopCartDetail.goods.pictureurl!''}" class="shop-pic" />
                <div class="right-div">
                    <a class="item-name">${shopCartDetail.goods.goodsname}</a>
                    <a class="item-name">数量:${shopCartDetail.nums!''}</a>
                    <a class="item-name amount">价钱:${shopCartDetail.amount?string.currency}</a>
                </div>
                <!--<b class="shop-list-price">￥169 </b>-->
                
            </li>
            <!--选择、删除-->
            <div style="height: 30px;border-bottom:solid 1px #EFEFEF ;">
                <lable class="check-box"><input type="checkbox" scdid ="${shopCartDetail.id!0}" class="select-gd" name="sex" value=""></lable><span class="right-del"  onclick="delShopCart(${shopCartDetail.id!0})"><img src="images/del.png" />删除</span>
            </#if>
            </#list>   
        </ul>
        
        <div class="shop-fix">
            <a class="del"><lable class="check-box"><input type="checkbox" name="sex" value=""></lable>全选</a>
            <a></a>
            <a class="js-btn">去结算</a>
            <div class="js-text">
                <P>合计：<b id="amountAll">${shopCart.amount?string.currency}</b></P>
            </div>
        </div>
        <#else>
        <div class="login-logo">
            <img src="images/logo.png">
            <p>亲、您的购物车还是空空的哦，快去装满它!</p>
            <a href="index" class="goshopping">前去逛逛</a>
        </div>
        <div class="shop-fix">
            <a class="del"><lable class="check-box"><input type="checkbox" class="select-all" value=""></lable>全选</a>
            <a></a>
            <a class="js-btn" id="js-btn">去结算</a>
            <div class="js-text">
                <P>合计：<b>￥0.00</b></P>
            </div>
        </div>
        </#if>
<!--底部-->
 <div style="height: 55px;"></div>
 <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default sq-foot am-no-layout" id="">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">   
          <li>
            <a href="index" class="">
                <span><img src="images/hom.png"/></span>
                <span class="am-navbar-label">首页</span>
            </a>
          </li>
          <li>
            <a href="category" class="">
                <span ><img src="images/classify.png"/></span>
                <span class="am-navbar-label">分类</span>
            </a>
          </li>
       
          <li>
            <a href="shopCart" class="curr">
                <span><img src="images/ca.png"/></span>
                <span class="am-navbar-label">购物车</span>
            </a>
          </li>
          <li>
            <a href="member.html" class="">
                <span><img src="images/me.png"/></span>
                <span class="am-navbar-label">我的</span>
            </a>
          </li>
      </ul>
</div>
 
 
 
<script>
    //购物数量加减
    $(function(){
        $('.increase').click(function(){
            var self = $(this);
            var current_num = parseInt(self.siblings('input').val());
            current_num += 1;
            self.siblings('input').val(current_num);
            update_item(self.siblings('input').data('item-id'));
        })      
        $('.decrease').click(function(){
            var self = $(this);
            var current_num = parseInt(self.siblings('input').val());
            if(current_num > 1){
                current_num -= 1;
                self.siblings('input').val(current_num);
                update_item(self.siblings('input').data('item-id'));
            }
        })
    })
</script>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>   
    </body>
</html>
