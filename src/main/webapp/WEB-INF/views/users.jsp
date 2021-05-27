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
                        onkeyup="filter(value)"
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

        <div id="filter-value" class="content-users-container">
        </div>
        <div id="current-value" class="content-users-container">
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
<%--                           <c:forEach var="i"  items="${user.tags}">--%>
<%--                               <a href="${tag}">${tag},</a>--%>
<%--                           </c:forEach>--%>
                       </div>
                   </div>
               </div>
           </c:forEach>
        </div>
        <div id="pagination" class="pagination">
            <c:forEach begin="${startPagination}" end="${endPagination}" var="i">
                <c:if test="${page != 1 && i == startPagination}">
                    <a href="${pageContext.request.contextPath}/users?page=${page - 1}">Prev</a>
                </c:if>
                <c:if test="${page == (i+1) && i != endPagination}">
                    <a href="${pageContext.request.contextPath}/users?page=${i+1}" class="active">${i+1}</a>
                </c:if>
                <c:if test="${page != (i+1) && i != endPagination}">
                    <a href="${pageContext.request.contextPath}/users?page=${i+1}">${i+1}</a>
                </c:if>
                <c:if test="${page != pagination && i == endPagination}">
                    <a href="${pageContext.request.contextPath}/users?page=${page + 1}">Next</a>
                </c:if>
            </c:forEach>
        </div>
    </div>

</main>
<script type="text/javascript">
    const filterValue = document.getElementById("filter-value");
    const currentValue = document.getElementById("current-value");
    const pagination = document.getElementById("pagination");
    const filter = async (value) => {
        controller.abort();
        controller = new AbortController();
        if(value == null || value == ''){
            currentValue.style.display = 'block';
            pagination.style.display = 'inline-block';
            filterValue.innerHTML = "";
            filterValue.style.display = 'none';
            return;
        } else {
            const signal = controller.signal;
            const _response = await fetch("/users/search?" + new URLSearchParams({
                query: value
            }), {signal});
            currentValue.style.display = 'none';
            pagination.style.display = 'none';
            filterValue.style.display = 'block';
            filterValue.innerHTML = "";
            const data = await _response.json();
            console.log(data, "data")
            if (data.status) {
                let user = "";
                data.result.forEach((e) => {
                    let tags = "";
                    let photo =  "/asset/" + e.photo;
                    // e.tags && e.tags.forEach((tag) => tags += `<a href="` + tag + `">` + tag+ `,</a>`);
                    filterValue.innerHTML +=
                        `<div class="content-user-container">
                   <img
                            src="`+ photo+ `"
                           height="48px"
                           width="48px"
                   />
                   <div>
                       <a href="users/` +  e.id + `">` + e.name + `</a>
                       <p>` + e.location + `</p>
                       <p style="font-weight: bold">` + e.views + `</p>
                       <div>

                       </div>
                   </div>
               </div>`;

                });
                console.log(filterValue.innerHTML)
                // filterValue.innerHTML += user;
            }
        };
    };
    // var timer;
    // function chk_me(value){
    //     clearTimeout(timer);
    //     timer=setTimeout(filter(value), 10000);
    // }
</script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
