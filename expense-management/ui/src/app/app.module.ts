import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {TabViewModule} from 'primeng/tabview';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {TooltipModule} from 'primeng/tooltip';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchLaunchComponent } from './search-launch/search-launch.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchPeopleComponent } from './search-people/search-people.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchLaunchComponent,
    NavbarComponent,
    SearchPeopleComponent
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
