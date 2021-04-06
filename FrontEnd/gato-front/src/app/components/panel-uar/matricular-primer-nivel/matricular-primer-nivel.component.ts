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

@Component({
  selector: 'app-matricular-primer-nivel',
  templateUrl: './matricular-primer-nivel.component.html',
  styleUrls: ['./matricular-primer-nivel.component.css']
})
export class MatricularPrimerNivelComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  matricula: Matricula = new Matricula();
  materias: Materia[];
  materiaSubmit: Materia[];
  periodos: Periodo[];
  estudiantes: Estudiante[];

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
      fecha: ['', [Validators.required]],
      tipo: ['', [Validators.required]],
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
    this.materiaSubmit.push(m);
  }

  get f(){
    return this.form.controls;
  }

  calcularCreditos(): void {
    for (const m of this.materiaSubmit) {
      this.matricula.totalCreditos += m.total_credits;
    }
  }

  calcularPago(): void {
    switch (this.matricula.tipo) {
      case 'P':
        this.matricula.pagoTotal = 0;
        break;
      case 'S':
        this.matricula.pagoTotal = this.matricula.totalCreditos * 30;
        break;
      case 'T':
        this.matricula.pagoTotal = this.matricula.totalCreditos * 60;
        break;
      default:
        break;
    }
  }

  onSubmit(): void {
    this.matricula.status = false;
    this.matricula.materias = this.materiaSubmit;
    this.calcularCreditos();
    this.calcularPago();
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
