class Base {
  private x = 100;
}
class Base2 {
  #x = 100;
}
const b = new Base2();
// Can't access from outside the class
//console.log((b as any).#x);