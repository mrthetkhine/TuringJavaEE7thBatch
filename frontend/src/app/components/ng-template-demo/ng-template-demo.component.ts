import {Component, signal, Signal, TemplateRef, viewChild, ViewChild} from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {LargeComponentComponent} from "../large-component/large-component.component";

@Component({
  selector: 'app-ng-template-demo',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    LargeComponentComponent,
  ],
  templateUrl: './ng-template-demo.component.html',
  styleUrl: './ng-template-demo.component.css'
})
export class NgTemplateDemoComponent {
  isAdmin = false;
  adminTemplate:Signal<any> = viewChild('admin');
  basicTemplate:Signal<any> = viewChild('basic');

  message = "how are you";
  name =signal('Jhon');
  getTemplate()
  {
    return this.isAdmin ? this.adminTemplate() : this.basicTemplate();
  }
}
