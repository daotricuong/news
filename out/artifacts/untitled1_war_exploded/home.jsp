<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file="WEB-INF/jsp/header.jsp"%>
<body>

<header>
    <!--Top-->

    <!--Navigation-->
    <%@ include file="/WEB-INF/jsp/nav.jsp" %>
    <%--<nav id="menu" class="navbar container navbar-light">--%>
        <%--<div class="navbar-header">--%>
            <%--<button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse"--%>
                    <%--data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>--%>
            <%--<a class="navbar-brand" href="/home.html">--%>
                <%--<div class="logo"><span>Báo Group 7</span></div>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="collapse navbar-collapse navbar-ex1-collapse">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Danh Mục <i--%>
                        <%--class="fa fa-arrow-circle-o-down"></i></a>--%>
                    <%--<div class="dropdown-menu" style="margin-left: 0px;">--%>
                        <%--<div class="dropdown-inner">--%>

                            <%--<c:if test="${catalogues.size()>5}">--%>
                                <%--<c:forEach var="i" begin="0" end="${catalogues.size()/5-1}">--%>
                                    <%--<ul class="list-unstyled">--%>
                                        <%--<c:forEach var="cata" begin="0" end="4">--%>

                                            <%--<li><a href="/${catalogues.get(cata+5*i).catalogueid}.html">${catalogues.get(cata+5*i).catalogueName}</a></li>--%>

                                        <%--</c:forEach>--%>
                                    <%--</ul>--%>
                                <%--</c:forEach>--%>
                            <%--</c:if>--%>
                            <%--<ul class="list-unstyled">--%>
                                <%--<c:forEach var="cata2" begin="${catalogues.size()-catalogues.size()%5}" end="${catalogues.size()-1}">--%>

                                    <%--<li><a href="/${catalogues.get(cata2).catalogueid}.html">${catalogues.get(cata2).catalogueName}</a></li>--%>

                                <%--</c:forEach>--%>
                            <%--</ul>--%>





                        <%--</div>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Giải Trí <i--%>
                        <%--class="fa fa-arrow-circle-o-down"></i></a>--%>
                    <%--<div class="dropdown-menu" style="margin-left: 0px;">--%>
                        <%--<div class="dropdown-inner">--%>
                            <%--<ul class="list-unstyled">--%>
                                <%--<li><a href="#">Cười</a></li>--%>
                                <%--<li><a href="#">Xe và Đời Sống</a></li>--%>
                                <%--<li><a href="##">Ngôi Sao</a></li>--%>
                                <%--<li><a href="##">Độc & Lạ</a></li>--%>
                                <%--<li><a href="##">Thời Trang</a></li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Video <i--%>
                        <%--class="fa fa-arrow-circle-o-down"></i></a>--%>
                    <%--<div class="dropdown-menu">--%>
                        <%--<div class="dropdown-inner">--%>
                            <%--<ul class="list-unstyled">--%>
                                <%--<li><a href="#">Nóng</a></li>--%>
                                <%--<li><a href="#">Thể Thao</a></li>--%>
                                <%--<li><a href="#">Âm Nhạc</a></li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</li>--%>

                <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Khác <i--%>
                        <%--class="fa fa-arrow-circle-o-down"></i></a>--%>
                    <%--<div class="dropdown-menu">--%>
                        <%--<div class="dropdown-inner">--%>
                            <%--<ul class="list-unstyled">--%>
                                <%--<li><a href="#">Khác 1</a></li>--%>

                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--&lt;%&ndash;<li><a href="#"><i class="fa justify-content-around"></i> Tin Nhanh</a></li>&ndash;%&gt;--%>

                <%--<li><a href="contact.html"><i class="fa fa-envelope"></i> Liên hệ</a></li>--%>

                <%--<li><a href="index.html">Thông tin</a></li>--%>
                <%--<c:if test="${sessionScope.username!=null}">--%>
                    <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:if test="${sessionScope.username.length() > 10 }">${sessionScope.username.substring(0, 10)}</c:if><c:if test="${sessionScope.username.length() <= 10 }">${sessionScope.username}</c:if>    <i--%>
                            <%--class="fa fa-user"></i></a>--%>
                        <%--<div class="dropdown-menu">--%>
                            <%--<div class="dropdown-inner">--%>
                                <%--<ul class="list-unstyled">--%>
                                    <%--<li><a href="/login.html">Tài khoản của tôi</a></li>--%>
                                    <%--<li><a href="/logout.html">Đăng xuất</a></li>--%>
                                <%--</ul>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                <%--</c:if>--%>
                <%--<c:if test="${sessionScope.username==null}">--%>
                    <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Tài Khoản <i--%>
                            <%--class="fa fa-arrow-circle-o-down"></i></a>--%>
                        <%--<div class="dropdown-menu">--%>
                            <%--<div class="dropdown-inner">--%>
                                <%--<ul class="list-unstyled">--%>
                                    <%--<li><a href="/login.html">Đăng Nhập</a></li>--%>
                                    <%--<li><a href="/register.html">Đăng Ký</a></li>--%>
                                <%--</ul>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                <%--</c:if>--%>


            <%--</ul>--%>
            <%--<ul class="list-inline navbar-right top-social">--%>
                <%--<li><a href="#"><i class="fa fa-facebook"></i></a></li>--%>
                <%--<li><a href="#"><i class="fa fa-twitter"></i></a></li>--%>
                <%--<li><a href="#"><i class="fa fa-pinterest"></i></a></li>--%>
                <%--<li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>--%>
                <%--<li><a href="#"><i class="fa fa-youtube"></i></a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</nav>--%>
</header>


<script>
    $(document).ready(function() {
        $("#owl-demo-1").owlCarousel({
            autoPlay: 3000,
            items : 1,
            itemsDesktop : [1199,1],
            itemsDesktopSmall : [400,1]
        });
        // $("#owl-demo-2").owlCarousel({
        //     autoPlay: 3000,
        //     items : 3,
        //
        // });
    });
</script>


<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>

<div class="featured container">
    <div class="row">
        <div class="col-sm-12">
            <!-- Carousel -->
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>
                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img style="min-height: 100px" src="<c:url value="${top3.get(0).topicCover}"/>" alt="First slide">
                        <!-- Static Header -->
                        <div class="header-text hidden-xs">
                            <div class="col-md-12 text-center">
                                <h2 style="background-color:rgba(255, 230, 179,0.4); border-radius: 10px">${top3.get(0).topicName}</h2>
                                <br>
                                <h3>${top3.get(0).topicDes}.</h3>
                                <br>
                            </div>
                        </div><!-- /header-text -->
                    </div>
                    <div class="item">
                        <img style="min-height: 100px" src="<c:url value="${top3.get(1).topicCover}"/>" alt="First slide">
                        <!-- Static Header -->
                        <div class="header-text hidden-xs">
                            <div class="col-md-12 text-center">
                                <h2 style="background-color:rgba(255, 230, 179,0.4); border-radius: 10px">${top3.get(1).topicName}</h2>
                                <br>
                                <h3>${top3.get(1).topicDes}.</h3>
                                <br>
                            </div>
                        </div><!-- /header-text -->
                    </div>
                    <div class="item">
                        <img style="min-height: 100px" src="<c:url value="${top3.get(2).topicCover}"/>" alt="First slide">
                        <!-- Static Header -->
                        <div class="header-text hidden-xs">
                            <div class="col-md-12 text-center">
                                <h2 style="background-color:rgba(64, 64, 64,0.4); border-radius: 10px">${top3.get(2).topicName}</h2>
                                <br>
                                <h3>${top3.get(2).topicDes}.</h3>
                                <br>
                            </div>
                        </div><!-- /header-text -->
                    </div>
                </div>
                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div><!-- /carousel -->
        </div>
    </div>
</div>

<!-- /////////////////////////////////////////Content -->
<div id="page-content" class="index-page container">
    <div class="row">
        <div id="main-content"><!-- background not working -->
            <div class="col-md-8">
                <div class="box wrap-vid">
                    <div class="zoom-container">
                        <div class="zoom-caption">
                            <span class="youtube">Top</span>
                            <a href="single.html">
                                <i class="fa fa-play icon-play" style="color: #fff"></i>
                            </a>
                            <p>Việt Nam vs Thái Lan: 3-0</p>
                        </div>
                        <img src="http://img.f50.bdpcdn.net/Assets/Media/2017/08/24/62/anh-nhan-dinh-vietnam-thailan-680.jpg" />
                    </div>
                    <h3 class="vid-name"><a href="#">[Gián Tiếp] Việt Nam vs Thái Lan: 3-0</a></h3>
                    <div class="info">
                        <h5>By <a href="#">Đức</a></h5>
                        <span><i class="fa fa-calendar"></i>25/12/2017</span>
                        <span><i class="fa fa-heart"></i>1,200</span>
                    </div>
                    <p class="more">Công Phượng vừa có cú hat-trick đầu tiên cho đội tuyển Việt Nam cách trong trận giao hữu với sinh viên Thái Lan ngày 25/12 vừa qua. Khẳng định bản thân đang có sự vượt...</p>
                </div>

                <c:forEach var="entry" items="${listTopic}">
                <c:set var = "num" scope = "session" value = "${entry.topics.size()}"/>
                <c:if test = "${num >= 2}">
                    <div class="box">
                        <div class="box-header header-natural">
                            <a href="/${entry.listId}.html"><h2>${entry.listName}</h2></a>
                        </div>
                        <div class="box-content">
                            <div class="row">
                                <div class="col-md-6">
                                    <img class="topiccover" src="${entry.topics.get(0).topicCover}" />
                                    <h3><a href="topic/${entry.topics.get(0).topicId}.html">${entry.topics.get(0).topicName}</a></h3>
                                    <span><i class="fa fa-heart"></i> ${entry.topics.get(0).likeCount} / <i class="fa fa-calendar"></i> ${entry.topics.get(0).createDay} / <i class="fa fa-comment-o"> </i> ${entry.topics.get(0).commentCount}  /<i class="fa fa-eye"></i> ${entry.topics.get(0).viewCount}</span>
                                    <p></p>
                                </div>
                                <div class="col-md-6">
                                    <img class="topiccover" src="${entry.topics.get(1).topicCover}" />
                                    <h3><a href="topic/${entry.topics.get(1).topicId}.html">${entry.topics.get(1).topicName}</a></h3>
                                    <span><i class="fa fa-heart"></i> ${entry.topics.get(1).likeCount} / <i class="fa fa-calendar"></i> ${entry.topics.get(1).createDay} / <i class="fa fa-comment-o"> </i> ${entry.topics.get(1).commentCount}  /<i class="fa fa-eye"></i> ${entry.topics.get(1).viewCount}</span>
                                    <p></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>

                </c:forEach>
                <div class="box">
                    <div class="box-header header-photo">
                        <h2>Photos</h2>
                    </div>
                    <div class="box-content">
                        <div id="owl-demo-2" class="owl-carousel">
                            <div class="item">
                                <img src="/resources/images/1.jpg" />
                                <img src="images/2.jpg" />
                            </div>
                            <div class="item">
                                <img src="images/3.jpg" />
                                <img src="images/5.jpg" />
                            </div>
                            <div class="item">
                                <img src="images/8.jpg" />
                                <img src="images/9.jpg" />
                            </div>
                            <div class="item">
                                <img src="images/10.jpg" />
                                <img src="images/11.jpg" />
                            </div>
                            <div class="item">
                                <img src="images/12.jpg" />
                                <img src="images/13.jpg" />
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        <%@ include file="WEB-INF/jsp/sidebar.jsp"%>
    </div>
</div>
</div>
</body>

<%@ include file="WEB-INF/jsp/footer.jsp"%>
