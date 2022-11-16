import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { ReleasesModule } from './releases/releases.module';
import { PersonModule } from 'src/person/person.module';
import { CoreModule } from 'src/core/core.module';




@NgModule({
  declarations: [
    AppComponent,


  ],
  imports: [
    BrowserModule,

    CoreModule,
    ReleasesModule,
    PersonModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
