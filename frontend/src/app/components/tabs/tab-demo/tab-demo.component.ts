import { Component } from '@angular/core';
import {TabComponent} from "../tab/tab.component";
import {TabPageComponent} from "../tab-page/tab-page.component";

@Component({
  selector: 'app-tab-demo',
  standalone: true,
  imports: [
    TabComponent,
    TabPageComponent,
  ],
  templateUrl: './tab-demo.component.html',
  styleUrl: './tab-demo.component.css'
})
export class TabDemoComponent {
  headers = ["Page1 ","Page 2","Page 3"];
}
