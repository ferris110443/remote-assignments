document.getElementById("sumForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const xhr = new XMLHttpRequest();
    const result = document.getElementById("answer");
    const userNum = parseInt(document.getElementById("number").value);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) { // request finished and response is ready
            if (xhr.status === 200) {
                result.textContent = userNum * ((userNum) + 1) / 2;
            } else {
                alert(xhr.statusText);
            }
        }
    };

    xhr.open("GET", 'sum.html');
    xhr.send();
});