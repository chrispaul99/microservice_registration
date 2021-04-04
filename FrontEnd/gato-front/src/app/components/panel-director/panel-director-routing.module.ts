import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PanelDirectorComponent } from './panel-director.component';
import { InicioDirectorComponent } from './inicio-director/inicio-director.component';
import { CrearMateriaComponent } from './crear-materia/crear-materia.component';
import { ListarMateriasComponent } from './listar-materias/listar-materias.component';

const routes: Routes = [{ path: '', component: PanelDirectorComponent, children: [
  { path: 'Crear_Materia', component: CrearMateriaComponent },
  { path: 'Listar_Materias', component: ListarMateriasComponent },
  { path: 'InicioDir', component: InicioDirectorComponent },
  { path: '', redirectTo: 'InicioDir', pathMatch: 'full' },
  { path: '**', redirectTo: 'InicioDir' }
]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PanelDirectorRoutingModule { }
