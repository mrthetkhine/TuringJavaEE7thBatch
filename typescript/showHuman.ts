function display(human:{
                    name:string,
                    age :number
                })
{
    console.log('Name ',human.name);
    console.log('Age ',human.age);
}
display({
    name : "TK",
    age : 40
});
type Human = {
    name : string,
    age : number,
    address? : string
}
function display2(human:Human)
{
    console.log('Name ',human.name);
    console.log('Age ',human.age);
    console.log('Address ',human.address);
}
display2({
    name : "TK",
    age : 40,
    address:"Somewhere"
});