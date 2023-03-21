// 弹出 帖子输入的框---【去掉默认隐藏为显示，设置display = "block";】
function post(){
    var inp = document.getElementsByClassName("post");
    inp[0].style.display = "block";
}	 
    
// 点击发布
function postSuccess(){
    //隐藏发布框
    var inp = document.getElementsByClassName("post");
    inp[0].style.display = "none";   
    
    // 创建li标签 		【并把li标签添加到ul列表下的首个子标签的位置】
    var newli=document.createElement("li");
    var ul = document.getElementById("postul");
    ul.insertBefore(newli,ul.firstChild);//【保证li当前添加的li标签始终在最上面】

    // 创建div标签 		并往li中添加div标签 
    var newdiv=document.createElement("div");
    newli.appendChild(newdiv);

    // 往div中添加图片 设置当前图片的路径
    var img=document.createElement("img");
    newdiv.appendChild(img);
    //随机取1-4的随机数
    var num = Math.floor(Math.random()*4+1);  
    //设置路径---通过setAttribute设置属性
    img.setAttribute("src","images/tou0"+num+".jpg");  

    // 在li中添加h1标签
    var h1=document.createElement("h1");
    newli.appendChild(h1);
    // 获取标题输入框中的内容
    var biao =  document.getElementById("title");
    h1.innerText=biao.value; //注意：因为input是单边标签，所以用.value获取
    
    // 在li中添加p标签 
    var newp=document.createElement("p");
    newli.appendChild(newp);

    // 获取所属板块中的内容
    var ban = document.getElementById("sec");
    // 把所选板块的信息写在p标签中
    newp.innerText = "模块信息："+ban.value;

    // 在p标签中添加span标签
    var span=document.createElement("span");
    newp.appendChild(span);

    // 给span标签设置外边框边距、距离标签100px
    span.style.marginLeft="100px";
    // 把日期写在span标签中
    span.innerText="发布时间 :  "+getTime();
}

function getTime(){
     // 1、获取当前的日期
     var date = new Date();
    var m = (date.getMonth()+1)>9?(date.getMonth()+1):"0"+(date.getMonth()+1);
    var min = (date.getMinutes())>9?(date.getMinutes()):"0"+(date.getMinutes());
    var se = (date.getSeconds())>9?(date.getSeconds()):"0"+(date.getSeconds);
    var cl = date.getFullYear()+"年"+m+"月"+date.getDate()+"日\t"+date.getHours()+"时"+min+"分"+date.getSeconds()+"秒";
    return cl;
}
