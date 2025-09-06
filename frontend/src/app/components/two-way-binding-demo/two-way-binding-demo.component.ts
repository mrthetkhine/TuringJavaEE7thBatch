import {Component, SimpleChanges} from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-two-way-binding-demo',
  standalone: true,
  imports: [
    FormsModule,
  ],
  templateUrl: './two-way-binding-demo.component.html',
  styleUrl: './two-way-binding-demo.component.css'
})
export class TwoWayBindingDemoComponent {

  count = 100;

  incCount()
  {
    console.log('IncCount previous count ',this.count);
    this.count ++;
  }
}
