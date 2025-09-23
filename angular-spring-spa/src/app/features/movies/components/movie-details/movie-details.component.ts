import {Component, input} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {MovieUIComponent} from "../movie-ui/movie-ui.component";
import {ActorUiComponent} from "../../../../core/components/actor-ui/actor-ui.component";
import {BsModalService} from "ngx-bootstrap/modal";
import {ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [
    MovieUIComponent,
    ActorUiComponent,
    ReactiveFormsModule,
  ],

  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  movie=input.required<Movie>();
}
