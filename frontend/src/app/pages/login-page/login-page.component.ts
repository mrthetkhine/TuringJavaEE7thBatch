import {Component, inject} from '@angular/core';
import {DummyAuthServiceService} from "../../services/dummy-auth-service.service";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";

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
  authService = inject(DummyAuthServiceService);
  private formBuilder = inject(FormBuilder);

  loginForm = this.formBuilder.group({
    username: ['', [
                    Validators.required,
                    Validators.minLength(4)
                  ]
              ],
    password: ['',[
            Validators.required,
            Validators.minLength(4)
      ]
    ],
  })

  login() {
    this.authService.login();
  }


  get username()
  {
    return this.loginForm.get('username');
  }
  get password()
  {
    return this.loginForm.get('password');
  }
  onSubmit()
  {
    console.log('submit ',this.loginForm.value);
  }
  clear()
  {
    this.loginForm.reset();
  }
}
