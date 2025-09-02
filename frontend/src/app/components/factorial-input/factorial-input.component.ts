import { Component } from '@angular/core';
import {FactorialComponent} from "../factorial/factorial.component";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-factorial-input',
  standalone: true,
  imports: [
    FormsModule,
    FactorialComponent,
  ],
  templateUrl: './factorial-input.component.html',
  styleUrl: './factorial-input.component.css'
})
export class FactorialInputComponent {
  factNo: number = 0;
}
