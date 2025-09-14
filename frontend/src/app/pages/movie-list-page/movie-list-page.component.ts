import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {Movie} from "../../models/movie";
import {FormGroup, FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-movie-list-page',
  standalone: true,
  imports: [
    RouterOutlet,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
  ],
  templateUrl: './movie-list-page.component.html',
  styleUrl: './movie-list-page.component.css'
})
export class MovieListPageComponent {
  movie : Movie = new Movie(0,'',0,'',['Drama']);

  addNewGenre()
  {
    this.movie.genres.push('');
  }
  removeGenre(index:number){
    this.movie.genres.splice(index,1);
  }
  onSubmit(movieForm: NgForm){
    //console.log('Movie Form ',movieForm.value);
    console.log('Movie ',this.movie);
  }
}
