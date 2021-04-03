import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelEstudianteRoutingModule } from './panel-estudiante-routing.module';
import { PerfilEstudianteComponent } from './perfil-estudiante/perfil-estudiante.component';
import { InicioComponent } from './inicio/inicio.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatricularseComponent } from './matricularse/matricularse.component';
import { FormularioManualComponent } from './formulario-manual/formulario-manual.component';


@NgModule({
  declarations: [
    PerfilEstudianteComponent,
    InicioComponent,
    MatricularseComponent,
    FormularioManualComponent
  ],
  imports: [
    CommonModule,
    PanelEstudianteRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class PanelEstudianteModule { }
