import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelDirectorRoutingModule } from './panel-director-routing.module';
import { PanelDirectorComponent } from './panel-director.component';
import { InicioDirectorComponent } from './inicio-director/inicio-director.component';
import { CrearMateriaComponent } from './crear-materia/crear-materia.component';
import { ActualizarMateriaComponent } from './actualizar-materia/actualizar-materia.component';
import { ListarMateriasComponent } from './listar-materias/listar-materias.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    InicioDirectorComponent,
    CrearMateriaComponent,
    ActualizarMateriaComponent,
    ListarMateriasComponent
  ],
  imports: [
    CommonModule,
    PanelDirectorRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class PanelDirectorModule { }
