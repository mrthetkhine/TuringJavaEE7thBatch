import {Actor} from "./actor.model";

export interface Movie {
  id:string;
  name: string;
  year: number;
  director: string;
  genres: string[];
  details: string;
  actors:Actor[];
  createdAt?: Date;
}
