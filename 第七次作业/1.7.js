myArray = new Array(1,2,3);
myArray.myMap = myMap(function (x) {
    return x*4;
});
console.log(myArray);
myArray.myReduce = myReduce();
myArray.myForeach = myForeach();
myArray.mySome = mySome();
myArray.myFilter = myFilter();
function myMap(f,object){
    var newArray = new Array();
    if(object)
        myMap.call(object);
    if(typeof f ==="function")
    for(var i = 0;i <myArray.length;i++)
    {
        newArray.push(f(myArray[i]));
    }
    return newArray;
}
function myReduce(f,initial){
    if(typeof f ==="function")
    {if(this.boolean(initial))
        return f(initial,myArray.slice());
    else
        return f(myArray.slice(),myArray.slice());}
}
function myForeach(f,o) {
    if(o)
        myForeach.call(o);
    if(typeof p ==="function")
    for(var i = 0 ;i < myArray.length; i++)
        f(myArray[i]);

}
function mySome(p,o) {
    var usePNumber = 0;
    if(o)
        mySome.call(o);
    if(typeof p === "function")
    for(var i = 0; i < myArray.length;i++)
    {
        if(p(this[i]))
            usePNumber++;
    }
    if ( usePNumber < myArray.length)
    {return false;}
    else if (usePNumber === myArray.length)
        return true;

}
function myFilter(p,o) {
    var newArray = new Array();
    if(o)
        myFilter.call(o);
    if(typeof p === "function")
    for(var i=0 ; i < myArray.length ; i++){
        if(p(this[i]))
            newArray.push(myArray[i]);
    }
    return newArray;
}
