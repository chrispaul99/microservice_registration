import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelUarRoutingModule } from './panel-uar-routing.module';
import { InicioUarComponent } from './inicio-uar/inicio-uar.component';
import { SubirInstructivoUarComponent } from './subir-instructivo-uar/subir-instructivo-uar.component';
import { SubirCronMatriculasComponent } from './subir-cron-matriculas/subir-cron-matriculas.component';
import { CrearPeriodoComponent } from './crear-periodo/crear-periodo.component';
import { MatricularPrimerNivelComponent } from './matricular-primer-nivel/matricular-primer-nivel.component';
import { RegistrarMatriculaComponent } from './registrar-matricula/registrar-matricula.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    InicioUarComponent,
    SubirInstructivoUarComponent,
    SubirCronMatriculasComponent,
    CrearPeriodoComponent,
    MatricularPrimerNivelComponent,
    RegistrarMatriculaComponent
  ],
  imports: [
    CommonModule,
    PanelUarRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class PanelUarModule { }
