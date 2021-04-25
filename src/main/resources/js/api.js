const postAskQuestion = () => {
    let title = document.getElementById("title").value;
    let body = document.getElementById("editor");
    console.log(title, body);
    let question = {};
    question["title"] = title;
    question["body"] = body.toString();
    let http = new XMLHttpRequest();
    http.open("POST", "/question/postAskQuestion", true);
    http.setRequestHeader('Content-type', 'application/json');
    http.setRequestHeader("Access-Control-Allow-Origin", '*');
    http.setRequestHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    http.onload = function () {
        // do something to response
        console.log(this.responseText.result.body);
    };
    http.send(JSON.stringify(question));
}