class DTO {

    constructor(public x:number,public y:number)
    {
    }
    display()
    {
        console.log('x is ',this.x, ' y ',this.y);
    }
}
let data:DTO = new DTO(10,20);
console.log('Data ',data);