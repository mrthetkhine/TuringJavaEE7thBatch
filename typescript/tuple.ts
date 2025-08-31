type StringNumberPair = [string, number];
let pair: StringNumberPair = ["hello", 100];
/*
console.log(pair[0]);
console.log(pair[1]);
*/
function div(a : number, b: number):[any,number]
{
    if(b === 0)
    {
        return ["Divide by zero",0];
    }
    else
    {
        return [null,a/b];
    }
}

let [err,result] = div(10,2);
console.log("Error ",err);
console.log("Result ",result);