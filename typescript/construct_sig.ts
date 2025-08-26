class Human
{
  name:string;
  constructor(name:string)
  {
    console.log('Human constructor ',name);
    this.name = name;
  }
}
type SomeConstructor = {
  new (s: string): Human;
};
function fn(ctor: SomeConstructor) {
  return new ctor("hello");
}
fn(Human);