import {CurrencyPipe, DatePipe, TitleCasePipe, UpperCasePipe} from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  standalone: true,
  imports: [
    CurrencyPipe, DatePipe, TitleCasePipe, UpperCasePipe
  ],
  templateUrl: './pipe-demo.component.html',
  styleUrl: './pipe-demo.component.css'
})
export class PipeDemoComponent {
  amount = 123.45;
  company = 'acme corporation';
  purchasedOn = new Date();
}
