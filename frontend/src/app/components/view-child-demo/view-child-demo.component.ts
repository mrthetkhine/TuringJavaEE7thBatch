import {Component, computed, viewChild} from '@angular/core';
import {GreetingComponent} from "../greeting/greeting.component";

@Component({
  selector: 'app-view-child-demo',
  standalone: true,
  imports: [
    GreetingComponent,
  ],
  templateUrl: './view-child-demo.component.html',
  styleUrl: './view-child-demo.component.css'
})
export class ViewChildDemoComponent {
  greeting = viewChild(GreetingComponent);
  headerText = computed(() => this.greeting()?.message);

  ngOnInit(): void {
    console.log('ViewChildDemoComponent on init ',this.greeting()?.message);
  }
}
