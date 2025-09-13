import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-movie-list-page',
  standalone: true,
  imports: [
    RouterOutlet
  ],
  templateUrl: './movie-list-page.component.html',
  styleUrl: './movie-list-page.component.css'
})
export class MovieListPageComponent {

}
