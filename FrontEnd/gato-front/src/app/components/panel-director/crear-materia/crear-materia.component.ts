import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Materia } from '../../../models/Materia/materia';
import { MateriaService } from '../../../services/Materia/materia.service';
import { PeriodoService } from '../../../services/Periodo/periodo.service';
import { Periodo } from '../../../models/Periodo/periodo';

@Component({
  selector: 'app-crear-materia',
  templateUrl: './crear-materia.component.html',
  styleUrls: ['./crear-materia.component.css']
})
export class CrearMateriaComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  materia: Materia = new Materia();
  periodo: Periodo = new Periodo();
  periodos: Periodo[];
  validPeriod = false;

  constructor(
    private formBuilder: FormBuilder,
    private materiaService: MateriaService,
    private periodoService: PeriodoService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      carrera: ['', [Validators.required]],
      nivel: ['', [Validators.required]],
      nrc: ['', [Validators.required]],
      creditos: ['', [Validators.required]],
      periodo: ['', [Validators.required]],
    });
    this.listarPeriodos();
  }

  listarPeriodos(): void {
    this.periodoService.list().subscribe(data => {
      this.periodos = data;
      if (data.length === 0) {
        Swal.fire({
          icon: 'warning',
          title: 'Atención!',
          text: 'No existen periodos registrados',
        });
      }
      else {
        this.validPeriod = true;
      }
    });
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    if (this.validPeriod) {
      this.periodo.subjects = [];
      this.materia.status = false;
      this.submitted = true;
      if (this.form.invalid) {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Error en el formulario',
        });
        return;
      }
      console.log(this.materia);
      // if (this.periodo.subjects === undefined) { this.periodo.subjects = []; }
      this.periodo.subjects.push(this.materia);
      this.periodoService.create(this.periodo).subscribe(() => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Materia Agregada',
          showConfirmButton: false,
          timer: 1500
        });
        this.materia = new Materia();
        this.submitted = false;
        this.onReset();
      });
    } else {
      Swal.fire({
        icon: 'info',
        title: 'Registrar Periodo',
        text: 'Espere hasta que se registre un periodo',
      });
    }
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.materia = new Materia();
    this.periodo = new Periodo();
  }

}
