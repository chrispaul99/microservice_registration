import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Estudiante } from '../../../models/Estudiante/estudiante';
import { Persona } from '../../../models/Persona/persona';
import { Usuario } from '../../../models/Usuario/Usuario';

@Component({
  selector: 'app-crear-estudiante',
  templateUrl: './crear-estudiante.component.html',
  styleUrls: ['./crear-estudiante.component.css']
})
export class CrearEstudianteComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  estudiante: Estudiante = new Estudiante();
  persona: Persona = new Persona();
  usuario: Usuario = new Usuario();

  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      correo: ['', [Validators.required]],
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
      nombres: ['', [Validators.required]],
      apellidos: ['', [Validators.required]],
      fechaNac: ['', [Validators.required]],
      cedula: ['', [Validators.required]],
      telefono: ['', [Validators.required]],
      carrera: ['', [Validators.required]],
    });
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.estudiante.matriculaLinea = false;
    this.estudiante.status = false;
    this.estudiante.idPersona = this.persona.ID;
    this.persona.user = this.usuario;
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    // this.empresaService.create(this.empresa).subscribe(() => {
    //   Swal.fire({
    //     position: 'top-end',
    //     icon: 'success',
    //     title: 'Empresa Agregada',
    //     showConfirmButton: false,
    //     timer: 1500
    //   });
    //   this.estudiante = new Estudiante();
    //   this.persona = new Persona();
    //   this.usuario = new Usuario();
    //   this.onReset();
    // });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.estudiante = new Estudiante();
    this.persona = new Persona();
    this.usuario = new Usuario();
  }

}
