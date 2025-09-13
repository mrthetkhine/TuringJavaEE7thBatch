import {Component, inject} from '@angular/core';
import {DummyAuthServiceService} from "../../services/dummy-auth-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.css'
})
export class AdminPageComponent {
  router = inject(Router);
  authService = inject(DummyAuthServiceService);

  /*ngOnInit() {
    if(!this.authService.isAuth()){
      this.router.navigate(['home']);
    }
  }*/
}
