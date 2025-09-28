import {inject, Injectable} from '@angular/core';
import { Movie} from "../model/movie.model";
import { HttpClient } from '@angular/common/http';
import {BehaviorSubject} from "rxjs";
import {API_URL} from "../Config";
import {ApiResponse} from "../model/api-response.model";
import {Callback} from "../model/common.model";

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
  getMovieById(id:string):Movie{
    return <Movie>this.moviesData.find(movie => movie.id == id);
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
  saveMovie(movie:Movie, successCallback:Callback){
    let body:any = {
      ... movie,
      details:{
        details:movie.details,
      }
    };
    console.log('save movie ', body);
    this.http.post<ApiResponse<Movie>>(API_URL+'/api/movies',body)
      .subscribe(response=>{
        const movie = response.data;
        movie.details = (movie.details as any).details;
        this.moviesData.push(movie);
        this.moviesSubject.next(this.moviesData);

        successCallback();
      },error => {
        console.log(error);
      });
  }
  updateMovie(movie:Movie, successCallback:(updateMovie:Movie) => void){
    let body = {
      ... movie,
      details:{
        details:movie.details,
      }
    }
    this.http.put<ApiResponse<Movie>>(API_URL+`/api/movies/${movie.id}`,body)
          .subscribe(response=>{
            const updateMovie = response.data;

            updateMovie.details = (updateMovie.details as any).details;
            this.moviesData = this.moviesData.map(movie => movie.id !== updateMovie.id?updateMovie:movie);
            this.moviesSubject.next(this.moviesData);

            successCallback(updateMovie);
          });
  }
  deleteMovie(movieId:string,successCallback:Callback){
    this.http.delete<ApiResponse<Movie>>(API_URL+`/api/movies/${movieId}`)
    .subscribe(response=>{
      const movie = response.data;
      this.moviesData = this.moviesData.filter(movie => movie.id !== movieId);
      this.moviesSubject.next(this.moviesData);

      successCallback();
    })
  }
  assignActorToMovie(movieId:string,actorId:string,successCallback:(movie:Movie)=>void)
  {
    this.http.post<ApiResponse<Movie>>(API_URL+`/api/movies/${movieId}/assignment/actors/${actorId}`,{})
      .subscribe(response=>{
        const movie = response.data;
        successCallback(movie);
      })
  }
}
