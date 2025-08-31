type Todo = {
    title: string;
    description: string;
    completed: boolean;
};
type ReadOnlyTodo = Readonly<Todo> ;

let todo : ReadOnlyTodo;
todo = {
    title: "Learn TypeScript",
    description: "Study hard",
    completed: false
}
//todo.completed = true;