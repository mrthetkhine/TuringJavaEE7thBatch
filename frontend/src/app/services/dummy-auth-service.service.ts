import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DummyAuthServiceService {

  authenticated = false;
  constructor() { }

  isAuth()
  {
    return this.authenticated;
  }
  login()
  {
    this.authenticated = true;
  }
}
