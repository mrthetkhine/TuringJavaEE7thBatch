import { Routes } from '@angular/router';
import {MovieListPageComponent} from "./features/movies/components/movie-list-page/movie-list-page.component";
import {MovieDetailsPageComponent} from "./features/movies/components/movie-details-page/movie-details-page.component";

export const routes: Routes = [
  {
    path: 'movies',
    component:MovieListPageComponent,
  },
  {
    path: 'movies/:id',
    component:MovieDetailsPageComponent,
  }
];
