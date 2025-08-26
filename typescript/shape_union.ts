type Circle = {
    radius : number
};
type Rectangle = {
    width : number,
    height : number
};
type Shape = Circle | Rectangle;
function area(shape:Shape):number
{
    if("radius" in shape)
    {
        return Math.PI * shape.radius * shape.radius;
    }
    else
    {
        return shape.width * shape.height;
    }
}
let result = area({
    radius: 10
}) ;
console.log('Result ',result);

result = area({
    width : 10,
    height : 20
});
console.log('Result ',result);