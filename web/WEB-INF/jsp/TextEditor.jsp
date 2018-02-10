<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css"/>
    <link rel="stylesheet" href="<c:url value="/resources/dist/summernote.css"/>">
    <title>summernote</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <script type="text/javascript" src="/resources/dist/summernote.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('.summernote').summernote({
                height: 300,
                tabsize: 2
            });
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            // $('.note-editable').html = $('#topicBody').value;
            $(".note-editable").html(document.getElementById("preview").innerHTML);
            <%--$(".note-editable").html("${topic.topicBody}");--%>

        });

    </script>

    <script type="text/javascript">
        function getText() {
            var textBody = ("<h6>" + document.getElementById("topicName").value + "</h6>" + $(".note-editable").html());
            document.getElementById("preview").innerHTML = textBody;
        }

        function setText() {
            // var textBody = $(".note-editable").html();
            document.getElementById("topicBody").value = $(".note-editable").html();
        }
    </script>
    <script>
        $(document).ready(function () {
            var x = document.getElementById("snackbar")
            x.className = "show";
            setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
        });
    </script>

</head>
<body>

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
<div class="container">


        <div id="page-content" class="single-page container" style="background-color:rgba(255, 238, 204,0.2); border-radius: 15px">
            <div style="width: 70%;margin: auto">
                <br>
                <H1>TextEditor</H1>
                <form accept-charset="UTF-8" role="form" action="/topic/addTopic.html" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control topicName" placeholder="Title" id="topicId" name="topicId" type="hidden" value="${topicId}">
                            <label for="topicName">Tên bài</label>
                            <input class="form-control topicName" placeholder="Title" id="topicName" name="topicName" type="text" value="${topic.topicName}">
                            <br>
                            <label for="topicDes">Tóm tắt</label>
                            <input class="form-control" placeholder="Description" id="topicDes" name="topicDes" type="text" value="${topic.topicDes}">
                            <br>
                            <label for="TopicCover">Ảnh bìa</label>
                            <input class="form-control" placeholder="TopicCover" id="TopicCover" name="topicCover" type="text" value="${topic.topicCover}">
                            <br>
                            <label for="topicTag">Tag</label>
                            <input class="form-control" placeholder="topicTag" id="topicTag" name="topicTag" type="text" value="${topic.tagStr}">
                            <br>
                            <input placeholder="topicAuthorId" id="topicAuthorId" name="topicAuthorId" type="hidden" value="${authorid}">

                            <select name="topicCatalogueid">
                                <c:forEach items="${catalogue}" var="catalogue">
                                    <option value="${catalogue.catalogueid}" <c:if test="${catalogue.catalogueid == topic.catalogue.catalogueid}">selected</c:if>>${catalogue.catalogueName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <div style="width: 100%" class="summernote" id="body"><p>Enter text here!</p></div>
                            <input type="hidden" id="topicBody" name="topicBody" value="">

                        </div>
                        <input onclick="setText()" class="btn btn-lg btn-success btn-block" type="submit" value="Save">
                    </fieldset>
                    <input class="btn btn-lg btn-success btn-block" type="button" value="Preview" onclick="getText();">
                    <br>
                    <br>
                    <div class="box" style="background-color: whitesmoke" id="preview">${topic.topicBody}</div>
                    <br>
                    <br>
                    <input onclick="setText()" class="btn btn-lg btn-success btn-block" type="submit" value="Save">
                    <br>
                    <br>
                </form>

            </div>

        </div>
    <c:if test="${message!=null}">
        <div id="snackbar">${message}</div>
    </c:if>


</div>
</body>

<%@ include file="footer.jsp" %>
</html>