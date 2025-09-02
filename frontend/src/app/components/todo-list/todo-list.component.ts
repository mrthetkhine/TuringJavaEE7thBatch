import { Component } from '@angular/core';
import {TodoItemComponent} from "../todo-item/todo-item.component";
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [
    FormsModule,
    TodoItemComponent,
  ],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent {
  newTodo: string = '';
  items = ["Task 1", "Task 2", "Task 3"];

  constructor() {
    console.log('TodoListComponent constructor');
  }

  ngOnInit()
  {
    console.log('TodoListComponent ngOnInit');
  }
  addNewTodo()
  {
    this.items.push(this.newTodo);
    this.newTodo = '';
  }
  itemDelete(index:number)
  {
    console.log('Todolist item delete ',index);
    this.items.splice(index,1);
  }
}
