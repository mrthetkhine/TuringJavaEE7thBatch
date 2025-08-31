import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HelloWorldComponent} from "./components/hello-world/hello-world.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {GreetingComponent} from "./components/greeting/greeting.component";
import {TrimMessageComponent} from "./components/trim-message/trim-message.component";
import {CounterComponent} from "./components/counter/counter.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HelloWorldComponent,
    ProfileComponent,
    GreetingComponent,
    TrimMessageComponent,
    CounterComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
