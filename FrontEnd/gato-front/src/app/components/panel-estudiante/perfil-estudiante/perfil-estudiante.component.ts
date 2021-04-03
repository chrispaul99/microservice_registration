import { Component, OnInit } from '@angular/core';
// import { PersonaService } from '../../../services/Persona/persona.service';
// import { UsuarioService } from '../../../services/Usuario/usuario.service';
import { Estudiante } from '../../../models/Estudiante/estudiante';
import { Usuario } from '../../../models/Usuario/Usuario';

@Component({
  selector: 'app-perfil-estudiante',
  templateUrl: './perfil-estudiante.component.html',
  styleUrls: ['./perfil-estudiante.component.css']
})
export class PerfilEstudianteComponent implements OnInit {

  estudiante: Estudiante = new Estudiante();
  usuario: Usuario = new Usuario();

  // constructor(
  //   private personaService: PersonaService,
  //   private usuarioService: UsuarioService,
  // ) { }

  ngOnInit(): void {

    /*Test*/
    this.estudiante.id = 1;
    this.estudiante.firstName = 'Carlitos';
    this.estudiante.lastName = 'Tévez';
    this.estudiante.phone = '1800-Carlitos';

    // const payLoad = JSON.parse(window.atob(localStorage.getItem('token').split('.')[1]));
    // this.personaService.retrieve(payLoad.nameid).subscribe(data => {
    //   this.persona.ID = data.ID;
    //   this.persona.nombres = data.nombres;
    //   this.persona.apellidos = data.apellidos;
    //   this.persona.telefono = data.telefono;
    // });
    // this.usuarioService.retrieve(payLoad.nameid).subscribe(data => {
    //   this.usuario.ciudadOrigen = data.ciudadOrigen;
    //   this.usuario.ciudadResidencia = data.ciudadResidencia;
    // });
  }

}
