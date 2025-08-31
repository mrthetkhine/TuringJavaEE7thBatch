interface Data {
    readonly name : string;
    readonly address : Address;
}
interface Address {
    city:string;
    township:string;
}
function print(data:Data)
{
    console.log('Name ',data.name);
    console.log('Address ',data.address);
    /*
    data.address = {
        city:"Dhaka",
        township:"Mirpur"
    }*/
    data.address.city= "Update";

}
let obj:Data ={
    name : "TK",
    address : {
        city:"Dhaka",
        township:"Mirpur"
    }
};
print(obj);
console.log('Obj ',obj);

let some:any = obj;

some.address = {
    city:"YGN",
    township:"Another"
}
console.log('Some ',some);