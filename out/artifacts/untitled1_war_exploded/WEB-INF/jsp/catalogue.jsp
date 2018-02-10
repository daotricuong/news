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
                <div class="box" style="padding-bottom: 20px">
                    <div class="box-header header-natural">
                        <h2>${catalogue}</h2>
                    </div>
                    <div class="box-content">
                        <c:forEach var="entry" items="${topic}">
                            <div class="row" style="padding-top: 20px">
                                <div class="col-md-6">
                                    <img class="topiccover" src="${entry.topicCover}" style=""/>
                                </div>
                                <div class="col-md-6">
                                    <a href="/topic/${entry.topicId}.html"><h3>${entry.topicName}</h3></a>
                                    <span><i class="fa fa-heart"></i> ${entry.likeCount} / <i
                                            class="fa fa-calendar"></i> ${entry.createDay} / <i
                                            class="fa fa-comment-o">  </i> ${entry.commentCount} / <i
                                            class="fa fa-eye"></i> ${entry.viewCount}</span>
                                    <p>${entry.topicDes}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="sidebar.jsp" %>
    </div>
</div>
</div>
</body>

<%@ include file="footer.jsp" %>
