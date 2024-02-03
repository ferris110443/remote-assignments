async function ajax(src, callback) {
// your code here
    try {
        const products = await fetch(src);
        const productsData = await products.json();
        console.log(productsData)
        callback(productsData);
    } catch (error) {
        console.log("Need check src connection : " + error)
    }
}

function render(data) {
// your code here
// document.createElement() and appendChild() methods are preferred.
    const body = document.querySelector("body");
    const ul = document.createElement("ul");

    data.forEach(element => {
        let text = "";
        let li = document.createElement("li")
        text += `Phone : ${element.name} Price : ${element.price} Description : ${element.description}`;
        li.innerText = text;
        ul.appendChild(li);
    })
    body.appendChild(ul);
}

ajax(
    'https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products',
    function (response) {
        render(response);
    }
); // you should get product information in JSON format and render data in the page