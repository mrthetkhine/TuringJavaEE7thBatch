import { Injectable } from '@angular/core';
import {Movie} from "../model/movie.model";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  _movies: Movie[] = [
    {
      "id": "68a1dcd355cff54a490a5d8f",
      "name": "Titanic",
      "year": 2020,
      "director": "James Cameron",
      "details": "Drama of sinking ship",
      "genres": [
        "Drama"
      ],
      "actors": [
        {
          "id": "68a083e9a3ee5ecf75cc1a0b",
          "firstName": "Leonardo",
          "lastName": "Decaprio",
          "gender": "Male"
        },
        {
          "id": "68a0845ef589a3b9b1ac36c2",
          "firstName": "Kate",
          "lastName": "Winselect",
          "gender": "Female"
        }
      ]
    },
    {
      "id": "68a47945ddc8cb87043e21dd",
      "name": "Insepection",
      "year": 2005,
      "director": "Christopher Nolan",
      "details": "Dream about dream",
      "genres": [
        "Scifi"
      ],
      "actors": [
        {
          "id": "68a083e9a3ee5ecf75cc1a0b",
          "firstName": "Leonardo",
          "lastName": "Decaprio",
          "gender": "Male"
        }
      ]
    },
  ];
  constructor() { }


  get movies() {
    return this._movies;
  }
}
