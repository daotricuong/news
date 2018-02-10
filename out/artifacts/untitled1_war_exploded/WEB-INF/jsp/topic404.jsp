<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>


<%@ include file="header.jsp" %>
<body>

<%@ include file="nav.jsp" %>


<script>
    $(document).ready(function () {
        $("#owl-demo-1").owlCarousel({
            autoPlay: 3000,
            items: 1,
            itemsDesktop: [1199, 1],
            itemsDesktopSmall: [400, 1]
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
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language: 'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language: 'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>

<!-- /////////////////////////////////////////Content -->
<div id="page-content" class="index-page container">
    <div class="row">
        <div id="main-content"><!-- background not working -->
            <div class="col-md-8">

                <div class="box" style="height: auto">
                    <h1 style="align-content: center">Sorry page not found!</h1>
                    <img src="<c:url value="/resources/images/404.png"/>">
                </div>
            </div>
        </div>
        <div id="sidebar">
            <div class="col-md-4">

                <!---- Start Widget ---->
                <div class="widget wid-new-post">
                    <div class="heading"><h4>Bình Luận Nhiều</h4></div>
                    <div class="content">
                        <c:forEach var="entry" items="${requestScope.topComment}">
                            <a href="${entry.topicId}.html"><h6>${entry.topicName}</h6></a>
                            <img class="topimg" src="${entry.topicCover}"/>
                            <ul class="list-inline">
                                <li><i class="fa fa-calendar"></i>${entry.createDay}</li>
                                <li><i class="fa fa-comments"></i>${entry.commentCount}</li>
                            </ul>
                            <p>${entry.topicDes}.</p>
                        </c:forEach>
                    </div>
                </div>
                <!---- Start Widget ---->
                <div class="widget wid-new-post">
                    <div class="heading"><h4>Mới</h4></div>
                    <div class="content">
                        <c:forEach var="news" items="${requestScope.topNews}">
                            <a href="${news.topicId}.html"><h6>${news.topicName}</h6></a>
                            <img class="topimg" src="${news.topicCover}"/>
                            <ul class="list-inline">
                                <li><i class="fa fa-calendar"></i>${news.createDay}</li>
                                <li><i class="fa fa-comments"></i>${news.commentCount}</li>
                            </ul>
                            <p>${news.topicDes}.</p>
                        </c:forEach>
                    </div>
                </div>

                <!---- Start Widget ---->
                <div class="widget wid-recent-post">
                    <div class="heading"><h4>Post gần đây</h4></div>
                    <div class="content">
                        <span>CPost gần đây <a href="#">Post gần đây</a></span>
                        <span>CPost gần đây <a href="#">Post gần đây</a></span>
                        <span>CPost gần đây <a href="#">Post gần đây</a></span>
                        <span>CPost gần đây <a href="#">Post gần đây</a></span>
                        <span>CPost gần đây <a href="#">Post gần đây</a></span>


                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
</div>
</body>

<%@ include file="footer.jsp" %>
