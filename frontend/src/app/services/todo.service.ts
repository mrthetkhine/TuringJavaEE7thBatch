import {inject, Injectable} from '@angular/core';
import {Todo} from "../models/todo";
import {HttpClient} from "@angular/common/http";

const API_URL = "https://jsonplaceholder.typicode.com"

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  http = inject(HttpClient);

  items :Todo[] = [
    /*{
      "userId": 1,
      "id": 1,
      "title": "delectus aut autem",
      "completed": false
    },
    {
      "userId": 1,
      "id": 2,
      "title": "quis ut nam facilis et officia qui",
      "completed": false
    },
    {
      "userId": 1,
      "id": 3,
      "title": "fugiat veniam minus",
      "completed": false
    },
    {
      "userId": 1,
      "id": 4,
      "title": "et porro tempora",
      "completed": true
    },
    {
      "userId": 1,
      "id": 5,
      "title": "laboriosam mollitia et enim quasi adipisci quia provident illum",
      "completed": false
    },
    {
      "userId": 1,
      "id": 6,
      "title": "qui ullam ratione quibusdam voluptatem quia omnis",
      "completed": false
    },*/
  ];
  constructor() { }

  loadAllTodo()
  {
    return this.http.get<Todo[]>(API_URL+'/todos');
  }
  deleteTodo(todoId:number)
  {
    return this.http.delete<Todo>(API_URL+`/todos/${todoId}`)
  }
  getAllTodos():Todo[]
  {
    return this.items;
  }
}
