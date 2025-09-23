import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthUser} from "../model/auth-user.model";
import {ApiResponse} from "../model/api-response.model";
import {Movie} from "../model/movie.model";
import {API_URL} from "../Config";
import {AuthResponse} from "../model/auth-response.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  http = inject(HttpClient);
  token:string= '';

  get isAuthenticated(){
    return !!this.token;
  }
  login(authUser:AuthUser, successCallback:()=>void,errorCallback:()=>void) {
    this.http.post<ApiResponse<AuthResponse>>(API_URL+'/api/login',authUser)
            .subscribe(response=>{
              this.token = response.data.token;
              console.log('Login success ',response);
              successCallback();
            },error => {
              console.log(error);
              errorCallback();
            });
  }
  logout(){
    this.token='';
  }
}
