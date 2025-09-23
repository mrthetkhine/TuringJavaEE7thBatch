import {CanActivateFn, Router, RouterStateSnapshot} from '@angular/router';
import {inject} from "@angular/core";
import {AuthService} from "../services/auth.service";

export const protectedGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router= inject(Router);


  console.log('Protected route ',route.url[0].path);
  if(authService.isAuthenticated)
  {
    return true;
  }
  else {
    router.navigate(['login'], {
      queryParams: { redirectUrl: route.url[0].path} });
    return false;
  }

};
