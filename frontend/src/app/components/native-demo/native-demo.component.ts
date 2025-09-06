import {Component, ElementRef, inject} from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-native-demo',
  standalone: true,
  imports: [
    FormsModule,
  ],
  templateUrl: './native-demo.component.html',
  styleUrl: './native-demo.component.css'
})
export class NativeDemoComponent {
  username:string = '';
  element:ElementRef<any>;

  constructor() {
    this.element = inject(ElementRef);
    console.log('native element ',this.element.nativeElement);
    /*afterEveryRender(() => {
      // Focus the first input element in this component.
      this.element.nativeElement.querySelector('input')?.focus();
    });*/
  }
  ngAfterViewInit()
  {
    console.log('ngAfterViewInit',this.element.nativeElement);
  }
  focusUsername()
  {
    this.element.nativeElement.querySelector('input')?.focus();
  }
}
