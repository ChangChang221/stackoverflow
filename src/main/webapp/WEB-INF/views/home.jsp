<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/home.css" />
</head>
<body>
<!-- header -->
<%@include file="layout/header.jsp"%>
<main class="main-container">
<%@include file="layout/sidebar.jsp"%>
    <div class="container content-container">
        <div id="questions-heading">
            <span style="font-size: 24px">Top Questions</span>
            <button
                    class="btn-primary"
                    style="font-weight: normal; font-size: 14px"
                    onclick="location.href='/questions/askQuestion';"
            >
                Ask Question
            </button>
        </div>
        <div id="question-filter">
            <div style="display: flex; justify-content: flex-end">
                <ul style="margin-right: 0px" class="filter-questions-list">
                    <li>
                        <a style="color: #3c4146">Interesting</a>
                    </li>
                    <li><a>Bountied</a></li>
                    <li><a>Hot</a></li>
                    <li><a>Week</a></li>
                    <li
                            style="
                  border-top-right-radius: 5px;
                  border-bottom-right-radius: 5px;
                "
                    >
                        Month
                    </li>
                </ul>
            </div>
        </div>
        <div class="home-questions-container">
            <c:forEach var="question" items="${questions }">
            <div class="question">

                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>${question.views}</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="${pageContext.request.contextPath}/questions/detail/${question.id}">
                        ${question.title}
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <c:forEach var="tag" items="${question.tags}">
                                <a href="#" class="tag">${tag.name}</a>
                            </c:forEach>
                        </div>
                        <div class="questioner">
                  <span>asked 53 secs ago <a href="#">${question.user.name}</a>
                    <span style="font-size: 13px; font-weight: 700; color: #3c4146">1</span></span>
                        </div>
                    </div>
                </div>


            </div>
            </c:forEach>
        </div>
        <div class="pagination">
            <a href="#">Prev</a>
            <a href="#">1</a>
            <a href="#" class="active">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">Next</a>
        </div>
    </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
