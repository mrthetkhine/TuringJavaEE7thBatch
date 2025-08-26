function firstElement(arr: any[]) {
  return arr[0];
}

console.log('firstElement ',firstElement([1,2,3,4,5]));
console.log('firstElement ',firstElement([1,'2',false,4,5]));

function firstElementV2<Type>(arr: Type[]): Type | undefined {
  return arr[0];
}
//
console.log('firstElement ',firstElementV2([1,'2',false,4,5]));//firstElementV2<any>
console.log('firstElement ',firstElementV2<number>([1,2,3,4,5]));