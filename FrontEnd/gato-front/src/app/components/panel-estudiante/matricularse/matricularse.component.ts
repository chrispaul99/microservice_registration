import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Matricula } from '../../../models/Matricula/matricula';
import { Materia } from '../../../models/Materia/materia';
import { MateriaService } from '../../../services/Materia/materia.service';
import { Periodo } from '../../../models/Periodo/periodo';
import { PeriodoService } from '../../../services/Periodo/periodo.service';
import { Estudiante } from '../../../models/Estudiante/estudiante';
import { EstudianteService } from '../../../services/Estudiante/estudiante.service';
import * as moment from 'moment';

@Component({
  selector: 'app-matricularse',
  templateUrl: './matricularse.component.html',
  styleUrls: ['./matricularse.component.css']
})
export class MatricularseComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  matricula: Matricula = new Matricula();
  matriculas: Matricula[] = [];
  materias: Materia[];
  periodos: Periodo[];
  IDperiodo: number;
  estudiante: Estudiante = new Estudiante();
  controllerButton: boolean[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private periodoService: PeriodoService,
    private materiaService: MateriaService,
    private estudianteService: EstudianteService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      periodo: ['', [Validators.required]],
    });
    this.listarMaterias();
    this.listarPeriodos();
    this.getEstudiante();
  }

  listarMaterias(): void {
    this.materiaService.list().subscribe(data => {
      this.materias = data;
    },
    err => {},
    () => {
      this.controllerButton.push(false);
    });
  }

  listarPeriodos(): void {
    this.periodoService.list().subscribe(data => {
      this.periodos = data;
    });
  }

  getEstudiante(): void {
    this.estudianteService.retrieve(1).subscribe(result => this.estudiante = result,
      err => {},
      () => this.estudiante.registrations = []);
  }

  selectMateria(m: Materia, pos: number): void{
    this.controllerButton[pos] = true;
    this.matricula.date = moment().toDate();
    this.matricula.subject = m;
    this.matricula.type = 'P';
    this.matricula.status = false;
    this.calcularPago();
    this.attachPeriodo();
  }

  calcularPago(): void {
    switch (this.matricula.type) {
      case 'P':
        this.matricula.paytotal = 0;
        break;
      case 'S':
        this.matricula.paytotal = this.matricula.paytotal * 30;
        break;
      case 'T':
        this.matricula.paytotal = this.matricula.paytotal * 60;
        break;
      default:
        break;
    }
  }

  get f(){
    return this.form.controls;
  }

  attachPeriodo(): void {
    this.periodoService.retrieve(this.IDperiodo).subscribe(data => {
      this.matricula.period = data;
    },
    err => {},
    () => {
      this.estudiante.registrations.push(this.matricula);
      console.log(this.estudiante.registrations);
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Materia Agregada',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }

  onSubmit(): void {
    if (this.estudiante.registrations.length === 0) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Las materias son necesarias',
      });
    }
    else {
      this.matricula.status = false;
      this.submitted = true;
      if (this.form.invalid) {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Error en el formulario',
        });
        return;
      }
      this.estudianteService.create(this.estudiante).subscribe(() => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Matriculas Agregadas',
          showConfirmButton: false,
          timer: 1500
        });
        this.matricula = new Matricula();
        this.submitted = false;
        this.onReset();
      });
    }
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.matricula = new Matricula();
  }

}
