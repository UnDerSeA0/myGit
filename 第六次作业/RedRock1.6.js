window.onload = function () {
    var bodyDiv = document.getElementById("body");
    var oDiv = document.createElement("div");
    var weatherRequest = new XMLHttpRequest();
    var distance = 500;
    var moveStatus = -1;
    var timer;
    var moveStep = 10;
    var Jweather;
    var canDrag = 0;
    bodyDiv.appendChild(oDiv);
    oDiv.style.width = 100 + "px";
    oDiv.style.height = 100 + "px";
    oDiv.style.backgroundColor = "#ffff0f";
    oDiv.style.position = "relative";
    oDiv.style.left = 0 + "px";
    oDiv.style.textAlign = "center";
    oDiv.addEventListener("click",Animate);
    oDiv.addEventListener("click",changeColor);
    weatherRequest.open("GET","http://123.207.89.151/jrtt/forecast",true);
    weatherRequest.send();
    weatherRequest.onreadystatechange=function () {
    if(weatherRequest.readyState ===4 && weatherRequest.status ===200)
    {
        Jweather = weatherRequest.responseText;
        for(var Date in JSON.parse(Jweather)) {
            for(var a in JSON.parse(Jweather)[Date])
            {oDiv.innerHTML = Date +":"+ JSON.parse(Jweather)[Date][a];
                break;}
            break;
        }
    }
    };
    //Ajax;
    function Animate(){
            moveStatus = -moveStatus;
            clearInterval(timer);
            smoothSlip(moveStep);

        }
    function changePosition(moveStatus,moveStep) {
        if(moveStatus === 1)
        {oDiv.style.left = parseInt(oDiv.style.left) + moveStep + "px";
        }


        else if(moveStatus === -1)
        {oDiv.style.left = parseInt(oDiv.style.left) - moveStep + "px";
        }

    }
    function smoothSlip(moveStep){
        var finish = 0;
            //while(parseInt(oDiv.style.left) < distance)
        timer=setInterval(function(){
            if(finish ===0)
            {changePosition(moveStatus,moveStep);
                if(Math.abs(parseInt(oDiv.style.left))>=distance||Math.abs(parseInt(oDiv.style.left))<=0)
                    finish = 1;}

        },100);
    }
    //移动

    //变色
    function changeColor() {
        var rgb='rgb('+Math.floor(Math.random()*255)+','
            +Math.floor(Math.random()*255)+','
            +Math.floor(Math.random()*255)+')';
        oDiv.style.backgroundColor = rgb;

    }

    //拖动
    var mouseBiasX = 0;
    oDiv.addEventListener("mousedown",function (e) {
        var e =e ;
        mouseBiasX = e.pageX -  oDiv.offsetLeft;
        mouseBiasY = e.pageY - oDiv.offsetTop;
       canDrag = 1;
    });
    document.onmousemove = function (e) {
        var e =e;
        var mouseX = e.pageX;
        var mouseY = e.pageY;
        var moveX = 0;
        var moveY = 0;
        if(canDrag)
        {
            moveX = mouseX -mouseBiasX;
            moveY = mouseY - mouseBiasX;
            if(moveX<0)
                moveX = 0;
            if(moveX>document.body.clientWidth)
                moveX =document.body.clientWidth;
            if(moveY<0)
                moveY = 0;
            if(moveY>document.body.clientHeight)
                moveY = document.body.clientHeight;
            oDiv.style.left = moveX + 'px';
            oDiv.style.top  = moveY + 'px';
        }
    }
    document.onmouseup = function () {
        canDrag = 0;
    }

};
