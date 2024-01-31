document.getElementById("sumForm").addEventListener("submit", function (event) {
    event.preventDefault();
    const xhr = new XMLHttpRequest();
    const result = document.getElementById("answer");
    const userNum = document.getElementById("number").value;
    xhr.open("GET", "data?number=" + userNum);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) { // request finished and response is ready
            if (xhr.status === 200) {
                const textResponse = xhr.responseText;
                if (textResponse === "Wrong Parameter") {
                    alert("Wrong Parameter")
                } else if (textResponse === "Lack of Parameter") {
                    alert("Lack of Parameter")
                } else {
                    result.innerText = textResponse;
                }
            } else {
                alert(xhr.statusText);
            }
        }
    };
    xhr.send();
});

