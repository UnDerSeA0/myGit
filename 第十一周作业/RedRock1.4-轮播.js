window.onload=function () {
    var container=document.getElementsByClassName("container")[0];
    var content=document.getElementsByClassName("content")[0];
    var prev=document.getElementsByClassName("prev")[0];
    var next=document.getElementsByClassName("next")[0];
    var point=document.getElementById("#1").getElementsByTagName("span");
    var index=0;
    var timer;
    prev.onclick=function () {
        index-- ;
        Roll(-690);
        showpPoint();
    };
    next.onclick=function () {
        index++;
        Roll(690);
        showpPoint();
    };
    container.onmouseover=function () {
        prev.style.display="inline-block";
        next.style.display="inline-block";
        stop();
    };
    container.onmouseout=function () {
        prev.style.display="none";
        next.style.display="none";
        play();
    };
    function Roll(position) {
            content.style.left=parseInt(content.style.left) + position+"px";

        if(parseInt(content.style.left) === 0)
        {
            content.style.left= -3450 + "px";}
        else if(parseInt(content.style.left) === -4140)
        {   index=0;
            content.style.left= -690 + "px";}

    }
    function showpPoint() {
        for(var i = 0; i < point.length; i++)
        {
            if(point[i].className === "on")
                point[i].className="";
        }
        if(index === 5)
            index=0;
        if(index === -1)
            index=4;
        console.log(index);
        console.log(point[index]);
        point[index].className="on";
    }
    function play() {
        timer=setInterval(next.onclick,3000);
    }
    function stop() {
        clearInterval(timer)
    }
    play();
};

