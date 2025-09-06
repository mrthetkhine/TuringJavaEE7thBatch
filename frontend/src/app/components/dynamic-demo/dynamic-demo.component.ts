import {Component, input} from '@angular/core';
import {AdminComponent} from "../admin/admin.component";
import {UserComponent} from "../user/user.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-dynamic-demo',
  standalone: true,
  imports: [
    CommonModule,
   /* AdminComponent,
    UserComponent,*/
  ],
  templateUrl: './dynamic-demo.component.html',
  styleUrl: './dynamic-demo.component.css'
})
export class DynamicDemoComponent {
  admin = input.required<boolean>();

  getBioComponent() {
    return this.admin()? AdminComponent : UserComponent;
  }
}
