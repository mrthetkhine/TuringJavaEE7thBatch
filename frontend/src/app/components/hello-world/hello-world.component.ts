import {Component, ViewEncapsulation} from '@angular/core';
import {AnotherComponent} from "../another/another.component";

@Component({
  selector: 'app-hello-world',
  standalone: true,
  imports: [AnotherComponent],
  templateUrl: './hello-world.component.html',
  styleUrl: './hello-world.component.css',
  encapsulation: ViewEncapsulation.Emulated,
})
export class HelloWorldComponent {
  message:string = 'Hello World';

}
