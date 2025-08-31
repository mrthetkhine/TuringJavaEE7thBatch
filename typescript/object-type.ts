interface Human  {
    name:string;
    age :number;
    address? : string
}
function display(obj:Human)
{
    console.log('Name ',obj.name);
    console.log('Age ',obj.age);
    console.log('Address ',obj.address?.toLowerCase());
}
display({
    name : "TK",
    age : 40
});

display({
    name : "Another",
    age : 20,
    address:"Somewhere"
})