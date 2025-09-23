import { Routes } from '@angular/router';
import {MovieListPageComponent} from "./features/movies/components/movie-list-page/movie-list-page.component";
import {MovieDetailsPageComponent} from "./features/movies/components/movie-details-page/movie-details-page.component";
import {LoginPageComponent} from "./features/auth/components/login-page/login-page.component";
import {HomePageComponent} from "./features/home/components/home-page/home-page.component";
import {protectedGuard} from "./core/guard/protected.guard";
import {LogoutComponent} from "./features/auth/components/logout/logout.component";
import {ActorListPageComponent} from "./features/actors/components/actor-list-page/actor-list-page.component";
import {ActorDetailsPageComponent} from "./features/actors/components/actor-details-page/actor-details-page.component";

export const routes: Routes = [
  {
    path: '',
    component:HomePageComponent,
  },
  {
    path: 'movies',
    component:MovieListPageComponent,
    canActivate:[protectedGuard]
  },
  {
    path: 'movies/:id',
    component:MovieDetailsPageComponent,
    canActivate:[protectedGuard]
  },
  {
    path: 'actors',
    component:ActorListPageComponent,
    canActivate:[protectedGuard]
  },
  {
    path: 'actors/:id',
    component:ActorDetailsPageComponent,
    canActivate:[protectedGuard]
  },
  {
    path: 'login',
    component:LoginPageComponent,
  },
  {
    path: 'logout',
    component:LogoutComponent,
    canActivate:[protectedGuard]
  },

];
