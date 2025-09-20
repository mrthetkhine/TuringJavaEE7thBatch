import {Component, inject} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Movie} from "../../../../core/model/movie.model";
import {MovieDetailsComponent} from "../movie-details/movie-details.component";

@Component({
  selector: 'app-movie-details-page',
  standalone: true,
  imports: [
    MovieDetailsComponent,
  ],
  templateUrl: './movie-details-page.component.html',
  styleUrl: './movie-details-page.component.css'
})
export class MovieDetailsPageComponent {
    route = inject(ActivatedRoute);
    movieId: string ='';

    movie:Movie = {
      "id": "68a1dcd355cff54a490a5d8f",
      "name": "Titanic",
      "year": 2020,
      "director": "James Cameron",
      "details": "Drama of sinking ship",
      "genres": [
        "Drama"
      ],
      "actors": [
        {
          "id": "68a083e9a3ee5ecf75cc1a0b",
          "firstName": "Leonardo",
          "lastName": "Decaprio",
          "gender": "Male"
        },
        {
          "id": "68a0845ef589a3b9b1ac36c2",
          "firstName": "Kate",
          "lastName": "Winselect",
          "gender": "Female"
        }
      ]
    };
    ngOnInit(): void {
      this.movieId = this.route.snapshot.paramMap?.get('id')!;
      // 'id' is the name of your route parameter as defined in your routing module
    }
}
