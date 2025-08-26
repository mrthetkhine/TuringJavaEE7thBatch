type Point ={
    x : number,
    y : number
};

type Point3D = Point & {
    z : number
}

interface Point2 {
    x : number,
    y : number
}
interface Point2 {
    z : number,
}
let p2 :Point2 = {
    x : 10,
    y : 20,
    z : 30
}
console.log('p2 ',p2);

let p3 :Point3D = {
    x : 10,
    y : 20,
    z : 30
}
console.log('p3 ',p3);