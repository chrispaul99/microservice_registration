import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'Login', component: LoginComponent },
  { path: 'panelEstudiante', loadChildren: () =>
  import('./components/panel-estudiante/panel-estudiante.module')
  .then(m => m.PanelEstudianteModule), /*canActivate: [ AuthGuard ] ,*/ data: { permittedRoles: ['U'] } },
  { path: 'panelUar', loadChildren: () => import('./components/panel-uar/panel-uar.module').then(m => m.PanelUarModule) },
  { path: '', redirectTo: '', pathMatch: 'full' },
  { path: 'panelVicerector', loadChildren: () =>
  import('./components/panel-vicerector/panel-vicerector.module').then(m => m.PanelVicerectorModule) },
  { path: 'panelDirector', loadChildren: () =>
  import('./components/panel-director/panel-director.module').then(m => m.PanelDirectorModule) },
  { path: 'panelUtics', loadChildren: () => import('./components/panel-utics/panel-utics.module').then(m => m.PanelUticsModule) },
  { path: 'panelDirCarrera', loadChildren: () =>
  import('./components/panel-director-carrera/panel-director-carrera.module').then(m => m.PanelDirectorCarreraModule) },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
