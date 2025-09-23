import {Component, inject} from '@angular/core';
import {AuthService} from "../../../../core/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-logout',
  standalone: true,
  imports: [],
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent {
  authService =inject(AuthService);
  router = inject(Router);

  logout()
  {
    this.authService.logout();
    this.router.navigate(['login']);
  }

}
