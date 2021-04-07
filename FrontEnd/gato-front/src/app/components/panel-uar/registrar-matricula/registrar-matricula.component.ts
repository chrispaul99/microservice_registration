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
  selector: 'app-registrar-matricula',
  templateUrl: './registrar-matricula.component.html',
  styleUrls: ['./registrar-matricula.component.css']
})
export class RegistrarMatriculaComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  matricula: Matricula = new Matricula();
  matriculas: Matricula[] = [];
  materias: Materia[];
  periodos: Periodo[];
  periodo: Periodo = new Periodo();
  estudiantes: Estudiante[];
  estudiante: Estudiante = new Estudiante();

  constructor(
    private formBuilder: FormBuilder,
    private periodoService: PeriodoService,
    private materiaService: MateriaService,
    private estudianteService: EstudianteService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      estudiante: ['', [Validators.required]],
      periodo: ['', [Validators.required]],
      materias: ['', [Validators.required]],
    });
    this.listarMaterias();
    this.listarMaterias();
    this.listarPeriodos();
    this.listarEstudiantes();
  }

  listarMaterias(): void {
    this.materiaService.list().subscribe(data => {
      this.materias = data;
    });
  }

  listarPeriodos(): void {
    this.periodoService.list().subscribe(data => {
      this.periodos = data;
    });
  }

  listarEstudiantes(): void {
    this.estudianteService.list().subscribe(data => {
      this.estudiantes = data;
    });
  }

  selectMateria(m: Materia): void{
    this.matricula.date = moment().toDate();
    this.matricula.period = this.periodo;
    this.matricula.type = 'P';
    this.matricula.status = false;
    this.calcularPago();
    this.matricula.subject = m;
    this.estudiante.registrations.push(this.matricula);
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

  onSubmit(): void {
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

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.matricula = new Matricula();
  }

}
