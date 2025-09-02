import {Component, computed, contentChild} from '@angular/core';
import {GreetingComponent} from "../greeting/greeting.component";

@Component({
  selector: 'app-content-child-demo',
  standalone: true,
  imports: [
    GreetingComponent,
  ],
  templateUrl: './content-child-demo.component.html',
  styleUrl: './content-child-demo.component.css'
})
export class ContentChildDemoComponent {
  greeting = contentChild(GreetingComponent);

  header = computed(() => this.greeting()?.message);

  ngAfterContentInit() {
    console.log("Message ",this.greeting()?.message);
  }
}
