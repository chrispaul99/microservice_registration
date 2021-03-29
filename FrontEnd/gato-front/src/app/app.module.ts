import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PanelEstudianteComponent } from './components/panel-estudiante/panel-estudiante.component';
import { FormsModule } from '@angular/forms';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { EncryptService } from './services/Encrypt/encrypt.service';
import { PersonaService } from './services/Persona/persona.service';
import { ServiceInterceptor } from './services/Interceptor/service.interceptor';
import { PanelUarComponent } from './components/panel-uar/panel-uar.component';
import { PanelVicerectorComponent } from './components/panel-vicerector/panel-vicerector.component';
import { PanelDirectorComponent } from './components/panel-director/panel-director.component';
import { PanelUticsComponent } from './components/panel-utics/panel-utics.component';
import { PanelDirectorCarreraComponent } from './components/panel-director-carrera/panel-director-carrera.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    PanelEstudianteComponent,
    PanelUarComponent,
    PanelVicerectorComponent,
    PanelDirectorComponent,
    PanelUticsComponent,
    PanelDirectorCarreraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    PdfViewerModule,
  ],
  providers: [
    EncryptService,
    PersonaService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ServiceInterceptor,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
