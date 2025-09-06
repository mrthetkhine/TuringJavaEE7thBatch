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
import {NativeDemoComponent} from "./components/native-demo/native-demo.component";
import {DynamicDemoComponent} from "./components/dynamic-demo/dynamic-demo.component";
import {ViewContainerRefDemoComponent} from "./components/view-container-ref-demo/view-container-ref-demo.component";
import {TemplateDemoComponent} from "./components/template-demo/template-demo.component";
import {TwoWayBindingDemoComponent} from "./components/two-way-binding-demo/two-way-binding-demo.component";
import {
  CrossTwoWayBindingDemoComponent
} from "./components/cross-two-way-binding-demo/cross-two-way-binding-demo.component";
import {ControlFlowDemoComponent} from "./components/control-flow-demo/control-flow-demo.component";
import {RenderListComponent} from "./components/render-list/render-list.component";
import {SwitchDemoComponent} from "./components/switch-demo/switch-demo.component";
import {PipeDemoComponent} from "./components/pipe-demo/pipe-demo.component";

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
    NativeDemoComponent,
    DynamicDemoComponent,
    ViewContainerRefDemoComponent,
    TemplateDemoComponent,
    TwoWayBindingDemoComponent,
    CrossTwoWayBindingDemoComponent,
    ControlFlowDemoComponent,
    RenderListComponent,
    SwitchDemoComponent,
    PipeDemoComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
