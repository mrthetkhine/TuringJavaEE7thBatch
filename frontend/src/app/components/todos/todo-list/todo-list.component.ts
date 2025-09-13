import {Component, inject} from '@angular/core';
import {TodoService} from "../../../services/todo.service";
import {Todo} from "../../../models/todo";
import {TodoComponent} from "../todo/todo.component";

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
  todoService = inject(TodoService);

  todos:Todo[] = [];

  ngOnInit() {
    this.todos = this.todoService.getAllTodos();
  }
}
