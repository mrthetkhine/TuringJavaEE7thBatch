import {Component, inject, input} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {MovieUIComponent} from "../movie-ui/movie-ui.component";
import {ActorUiComponent} from "../../../../core/components/actor-ui/actor-ui.component";
import {BsModalService} from "ngx-bootstrap/modal";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ActorService} from "../../../../core/services/actor.service";
import {Actor} from "../../../../core/model/actor.model";
import {MovieService} from "../../../../core/services/movie.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [
    MovieUIComponent,
    ActorUiComponent,
    ReactiveFormsModule,
    FormsModule,
  ],

  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  movie=input.required<Movie>();
  actorService = inject(ActorService);
  movieService = inject(MovieService);

  actors:Actor[] =[];
  selectedActorId:string='';

  ngOnInit() {
    this.actorService.actors.subscribe(actor => {
      this.actors = actor;
    });
    this.actorService.loadAllActors();
  }
  assignActorToMovie()
  {
    console.log('assign Actor id ',this.selectedActorId);
    this.movieService.assignActorToMovie(this.movie().id, this.selectedActorId,(movie:Movie)=>{
      this.movie().actors = movie.actors;
      Swal.fire({
        title: 'Success!',
        icon: "success",
        titleText: 'Actor successfully assigned to movie',
        confirmButtonText: 'Ok'
      });
    });
  }
}
