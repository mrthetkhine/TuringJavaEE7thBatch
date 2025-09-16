import {Component, inject, input} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-movie-ui',
  standalone: true,
  imports: [],
  templateUrl: './movie-ui.component.html',
  styleUrl: './movie-ui.component.css'
})
export class MovieUIComponent {
  router = inject(Router);
  movie =input.required<Movie>();


  goToMovieDetails() {
    this.router.navigate([`movies/${this.movie().id}`]);
  }
}
