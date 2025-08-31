class Person {
  constructor(public name: string, public age: number) {

  }
}
 
class Employee {


  constructor(public name: string, public age: number,public salary:number) {
    
  }
}
 
// OK
let p: Person = new Employee('TK',40,102022);
p = {
    name : "TK",
    age : 40,
    salary:11022
} as Employee;
console.log('P ',p);