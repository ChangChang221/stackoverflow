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
            <button id="log-in">Log in</button>
            <button id="sign-up">Sign up</button>
        </div>
    </div>
</header>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
