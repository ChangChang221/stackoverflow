
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewpost" content="width=device-width, initial-scale=1">
    <title>StackOverFlow</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/orange.css" type="text/css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" type="text/css">

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
   <!--         <li><a href="#" onclick="location.href='/';"><i class="fa fa-sign-out"></i>Logout</a></li> -->

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
                            <div class="icon"><i class="fa fa-question"></i></div>
                            <h4>All Post</h4>
                            <p>12000</p>
                        </div>
                    </div>


                    <!--  Service item End-->
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-calendar"></i></div>
                            <h4>Day</h4>
                            <p>12000</p>
                        </div>
                    </div>


                    <!--  Service item End-->
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-calendar"></i></div>
                            <h4>Month</h4>
                            <p>12000</p>
                        </div>
                    </div>


                    <!--  Service item End-->
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-calendar"></i></div>
                            <h4>Year</h4>
                            <p>12000</p>
                        </div>
                    </div>
                    <!--  Service item End-->
                </div>

                <!-- Searcher box-->
                <div class="row" style="padding-bottom: 100px">


                    <form action="" class="search-box padd-15">
                        <input type="text" name="" value="" placeholder="Search...">

                        <button class="search-button" type="button" name="Tìm Kiếm">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>


                </div>
                <!-- Searcher box-->



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

<!-- Main container  -->
</body>
</html>