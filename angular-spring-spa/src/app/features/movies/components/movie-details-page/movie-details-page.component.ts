import {Component, inject, viewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Movie} from "../../../../core/model/movie.model";
import {MovieDetailsComponent} from "../movie-details/movie-details.component";
import {MovieNewFormDialogComponent} from "../movie-new-form-dialog/movie-new-form-dialog.component";
import {MovieService} from "../../../../core/services/movie.service";
import {BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-movie-details-page',
  standalone: true,
  imports: [
    MovieDetailsComponent,
    MovieNewFormDialogComponent,
    ModalModule,
    ReactiveFormsModule,
  ],
  providers: [BsModalService],
  templateUrl: './movie-details-page.component.html',
  styleUrl: './movie-details-page.component.css'
})
export class MovieDetailsPageComponent {
    router = inject(Router);
    route = inject(ActivatedRoute);
    movieService= inject(MovieService);
    movieId: string ='';

    movieNewFormDlg = viewChild<MovieNewFormDialogComponent>('movieNewFormDlg');
    movie!:Movie;


    ngOnInit(): void {
      this.movieId = this.route.snapshot.paramMap?.get('id')!;
      this.movie = this.movieService.getMovieById(this.movieId)!;
      // 'id' is the name of your route parameter as defined in your routing module
    }
  goToMoviesPage()
  {
    this.router.navigate(['movies']);
  }
  updateMovieCallBack(updatedMovie: Movie){
      this.movie = updatedMovie;
  }
  showEditMovieModal(){
      this.movieNewFormDlg()?.showEditDialog(this.updateMovieCallBack.bind(this));
  }
}
