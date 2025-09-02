import {Component, EventEmitter, input, Output, output} from '@angular/core';

@Component({
  selector: 'app-todo-item',
  standalone: true,
  imports: [],
  templateUrl: './todo-item.component.html',
  styleUrl: './todo-item.component.css'
})
export class TodoItemComponent {
  name = input('');
  index=input(0);

  //itemDelete = output<number>();
  @Output() itemDelete = new EventEmitter<number>();

  constructor(){
    console.log('TodoItemComponent constructor');
  }
  ngOnInit()
  {
    console.log('TodoItemComponent ngOnInit');
  }
  ngOnChanges()
  {
    console.log('TodoItemComponent Input Change ',this.name());
  }
  ngOnDestroy()
  {
    console.log('TodoItemComponent ngOnDestroy');
  }
  deleteHandler()
  {
    console.log('Delete index ',this.index());
    this.itemDelete.emit(this.index());
  }
}
