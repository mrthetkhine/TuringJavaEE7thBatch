import {inject, Injectable} from '@angular/core';
import {Movie} from "../model/movie.model";
import { HttpClient } from '@angular/common/http';
import {BehaviorSubject} from "rxjs";
import {API_URL} from "../Config";
import {ApiResponse} from "../model/api-response.model";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  http = inject(HttpClient);
  moviesData:Movie[]=[];//store Review data

  moviesSubject = new BehaviorSubject<Movie[]>(this.moviesData);
  _movies = this.moviesSubject.asObservable();


  get movies()
  {
    return this._movies;
  }
  loadAllMovies(): void
  {
    this.http.get<ApiResponse<Movie[]>>(API_URL+'/api/movies')
      .subscribe(response=>{
        this.moviesData = response.data;
        this.moviesData.forEach((movie:Movie) => {
          movie.details = (movie.details as any).details;
        })
        this.moviesSubject.next(this.moviesData);
      },error => {
        console.log(error);
      });
  }
}
