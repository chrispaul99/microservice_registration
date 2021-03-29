import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PanelVicerectorComponent } from './panel-vicerector.component';
import { InicioVicerectorComponent } from './inicio-vicerector/inicio-vicerector.component';
import { RevisarInstructivoComponent } from './revisar-instructivo/revisar-instructivo.component';
import { ListarInstructivosComponent } from './listar-instructivos/listar-instructivos.component';

const routes: Routes = [{ path: '', component: PanelVicerectorComponent, children: [
  { path: 'Revisar/:id', component: RevisarInstructivoComponent },
  { path: 'Listar_Instructivos', component: ListarInstructivosComponent },
  { path: 'InicioVice', component: InicioVicerectorComponent },
  { path: '', redirectTo: 'InicioVice', pathMatch: 'full' },
  { path: '**', redirectTo: 'InicioVice' }
]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PanelVicerectorRoutingModule { }
