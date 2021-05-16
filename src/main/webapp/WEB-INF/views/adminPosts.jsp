<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewpost" content="width=device-width, initial-scale=1">
    <title>StackOverFlow</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/orange.css" type="text/css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" type="text/css">
    <!-- StyleSwitcher -->
    <link rel="stylesheet" class="alternate-style" title="pink" href="${pageContext.request.contextPath}/styles/pink.css" type="text/css" disabled>
    <link rel="stylesheet" class="alternate-style" title="blue" href="${pageContext.request.contextPath}/styles/blue.css" type="text/css" disabled>
    <link rel="stylesheet" class="alternate-style" title="orange" href="${pageContext.request.contextPath}/styles/orange.css" type="text/css" disabled>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styleSwitcher.css" type="text/css">
    <script src="${pageContext.request.contextPath}/styles/styleSwitcher.js"></script>
</head>
<body>
<%@include file="layout/header.jsp"%>
<!-- Main container  -->
<div class="main-container">
    <!-- Aside -->
    <div class="aside">
        <!-- logo -->
        <div class="logo">
            <a href="#">Admin</a>
        </div>
        <!-- Nav Toggler Btn -->
        <div class="nav-toggler">
            <span></span>
        </div>
        <!-- Nav  -->
        <ul class="nav">
            <li><a href="#" onclick="location.href='/test/adminHome';"><i class="fa fa-home"></i>Home</a></li>
            <li><a href="#" onclick="location.href='/test/adminAbout';"><i class="fa fa-user"></i>About</a></li>
            <li><a href="#"  onclick="location.href='/test/user';"><i class="fa fa-users"></i>User Manage</a></li>
            <li><a href="#" class="active" onclick="location.href='/test/adminPost';"><i class="fa fa-question"></i>Post Manage</a></li>
        </ul>
        <!-- copyright  -->
        <div class="copyright-text">
            &copy; 2021 The Stackoverflow Website
        </div>
    </div>
    <!-- Aside end -->
    <!-- Main content -->

    <div class="main-content">
        <!-- Service User -->
        <section id="usermanage" class="section service">
            <div class="container">
                <div class="row">
                    <div class="section-title padd-15">
                        <h2>User Manage</h2>
                    </div>
                </div>
                <div class="row">
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-laptop"></i></div>
                            <h4>All User</h4>
                            <p>12000</p>
                        </div>
                    </div>


                    <!--  Service item End-->
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-laptop"></i></div>
                            <h4>Day</h4>
                            <p>12000</p>
                        </div>
                    </div>


                    <!--  Service item End-->
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-laptop"></i></div>
                            <h4>Month</h4>
                            <p>12000</p>
                        </div>
                    </div>


                    <!--  Service item End-->
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-laptop"></i></div>
                            <h4>Year</h4>
                            <p>12000</p>
                        </div>
                    </div>
                    <!--  Service item End-->
                </div>
                <div class="row">
                    <div class="section-title padd-15">
                        <table class="table padd-15">
                            <tr>
                                <th>ID</th>
                                <th>UserId</th>
                                <th>CreatedOn</th>
                                <th>Title</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var="question" items="${questions}">
                                <tr>
                                    <td>${question.id}</td>
                                    <td>${question.userId}</td>
                                    <td  style=" text-align: center;">${question.createdOn}</td>
                                    <td>${question.title}</td>
                                    <td style=" text-align: center;">
                                        <a href="#">
                                            <img src="${pageContext.request.contextPath}/asset/edit.png" style="height: 18px; width: 18px"/>
                                        </a>
                                        <a href="#">
                                            <img src="${pageContext.request.contextPath}/asset/clear.png" style="height: 15px; width: 15px"/>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!-- Service User End-->


        <!-- Service Post End-->



    </div>
    <!-- Main content end -->
</div>

<!-- javscript End-->
<div class="style-switcher">
    <div class="toggle-style-switcher">
        <i class="fa fa-cog fa-spin"></i>
    </div>
    <h5>Style Switcher</h5>
    <ul>
        <li><a href="#" title="pink" style="background: #ec1839" onclick="setActiveStyle('pink')"></a></li>
        <li><a href="#" title="blue" style="background: #2196F8" onclick="setActiveStyle('blue')"></a></li>
        <li><a href="#" title="orange" style="background: #fa5b0f" onclick="setActiveStyle('orange')"></a></li>
    </ul>

</div>

<!-- Live Style Switcher - Demo Only -->


<!-- Live Style Switcher - Demo Only End-->
<!-- Main container  -->
<script src="${pageContext.request.contextPath}/js/styleSwitcher.js"></script>

</body>
</html>