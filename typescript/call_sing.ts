type DescribableFunction = {
  description: string;
  (someArg: number): boolean;
};
function isEven(data:number)
{
    console.log('isEven ',data);
    return data % 2 === 0;
}
isEven.description = "Check if the number is even";
console.log('isEven ',isEven.description);
let fun : DescribableFunction = isEven;

console.log('Fun ',fun(4));
console.log('Fun description ',fun.description);