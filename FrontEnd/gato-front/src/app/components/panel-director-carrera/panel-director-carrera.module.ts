import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelDirectorCarreraRoutingModule } from './panel-director-carrera-routing.module';
import { InicioDirCarreraComponent } from './inicio-dir-carrera/inicio-dir-carrera.component';
import { AutorizarMatriculaComponent } from './autorizar-matricula/autorizar-matricula.component';
import { ListarFormulariosComponent } from './listar-formularios/listar-formularios.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';


@NgModule({
  declarations: [
    InicioDirCarreraComponent,
    AutorizarMatriculaComponent,
    ListarFormulariosComponent
  ],
  imports: [
    CommonModule,
    PanelDirectorCarreraRoutingModule,
    PdfViewerModule,
  ]
})
export class PanelDirectorCarreraModule { }
