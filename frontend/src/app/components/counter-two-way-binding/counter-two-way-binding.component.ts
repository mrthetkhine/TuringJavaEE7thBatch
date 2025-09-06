import {Component, model} from '@angular/core';

@Component({
  selector: 'app-counter-two-way-binding',
  standalone: true,
  imports: [],
  templateUrl: './counter-two-way-binding.component.html',
  styleUrl: './counter-two-way-binding.component.css'
})
export class CounterTwoWayBindingComponent {
  count = model<number>(0);

  updateCount(amount: number): void {
    this.count.update(currentCount => currentCount + amount);
  }
}
