import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {Todo} from "../models/todo";
const API_URL = "https://jsonplaceholder.typicode.com";

@Injectable({
  providedIn: 'root'
})

export class ReactiveTodoService {
  http = inject(HttpClient);
  todosData:Todo[]=[];//store Review data

  todosSubject = new BehaviorSubject<Todo[]>(this.todosData);
  _todos = this.todosSubject.asObservable();

  get todos()
  {
    return this._todos;
  }
  loadAllTodos()
  {
    this.http.get<Todo[]>(API_URL+'/todos')
      .subscribe(data=>{
        this.todosData = data;
        this.todosSubject.next(this.todosData);
      });
  }
  deleteTodo(todoId:number)
  {
    this.http.delete<Todo>(API_URL+`/todos/${todoId}`)
    .subscribe(data=>{
      this.todosData = this.todosData.filter(td=>td.id !== todoId);
      this.todosSubject.next(this.todosData);
    })

  }
}
