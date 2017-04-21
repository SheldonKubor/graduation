<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/23
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <link rel="stylesheet" href="js/swiper-3.4.2.min.css"/>
    <link rel="stylesheet" href="js/animate.min.css"/>
    <link rel="stylesheet" href="css/indexCss.css" type="text/css"/>
</head>
<body>
    <div id="hd">
        <div class="tools">
            <div class="top_link">
                <ul class="tools_list">
                    <li><a href="login.jsp">登录</a>&nbsp;&nbsp;</li>
                    <li><a href="personal_info.jsp" target="_blank">个人中心</a>&nbsp;&nbsp;</li>
                    <li><a href="shop_cart.jsp" target="_blank">我的购物车</a></li>
                </ul>
            </div>
        </div>
        <div class="search_box">
            <div class="logo">
                <img src="http://img63.ddimg.cn/upload_img/00444/tupian/doodle.gif">
            </div>
            <div class="search">
                <form action="search" name="searchform" id="form_search_new" method="GET">
                    <input type="text" placeholder="请输入图书分类，作者或书名" class="search_text"/>

                    <input type="submit" class="search_button" onclick=""/>
                </form>
            </div>
        </div>
    </div>
    <div id="index_left">
        <div id="book_menu">
            <ul>
                <li class="all"><a>图书分类</a></li>
                <li><a href="#">科技</a></li>
                <li><a href="#">文学</a></li>
                <li><a href="#">小说</a></li>
                <li><a href="#">魔幻</a></li>
                <li><a href="#">科幻</a></li>
            </ul>
        </div>
    </div>
    <div id="index_center" style="overflow:hidden;">
            <div class="swiper-container" style="width: 100%;height: 300px;">
                <div class="swiper-wrapper" style="width: 100%">
                    <div class="swiper-slide"><img src="images/1.jpg" width="100%"/></div>
                    <div class="swiper-slide"><img src="images/2.jpg" width="100%"/></div>
                    <div class="swiper-slide"><img src="images/3.jpg" width="100%"/></div>
                    <div class="swiper-slide"><img src="images/4.jpg" width="100%"/></div>
                    <div class="swiper-slide"><img src="images/5.jpg" width="100%"/></div>
                    <!-- 如果需要分页器 -->

                </div>
                <div class="swiper-pagination"></div>

                <!-- 如果需要导航按钮 -->
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            </div>
        <br>
    </div>

    <div id="index_bottom">
        <div class="footer_copyright">
            <span><a href="http://www.miibeian.gov.cn/" target="_blank" rel="nofollow">京ICP证041189号</a></span>
            <span class="sep">|</span><span>出版物经营许可证 新出发京批字第直0673号</span><span class="sep">|</span>
            <span>食品流通许可证：SP1101011010021855(1-1)</span><br>
            <span>互联网药品信息服务资格证编号：(京)-非经营性-2012-0016</span>
            <span class="sep">|</span><span>京公网安备110101000001号</span><br>
            <span>互联网违法和不良信息举报电话：4001066666-5 邮箱：<a href="mailto:service@cs.dangdang.com">service@cs.dangdang.com</a></span>
        </div>
    </div>
    <script src="js/swiper-3.4.2.min.js"></script>
    <script src="js/swiper.animate.min.js"></script>

    <script>
        var mySwiper = new Swiper ('.swiper-container', {
            loop: true,
            autoplay:3000,
            // 如果需要分页器
            pagination: '.swiper-pagination',

            // 如果需要前进后退按钮
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',

            // 如果需要滚动条
            //scrollbar: '.swiper-scrollbar',
        })
    </script>

</body>
</html>
