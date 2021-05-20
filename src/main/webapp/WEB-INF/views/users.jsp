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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/users.css" />
    <!-- Bootstrap CSS -->
</head>
<body>
<%@include file="layout/header.jsp"%>
<main class="main-container">
    <%@include file="layout/sidebar.jsp"%>
    <div class="content-container" style="max-width: 60%">
        <h1>Users</h1>
        <div class="options-container-users-filter">
            <div class="search-input">
                <svg aria-hidden="true" width="18" height="18" viewBox="0 0 18 18">
                    <path
                            d="M18 16.5l-5.14-5.18h-.35a7 7 0 10-1.19 1.19v.35L16.5 18l1.5-1.5zM12 7A5 5 0 112 7a5 5 0 0110 0z"
                    ></path>
                </svg>
                <input
                        placeholder="Filter by user"
                        class="input-type"
                        style="padding-left: 40px"
                />
            </div>
            <ul class="filter-questions-list" style="margin-right: 0px">
                <li>
                    <a style="color: #3c4146">Popular</a>
                </li>
                <li><a>Name</a></li>
                <li><a>New</a></li>
            </ul>
        </div>
        <div class="filter-by-time">
            <a class="active-filter-by-time">week</a>
            <a>month</a>
            <a>quarter</a>
            <a>year</a>
            <a>all</a>
        </div>
        <div class="content-users-container">
           <c:forEach var="user" items="${users}">
               <div class="content-user-container">
                   <img
                            src="${pageContext.request.contextPath}/asset/${user.photo}"
                           height="48px"
                           width="48px"
                   />
                   <div>
                       <a href="users/${user.id}">${user.name}</a>
                       <p>${user.location}</p>
                       <p style="font-weight: bold">${user.views}</p>
                       <div>
                           <a href="#">sql</a>,
                           <a href="#">mysql</a>,
                           <a href="#">sql-server</a>
                       </div>
                   </div>
               </div>
           </c:forEach>

        </div>
    </div>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
