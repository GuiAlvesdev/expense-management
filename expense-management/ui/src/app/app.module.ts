import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {TabViewModule} from 'primeng/tabview';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {TooltipModule} from 'primeng/tooltip';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LaunchRegistrationComponent } from './launch-registration/launch-registration.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LaunchRegistrationComponent,
  ],
  imports: [
    BrowserModule,

    ButtonModule,
    InputTextModule,
    TableModule,
    TabViewModule,
    TooltipModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
