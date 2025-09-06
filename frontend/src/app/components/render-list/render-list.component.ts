import { Component } from '@angular/core';

@Component({
  selector: 'app-render-list',
  standalone: true,
  imports: [],
  templateUrl: './render-list.component.html',
  styleUrl: './render-list.component.css'
})
export class RenderListComponent {
  items = ['Apple','Orange',"Banana"];

  resetList()
  {
    this.items = [];
  }
}
