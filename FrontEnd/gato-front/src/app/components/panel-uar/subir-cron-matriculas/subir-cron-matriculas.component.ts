import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Cronograma } from '../../../models/Cronograma/cronograma';
import { CronogramaService } from '../../../services/Cronograma/cronograma.service';
import { PeriodoService } from '../../../services/Periodo/periodo.service';
import { Periodo } from '../../../models/Periodo/periodo';

@Component({
  selector: 'app-subir-cron-matriculas',
  templateUrl: './subir-cron-matriculas.component.html',
  styleUrls: ['./subir-cron-matriculas.component.css']
})
export class SubirCronMatriculasComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  cronograma: Cronograma = new Cronograma();
  periodos: Periodo[];
  periodo: Periodo = new Periodo();

  constructor(
    private formBuilder: FormBuilder,
    private cronogramaService: CronogramaService,
    private periodoService: PeriodoService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      min: ['', [Validators.required]],
      max: ['', [Validators.required]],
      tipo: ['', [Validators.required]],
      desc: ['', [Validators.required]],
      fecha: ['', [Validators.required]],
      periodo: ['', [Validators.required]],
    });
    this.listarPeriodos();
  }

  get f(){
    return this.form.controls;
  }

  listarPeriodos(): void {
    this.periodoService.list().subscribe(data => {
      this.periodos = data;
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    this.cronogramaService.create(this.cronograma).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Cronograma Registrado',
        showConfirmButton: false,
        timer: 1500
      });
      console.log(this.periodo);
      this.attachPeriodo();
      this.cronograma = new Cronograma();
      this.periodo = new Periodo();
      this.submitted = false;
      this.onReset();
    });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.cronograma = new Cronograma();
    this.periodo = new Periodo();
  }

  attachPeriodo(): void {
    this.periodo.cronograma = this.cronograma;
    this.periodoService.create(this.periodo).subscribe();
  }

}
