<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="hasRole('ROLE_USER')" var="isUser" />
<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/question-detail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/styles/default.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/highlight.min.js"></script>
    <!-- and it's easy to individually load additional languages -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/languages/go.min.js"></script>
    <!-- moment js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <link
            href="https://cdn.quilljs.com/1.3.6/quill.snow.css"
            rel="stylesheet"
    />
    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <script src="https://sdk.amazonaws.com/js/aws-sdk-2.888.0.min.js"></script>
    <!-- Bootstrap CSS -->
</head>
<body>
<%@include file="layout/header.jsp"%>
<main class="main-container">
    <%@include file="layout/sidebar.jsp"%>
    <div class="content-container">
        <div class="question-detail-heading">
            <div class="topic-question-detail-container">
                <a href="#" class="topic-question-detail">
                    ${question.title}
                </a>
                <div style="flex: 1">
                    <button
                            class="btn-primary"
                            style="font-weight: normal; font-size: 14px; float: right"
                    >
                        Ask Question
                    </button>
                </div>
            </div>
            <div class="more-info-question-detail-container">
                <span>Asked<span>2 days ago</span></span>
                <span>Active<span>today</span> </span>
                <span>Viewed<span>15 times</span> </span>
            </div>
        </div>
        <div class="content-question-detail-container">
            <div class="first-answer-detail content-question-detail">
                <div class="action-option-question-detail">
                    <svg
                            onclick=""
                            aria-hidden="true"
                            class="m0 svg-icon iconArrowUpLg"
                            width="36"
                            height="36"
                            viewBox="0 0 36 36"
                    >
                        <path d="M2 26h32L18 10 2 26z"></path>
                    </svg>
                    <p>0</p>
                    <svg
                            onclick=""
                            aria-hidden="true"
                            class="m0 svg-icon iconArrowDownLg"
                            width="36"
                            height="36"
                            viewBox="0 0 36 36"
                    >
                        <path d="M2 10h32L18 26 2 10z"></path>
                    </svg>
                    <svg
                            aria-hidden="true"
                            class="svg-icon iconBookmark"
                            width="18"
                            height="18"
                            viewBox="0 0 18 18"
                    >
                        <path
                                d="M6 1a2 2 0 00-2 2v14l5-4 5 4V3a2 2 0 00-2-2H6zm3.9 3.83h2.9l-2.35 1.7.9 2.77L9 7.59l-2.35 1.7.9-2.76-2.35-1.7h2.9L9 2.06l.9 2.77z"
                        ></path>
                    </svg>
                    <svg
                            aria-hidden="true"
                            class="mln2 mr0 svg-icon iconHistory"
                            width="19"
                            height="18"
                            viewBox="0 0 19 18"
                    >
                        <path
                                d="M3 9a8 8 0 113.73 6.77L8.2 14.3A6 6 0 105 9l3.01-.01-4 4-4-4h3L3 9zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5z"
                        ></path>
                    </svg>
                </div>
                <div class="answer-question-detail">
                    <div class="editor" style="padding-top: 10px;margin-bottom: 10px;width: 3%;
    overflow: scroll;">
                        ${question.body}
                    </div>
                    <div class="answer-question-tags">
                        <c:forEach var="tag" items="${question.tags}">
                           <a href="#" class="tag">${tag}</a>
                        </c:forEach>
                    </div>
                    <div class="answer-question-footer">
                        <div class="answer-question-footer-action">
                            <a href="#">Share</a>
                            <a href="#">Follow</a>
                        </div>
                        <div class="answer-question-author">
                            <p id="createdOn" >${question.createdOn}</p>
                            <script>
                                let createdOn = document.getElementById("createdOn");
                                let date = moment();
                                createdOn.innerHTML = date(createdOn.outerHTML).fromNow();

                            </script>
                            <div>
                                <img
                                        src="https://lh6.googleusercontent.com/-xeD2LdRJUJc/AAAAAAAAAAI/AAAAAAAAABw/YuIWglg5h0w/photo.jpg?sz=32"
                                        height="32px"
                                        width="32px"
                                        style="border-radius: 8px"
                                />
                                <div>
                                    <a href="#">${question.user.name}</a>
                                    <div>
                                        <span>1</span>
                                        <span
                                                class="dot"
                                                style="background-color: #6a737c"
                                        ></span>
                                        <span>1</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="answer-info">
                <h3>${answers.size()} Answers</h3>
                <ul class="filter-questions-list" style="margin-right: 0px">
                    <li><a>Active</a></li>
                    <li><a>Older</a></li>
                    <li
                            style="
                  border-top-right-radius: 5px;
                  border-bottom-right-radius: 5px;
                "
                    >
                        <a>Votes</a>
                    </li>
                </ul>
            </div>
            <c:forEach var="answer" items="${answers}">
                <div class="content-question-detail">
                    <div class="action-option-question-detail">
                        <svg
                                onclick="upVote(`${answer.id}`)"
                                aria-hidden="true"
                                class="m0 svg-icon iconArrowUpLg"
                                width="36"
                                height="36"
                                viewBox="0 0 36 36"
                        >
                            <path d="M2 26h32L18 10 2 26z"></path>
                        </svg>
                        <p id="${answer.id}">${answer.votes.size()}</p>
                        <svg
                                aria-hidden="true"
                                class="m0 svg-icon iconArrowDownLg"
                                width="36"
                                height="36"
                                viewBox="0 0 36 36"
                        >
                            <path d="M2 10h32L18 26 2 10z"></path>
                        </svg>
                        <svg
                                aria-hidden="true"
                                class="svg-icon iconBookmark"
                                width="18"
                                height="18"
                                viewBox="0 0 18 18"
                        >
                            <path
                                    d="M6 1a2 2 0 00-2 2v14l5-4 5 4V3a2 2 0 00-2-2H6zm3.9 3.83h2.9l-2.35 1.7.9 2.77L9 7.59l-2.35 1.7.9-2.76-2.35-1.7h2.9L9 2.06l.9 2.77z"
                            ></path>
                        </svg>
                        <svg
                                aria-hidden="true"
                                class="mln2 mr0 svg-icon iconHistory"
                                width="19"
                                height="18"
                                viewBox="0 0 19 18"
                        >
                            <path
                                    d="M3 9a8 8 0 113.73 6.77L8.2 14.3A6 6 0 105 9l3.01-.01-4 4-4-4h3L3 9zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5z"
                            ></path>
                        </svg>
                    </div>
                    <div class="answer-question-detail">
                            <div class="editor" style="padding-top: 10px;width: 3%;
    overflow: scroll;">
                                    ${answer.body}
                            </div>
                            <div class="answer-question-footer">
                                <div class="answer-question-footer-action">
                                    <a href="#">Share</a>
                                    <a href="#">Follow</a>
                                </div>
                                <div class="answer-question-author">
                                    <p>asked 14 mins ago</p>
                                    <div>
                                        <img
                                                src="https://lh6.googleusercontent.com/-xeD2LdRJUJc/AAAAAAAAAAI/AAAAAAAAABw/YuIWglg5h0w/photo.jpg?sz=32"
                                                height="32px"
                                                width="32px"
                                                style="border-radius: 8px"
                                        />
                                        <div>
                                            <a href="#">${answer.user.name}</a>
                                            <div>
                                                <span>1</span>
                                                <span
                                                        class="dot"
                                                        style="background-color: #6a737c"
                                                ></span>
                                                <span>1</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="comment-answer-container">
                                <div class="comment-answer">
                  <span
                  >I have fixed your syntax error and now it seems to be
                    working fine. Check it out.
                  </span>
                                    <span>-</span>
                                    <a href="#"> Yadab</a>
                                    <span>9 mins ago</span>
                                </div>
                            </div>
                            <div class="add-a-comment">Add a comment</div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div class="type-answer">
            <h2 style="font-weight: 500">Your Answer</h2>
            <div id="editor"></div>
            <c:choose>
                <c:when test="${isUser || isAdmin}">
                    <button class="btn btn-primary" style="margin-top: 40px" onclick="postAnswer(`${question.id}`)" >
                        Post your answer
                    </button>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-primary" style="margin-top: 40px" onclick="clickPostAnswerNoLogin()">
                        Post your answer
                    </button>
                </c:otherwise>
            </c:choose>
            <div class="note-post-your-answers">
            <span>
              By clicking “Post Your Answer”, you agree to our
              <a href="#">terms of service</a>,
              <a href="#"> privacy policy</a> and
              <a>cookie policy</a>
            </span>
            </div>
            <div id="alertSignin">

            </div>

        </div>
    </div>
</main>

<script>
    const upVote = (answerId) => {
        let numberOfVote = document.getElementById(answerId);
        console.log("call api upVote");
        let answer = {};
        answer["answerId"] = answerId;
        let http = new XMLHttpRequest();
        http.open("PUT", "/answers/upVote", true);
        http.setRequestHeader('Content-type', 'application/json');
        http.setRequestHeader("Access-Control-Allow-Origin", '*');
        http.setRequestHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        http.onload = function () {
            // do something to response
            console.log(this.responseText);
            data = JSON.parse(this.responseText);
            if(data.status){
                numberOfVote.innerHTML = data.result.votes.length;
            }
        };
        http.send(JSON.stringify(answer));
    };
    const postAnswer = (questionId) => {
        console.log(questionId, "call api");
        let editor = document.getElementsByClassName("ql-editor");
        let body = editor[editor.length - 1];
        let rediret = "http://localhost:8000/questions/detail/" + questionId;
        console.log(rediret, "rediret");
        let answer = {};
        answer["body"] = body.outerHTML || new XMLSerializer().serializeToString(body);
        answer["questionId"] = questionId;
        let http = new XMLHttpRequest();
        http.open("POST", "/answers/postAnswer", true);
        http.setRequestHeader('Content-type', 'application/json');
        http.setRequestHeader("Access-Control-Allow-Origin", '*');
        http.setRequestHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        http.onload = function () {
            // do something to response
            console.log(this.responseText);
            if(JSON.parse(this.responseText).status){
                window.location.href = rediret;
                console.log(rediret, "response")
            }
        };
        http.send(JSON.stringify(answer));
    };
</script>
<script>
    const clickPostAnswerNoLogin = () => {
        let alert = document.getElementById("alertSignin");
        alert.innerHTML = `<div style="
                background-color: #ea1f1f;
                color: white;
                padding: 10px;
                width: 55%;
           ">
                    <p>To answer a question, you must either sign up for an account or post as a guest.</p>
                </div>`
    };
</script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%--<script src="${pageContext.request.contextPath}/js/api.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/quill.js" type="text/javascript"></script>
</body>
</html>
