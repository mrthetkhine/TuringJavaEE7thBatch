import {Component, inject, input, TemplateRef, viewChild} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import Swal from "sweetalert2";
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";

@Component({
  selector: 'app-movie-new-form-dialog',
  standalone: true,
    imports: [
        FormsModule,
        ReactiveFormsModule,

    ],
  templateUrl: './movie-new-form-dialog.component.html',
  styleUrl: './movie-new-form-dialog.component.css'
})
export class MovieNewFormDialogComponent {
  modalRef?: BsModalRef;
  modalService = inject(BsModalService);
  movieService = inject(MovieService);
  private formBuilder = inject(FormBuilder);
  movieFormDlg = viewChild<TemplateRef<void>>('movieFormDlg');

  editMovie = input<Movie>();
  updateMovieCallBack?:(updatedMovie:Movie) => void;
  movieForm = this.formBuilder.group({
    name: ['', [
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
  openModal(template: TemplateRef<void>) {
    this.modalRef = this.modalService.show(template,{ class: 'modal-lg' });
  }
  showEditDialog(updateMovieCallBack:(updatedMovie:Movie) => void)
  {
    this.openModal(this.movieFormDlg()!);
    if(this.editMovie())
    {
      console.log('Show Edit Movie');
      this.populateEditMovieForm();
    }
    this.updateMovieCallBack = updateMovieCallBack;
  }
  showDialog()
  {
    this.openModal(this.movieFormDlg()!);

  }
  populateEditMovieForm()
  {
    const movie = this.editMovie()!;

    const genresArr:FormArray<FormControl<string|null>> = this.formBuilder.array<string|null>([]);
    for(const genre of movie.genres)
    {
      genresArr.push(this.formBuilder.control(genre,[Validators.required]));
    }
    this.movieForm.patchValue({
      name : movie.name,
      year : movie.year+'',
      director: movie.director,
      details: movie.details,
    });
    this.movieForm.controls.genres = genresArr;
  }

  ngOnChanges(): void {
    //console.log('NgOnChange ',this.movieForm);
    //console.log('EditMovie ',this.editMovie());
  }


  get name()
  {
    return this.movieForm.get('name');
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
    if(this.editMovie())//Update
    {
      this.updateMovie();
    }
    else
    {
      this.saveMovie();
    }


  }

  private updateMovie() {
    const movieToUpdate: any = {
      ...this.editMovie(),//id,actors
      ...this.movieForm.value,
    }
    console.log('Movie to update ',movieToUpdate);
    this.movieService.updateMovie(movieToUpdate, (updateMovie:Movie) => {
      Swal.fire({
        title: 'Success!',
        icon: "success",
        titleText: 'Movie updated successfully',
        confirmButtonText: 'Ok'
      });
      this.updateMovieCallBack?.(updateMovie);
      this.modalRef?.hide();

    });
  }

  private saveMovie() {
    this.movieService.saveMovie(this.movieForm.value as any, () => {

      this.modalRef?.hide();
      Swal.fire({
        title: 'Success!',
        icon: "success",
        titleText: 'Movie saved successfully',
        confirmButtonText: 'Ok'
      });

      this.movieForm.reset();
    });
  }
}
