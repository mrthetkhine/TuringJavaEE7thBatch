import { HttpInterceptorFn } from '@angular/common/http';
import {inject} from "@angular/core";
import {AuthService} from "../services/auth.service";

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const authToken = authService.token;
  // Clone the request to add the authentication header.
  console.log('Interceptor ');
  if(authService.isAuthenticated){
    const newReq = req.clone({
      headers: req.headers.append('Authorization', 'Bearer '+authToken),

    });
    return next(newReq);
  }
  else{
    return next(req);
  }

};
