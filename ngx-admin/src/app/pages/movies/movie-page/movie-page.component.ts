import { Component } from '@angular/core';
import {LocalDataSource} from "ng2-smart-table";
import {SmartTableData} from "../../../@core/data/smart-table";
import {MovieService} from "../../../@core/services/movie.service";
import {Movie} from "../../../@core/model/movie.model";
import {NbComponentStatus} from "@nebular/theme";
import {MessageService} from "../../../@core/services/message.service";

@Component({
  selector: 'ngx-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrls: ['./movie-page.component.scss']
})
export class MoviePageComponent {
  settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
      confirmCreate: true,
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
      confirmSave: true,
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    columns: {
      name: {
        title: 'Name',
        type: 'string',
      },
      year: {
        title: 'Year',
        type: 'number',
      },
      director: {
        title: 'Director',
        type: 'string',
      },
      details: {
        title: 'Details',
        type: 'string',
      },

    },
  };
  movies:Movie[]=[];
  source: LocalDataSource = new LocalDataSource();

  constructor(private movieService: MovieService,
  private messageService: MessageService) {


  }
  ngOnInit() {
    this.movieService.movies.subscribe(data=>{
      this.movies = data;
      this.source.load(data);
    });
    this.movieService.loadAllMovies();
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      console.log('Delete Event ',event);
      this.movieService.deleteMovie(event.data?.id,()=>{
        event.confirm.resolve();
        this.messageService.showToast('primary','Success','Movie deleted successfully');
      });

    } else {
      event.confirm.reject();
    }
  }
  onCreate(event:any){
    console.log('on Create ',event);
  }
  onCreateConfirm(event:any): void {
    console.log('Create ',event.newData);
    const movie:Movie = event.newData as any;
    movie.genres = [];
    this.movieService.saveMovie(movie,()=>{
      this.messageService.showToast('primary','Success','Movie saved successfully');
    });
  }
  onEditConfirm(event:any){
    console.log('on Edit ',event);
    const movie:Movie = event.newData as any;
    this.movieService.updateMovie(movie,()=>{
      console.log('Movie update successfully ');
      this.messageService.showToast('primary','Success','Movie update successfully');
    });
  }

}
