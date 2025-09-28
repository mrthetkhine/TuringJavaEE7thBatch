import { Component, inject } from '@angular/core';
import {NbCardModule} from "@nebular/theme";
import {FormBuilder, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../../@core/services/auth.service";
import Swal from 'sweetalert2';
import {AuthUser} from "../../../../@core/model/auth-user.model";
@Component({
  selector: 'ngx-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss'],

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
