<%@page contentType="text/html" pageEncoding="UTF-8" %>

<header>
    <!--Top-->
    <nav id="top">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <strong>Welcome to Group 7!</strong>
                </div>
                <div class="col-md-6">
                    <ul class="list-inline top-link link">
                        <li><a href="/home.html"><i class="fa fa-home"></i> Home</a></li>
                        <li><a href="#"><i class="fa fa-comments"></i> Contact</a></li>
                        <li><a href="#"><i class="fa fa-question-circle"></i> FAQ</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <!--Navigation-->
    <nav id="menu" class="navbar container navbar-light">
        <div class="navbar-header">
            <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
            <a class="navbar-brand" href="/home.html">
                <div class="logo"><span>Báo Group 7</span></div>
            </a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Danh Mục <i
                        class="fa fa-arrow-circle-o-down"></i></a>
                    <div class="dropdown-menu" style="margin-left: 0px;">
                        <div class="dropdown-inner">

                            <c:if test="${requestScope.catalogues.size()>5}">
                                <c:forEach var="i" begin="0" end="${requestScope.catalogues.size()/5-1}">
                                    <ul class="list-unstyled">
                                        <c:forEach var="cata" begin="0" end="4">

                                            <li><a href="/${requestScope.catalogues.get(cata+5*i).catalogueid}.html">${requestScope.catalogues.get(cata+5*i).catalogueName}</a></li>

                                        </c:forEach>
                                    </ul>
                                </c:forEach>
                            </c:if>
                                <ul class="list-unstyled">
                                    <c:forEach var="cata2" begin="${requestScope.catalogues.size()-requestScope.catalogues.size()%5}" end="${requestScope.catalogues.size()-1}">

                                        <li><a href="/${requestScope.catalogues.get(cata2).catalogueid}.html">${requestScope.catalogues.get(cata2).catalogueName}</a></li>

                                    </c:forEach>
                                </ul>





                        </div>
                    </div>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Giải Trí <i
                        class="fa fa-arrow-circle-o-down"></i></a>
                    <div class="dropdown-menu" style="margin-left: 0px;">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="#">Cười</a></li>
                                <li><a href="#">Xe và Đời Sống</a></li>
                                <li><a href="##">Ngôi Sao</a></li>
                                <li><a href="##">Độc & Lạ</a></li>
                                <li><a href="##">Thời Trang</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Video <i
                        class="fa fa-arrow-circle-o-down"></i></a>
                    <div class="dropdown-menu">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="#">Nóng</a></li>
                                <li><a href="#">Thể Thao</a></li>
                                <li><a href="#">Âm Nhạc</a></li>
                            </ul>
                        </div>
                    </div>
                </li>

                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Khác <i
                        class="fa fa-arrow-circle-o-down"></i></a>
                    <div class="dropdown-menu">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="#">Khác 1</a></li>
                                <li><a href="#">Khác 2</a></li>
                                <li><a href="#">Khác 3</a></li>
                                <li><a href="#">Khác 4</a></li>
                                <li><a href="#">Khác 5</a></li>
                                <li><a href="#">Khác 5</a></li>
                                <li><a href="#">Khác 5</a></li>
                                <li><a href="#">Khác 5</a></li>
                                <li><a href="#">Khác 5</a></li>


                            </ul>
                        </div>
                    </div>
                </li>
                <%--<li><a href="#"><i class="fa justify-content-around"></i> Tin Nhanh</a></li>--%>

                <li><a href="contact.html"><i class="fa fa-envelope"></i> Liên hệ</a></li>

                <li><a href="index.html">Thông tin</a></li>

                <c:if test="${sessionScope.username!=null}">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:if test="${sessionScope.username.length() > 10 }">${sessionScope.username.substring(0, 10)}</c:if><c:if test="${sessionScope.username.length() <= 10 }">${sessionScope.username}</c:if>    <i
                            class="fa fa-user"></i></a>
                        <div class="dropdown-menu">
                            <div class="dropdown-inner">
                                <ul class="list-unstyled">
                                    <li><a href="/myprofile.html">Tài khoản của tôi</a></li>
                                    <li><form action="/logout.html" method="post" id="logout"><a href="#" onclick="this.parentNode.submit()">Đăng xuất</a></form></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </c:if>
                <c:if test="${sessionScope.username==null}">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Tài Khoản <i
                            class="fa fa-arrow-circle-o-down"></i></a>
                        <div class="dropdown-menu">
                            <div class="dropdown-inner">
                                <ul class="list-unstyled">
                                    <li><a href="/login.html">Đăng Nhập</a></li>
                                    <li><a href="/register.html">Đăng Ký</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </c:if>

            </ul>
            <ul class="list-inline navbar-right top-social">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
                <li><a href="#"><i class="fa fa-youtube"></i></a></li>
            </ul>
        </div>
    </nav>
</header>