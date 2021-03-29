import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PanelUticsComponent } from './panel-utics.component';
import { InicioUticsComponent } from './inicio-utics/inicio-utics.component';
import { CrearEstudianteComponent } from './crear-estudiante/crear-estudiante.component';

const routes: Routes = [{ path: '', component: PanelUticsComponent, children: [
  { path: 'Crear_Nuevo_Estudiante', component: CrearEstudianteComponent },
  { path: 'InicioUtics', component: InicioUticsComponent },
  { path: '', redirectTo: 'InicioUtics', pathMatch: 'full' },
  { path: '**', redirectTo: 'InicioUtics' }
]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PanelUticsRoutingModule { }
