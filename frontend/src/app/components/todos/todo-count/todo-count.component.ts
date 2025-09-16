import {Component, inject} from '@angular/core';
import {ReactiveTodoService} from "../../../services/reactive-todo.service";

@Component({
  selector: 'app-todo-count',
  standalone: true,
  imports: [],
  templateUrl: './todo-count.component.html',
  styleUrl: './todo-count.component.css'
})
export class TodoCountComponent {
  todoService = inject(ReactiveTodoService);
  count :number =0;

  ngOnInit() {
    this.todoService.todos.subscribe(todos=>{
      this.count = todos.length;
    });
  }
}
