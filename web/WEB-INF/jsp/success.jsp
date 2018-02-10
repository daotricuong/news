<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<body>
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


<script type="text/javascript" src="<c:url value="js/bootstrap-datetimepicker.js"/> " charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="js/locales/bootstrap-datetimepicker.fr.js"/> "
        charset="UTF-8"></script>
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

    <div style="height:500px;margin: auto;">

        <div class="box" style=" padding-top: 80px ; padding-bottom: 8px;background-color: rgba(9,25,255,0.2)">
            <h1 style="align-content: center">Success!</h1>
            <h1 style="align-content: center">Thành công! </h1>
        </div>
    </div>

</div>

<%
    String redirectURL = "/admin/editors.html";
    response.sendRedirect(redirectURL);
%>
</body>

