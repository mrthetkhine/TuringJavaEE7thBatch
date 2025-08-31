class Money
{
    private _amount : number;
    constructor(amount:number)
    {
        this._amount = amount;
    }
    get amount()
    {
        console.log('Getter run');
        return this._amount;
    }
    set amount(newValue)
    {
        console.log('setter newValue ',newValue);
        if(newValue >=0)
        {
            this._amount = newValue;
        }
    }
}
let money:Money = new Money(10);
console.log('Money ',money.amount);
money.amount= -200;
console.log('Money ',money.amount);

money.amount= 100;
console.log('Money ',money.amount);