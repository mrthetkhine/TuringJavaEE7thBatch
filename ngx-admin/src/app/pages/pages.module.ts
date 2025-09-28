import { NgModule } from '@angular/core';
import {NbButtonModule, NbCardModule, NbCheckboxModule, NbInputModule, NbMenuModule} from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { LoginPageComponent } from './auth/components/login-page/login-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NbSharedModule} from "@nebular/theme/components/shared/shared.module";
import { MoviePageComponent } from './movies/movie-page/movie-page.component';
import {Ng2SmartTableModule} from "ng2-smart-table";

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    DashboardModule,
    ECommerceModule,
    MiscellaneousModule,
    FormsModule,
    NbButtonModule,
    NbCardModule,
    NbCheckboxModule,
    NbInputModule,
    ReactiveFormsModule,
    Ng2SmartTableModule,

  ],
  declarations: [
    PagesComponent,
    LoginPageComponent,
    MoviePageComponent,
  ],
})
export class PagesModule {
}
