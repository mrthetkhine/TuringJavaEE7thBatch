import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-control-flow-demo',
  standalone: true,
  imports: [
    FormsModule,
  ],
  templateUrl: './control-flow-demo.component.html',
  styleUrl: './control-flow-demo.component.css'
})
export class ControlFlowDemoComponent {
  data= 10;
}
