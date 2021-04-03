import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PanelUarComponent } from './panel-uar.component';
import { InicioUarComponent } from './inicio-uar/inicio-uar.component';
import { CrearPeriodoComponent } from './crear-periodo/crear-periodo.component';
import { MatricularPrimerNivelComponent } from './matricular-primer-nivel/matricular-primer-nivel.component';
import { RegistrarMatriculaComponent } from './registrar-matricula/registrar-matricula.component';
import { SubirCronMatriculasComponent } from './subir-cron-matriculas/subir-cron-matriculas.component';
import { SubirInstructivoUarComponent } from './subir-instructivo-uar/subir-instructivo-uar.component';

const routes: Routes = [{ path: '', component: PanelUarComponent, children: [
  { path: 'Crear_Periodo', component: CrearPeriodoComponent },
  { path: 'Matricula_Primer_Nivel', component: MatricularPrimerNivelComponent },
  { path: 'Registrar_Matricula', component: RegistrarMatriculaComponent },
  { path: 'Cronograma', component: SubirCronMatriculasComponent },
  { path: 'Instructivo', component: SubirInstructivoUarComponent },
  { path: 'InicioUAR', component: InicioUarComponent },
  { path: '', redirectTo: 'InicioUAR', pathMatch: 'full' },
  { path: '**', redirectTo: 'InicioUAR' }
]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PanelUarRoutingModule { }
