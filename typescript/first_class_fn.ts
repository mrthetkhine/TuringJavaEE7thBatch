//
function hello()
{
    console.log("Hello");
}
let fun = hello;//Rule1
fun();


function accept(fn:()=>void)
{
    fn();
}
accept(hello);//Rule2

function getFun()
{
    return hello;
}

getFun()();