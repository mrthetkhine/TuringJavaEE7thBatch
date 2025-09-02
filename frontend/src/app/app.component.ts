import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HelloWorldComponent} from "./components/hello-world/hello-world.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {GreetingComponent} from "./components/greeting/greeting.component";
import {TrimMessageComponent} from "./components/trim-message/trim-message.component";
import {CounterComponent} from "./components/counter/counter.component";
import {TodoListComponent} from "./components/todo-list/todo-list.component";
import {BorderComponent} from "./components/border/border.component";
import {LayoutComponent} from "./components/layout/layout.component";
import {LayoutHeaderComponent} from "./components/layout-header/layout-header.component";
import {LayoutBodyComponent} from "./components/layout-body/layout-body.component";
import {LayoutFooterComponent} from "./components/layout-footer/layout-footer.component";
import {FactorialInputComponent} from "./components/factorial-input/factorial-input.component";
import {ViewChildDemoComponent} from "./components/view-child-demo/view-child-demo.component";
import {ContentChildDemoComponent} from "./components/content-child-demo/content-child-demo.component";

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
    TodoListComponent,
    BorderComponent,
    LayoutComponent,
    LayoutHeaderComponent,
    LayoutBodyComponent,
    LayoutFooterComponent,
    FactorialInputComponent,
    ViewChildDemoComponent,
    ContentChildDemoComponent,

  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
