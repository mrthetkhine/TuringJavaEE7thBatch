import {Component, signal} from '@angular/core';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css',
  host: {
    '[class.active]':"isActive()",
    '(click)': 'updateValue($event)',
  },
})
export class LayoutComponent {
  isActive = signal(true);
  updateValue(event: Event) {
    console.log('Keydown event ', event);
  }
}
