let data;
console.log('Data ',data);

data = null;
console.log('Data ',data);
function doSomething(x: string | null) {
  if (x !== null) {
    console.log("Hello, " + x.toUpperCase());
  } 
}
doSomething('test');

function doSomething2(x: string | null) {
   console.log("Hello, " + x!.toUpperCase());
}
doSomething2("null");