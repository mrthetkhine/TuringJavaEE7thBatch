interface Point2D
{
    x:number;
    y:number;
}
interface Point3D extends Point2D
{
    z:number;
}
let point:Point3D = {
    x: 10,
    y : 20,
    z:30,
}
console.log('Point ',point);

type ThreeD = Point2D & { z:number };
let point2:ThreeD = {
    x: 10,
    y : 20,
    z:30,
}
console.log('Point ',point2);