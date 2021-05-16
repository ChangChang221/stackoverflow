<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/question.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
</head>
<body style="background-color: #fff">
<header class="header-container">
    <div class="container-header">
        <div class="icon-container-header">
            <img id="logo" src="${pageContext.request.contextPath}/asset/logo.png" />
        </div>
        <nav class="nav-menu">
            <a>About</a>
            <a>Products</a>
        </nav>
        <div class="search-container">
            <img id="search-icon" src="${pageContext.request.contextPath}/asset/search-icon.png" />
            <input placeholder="Search..." id="input-search" />
        </div>
        <div class="button-container">
            <button id="log-in">Log in</button>
            <button id="sign-up">Sign up</button>
        </div>
    </div>
</header>
<main class="main-container">
    <%@include file="layout/sidebar.jsp"%>
    <div class="container content-container">
        <div id="questions-heading">
            <span style="font-size: 24px">All Questions</span>
            <button
                    class="btn-primary"
                    style="font-weight: normal; font-size: 14px"
                    onclick="location.href='/questions/askQuestion';"
            >
                Ask Question
            </button>
        </div>
        <div id="question-filter">
            <div>
                <span>${total} questions </span>
                <div>
                    <ul class="filter-questions-list">
                        <li>
                            <a style="color: #3c4146" href="${pageContext.request.contextPath}/questions?page=${page}&tab=newest">Newest</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/questions?page=${page}&tab=active">Active</a></li>
                        <li><a href="${pageContext.request.contextPath}/questions?page=${page}&tab=unanswers">Unanswers</a></li>
<%--                        <li--%>
<%--                                style="--%>
<%--                    border-top-right-radius: 5px;--%>
<%--                    border-bottom-right-radius: 5px;--%>
<%--                  "--%>
<%--                        >--%>
<%--                            More<img--%>
<%--                                src="https://cdn1.iconfinder.com/data/icons/ios-11-ui-elements-vol-1/29/25_dropdown_menu_down_arrow-512.png"--%>
<%--                                style="height: 10px; width: 10px"--%>
<%--                        />--%>
<%--                        </li>--%>
                    </ul>
<%--                    <button id="filter">--%>
<%--                        <img--%>
<%--                                src="${pageContext.request.contextPath}/asset/setting-removebg-preview.png"--%>
<%--                                style="height: 10px; width: 10px"--%>
<%--                        />--%>
<%--                        Filter--%>
<%--                    </button>--%>
                </div>
            </div>
        </div>
        <div id="questions">
            <c:forEach var="question" items="${questions}">
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <span>${question.views}</span>
                        <span style="margin-left: 5px">views</span>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">${question.title}</a>
                    <p>
                        I have two images when hovering the mouse over one of these
                        images, a certain component is displayed if it says more in
                        detail when hovering over the first image, a component with a
                        red background is ...
                    </p>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <c:forEach var="tag" items="${question.tags}">
                                <a href="#" class="tag">${tag}</a>
                            </c:forEach>
                        </div>
                        <div class="questioner">
                            <span>asked 37 secs ago</span>
                            <div>
                                <img
                                        src="https://www.gravatar.com/avatar/9d380711c6cdebb4864551fdb7d566ad?s=32&d=identicon&r=PG&f=1"
                                />
                                <div>
                                    <a href="#">${question.user.name}</a>
<%--                                    <div>--%>
<%--                                        <span style="font-weight: bold">441</span>--%>
<%--                                        <span--%>
<%--                                                class="dot"--%>
<%--                                                style="background-color: #ffb000; margin-left: 5px"--%>
<%--                                        >--%>
<%--                        </span>--%>
<%--                                        <span>3</span>--%>
<%--                                        <span class="dot" style="background-color: #b3b3b3">--%>
<%--                        </span>--%>
<%--                                        <span>9</span>--%>
<%--                                        <span class="dot" style="background-color: #c3a382">--%>
<%--                        </span>--%>
<%--                                        <span>12</span>--%>
<%--                                    </div>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
        <div class="pagination">

            <c:forEach begin="0" end="${pagination}" var="i">
                <c:if test="${page != 1 && i == 0}">
                    <a href="${pageContext.request.contextPath}?page=${page - 1}">Prev</a>
                </c:if>
                <c:if test="${page == (i+1) && i != pagination}">
                    <a href="${pageContext.request.contextPath}?page=${i+1}" class="active">${i+1}</a>
                </c:if>
                <c:if test="${page != (i+1) && i != pagination}">
                    <a href="${pageContext.request.contextPath}?page=${i+1}">${i+1}</a>
                </c:if>
                <c:if test="${page != pagination && i == pagination}">
                    <a href="${pageContext.request.contextPath}?page=${page + 1}">Next</a>
                </c:if>
            </c:forEach>

        </div>
    </div>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>