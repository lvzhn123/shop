<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="icon" type="image/png" href="/theme/default/images/favicon.png">
		<link href="/css/amazeui.min.css" rel="stylesheet" type="text/css" />
		<link href="/css/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/loading.css" />
		<link rel="stylesheet" href="css/loaders.min.css" />
		<script src="js/jquery-1.10.2.min.js"></script>
		<script src="js/time.js"></script>
		<!--<script>
                    $(function () {
                        var elm = $('#shortbar');
                        var startPos = $(elm).offset().top;
                        $.event.add(window, "scroll", function () {
                            var p = $(window).scrollTop();
                            if (p > startPos) {
                                elm.addClass('sortbar-fixed');
                            } else {
                                elm.removeClass('sortbar-fixed');
                            }
                        });
                    });

		</script>-->
		<script type="text/javascript">
			$(window).load(function(){
				$(".loading").addClass("loader-chanage")
				$(".loading").fadeOut(500)
			})
		</script>
	</head>
	<body>
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
<!--图片轮换-->
<div class="am-slider am-slider-default" data-am-flexslider id="demo-slider-0" style="position: relative;">
	<header data-am-widget="header" class="am-header am-header-default tm-head sortbar-fixed" id="shortbar" >
			<!--<div class="am-header-left am-header-nav">
		        <a href="city.html" class="">
			        <img src="../images/city.png" />
			        <p style="font-size: 12px; margin-top: -35px;">南昌</p>
			    </a>
		   </div>-->
			<h1 class="am-header-title1">
		        <div class="search-box">
		           <input type="text" name="title" class="index-search" placeholder="寻找你喜欢的商品......" />
		           <input type="submit" value="" class="search-icon" />
		        </div>
		    </h1>
			<!--<div class="am-header-right am-header-nav">

			    <a href="" class="">
		           <img src="../images/sao.png" />
		           <p style="font-size: 12px; margin-top: -35px;">扫一扫</p>
		        </a>
			</div>-->
        </header>
  <ul class="am-slides">
    <#if rollads ?exists>
       <#list rollads as rollad>
			<li><img src="../images/${rollad.url}" /></li>
		</#list>
    </#if>
  </ul>
</div>
<!--导航-->
 <!-- 特色专区-->
  <div class="sq-title">
 	<img src="images/ts.png" width="24"/>
 	热销商品
 </div>
  <div class="whitebar">
			      <div class="am-tabs-bd">
			          <div data-tab-panel-0 class="am-tab-panel am-active">
                         <ul data-am-widget="gallery" class="am-gallery special am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-default" >
						      <#if hotsellGoods ??>
						      <#list hotsellGoods  as hotsellGood>
						        <li>
						        <div class="am-gallery-item">
						            <a href="goodsDetail.html?goodsId=${hotsellGood.goodsid}" class="">
						              <img src="../images/${hotsellGood.pictureurl}"/>
						                <h3 class="am-gallery-title">${hotsellGood.goodsname}</h3>
	                                    <div class="am-gallery-desc">${hotsellGood.stdptrice?string.currency} <del>${hotsellGood.marketprice?string.currency}</del></div>
						            </a>
						        </div>
						      </li>
						      </#list>
						      </#if>
						 </ul>
			          </div>
			    
            </div>
           
	   </div>
 <!--底部-->
 <div style="height: 55px;"></div>
 <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default sq-foot am-no-layout" id="">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">   
          <li>
            <a href="/index" class="curr">
                <span><img src="../images/home.png"/></span>
                <span class="am-navbar-label ha">首页</span>
            </a>
          </li>
          <li>
            <a href="/category" class="">
                <span><img src="../images/classify.png"/></span>
                <span class="am-navbar-label">分类</span>
            </a>
          </li>

          <li>
            <a href="/shopCart" class="">
                <span><img src="../images/cart.png"/></span>
                <span class="am-navbar-label">购物车</span>
            </a>
          </li>
          <li>
            <a href="login.html" class="">
                <span><img src="../images/me.png"/></span>
                <span class="am-navbar-label">我的</span>
            </a>
          </li>
      </ul>
</div>





<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
	</body>
</html>
