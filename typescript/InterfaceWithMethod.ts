interface Animal
{
    name :string;
    talk:()=>void;
}
let animal : Animal = {
    name : "Woof",
    talk() {
        console.log('Talking by ',this.name);
    },
}
animal.talk();