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
        <link rel="stylesheet" href="css/loading.css" />
        <link rel="stylesheet" href="css/loaders.min.css" />
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/time.js"></script>
        <script type="text/javascript">
            $(window).load(function() {
                $(".loading").addClass("loader-chanage");
                $(".loading").fadeOut(300);
                getActivity();
                
            })
           
           function appendGoodsList(datas){
                $('#goodsColumn').html('');
                for(var idx in datas){
                            var data = datas[idx];
                            $('#goodsColumn').append("<li><a href=\"goodsDetail?goodsId="+data.goodsid+"\"><img src=\"../images/"+data.pictureurl+"\"  class=\"list-pic\" /></a> <div class=\"shop-list-mid\" style=\"width: 65%;\"><div class=\"tit\"><a href=\"goodsDetail?goodsId="+data.goodsid+"\">"+data.goodsname+"</a>"+"<a href=\"goodsDetail?goodsId="+data.goodsid+"\">价钱：￥"+data.stdptrice+"<span style=\"display: inline-block; padding: 2px 5px;\">原价:</span><span class=\" line-through \">￥"+data.marketprice
                                +"</span></a></div> </div></li>");
                        }
           }
            function getActivity(){
                $.ajax({url:"/getActivity",success:function(datas){
                        appendGoodsList(datas);
                }});
            }
            function getGoodsByClassId(id){
                $.ajax({url:"/getGoodsByClass",type:"post",data:{classId:id},success:function(datas){
                        appendGoodsList(datas);
                }});    
            }
            function findByname(){
            	    var name = $('.cate-input').val();
                    if(name!= '' && name !='请输入搜索关键词'){
                    $.ajax({url:"/getGoodsByName",type:"post",data:{name:name},success:function(datas){
                        appendGoodsList(datas);
                    }});
                }        
            }
            $('body').bind('.cate-btn','click',function(){
                   findByname();                   
            });
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
        <header data-am-widget="header" class="am-header am-header-default sq-head ">
            <div class="am-header-left am-header-nav">
                <a href="javascript:history.back()" class="">
                    <i><img  src="images/arow.png"/></i>
                </a>
            </div>
            <h1 class="am-header-title">
                <a href="" class="">商品分类</a>
            </h1>
        </header>
        <div style="height: 49px;"></div>
        <div class="cate-search">
            <input type="text" class="cate-input" placeholder="请输入搜索关键词" />
            <input type="button" class="cate-btn" />
        </div>
        <div class="content-list">
            <ul class="list-left" id="tab_btn">
                <li class="current">
                    <a onclick="getActivity()">热销商品</a>
                </li>
                <#if goodsClass ??>
                   <#list goodsClass as goodsCls>
                        <li>
                        <a onclick="getGoodsByClassId(${goodsCls.classid!''})">${goodsCls.name!''}</a>
                        </li>
                    </#list>    
                </#if>
            </ul>
            <div class="list-right" id="tab_con">
                <ul class="list-pro" id="goodsColumn">
                    <li>
                        <a href="detail.html"><img src=" images/test10.png" class="list-pic" /></a>
                        <div class="shop-list-mid" style="width: 65%;">
                            <div class="tit">
                                <a href="detail.html">
                                    法国加力果12个装 进口新鲜水果
                                </a>
                                <a href="detail.html">
                                    规格
                                </a>
                                <a href="detail.html">
                                    价钱：￥150
                                    <span style="display: inline-block; padding: 2px 5px;">原价:</span><span class=" line-through ">￥200</span>
                                </a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

        </div>

        <!--底部-->
        <div style="height: 55px;"></div>
        <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default sq-foot am-no-layout" id="">
            <ul class="am-navbar-nav am-cf am-avg-sm-4">
                <li>
                    <a href="index">
                        <span><img src="images/hom.png"/></span>
                        <span class="am-navbar-label">首页</span>
                    </a>
                </li>
                <li>
                    <a href="category" class="curr">
                        <span><img src="images/clas.png"/></span>
                        <span class="am-navbar-label">分类</span>
                    </a>
                </li>

                <li>
                    <a href="shopCart" class="">
                        <span><img src="images/cart.png"/></span>
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

        <script type="text/javascript">
            //TAB切换
            var tab_Btns_box = document.getElementById('tab_btn');
            var tab_Btns = tab_Btns_box.getElementsByTagName('li');
            var tab_contents = document.getElementsByClassName('tab_content');
            for(var i = 0; i < tab_Btns.length; i++) {
                tab_Btns[i].index = i;

                tab_Btns[i].onclick = function() {
                    for(var i = 0; i < tab_Btns.length; i++) {
                        if(i !== this.index) {
                            tab_Btns[i].classList.remove('current')
                        }
                    }
                    tab_Btns[this.index].className = "current";

                    for(var j = 0; j < tab_contents.length; j++) {
                        if(j !== this.index) {
                            tab_contents[j].classList.remove('show');
                        }
                        tab_contents[this.index].classList.add('show');
                    }
                }
            }
        </script>
        <script src="js/jquery.min.js"></script>
        <script src="js/amazeui.min.js"></script>
    </body>

</html>