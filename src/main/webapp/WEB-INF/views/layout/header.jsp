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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css" />
</head>
<body>
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
