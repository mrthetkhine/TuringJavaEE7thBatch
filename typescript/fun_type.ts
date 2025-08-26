function add(x:number,y:number):number
{
    return x+y;
}
function sub(x:number,y:number):number
{
    return x-y;
}
function another()
{
    console.log('Another');
}
type BinaryFun = (x:number,y:number) => number;

let fun : BinaryFun = add;
console.log('Fun ',fun(1,2));

fun = sub;
console.log('Fun ',fun(1,2));

type Callback = ()=>void;

function invoke(callBack:Callback)
{
    console.log('Invoke later');
    callBack();
}
invoke(another);