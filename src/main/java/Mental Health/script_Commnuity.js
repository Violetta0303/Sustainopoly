var box = document.querySelector(".box")
console.log(box);

var post = document.querySelector(".post");
var sample = document.querySelector(".sample")


post.onclick=function(){
    var sr = document.querySelector(".sr");
    var sct = document.querySelector(".sct");
    var tx = Math.floor(Math.random()*4)+1;
    document.getElementById('content').value = "";

    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var date1 = date.getDate();
    var day = date.getDay();
    var hours = date.getHours();
    var min = date.getMinutes();
    var second = date.getSeconds();

    if(hours < 10) {
        hours = "0" + hours;
    }
    if(min < 10) {
        min = "0" + min;
    }
    if(second < 10) {
        second = "0" + second;
    }
    

    sample.innerHTML = `<div class="line">
        <div>
            <h3>${sr.value}</h3>
            Topic：<span class="plate">${sct.value}</span>
            Time：<span class="time">${year}-${month}-${date1}&ensp;${hours}:${min}</span>
        </div>
    </div>`+ sample.innerHTML
    sct.value = "Please select the topic";
    sr.value = "";
}




