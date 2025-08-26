type NumOrString = number | string;

let data:NumOrString = 10;
data = "Hello";

function show(data:NumOrString)
{
    if(typeof data === "number")
    {
        data = data * 2;
    }
    else
    {
        data = data + " World";
    }
    console.log('Data ',data);
}
show(2);
show("Hello");