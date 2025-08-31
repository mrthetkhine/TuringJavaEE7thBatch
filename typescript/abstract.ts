abstract class Base {
  abstract getName(): string;
 
  printName() {
    console.log("Hello, " + this.getName());
  }
}
class Child extends Base {
  getName() {
    return "Child";
  }
}
let base:Base = new Child(); 
console.log('getname ',base.getName());