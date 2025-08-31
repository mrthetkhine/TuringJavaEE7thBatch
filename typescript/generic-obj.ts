/*
type Box = {
    data : any;
}

let box : Box = {
    data : "Hello"
}
let box2: Box = {
    data : 122,
}
console.log('Box2 ',box2.data.toLowerCase());
*/
type Box<T>={
    data : T
}
let box1:Box<number> ={
    data :123,
}
let box2 : Box<string>={
    data : "Hello"
}
console.log('box2 ',box2.data);