import { Component } from '@angular/core';
import {AdminComponent} from "../admin/admin.component";
import {UserComponent} from "../user/user.component";

@Component({
  selector: 'app-switch-demo',
  standalone: true,
  imports: [
    AdminComponent,
    UserComponent
  ],
  templateUrl: './switch-demo.component.html',
  styleUrl: './switch-demo.component.css'
})
export class SwitchDemoComponent {
  isAdmin = false;

  toggle()
  {
    this.isAdmin = !this.isAdmin;
  }
}
