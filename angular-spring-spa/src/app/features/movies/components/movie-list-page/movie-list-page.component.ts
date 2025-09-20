import {Component, inject, TemplateRef} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {MovieUIComponent} from "../movie-ui/movie-ui.component";
import {ActivatedRoute, Router} from "@angular/router";
import {BsModalRef, BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {FormArray, FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {MovieService} from "../../../../core/services/movie.service";

@Component({
  selector: 'app-movie-list-page',
  standalone: true,

  imports: [
    MovieUIComponent,
    ModalModule,
    ReactiveFormsModule,
  ],
  providers: [BsModalService],
  templateUrl: './movie-list-page.component.html',
  styleUrl: './movie-list-page.component.css'
})
export class MovieListPageComponent {
  modalRef?: BsModalRef;
  modalService = inject(BsModalService);

  private formBuilder = inject(FormBuilder);
  router = inject(Router);
  movieService = inject(MovieService);

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

  openModal(template: TemplateRef<void>) {
    this.modalRef = this.modalService.show(template,{ class: 'modal-lg' });
  }

  movieForm = this.formBuilder.group({
    title: ['', [
      Validators.required
    ]
    ],
    year: ['',[
      Validators.required
    ]
    ],
    director: ['',[
      Validators.required,
    ]
    ],
    details: ['',[
      Validators.required
    ]
    ],
    genres: this.formBuilder.array([this.formBuilder.control('',[Validators.required])]),
  });

  get title()
  {
    return this.movieForm.get('title');
  }
  get year()
  {
    return this.movieForm.get('year');
  }
  get director()
  {
    return this.movieForm.get('director');
  }
  get details()
  {
    return this.movieForm.get('details');
  }
  get genres()
  {
    return this.movieForm.get('genres') as FormArray;
  }
  addGenre()
  {
    this.genres.push(this.formBuilder.control('',[Validators.required]));
  }
  removeGenre(index:number)
  {
    this.genres.removeAt(index);
  }

  onSubmit()
  {
    console.log('Movie form value ',this.movieForm.value);
  }
}
