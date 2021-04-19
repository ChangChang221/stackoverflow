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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sign-up.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/navigate_form.js"></script>
</head>
<body style="background-color: #eff0f1">
<%@include file="layout/header.jsp"%>
<main class="main-container">
    <aside id="sidebar">
        <ul>
            <li>Home</li>
            <li>
                PUBLIC
                <ul style="padding-left: 0px">
                    <li style="display: flex; align-items: center">
                        <img
                                src="./asset/earth-icon.png"
                                style="height: 15px; width: 15px; margin-right: 10px"
                        />Questions
                    </li>
                    <li class="menu-item-sidebar">Tags</li>
                    <li class="menu-item-sidebar">Users</li>
                </ul>
            </li>
            <li>
                FIND A JOB
                <ul style="padding-left: 0px">
                    <li class="menu-item-sidebar">Jobs</li>
                    <li class="menu-item-sidebar">Company</li>
                </ul>
            </li>
        </ul>
    </aside>
    <div class="intro content-container">
        <div>
            <h2>Join the Stack Overflow community</h2>
            <ul>
                <li>
                    <img src="./asset/question-removebg-preview.png" />
                    <span>Get unstuck — ask a question</span>
                </li>
                <li>
                    <img src="./asset/vote-removebg-preview.png" />
                    <span>Unlock new privileges like voting and commenting</span>
                </li>
                <li>
                    <img src="./asset/tag.webp" />
                    <span>Save your favorite tags, filters, and jobs</span>
                </li>
            </ul>
        </div>
    </div>
    <div class="form-auth-container">
        <form class="form-auth">
            <label>Email</label>
            <input class="input-type" />
            <label>Password</label>
            <input class="input-type" />
            <a
                    style="
              text-decoration: none;
              color: #0095ff;
              cursor: pointer;
              margin: 10px 0px;
            "
                    onclick="navigate_form('forgot_password')"
            >Forgot password ?
            </a>
            <button class="btn-primary">Sign in</button>
        </form>
        <span style="font-size: 14px; color: #868585" ;
        >Don’t have an account?
          <a
                  style="text-decoration: none; color: #0095ff; cursor: pointer"
                  onclick="navigate_form(`sign_up`)"
          >Sign up</a
          ></span
        >
    </div>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
