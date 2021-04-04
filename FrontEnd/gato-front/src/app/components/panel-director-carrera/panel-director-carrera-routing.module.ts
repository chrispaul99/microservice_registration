import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PanelDirectorCarreraComponent } from './panel-director-carrera.component';
import { InicioDirCarreraComponent } from './inicio-dir-carrera/inicio-dir-carrera.component';
import { AutorizarMatriculaComponent } from './autorizar-matricula/autorizar-matricula.component';
import { ListarFormulariosComponent } from './listar-formularios/listar-formularios.component';

const routes: Routes = [{ path: '', component: PanelDirectorCarreraComponent, children: [
  { path: 'Autorizar_Matricula/:id', component: AutorizarMatriculaComponent },
  { path: 'Listar_Matriculas', component: ListarFormulariosComponent },
  { path: 'InicioDirCar', component: InicioDirCarreraComponent },
  { path: '', redirectTo: 'InicioDirCar', pathMatch: 'full' },
  { path: '**', redirectTo: 'InicioDirCar' }
]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PanelDirectorCarreraRoutingModule { }
