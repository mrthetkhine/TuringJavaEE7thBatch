import { CanActivateFn } from '@angular/router';
import {inject} from "@angular/core";
import {DummyAuthServiceService} from "../services/dummy-auth-service.service";

export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(DummyAuthServiceService);
  return authService.isAuth();
};
