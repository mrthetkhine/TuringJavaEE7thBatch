function hello(message:string)
{
    console.log('hello ',message);
}
hello("world");

function add(x:number,y:number):number
{
    return x+y;
}
let result = add(4,3);
console.log('Result ',result);

let strArr = ["Apple","Orange"];
strArr.forEach(s=>{
    console.log('str ',s.toUpperCase());
});