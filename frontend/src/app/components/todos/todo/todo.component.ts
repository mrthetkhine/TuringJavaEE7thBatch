import {Component, input} from '@angular/core';
import {Todo} from "../../../models/todo";

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  todo = input.required<Todo>();
}
