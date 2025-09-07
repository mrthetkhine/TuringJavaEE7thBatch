import { Component } from '@angular/core';

@Component({
  selector: 'app-inline-template',
  standalone: true,
  imports: [],
  template: `
  <div>
  <h1>this is inline template</h1>
  </div>
  `,
  styleUrl: './inline-template.component.css'
})
export class InlineTemplateComponent {

}
