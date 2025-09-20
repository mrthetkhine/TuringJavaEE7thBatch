import {Component, inject} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../../core/services/auth.service";
import {AuthUser} from "../../../../core/model/auth-user.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {
  private formBuilder = inject(FormBuilder);
  authService  =inject(AuthService);
  router = inject(Router);

  authForm = this.formBuilder.group({
    username: ['', [
      Validators.required
    ]
    ],
    password: ['', [
      Validators.required
    ]
    ]
  });
  get username()
  {
    return this.authForm.get('username');
  }
  get password()
  {
    return this.authForm.get('password');
  }
  onSubmit()
  {
    console.log('Auth form value ',this.authForm.value);
    this.authService.login(this.authForm.value as AuthUser,()=>{
      console.log('Route to home');
      this.router.navigate(['/']);
    });
  }

}
