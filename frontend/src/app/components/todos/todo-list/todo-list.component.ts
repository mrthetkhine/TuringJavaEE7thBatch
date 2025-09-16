import {Component, inject} from '@angular/core';
import {TodoService} from "../../../services/todo.service";
import {Todo} from "../../../models/todo";
import {TodoComponent} from "../todo/todo.component";
import {ReactiveTodoService} from "../../../services/reactive-todo.service";

@Component({
  selector: 'app-todo-list-2',
  standalone: true,
  imports: [
    TodoComponent,
  ],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent {
  todoService = inject(ReactiveTodoService);

  todos:Todo[] = [];

  ngOnInit() {
    //this.todos = this.todoService.getAllTodos();
    this.todoService.todos.subscribe(data=>{
      console.log('todo data changes ',data);
      this.todos = data;
    });
    this.todoService.loadAllTodos();
  }
  deleteTodo(todoId:number){
    console.log('Delete todo ',todoId);
    this.todoService.deleteTodo(todoId);

  }
}
