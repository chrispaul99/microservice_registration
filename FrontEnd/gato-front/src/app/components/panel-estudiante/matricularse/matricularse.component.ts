import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Matricula } from '../../../models/Matricula/matricula';
import { Materia } from '../../../models/Materia/materia';
import { Periodo } from '../../../models/Periodo/periodo';
import { Estudiante } from '../../../models/Estudiante/estudiante';

@Component({
  selector: 'app-matricularse',
  templateUrl: './matricularse.component.html',
  styleUrls: ['./matricularse.component.css']
})
export class MatricularseComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  matricula: Matricula = new Matricula();
  materias: Materia[];
  materiaSubmit: Materia[];
  periodos: Periodo[];
  estudiantes: Estudiante[];
  // persona: Persona = new Persona();

  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      estudiante: ['', [Validators.required]],
      periodo: ['', [Validators.required]],
      materias: ['', [Validators.required]],
      fecha: ['', [Validators.required]],
      tipo: ['', [Validators.required]],
    });
    this.listarMaterias();
    // Listar Estudiantes
    // Listar Periodos
  }

  listarMaterias(): void {
    // this.empresaService.list().subscribe(data => {
    //   this.materias = data;
    // });
  }

  selectMateria(m: Materia): void{
    this.materiaSubmit.push(m);
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    // Definir Status´
    // Calcular ceditos
    // Calcular pago
    this.matricula.materias = this.materiaSubmit;
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    // this.empresaService.create(this.matricula).subscribe(() => {
    //   Swal.fire({
    //     position: 'top-end',
    //     icon: 'success',
    //     title: 'Matricula Agregada',
    //     showConfirmButton: false,
    //     timer: 1500
    //   });
    //   this.matricula = new Matricula();
    //   this.submitted = false;
    //   this.onReset();
    // });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.materiaSubmit = [];
    this.matricula = new Matricula();
  }

}
