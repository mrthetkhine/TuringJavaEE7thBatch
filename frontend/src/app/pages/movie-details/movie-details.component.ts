import {Component, inject} from '@angular/core';
import {FormArray, FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  private formBuilder = inject(FormBuilder);
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
