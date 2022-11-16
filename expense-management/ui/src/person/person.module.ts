import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonRegistrationComponent } from './person-registration/person-registration.component';
import { PersonSearchComponent } from './person-search/person-search.component';
import { PersonGridComponent } from './person-grid/person-grid.component';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { InputMaskModule } from 'primeng/inputmask';
import { SharedModule } from 'src/shared/shared.module';




@NgModule({
  declarations: [
    PersonRegistrationComponent,
    PersonSearchComponent,
    PersonGridComponent
  ],
  imports: [
    CommonModule,

    FormsModule,

    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    InputMaskModule,

    SharedModule
  ],
  exports: [
    PersonRegistrationComponent,
    PersonSearchComponent
  ]
})
export class PersonModule { }
