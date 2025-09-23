import {Component, inject, TemplateRef, viewChild} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {MovieUIComponent} from "../movie-ui/movie-ui.component";
import {ActivatedRoute, Router} from "@angular/router";
import {BsModalRef, BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {FormArray, FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {MovieService} from "../../../../core/services/movie.service";
import Swal from 'sweetalert2';
import {MovieNewFormDialogComponent} from "../movie-new-form-dialog/movie-new-form-dialog.component";
@Component({
  selector: 'app-movie-list-page',
  standalone: true,

  imports: [
    MovieUIComponent,
    ModalModule,
    ReactiveFormsModule,
    MovieNewFormDialogComponent,
  ],
  providers: [BsModalService],
  templateUrl: './movie-list-page.component.html',
  styleUrl: './movie-list-page.component.css'
})
export class MovieListPageComponent {

  router = inject(Router);
  movieService = inject(MovieService);
  movieNewFormDlg = viewChild<MovieNewFormDialogComponent>('movieNewFormDlg');

  movies: Movie[] = [

  ];
  ngOnInit() {
    this.movieService.movies.subscribe(data=>{
      this.movies = data;
    });
    this.movieService.loadAllMovies();
  }
  goToMovieDetails(movie:Movie) {
    this.router.navigate([`movies/${movie.id}`]);
  }
  openMovieNewForm()
  {
    console.log('Open New movie dlg',this.movieNewFormDlg());
    this.movieNewFormDlg()?.showDialog();
  }

  showDeleteConfirmDlg(movie:Movie){
    console.log('Delete ',movie);
    Swal.fire({
      title: "Are you sure?",
      text: "You want to delete the movie? named "+movie.name,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes"
    }).then((result) => {
      if (result.isConfirmed) {
        console.log('Delete confirm ');
        this.deleteMovie(movie);

      }
    });
  }
  deleteMovie(movie:Movie){
    this.movieService.deleteMovie(movie.id,()=>{
      Swal.fire({
        title: "Deleted!",
        text: "Your file has been deleted.",
        icon: "success"
      })
    });

  }
}
