import { Component } from '@angular/core';
import {OuterComponent} from "../outer/outer.component";

@Component({
  selector: 'app-view-container-ref-demo',
  standalone: true,
  imports: [
    OuterComponent,
  ],
  templateUrl: './view-container-ref-demo.component.html',
  styleUrl: './view-container-ref-demo.component.css'
})
export class ViewContainerRefDemoComponent {

}
