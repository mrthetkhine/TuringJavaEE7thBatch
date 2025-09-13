import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  constructor() {
    console.log('Logger service created');
  }
  log(message: string): void {
    console.log(message);
  }
  error(message: string): void {
    console.error(message);
  }
  warn(message: string): void {
    console.error(message);
  }
}
