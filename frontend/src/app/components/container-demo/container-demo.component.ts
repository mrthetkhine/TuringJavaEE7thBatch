import { Component } from '@angular/core';
import {CommonModule, NgComponentOutlet} from "@angular/common";
import {ContainerPage1Component} from "../container-page1/container-page1.component";
import {ContainerPage2Component} from "../container-page2/container-page2.component";

@Component({
  selector: 'app-container-demo',
  standalone: true,
  imports: [
    CommonModule,
    NgComponentOutlet,
  ],
  templateUrl: './container-demo.component.html',
  styleUrl: './container-demo.component.css'
})
export class ContainerDemoComponent {

  index = 0;

  changePage(page: number) {
    this.index= page;
  }
  getPage()
  {
    if(this.index === 0){
      return ContainerPage1Component;
    }
    else
    {
      return ContainerPage2Component;
    }
  }
}
