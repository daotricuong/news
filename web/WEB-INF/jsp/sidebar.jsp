<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="sidebar">
    <div class="col-md-4">

        <!---- Start Widget ---->
        <div class="widget wid-new-post">
            <div class="heading"><h4>Bình Luận Nhiều</h4></div>
            <div class="content">
                <c:forEach var="entry"  items="${requestScope.topComment}">
                    <a href="topic/${entry.topicId}.html"><h6>${entry.topicName}</h6></a>
                    <img class="topimg" src="${entry.topicCover}" />
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
                <c:forEach var="news"  items="${requestScope.topNews}">
                    <a href="topic/${news.topicId}.html"><h6>${news.topicName}</h6></a>
                    <img class="topimg" src="${news.topicCover}" />
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