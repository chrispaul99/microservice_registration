import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PdfViewerModule } from 'ng2-pdf-viewer';

import { PanelVicerectorRoutingModule } from './panel-vicerector-routing.module';
import { RevisarInstructivoComponent } from './revisar-instructivo/revisar-instructivo.component';
import { InicioVicerectorComponent } from './inicio-vicerector/inicio-vicerector.component';
import { ListarInstructivosComponent } from './listar-instructivos/listar-instructivos.component';


@NgModule({
  declarations: [
    RevisarInstructivoComponent,
    InicioVicerectorComponent,
    ListarInstructivosComponent
  ],
  imports: [
    CommonModule,
    PanelVicerectorRoutingModule,
    PdfViewerModule,
  ]
})
export class PanelVicerectorModule { }
