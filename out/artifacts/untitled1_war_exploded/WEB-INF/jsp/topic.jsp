<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/24/2017
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ include file="header.jsp" %>
<body>

<%@ include file="nav.jsp" %>


<div id="page-content" class="single-page container">
    <div class="row">
        <div id="main-content" class="col-md-8">
            <div class="box">


                <div class="line"></div>
                <h1>${topic.topicName}</h1>
                <div class="info">
                    <h5>By <a href="#">${topic.authorId}</a></h5>
                    <span><i class="fa fa-calendar"></i>${topic.createDay}</span>
                    <span><i class="fa fa-heart"></i>${topic.likeCount}</span>
                </div>
                <h6>${topic.topicDes}</h6>

                <p class="form-image" style="margin-top: 20px">
                    ${topic.topicBody}
                </p>

                <div class="glyphicon-tag">
                    <c:forEach var="tag" items="${topic.tag}">
                        <a href="#">${tag.toString()} </a>
                    </c:forEach>
                </div>

                <div class="line"></div>
                <%--<div class="comment">--%>
                    <%--<h3>Leave A Comment</h3>--%>
                    <%--<form name="form1" method="post" action="">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-md-6">--%>
                                <%--<div class="form-group">--%>
                                    <%--<input type="text" class="form-control input-lg" name="name" id="name"--%>
                                           <%--placeholder="Enter name" required="required"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-6">--%>
                                <%--<div class="form-group">--%>
                                    <%--<input type="email" class="form-control input-lg" name="email" id="email"--%>
                                           <%--placeholder="Enter email" required="required"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-md-12">--%>
                                <%--<div class="form-group">--%>
										<%--<textarea name="message" id="message" class="form-control" rows="4" cols="25"--%>
                                                  <%--required="required"--%>
                                                  <%--placeholder="Message"></textarea>--%>
                                <%--</div>--%>
                                <%--<button type="submit" class="btn btn-4 btn-block" name="btnBooking" id="btnBbooking">--%>
                                    <%--Comment--%>
                                <%--</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>
                <div class="fb-comments" data-href="${pagecontext.request.contextpath}/topic/${topic.topicId}.html" data-width="700" data-numposts="10"></div>
                <div id="fb-root"></div>
                <script>(function(d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (d.getElementById(id)) return;
                    js = d.createElement(s); js.id = id;
                    js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.11';
                    fjs.parentNode.insertBefore(js, fjs);
                }(document, 'script', 'facebook-jssdk'));</script>
            </div>

            <div class="box">

                <c:forEach var="topview" items="${topView}">
                    <div class="row">
                        <div class="col-md-6">
                            <img src="${topview.topicCover}"/>
                        </div>
                        <div class="col-md-6">
                            <h6><a href="${topview.topicId}.html">${topview.topicName}</a></h6>
                            <span><i class="fa fa-heart"></i> ${topview.likeCount} / <i
                                    class="fa fa-calendar"></i> ${topview.createDay} / <i
                                    class="fa fa-comment-o">  </i> ${topview.commentCount} / <i
                                    class="fa fa-eye"></i> ${topview.viewCount}</span>
                            <p>${topview.topicDes}...</p>
                        </div>
                    </div>
                    <br>
                </c:forEach>
                <div class="row">
                    <div class="col-md-6">
                        <img src="http://media.kinhtedothi.vn//2017/03/14/giao_duc_the_chat.jpg"/>
                    </div>
                    <div class="col-md-6">
                        <h6 style="color: black"><a href="#">GS Ngô Bảo Châu nghiên cứu chiến lược phát triển giáo dục
                            đại học Việt Nam</a></h6>
                        <span><i class="fa fa-heart"></i> 1,200 / <i class="fa fa-calendar"></i> 25/3/2015 / <i
                                class="fa fa-comment-o">  </i> 3 / <i class="fa fa-eye"></i> 1007</span>
                        <p>There once was a story about a man who could turn invisible. I thought it was only a story???
                            until it happened to me. Ok, so here???s how it works: there???s this stuff called...</p>
                    </div>
                </div>

                <ul>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                    <li>4</li>
                    <li>1</li>
                </ul>
            </div>

        </div>

        <div id="sidebar">
            <div class="col-md-4">

                <!---- Start Widget ---->
                <div class="widget wid-new-post">
                    <div class="heading"><h4>Bình Luận Nhiều</h4></div>
                    <div class="content">
                        <c:forEach var="entry" items="${topComment}">
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
                        <c:forEach var="news" items="${topNews}">
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
</body>

<%@ include file="footer.jsp" %>