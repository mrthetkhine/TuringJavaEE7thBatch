import {inject, Injectable} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from "../services/auth.service";

@Injectable()
export class TokenInterceptorInterceptor implements HttpInterceptor {
  authService = inject(AuthService);
  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    const authToken = this.authService.token;
    // Clone the request to add the authentication header.
    console.log('Interceptor ');
    if(this.authService.isAuthenticated){
      const newReq = request.clone({
        headers: request.headers.append('Authorization', 'Bearer '+authToken),

      });
      return next.handle(newReq);
    }
    else{
      return next.handle(request);
    }

  }
}
