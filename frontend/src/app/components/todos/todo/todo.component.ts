import {Component, inject, input, output} from '@angular/core';
import {Todo} from "../../../models/todo";
import {TodoService} from "../../../services/todo.service";

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {

  todo = input.required<Todo>();
  todoDeleted = output<number>();

  onDeleteTodo(){
    this.todoDeleted.emit(this.todo().id);
  }
}
