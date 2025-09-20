import {Component, input} from '@angular/core';
import {Actor} from "../../model/actor.model";

@Component({
  selector: 'app-actor-ui',
  standalone: true,
  imports: [],
  templateUrl: './actor-ui.component.html',
  styleUrl: './actor-ui.component.css'
})
export class ActorUiComponent {
  actor = input.required<Actor>();
}
