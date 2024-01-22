


// ================Click to Change Text for message====================
const message = document.querySelector(".message");
message.addEventListener("click",function(){
    let text = message.textContent;
    if (text === "Welcome Message"){
        message.textContent = "Have a Good Time!";
    } else {
        message.textContent = "Welcome Message";
    }
    console.log(text);
})


// ================Click to Show More Content Boxes====================

const callToActionBtn = document.querySelector(".section-coa button");

callToActionBtn.addEventListener("click" , function(){
    const lastBoxContainer = document.querySelector(".box-container:last-child");
    const containerStatus=lastBoxContainer.style.display
    if (containerStatus === ""|| containerStatus ==="none"){
        lastBoxContainer.style.display = "flex";
    } else {
        lastBoxContainer.style.display = "none";
    }
})