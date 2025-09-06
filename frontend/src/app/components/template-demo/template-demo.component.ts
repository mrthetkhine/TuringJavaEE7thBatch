import {Component, signal} from '@angular/core';

@Component({
  selector: 'app-template-demo',
  standalone: true,
  imports: [],
  templateUrl: './template-demo.component.html',
  styleUrl: './template-demo.component.css'
})
export class TemplateDemoComponent {
  disabledFlag = false;
  active =false;
  height = 300;

  toggle()
  {
    this.active = !this.active;
  }
  sectionStyles = signal({
    border: '1px solid black',
    'font-weight': 'bold',
  });

  handleEvent  (e: MouseEvent) {
    console.log('MouseDwn ',e);
  }

  handleRightClickEvent  (e: MouseEvent) {
    console.log('Right click ',e);
    e.preventDefault();
  }
}
