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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/ask_question.css" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/styles/default.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/highlight.min.js"></script>
    <!-- and it's easy to individually load additional languages -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.2/languages/go.min.js"></script>
    <link
            href="https://cdn.quilljs.com/1.3.6/quill.snow.css"
            rel="stylesheet"
    />

    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <script src="https://sdk.amazonaws.com/js/aws-sdk-2.888.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/api.js" type="text/javascript"></script>
    <!-- Bootstrap CSS -->
</head>
<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@include file="layout/header.jsp"%>
<main class="main-container" style="background-color: #eff0f1">
    <div class="ask-question-container">
        <div style="display: flex; justify-content: space-between">
            <h2 style="flex: 1">Ask a public question</h2>
            <div class="bg-heading-ask-question"></div>
        </div>
        <div class="ask-question-content-container">
            <div class="ask-question-form-container">
                <div class="ask-question-form-title-container">
                    <div class="ask-question-form-title">Title</div>
                    <div>
                        Be specific and imagine you’re asking a question to another
                        person
                    </div>
                    <div>
                        <input id="title"
                                placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
                        />
                    </div>
                </div>
                <div class="ask-question-form-body-container">
                    <div class="ask-question-form-body">Body</div>
                    <div style="font-size: 13px; color: #3c4146">
                        Include all the information someone would need to answer your
                        question
                    </div>
                    <div>
                        <div id="editor"></div>
                    </div>
                </div>
                <div
                        class="ask-question-form-title-container"
                        style="margin-top: 30px"
                >
                    <div class="ask-question-form-title">Tags</div>
                    <div>
                        <input placeholder="e.g. (spring vba python)" />
                    </div>
                </div>
                <button class="btn btn-primary" style="margin-top: 40px" onclick="postAskQuestion()">
                    Post your question
                </button>
            </div>
            <div class="ask-question-step-container">
                <div></div>
            </div>
        </div>
    </div>
</main>
<script src="${pageContext.request.contextPath}/js/quill.js" type="text/javascript"></script>
</body>
</html>
