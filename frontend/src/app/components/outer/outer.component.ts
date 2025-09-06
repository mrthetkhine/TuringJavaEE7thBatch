import { Component } from '@angular/core';
import {InnerComponent} from "../inner/inner.component";

@Component({
  selector: 'app-outer',
  standalone: true,
  imports: [
    InnerComponent
  ],
  templateUrl: './outer.component.html',
  styleUrl: './outer.component.css'
})
export class OuterComponent {

}
