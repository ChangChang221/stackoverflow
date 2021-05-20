<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize access="hasRole('ROLE_USER')" var="isUser" />
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
</head>
<body>
<header class="header-container">
    <div class="container-header">
        <div class="icon-container-header">
            <img id="logo" src="${pageContext.request.contextPath}/asset/logo.png"/>
        </div>
        <nav class="nav-menu">
            <a>About</a>
            <a>Products</a>
        </nav>
        <div class="search-container">
            <img id="search-icon" src="${pageContext.request.contextPath}/asset/search-icon.png"/>
            <input placeholder="Search..." id="input-search"/>
            <ul class="search-results">
                <!-- <p style="margin-left: 15px">Gợi ý tìm kiếm:</p> -->
                <li>
                    <div>
                        <div>
                            <div>8</div>
                            <div>answers</div>
                        </div>
                        <div>
                            <a href="#">Can StyleCop automatically fix anything?</a>
                            <div class="answer-question-tags">
                                <a href="#" class="tag">android</a>
                                <a href="#" class="tag">react-native</a>
                                <a href="#" class="tag">huawei-mobile-services</a>
                                <a href="#" class="tag">huawei-push-notification</a>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div>
                        <div>
                            <div>8</div>
                            <div>answers</div>
                        </div>
                        <div>
                            <a href="#">Can StyleCop automatically fix anything?</a>
                            <div class="answer-question-tags">
                                <a href="#" class="tag">android</a>
                                <a href="#" class="tag">react-native</a>
                                <a href="#" class="tag">huawei-mobile-services</a>
                                <a href="#" class="tag">huawei-push-notification</a>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div>
                        <div>
                            <div>8</div>
                            <div>answers</div>
                        </div>
                        <div>
                            <a href="#">Can StyleCop automatically fix anything?</a>
                            <div class="answer-question-tags">
                                <a href="#" class="tag">android</a>
                                <a href="#" class="tag">react-native</a>
                                <a href="#" class="tag">huawei-mobile-services</a>
                                <a href="#" class="tag">huawei-push-notification</a>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="button-container">
            <button id="log-in">Log in</button>
            <button id="sign-up">Sign up</button>
        </div>
    </div>
</header>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
