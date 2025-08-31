class Human
{
    name :string;
    age : number;

    constructor(name:string,age:number)
    {
        console.log('Human constructor');
        this.name = name;
        this.age = age;
    }
    display()
    {
        console.log('Name ',this.name);
        console.log('Age ',this.age);
    }
}
class Teacher extends Human
{
    subject:string;
    constructor(name:string,age:number,subject:string)
    {
        super(name,age);
        console.log('Teacher constructor');
        this.subject = subject;
    }
    display(): void {
        console.log('Teacher display');
        super.display();
        console.log('Subject ',this.subject);
    }
}
let h : Human = new Human("TK",40);
//console.log('Human ',h);
h.display();

let t : Teacher =new Teacher("TK",40,"Java");
t.display();