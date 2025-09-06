import { Component } from '@angular/core';
import {CounterTwoWayBindingComponent} from "../counter-two-way-binding/counter-two-way-binding.component";

@Component({
  selector: 'app-cross-two-way-binding-demo',
  standalone: true,
  imports: [
    CounterTwoWayBindingComponent,
  ],
  templateUrl: './cross-two-way-binding-demo.component.html',
  styleUrl: './cross-two-way-binding-demo.component.css'
})
export class CrossTwoWayBindingDemoComponent {
  initialCount = 18;
}
