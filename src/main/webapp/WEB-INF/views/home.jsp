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
                        <p>${question.answers}</p>
<%--                        <p>0</p>--%>
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
                                <a href="#" class="tag">${tag}</a>
                            </c:forEach>
                        </div>
                        <div class="questioner">
                  <span>asked 53 secs ago <a href="${pageContext.request.contextPath}/users/${question.user.id}">${question.user.name}</a>
                    <span style="font-size: 13px; font-weight: 700; color: #3c4146">1</span></span>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
        <div class="pagination">
  
  <c:forEach begin="${startPagination}" end="${endPagination}" var="i">
      <c:if test="${page != 1 && i == startPagination}">
          <a href="${pageContext.request.contextPath}?page=${page - 1}">Prev</a>
      </c:if>
      <c:if test="${page == (i+1) && i != endPagination}">
          <a href="${pageContext.request.contextPath}?page=${i+1}" class="active">${i+1}</a>
      </c:if>
      <c:if test="${page != (i+1) && i != endPagination}">
          <a href="${pageContext.request.contextPath}?page=${i+1}">${i+1}</a>
      </c:if>
      <c:if test="${page != pagination && i == endPagination}">
          <a href="${pageContext.request.contextPath}?page=${page + 1}">Next</a>
      </c:if>
  </c:forEach>

        </div>
    </div>
</main>
<%@include file="layout/footer.jsp"%>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
