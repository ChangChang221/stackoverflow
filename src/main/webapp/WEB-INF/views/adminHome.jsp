<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewpost" content="width=device-width, initial-scale=1">
    <title>Personal Porfolio Template</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/orange.css" type="text/css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" type="text/css">
    <!-- StyleSwitcher -->
    <link rel="stylesheet" class="alternate-style" title="pink" href="${pageContext.request.contextPath}/styles/pink.css" type="text/css" disabled>
    <link rel="stylesheet" class="alternate-style" title="blue" href="${pageContext.request.contextPath}/styles/blue.css" type="text/css" disabled>
    <link rel="stylesheet" class="alternate-style" title="orange" href="${pageContext.request.contextPath}/styles/orange.css" type="text/css" disabled>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styleSwitcher.css" type="text/css">
</head>
<body>
<!-- Main container  -->
<div class="main-container">
    <!-- Aside -->
    <div class="aside">
        <!-- logo -->
        <div class="logo">
            <a href="#">Trang</a>
        </div>
        <!-- Nav Toggler Btn -->
        <div class="nav-toggler">
            <span></span>

        </div>
        <!-- Nav  -->
        <ul class="nav">
            <li><a href="#" class="active" onclick="location.href='/test/adminHome';"><i class="fa fa-home"></i>Home</a></li>
            <li><a href="#"  onclick="location.href='/test/adminAbout';"><i class="fa fa-user"></i>About</a></li>
            <li><a href="#" onclick="location.href='/test/user';"><i class="fa fa-users"></i>User Manage</a></li>
            <li><a href="#" onclick="location.href='/test/adminPost';"><i class="fa fa-question"></i>Post Manage</a></li>
        </ul>
        <!-- copyright  -->
        <div class="copyright-text">
            &copy; 2021 The Stackoverflow Website
        </div>
    </div>
    <!-- Aside end -->

    <!-- Main content -->

    <div class="main-content">
        <!--  Home Section -->

        <section class="home section active" id="home">
            <div class="container">
                <div class =intro>
                    <img src="${pageContext.request.contextPath}/asset/Trang.jpg"  alt="profile" class="shadow-dark"/>
                    <h1>Mrs Trang</h1>
                    <p>I'm a web Developer</p>
                    <div class="social-link">
                        <a href="https://www.facebook.com/trang.nt.2201/" class="fa fa-facebook"></a>
                        <a href="https://www.instagram.com/accounts/login/" class="fa fa-instagram"></a>
                        <a href="https://twitter.com/TrangNguynTh8" class="fa fa-twitter"></a>
                    </div>
                </div>

            </div>
        </section>
        <!--  Home Section End-->

        <!-- About Section End-->
        <section class="about section active" id="about">
            <div class="container">
                <div class="row">
                    <div class="section-title padd-15">
                        <h2>About Me</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="about-content padd-15">
                        <div class="row">
                            <div class="about-text padd-15">
                                <h3> I'm Trang and <span>Web Developer</span></h3>
                                <p>Hi! My name is Trang. I am a Web Developer, and I'm very passionate and dedicated to my mork. With 1 year
                                    experience as a professional Web developer, T have acquired the skills and knowledge necessary to make
                                    your project a success. I enjoy every step of the
                                    design process, from discussion and collaboration. </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="personal-info padd-15">
                                <div class="row">
                                    <div class="info-item padd-15">
                                        <p>Birthday: <span>22 June 2000</span></p>
                                    </div>
                                    <div class="info-item padd-15">
                                        <p>Age: <span>21</span></p>
                                    </div>
                                    <div class="info-item padd-15">
                                        <p>Degree: <span>Student</span></p>
                                    </div>
                                    <div class="info-item padd-15">
                                        <p>Email: <span>trangbg20@gmail.com</span></p>
                                    </div>
                                    <div class="info-item padd-15">
                                        <p>Phone: <span>0867238735</span></p>
                                    </div>
                                    <div class="info-item padd-15">
                                        <p>City: <span>Bac Giang</span></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="buttons padd-15">
                                        <a href="#" class="btn">Download CV</a>
                                        <a href="#" class="btn">Hire Me</a>
                                    </div>

                                </div>
                            </div>

                            <div class="skills padd-15">
                                <div class="row">
                                    <div class="skill-item padd-15" >
                                        <h5>JavaScript</h5>
                                        <div class="process">
                                            <div class="process-in" style="width:70%"></div>
                                            <div class="skill-percent">70%</div>
                                        </div>
                                    </div>
                                    <div class="skill-item padd-15" >
                                        <h5>Css</h5>
                                        <div class="process">
                                            <div class="process-in" style="width:50%"></div>
                                            <div class="skill-percent">50%</div>
                                        </div>
                                    </div>
                                    <div class="skill-item padd-15" >
                                        <h5>Html</h5>
                                        <div class="process">
                                            <div class="process-in" style="width: 76%"></div>
                                            <div class="skill-percent">76%</div>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- About Section End -->
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
                                <th>Tài khoản</th>
                                <th>Họ và tên</th>
                                <th>Email</th>
                                <th>Ngày đăng ký</th>
                                <th>Chức năng</th>
                            </tr>
                            <tr>
                                <td>ID</td>
                                <td>Tài khoản</td>
                                <td>Nguyễn Văn A</td>
                                <td>A@gmail.com</td>
                                <td  style=" text-align: center;">03/08/1993</td>
                                <td style=" text-align: center;">
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/edit.png" style="height: 18px; width: 18px"/>
                                    </a>
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/clear.png" style="height: 15px; width: 15px"/>
                                    </a>

                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!-- Service User End-->

        <!-- Service Post -->
        <section id="postmanage" class="section service">
            <div class="container">
                <div class="row">
                    <div class="section-title padd-15">
                        <h2>Post Manage</h2>
                    </div>
                </div>
                <div class="row">
                    <!-- Service item -->
                    <div class="service-item padd-15">
                        <div class="service-item-inner">
                            <div class="icon"><i class="fa fa-laptop"></i></div>
                            <h4>All Post</h4>
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
                                <th>Tài khoản</th>
                                <th>Họ và tên</th>
                                <th>Email</th>
                                <th>Ngày đăng ký</th>
                                <th>Chức năng</th>
                            </tr>
                            <tr>
                                <td>ID</td>
                                <td>Tài khoản</td>
                                <td>Nguyễn Văn A</td>
                                <td>A@gmail.com</td>
                                <td  style=" text-align: center;">03/08/1993</td>
                                <td style=" text-align: center;">
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/assetedit.png" style="height: 18px; width: 18px"/>
                                    </a>
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/clear.png" style="height: 15px; width: 15px"/>
                                    </a>

                                </td>
                            </tr>
                            <tr>
                                <td>ID</td>
                                <td>Tài khoản</td>
                                <td>Nguyễn Văn A</td>
                                <td>A@gmail.com</td>
                                <td  style=" text-align: center;">03/08/1993</td>
                                <td style=" text-align: center;">
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/edit.png" style="height: 18px; width: 18px"/>
                                    </a>
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/clear.png" style="height: 15px; width: 15px"/>
                                    </a>

                                </td>
                            </tr>
                            <tr>
                                <td>ID</td>
                                <td>Tài khoản</td>
                                <td>Nguyễn Văn A</td>
                                <td>A@gmail.com</td>
                                <td  style=" text-align: center;">03/08/1993</td>
                                <td style=" text-align: center;">
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/edit.png" style="height: 18px; width: 18px"/>
                                    </a>
                                    <a href="#">
                                        <img src="${pageContext.request.contextPath}/asset/clear.png" style="height: 15px; width: 15px"/>
                                    </a>

                                </td>
                            </tr>
                        </table>

                        <!-- Test thuwr -->

                        <!-- Test thuwr End -->

                    </div>
                </div>
            </div>

        </section>
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
<script src="${pageContext.request.contextPath}/styles/styleSwitcher.js"></script>

</body>
</html>