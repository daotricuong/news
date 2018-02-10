<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file="header.jsp"%>

<body>

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


<script>
    $(document).ready(function () {
        var x = document.getElementById("snackbar")
        x.className = "show";
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
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
<div style="width: 100%; height: 100%">

    <c:if test="${message!=null}">
        <div id="snackbar">${message}</div>
    </c:if>
    <!-- /////////////////////////////////////////Content -->
    <div class="container" style="padding-top: 190px">
        <div class="row vertical-offset-100">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please sign in</h3>
                    </div>
                    <div class="panel-body">
                        <form accept-charset="UTF-8" role="form" action="/login.html" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                                    </label>
                                </div>
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                                <a href="/register.html">Register here!</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>

