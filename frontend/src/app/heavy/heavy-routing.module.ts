import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LazyPageComponent} from "./lazy-page/lazy-page.component";

const routes: Routes = [
  {
    path: 'heavy',
    component:LazyPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HeavyRoutingModule { }
