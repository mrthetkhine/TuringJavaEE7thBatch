import {Component, inject, TemplateRef, viewChild} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../../core/services/auth.service";
import {AuthUser} from "../../../../core/model/auth-user.model";
import {ActivatedRoute, Router} from "@angular/router";

import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    ReactiveFormsModule,
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {
  private formBuilder = inject(FormBuilder);
  activateRoute = inject(ActivatedRoute);
  authService  =inject(AuthService);
  router = inject(Router);


  redirectTo: string ='/';

  ngOnInit(): void {
    this.activateRoute.queryParams.subscribe(params => {
      console.log('Activate route ',params);
      let par:any = params;
      if(par.redirectUrl)
      {
        this.redirectTo = par.redirectUrl;
      }

    })
  }
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
  loginSuccess()
  {
    console.log('Route to home');
    this.router.navigate([this.redirectTo]);
  }
  loginError()
  {
    console.log('Login failed');
    Swal.fire({
      title: 'Error!',
      titleText: 'Invalid username or password',
      icon: 'error',
      confirmButtonText: 'Cool'
    });
    this.authForm.reset();
  }
  onSubmit()
  {
    //console.log('Auth form value ',this.authForm.value);

    this.authService.login(this.authForm.value as AuthUser,this.loginSuccess.bind(this),this.loginError.bind(this));
  }

}
