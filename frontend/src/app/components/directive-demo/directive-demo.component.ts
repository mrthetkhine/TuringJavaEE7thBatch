import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";
import {HighlightDirective} from "../../highlight.directive";
import {LoggerService} from "../../services/logger.service";

@Component({
  selector: 'app-directive-demo',
  standalone: true,
  imports: [
    CommonModule,
    HighlightDirective,
  ],
  templateUrl: './directive-demo.component.html',
  styleUrl: './directive-demo.component.css'
})
export class DirectiveDemoComponent {
  hero = true;
  name = "Jhon";


}
