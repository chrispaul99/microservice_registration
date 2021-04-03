import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PanelEstudianteComponent } from './panel-estudiante.component';
import { PerfilEstudianteComponent } from './perfil-estudiante/perfil-estudiante.component';
import { InicioComponent } from './inicio/inicio.component';
import { MatricularseComponent } from './matricularse/matricularse.component';
import { FormularioManualComponent } from './formulario-manual/formulario-manual.component';

const routes: Routes = [{ path: '', component: PanelEstudianteComponent, children: [
  { path: 'Perfil_Estudiante', component: PerfilEstudianteComponent },
  { path: 'Matricula', component: MatricularseComponent },
  { path: 'Form_Manual', component: FormularioManualComponent },
  { path: 'Inicio', component: InicioComponent },
  { path: '', redirectTo: 'Inicio', pathMatch: 'full' },
  { path: '**', redirectTo: 'Inicio' }
]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PanelEstudianteRoutingModule { }
