let input = document.querySelector(".js-tageditor-replacing");
let width = 19;
let tags = [];

input.addEventListener("keypress", function (event) {
    width += 6;
    input.style.width = width + "px";
    if (event.which === 13) {
        if (tags.indexOf(input.value) < 0) {
            tags.push(input.value);
            let listTags = document.getElementsByClassName("list-tags")[0];
            listTags.innerHTML += `<span class="s-tag rendered-element" id="${input.value}"
                >${input.value}<a class="js-delete-tag s-tag--dismiss" title="Remove tag"
                  ><svg
                    class="svg-icon iconClearSm pe-none"
                    width="14"
                    height="14"
                    viewBox="0 0 14 14"
                    onClick="chipClickHandler(this)"
                    name="${input.value}"
                  >
                    <path
                      d="M12 3.41L10.59 2 7 5.59 3.41 2 2 3.41 5.59 7 2 10.59 3.41 12 7 8.41 10.59 12 12 10.59 8.41 7z"
                    ></path></svg></a></span>`;
            input.value = "";
        }
    }
});
function chipClickHandler(event) {
    let tag = event.getAttribute("name");
    let pos = tags.indexOf(tag);
    tags.splice(pos, 1);
    console.log(tags);
    let tagElement = document.getElementById(tag);
    tagElement.remove();
}
const postAskQuestion = () => {
    let title = document.getElementById("title").value;
    let body = document.getElementById("editor");
    let question = {};
    question["title"] = title;
    question["body"] = body.outerHTML || new XMLSerializer().serializeToString(body);
    console.log(question["body"], "body");
    question["tags"] = tags;
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