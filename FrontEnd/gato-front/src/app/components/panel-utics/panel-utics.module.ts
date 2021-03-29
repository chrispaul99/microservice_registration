import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelUticsRoutingModule } from './panel-utics-routing.module';
import { CrearEstudianteComponent } from './crear-estudiante/crear-estudiante.component';
import { InicioUticsComponent } from './inicio-utics/inicio-utics.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CrearEstudianteComponent,
    InicioUticsComponent
  ],
  imports: [
    CommonModule,
    PanelUticsRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class PanelUticsModule { }
