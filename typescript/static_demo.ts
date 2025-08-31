class MyClass {
  static x = 10;
  static{
    console.log('Block1');
    MyClass.x = 20;
  }
  static{
    console.log('Block2');
   
  }
  static printX() {
    console.log(MyClass.x);
  }
}
let obj:MyClass = new MyClass();
//console.log("Obj.x ",obj.x);
MyClass.printX();
console.log('Class ',MyClass.x);