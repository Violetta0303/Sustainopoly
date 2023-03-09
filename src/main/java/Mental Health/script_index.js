// Heart
var index1 = 1;
    function Playback1() {
        index1 ++;
        if(index1 > 6) {
            index1 = 1;
        }
        
        var img1 = document.getElementById('heart');
        img1.src = "images/Heart_" + index1 + ".svg";
    }
    setInterval(Playback1, 200);


//Brain 
var index2 = 1;
    function Playback2() {
        index2 ++;
        if(index2 > 5) {
            index2 = 1;
        }
        
        var img2 = document.getElementById('brain');
        img2.src = "images/Brain_" + index2 + ".png";
    }
    setInterval(Playback2, 200);


//Subnav_Box
// title1
var flag1 = true;
var flag2 = false;
var flag3 = false;
var flag4 = false;

var window1 = document.getElementById('title1');
var window2 = document.getElementById('title2');
var window3 = document.getElementById('title3');
var window4 = document.getElementById('title4');

var onl1 = document.getElementById('content1');
var onl2 = document.getElementById('content2');
var onl3 = document.getElementById('content3');
var onl4 = document.getElementById('content4');

window1.onclick = function() {
    if(flag2 == true || flag3 == true || flag4 == true) {
        onl2.style.display = "none";
        onl3.style.display = "none";
        onl4.style.display = "none";
    }
    if(onl1.style.display == "none") {
    //      onl1.style.display = "none";
    // } else {
        onl1.style.display = "block";
        flag1 = true;
    }
    
}

// title2

window2.onclick = function() {
    if(flag1 == true || flag3 == true || flag4 == true) {
        onl1.style.display = "none";
        onl3.style.display = "none";
        onl4.style.display = "none";
    }
    if(onl2.style.display == "block") {
        onl2.style.display = "none";
    } else {
        onl2.style.display = "block";
        flag2 = true;
    }
    }
    

// title3
window3.onclick = function() {
    if(flag1 == true || flag2 == true || flag4 == true) {
        onl1.style.display = "none";
        onl2.style.display = "none";
        onl4.style.display = "none";
    }
    if(onl3.style.display == "block") {
        onl3.style.display = "none";
    } else {
        onl3.style.display = "block";
        flag3 = true;
    }
    
}

// title4
window4.onclick = function() {
    if(flag1 == true || flag2 == true || flag3 == true) {
        onl1.style.display = "none";
        onl2.style.display = "none";
        onl3.style.display = "none";
    }
    
    if(onl4.style.display == "block") {
        onl4.style.display = "none";
    } else {
        onl4.style.display = "block";
        flag4 = true;
    }
    
}
