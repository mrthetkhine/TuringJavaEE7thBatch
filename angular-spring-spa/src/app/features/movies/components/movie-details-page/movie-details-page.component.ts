import {Component, inject} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-movie-details-page',
  standalone: true,
  imports: [],
  templateUrl: './movie-details-page.component.html',
  styleUrl: './movie-details-page.component.css'
})
export class MovieDetailsPageComponent {
    route = inject(ActivatedRoute);
    movieId: string ='';
    ngOnInit(): void {
      this.movieId = this.route.snapshot.paramMap?.get('id')!;
      // 'id' is the name of your route parameter as defined in your routing module
    }
}
