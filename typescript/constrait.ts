function longest<Type extends { length: number }>(a: Type, b: Type) {
  if (a.length >= b.length) {
    return a;
  } else {
    return b;
  }
}
console.log('longest ',longest([1,2,3],[4,5,6,7]));
console.log('longest ',longest('hi','hello'));

let obj = {
    length:5
}
let obj2={
    length:3
}
console.log('longest ',longest(obj,obj2));