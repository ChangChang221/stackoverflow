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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/tags.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
    <!-- Bootstrap CSS -->
</head>
<body>
<%@include file="layout/header.jsp"%>
<main class="main-container">
    <%@include file="layout/sidebar.jsp"%>
    <div class="content-container">
        <h1>Tags</h1>
        <p style="max-width: 575px">
            A tag is a keyword or label that categorizes your question with other,
            similar questions. Using the right tags makes it easier for others to
            find and answer your question.
        </p>
        <a href="#">Show all tag synonyms</a>
        <br />
        <div class="options-container-user-filter">
            <div class="search-input">
                <svg aria-hidden="true" width="18" height="18" viewBox="0 0 18 18">
                    <path
                            d="M18 16.5l-5.14-5.18h-.35a7 7 0 10-1.19 1.19v.35L16.5 18l1.5-1.5zM12 7A5 5 0 112 7a5 5 0 0110 0z"
                    ></path>
                </svg>
                <input
                        placeholder="Filter by tag name"
                        class="input-type"
                        style="padding-left: 40px"
                />
            </div>
<%--            <ul class="filter-questions-list">--%>
<%--                <li>--%>
<%--                    <a style="color: #3c4146">Popular</a>--%>
<%--                </li>--%>
<%--                <li><a>Name</a></li>--%>
<%--                <li><a>New</a></li>--%>
<%--            </ul>--%>
        </div>
        <div class="content-tags-container">
            <c:forEach var="tag" items="${tags}">
                <div class="content-tag-container">
                    <div class="content-tag">
                        <div><a class="tag" href="#">${tag.name}</a></div>
                        <div class="tag-description">
                            <p>${tag.name}</p>
                        </div>
                        <div>
                            <p>${tag.description}</p>
                        </div>
                        <div class="tag-detail">
                            <div class="questions-about-tag-total">
                                <p>${tag.numberQuestion} questions</p>
                            </div>
                            <div class="question-about-tag">
                                <p>561 asked today, 5323 this week</p>
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
