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
    <link rel="stylesheet" href="./styles/common.css" />
    <link rel="stylesheet" href="./styles/header.css" />
    <link rel="stylesheet" href="./styles/sidebar.css" />
    <link rel="stylesheet" href="./styles/home.css" />
</head>
<body>
<!-- header -->
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
                                src="${pageContext.request.contextPath}/asset/earth-icon.png"
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
    <div class="container content-container">
        <div id="questions-heading">
            <span style="font-size: 24px">Top Questions</span>
            <button
                    class="btn-primary"
                    style="font-weight: normal; font-size: 14px"
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
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
            <div class="question">
                <div class="info-question">
                    <div>
                        <p>0</p>
                        <p>votes</p>
                    </div>
                    <div>
                        <p>0</p>
                        <p>answers</p>
                    </div>
                    <div>
                        <p>3</p>
                        <p>views</p>
                    </div>
                </div>
                <div class="content-question">
                    <a href="#">
                        Mysql Index on Table that gets deleted every night
                    </a>
                    <div class="more-info-question">
                        <div class="tags-question">
                            <a href="#" class="tag">mysql</a>
                            <a href="#" class="tag">amazone-web-services</a>
                            <a href="#" class="tag">indexing</a>
                            <a href="#" class="tag">amazon-rds</a>
                        </div>
                        <div class="questioner">
                  <span
                  >asked 53 secs ago <a href="#">Daniel Ross</a>
                    <span
                            style="font-size: 13px; font-weight: 700; color: #3c4146"
                    >1</span
                    ></span
                  >
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
