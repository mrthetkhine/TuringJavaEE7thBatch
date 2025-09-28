import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs";
import {Actor} from "../model/actor.model";
import {ApiResponse} from "../model/api-response.model";
import {API_URL} from "../Config";
import {Callback} from "../model/common.model";

@Injectable({
  providedIn: 'root'
})
export class ActorService {

  http = inject(HttpClient);
  actorsData:Actor[]=[];//store Review data

  actorSubject = new BehaviorSubject<Actor[]>(this.actorsData);
  _actors = this.actorSubject.asObservable();


  get actors()
  {
    return this._actors;
  }
  loadAllActors(): void
  {
    this.http.get<ApiResponse<Actor[]>>(API_URL+'/api/actors')
      .subscribe(response=>{
        this.actorsData = response.data;

        this.actorSubject.next(this.actorsData);
      },error => {
        console.log(error);
      });
  }
  saveActor(actor:Actor, successCallback:Callback){

    console.log('save actor ', actor);
    this.http.post<ApiResponse<Actor>>(API_URL+'/api/actors',actor)
      .subscribe(response=>{
        const savedActor = response.data;

        this.actorsData.push(savedActor);
        this.actorSubject.next(this.actorsData);

        successCallback();
      },error => {
        console.log(error);
      });
  }
}
