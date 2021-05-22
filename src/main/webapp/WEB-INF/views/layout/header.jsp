<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize access="hasRole('ROLE_USER')" var="isUser" />
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
</head>
<body>
<script>
    let controller = new AbortController();
    const search = async (value) => {
        console.log(value);
        if(event.keyCode === 13) {
            window.location.href =  "http://localhost:8000/questions/search?search=" + value;
        }
        controller.abort();
        controller = new AbortController();
        const signal = controller.signal;
        const loader = document.getElementById("loader");
        const ul = document.getElementById("search-results")
        if (value === "") {
            ul.innerHTML = "";
            ul.appendChild(loader);
            loader.style.display = "none"
        } else {
            ul.innerHTML = "";
            ul.appendChild(loader);
            loader.style.display = "block"
            const _response = await fetch("/search?" + new URLSearchParams({
                query: value
            }), {signal});
            const response = await _response.json();
            if (response.status) {
                loader.style.display = "none";
                const _results = response.result;
                _results.forEach((_result) => {
                    let li = document.createElement("li");
                    let div_1 = document.createElement("div");
                    let div_2_1 = document.createElement("div");
                    let div_3_1 = document.createElement("div");
                    div_3_1.innerHTML = _result.answers;
                    let div_3_2 = document.createElement("div");
                    div_3_2.innerHTML = "answers"
                    let div_2_2 = document.createElement("div");
                    let a_3_1 = document.createElement("a");
                    a_3_1.innerHTML = _result.title;
                    a_3_1.setAttribute("href", "#");
                    let div_3_3 = document.createElement("div");
                    div_3_3.setAttribute("class", "answer-question-tags");
                    for (let i = 0; i < _result.tags.length; i++) {
                        let tag = document.createElement("a");
                        tag.innerHTML = _result.tags[i].name;
                        tag.setAttribute("href", "#");
                        tag.setAttribute("class", "tag");
                        div_3_3.appendChild(tag)
                    }
                    div_2_2.appendChild(a_3_1);
                    div_2_2.appendChild(div_3_3);
                    div_2_1.appendChild(div_3_1);
                    div_2_1.appendChild(div_3_2);
                    div_1.appendChild(div_2_1);
                    div_1.appendChild(div_2_2)
                    li.appendChild(div_1)
                    ul.appendChild(li)
                })
            }
        }
    }
</script>
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
            <img id="search-icon" src="/asset/search-icon.png"/>
            <input placeholder="Search..." id="input-search" onkeyup="search(value)"/>
            <ul class="search-results" id="search-results">
                <div class="lds-hourglass" id="loader" style="display: none"></div>
                <!-- <p style="margin-left: 15px">Gợi ý tìm kiếm:</p> -->
                <%--                <li>--%>
                <%--                    <div>--%>
                <%--                        <div>--%>
                <%--                            <div>8</div>--%>
                <%--                            <div>answers</div>--%>
                <%--                        </div>--%>
                <%--                        <div>--%>
                <%--                            <a href="#">Can StyleCop automatically fix anything?</a>--%>
                <%--                            <div class="answer-question-tags">--%>
                <%--                                <a href="#" class="tag">android</a>--%>
                <%--                                <a href="#" class="tag">react-native</a>--%>
                <%--                                <a href="#" class="tag">huawei-mobile-services</a>--%>
                <%--                                <a href="#" class="tag">huawei-push-notification</a>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </li>--%>
                <%--                <li>--%>
                <%--                    <div>--%>
                <%--                        <div>--%>
                <%--                            <div>8</div>--%>
                <%--                            <div>answers</div>--%>
                <%--                        </div>--%>
                <%--                        <div>--%>
                <%--                            <a href="#">Can StyleCop automatically fix anything?</a>--%>
                <%--                            <div class="answer-question-tags">--%>
                <%--                                <a href="#" class="tag">android</a>--%>
                <%--                                <a href="#" class="tag">react-native</a>--%>
                <%--                                <a href="#" class="tag">huawei-mobile-services</a>--%>
                <%--                                <a href="#" class="tag">huawei-push-notification</a>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </li>--%>
                <%--                <li>--%>
                <%--                    <div>--%>
                <%--                        <div>--%>
                <%--                            <div>8</div>--%>
                <%--                            <div>answers</div>--%>
                <%--                        </div>--%>
                <%--                        <div>--%>
                <%--                            <a href="#">Can StyleCop automatically fix anything?</a>--%>
                <%--                            <div class="answer-question-tags">--%>
                <%--                                <a href="#" class="tag">android</a>--%>
                <%--                                <a href="#" class="tag">react-native</a>--%>
                <%--                                <a href="#" class="tag">huawei-mobile-services</a>--%>
                <%--                                <a href="#" class="tag">huawei-push-notification</a>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </li>--%>
            </ul>
        </div>
        <div class="button-container">
            <c:if test="${isUser}">
            </c:if>
            <c:if test="${!isUser}">
                <button id="log-in" onclick="login()">Log in</button>
                <button id="sign-up" onclick="signup()">Sign up</button>
            </c:if>

        </div>
    </div>
</header>
<script>
    const login = () => {
        window.location.href = "http://localhost:8000/users/auth"
    }
    const signup = () => {
        window.location.href = "http://localhost:8000/users/auth"
    }
</script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
