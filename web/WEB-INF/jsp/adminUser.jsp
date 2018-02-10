<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/27/2018
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Cp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="author" content="https://www.365bootstrap.com">
    <meta http-equiv="X-UA-Compatible" content="IE=100"/>
    <meta http-equiv="REFRESH" content="1800"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery UI -->
    <link href="https://code.jquery.com/ui/1.10.3/themes/redmond/jquery-ui.css" rel="stylesheet" media="screen">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/adminstyles.css"/>">
    <script src="<c:url value="https://code.jquery.com/ui/1.10.3/jquery-ui.js"/>"></script>
    <!-- jQuery and Modernizr-->
    <script src="<c:url value="/resources/js/jquery-2.1.1.js"/>"></script>
    <link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet" media="screen">

    <script src="<c:url value="/resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    <script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>

    <script src="<c:url value="/resources/js/dataTables.bootstrap.js"/>"></script>

    <script src="<c:url value="/resources/js/custom.js"/>"></script>
    <script src="<c:url value="/resources/js/tables.js"/>"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style>
        #snackbar {
            visibility: hidden;
            min-width: 250px;
            margin-left: -125px;
            background-color: #333;
            color: #fff;
            text-align: center;
            border-radius: 2px;
            padding: 16px;
            position: fixed;
            z-index: 1;
            left: 50%;
            top: 50px;
            font-size: 17px;
        }

        #snackbar.show {
            visibility: visible;
            -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
            animation: fadein 0.5s, fadeout 0.5s 2.5s;
        }

        @-webkit-keyframes fadein {
            from {top: 0; opacity: 0;}
            to {top: 50px; opacity: 1;}
        }

        @keyframes fadein {
            from {top: 0; opacity: 0;}
            to {top: 50px; opacity: 1;}
        }

        @-webkit-keyframes fadeout {
            from {top: 50px; opacity: 1;}
            to {top: 0; opacity: 0;}
        }

        @keyframes fadeout {
            from {top: 50px; opacity: 1;}
            to {top: 0; opacity: 0;}
        }
    </style>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <!-- Logo -->
                <div class="logo">
                    <h1><a href="index.html">Admin Cp</a></h1>
                </div>
            </div>
            <div class="col-md-5">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="input-group form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
	                         <button class="btn btn-primary" type="button">Search</button>
	                       </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-2">
                <div class="navbar navbar-inverse" role="banner">
                    <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account <b
                                        class="caret"></b></a>
                                <ul class="dropdown-menu animated fadeInUp">
                                    <li><a href="profile.html">Profile</a></li>
                                    <li><a href="login.html">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content">
    <div class="row">
        <div class="col-md-2">
            <div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <!-- Main menu -->
                    <li><a href="admincp.html"><i class="glyphicon glyphicon-home"></i> AdminCp</a></li>
                    <li><a href="role.html"><i class="glyphicon glyphicon-calendar"></i> QL Quyền</a></li>
                    <li><a href="stats.html"><i class="glyphicon glyphicon-stats"></i> Thống kê</a></li>
                    <li  class="current"><a href="user.html"><i class="glyphicon glyphicon-list"></i> QL Người Dùng</a></li>
                    <li><a href="CatalogueManager.html"><i class="glyphicon glyphicon-record"></i> QL Danh Mục</a></li>
                    <li class="submenu">
                        <a href="#">
                            <i class="glyphicon glyphicon-pencil"></i> QL Bài Viết
                            <span class="caret pull-right"></span>
                        </a>
                        <!-- Sub menu -->
                        <ul>
                            <li><a href="editors.html">DS Bài</a></li>
                            <li><a href="../editor.html" target="_blank">Trang viết bài</a></li>
                        </ul>
                    </li>
                    <li><a href="binhluan.html"><i class="glyphicon glyphicon-tasks"></i> QL Bình Luận</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-10">
            <div class="content-box-large">
                <div class="panel-heading">
                    <div class="panel-title">Quản Lý USer</div>
                </div>
                <div class="panel-body">
                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered"
                           id="table">
                        <thead>
                        <tr>
                            <th>User Id</th>
                            <th>Username</th>
                            <th>Tên</th>
                            <th>Quyền</th>
                            <th>Trạng Thái</th>
                            <th>Sửa</th>
                            <th>Xóa</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="listUser" items="${listUser}">
                            <tr class="odd gradeX">
                                <td>${listUser.id}</td>
                                <td>${listUser.username}</td>
                                <c:if test="${listUser.name.length() > 100 }"><td>${listUser.name.substring(0, 100)}...</td></c:if>
                                <c:if test="${listUser.name.length() <= 100 }"><td>${listUser.name} </td></c:if>
                                <td class="center"> ${listUser.role}</td>
                                <c:if test="${listUser.status == true}">
                                    <td>
                                        <form action="/admin/editUserStatus.html" method="post">
                                            <input type="hidden" value="0" name="status">
                                            <button name="topicId" value="${listUser.id}"
                                                    class="btn btn-success btn-xs" style="width: 100%">
                                                Đang hoạt động
                                            </button>
                                        </form>
                                    </td>
                                </c:if>
                                <c:if test="${listUser.status == false}">
                                    <td>
                                        <form action="/admin/editUserStatus.html" method="post">
                                            <input type="hidden" value="1" name="status">
                                            <button name="topicId" value="${listUser.id}"
                                                    class="btn btn-warning btn-xs" style="width: 100%">
                                                Đang Block
                                            </button>
                                        </form>
                                    </td>
                                </c:if>
                                    <%--<td><button class="btn btn-danger btn-xs" style="width: 100%"><i class="glyphicon glyphicon-edit"></i> Sửa/Xóa</button></td>--%>
                                <td>
                                    <form action="/editor.html" method="get" target="_blank">
                                        <button name="submitFromAdmin" value="${listTopic.topicId}"
                                                class="btn btn-primary btn-xs" style="width: 100%; alignment: center" >
                                            <i class="glyphicon glyphicon-edit" >
                                            </i>
                                            Sửa
                                        </button>
                                    </form>
                                </td>
                                <td>
                                    <form action="/topic/deleteTopic.html" method="post" onsubmit="return confirm('Xóa ${listTopic.topicId}?')">
                                        <button name="topicId" value="${listTopic.topicId}"
                                                class="btn btn-danger btn-xs" style="width: 100%;alignment: center">
                                            <i class="glyphicon glyphicon-remove" >
                                            </i>
                                            Xóa
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <c:if test="${message!=null}">
                <div id="snackbar">${message}</div>
            </c:if>

        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        var x = document.getElementById("snackbar")
        x.className = "show";
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    });
</script>
<footer>
    <div class="container">

        <div class="copy text-center">
            Copyright 2014 <a href='#'>Website</a>
        </div>

    </div>
</footer>


</body>
</html>
