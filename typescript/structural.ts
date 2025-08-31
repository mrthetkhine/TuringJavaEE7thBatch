class Data {
    x : number;
    y: number

    constructor(x:number,y:number)
    {
        this.x = x;
        this.y = y;
    }
}
class Data2{
    x:number;
    y:number;
    constructor(x:number,y:number)
    {
        this.x = x;
        this.y = y;
    }

}

let data : Data = new Data(10,20);
let data2 : Data2 = new Data2(30,40);


data = data2;

console.log('Data ',data);
