import { Routes } from '@angular/router';
import {HomePageComponent} from "./pages/home-page/home-page.component";
import {AdminPageComponent} from "./pages/admin-page/admin-page.component";
import {UserComponent} from "./components/user/user.component";
import {NotFoundPageComponent} from "./pages/not-found-page/not-found-page.component";
import {NewUserComponent} from "./pages/new-user/new-user.component";
import {MovieListPageComponent} from "./pages/movie-list-page/movie-list-page.component";
import {MovieDetailsComponent} from "./pages/movie-details/movie-details.component";
import {MovieEditPageComponent} from "./pages/movie-edit-page/movie-edit-page.component";
import {authGuard} from "./guards/auth.guard";
import {LoginPageComponent} from "./pages/login-page/login-page.component";
import {userResolver} from "./resolver/user.resolver";
import {TodoListComponent} from "./components/todo-list/todo-list.component";

export const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: 'home',
    redirectTo: '',
  },
  {
    path: 'super',
    redirectTo: 'admin',
  },
  {
    path: 'login',
    component: LoginPageComponent,
  },
  {
    path: 'admin',
    component: AdminPageComponent,
    canActivate:[authGuard],
    title: 'Admin'
  },
  {
    path: 'heavy',
    loadComponent: () => import('./pages/heavy-component/heavy-component.component').then(m=>m.HeavyComponentComponent),
    //component: NewUserComponent,
  },
  {
    path: 'todos',
    component: TodoListComponent,
  },
  {
    path: 'users/new',
    component: NewUserComponent,
  },
  {
    path: 'users/:id',
    component: UserComponent,
    data: { analyticsId: '456' },
    resolve: {
      user: userResolver,

    }
  },
  {
    path: 'movies',
    component: MovieListPageComponent,
    /*children:[
      {
        path: 'edit/:id',
        component: MovieEditPageComponent,
      },
      {
        path: ':id',
        component: MovieDetailsComponent,
      }
    ]*/
  },
  {
    path: 'movies/:id',
    component: MovieDetailsComponent,
  },
  {
    path: 'movies/edit/:id',
    component: MovieEditPageComponent,
  },
  {
    path: '**',
    component: NotFoundPageComponent,
  },
];
